package com.example.appnews.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.SearchView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appnews.BuildConfig
import com.example.appnews.R
import com.example.appnews.data.model.APIResponse
import com.example.appnews.data.util.Resource
import com.example.appnews.databinding.FragmentNewsBinding
import com.example.appnews.presentation.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private val viewModel: NewsViewModel by activityViewModels()

    @Inject
    lateinit var newsAdapter: NewsAdapter
    private var page = 1
    private var isScrolling = false
    private var isLoading = false
    private var isLastPage = false
    private var pages = 0

    private val onScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                isScrolling = true
            }
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val layoutManager = binding.recyclewView.layoutManager as LinearLayoutManager
            val sizeOfTheCurrentList = layoutManager.itemCount
            val visibleItems = layoutManager.childCount
            val topPosition = layoutManager.findFirstVisibleItemPosition()

            val hasReachedTheEnd = topPosition + visibleItems >= sizeOfTheCurrentList

            val shouldPaginate = !isLoading && !isLastPage && hasReachedTheEnd && isScrolling
            if (shouldPaginate) {
                page++
                viewModel.getNewsHeadline(BuildConfig.COUNTRY, page)
                isScrolling = false
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewNewsList()
        setSearchView()
        initRecyclerView()
    }

    private fun viewNewsList() {
        viewModel.getNewsHeadline(BuildConfig.COUNTRY, page)
        viewModel.newsHeadLine.observe(viewLifecycleOwner) { response ->
            checkReturnedResponseAndShowListOrError(response)
        }
    }

    private fun viewSearchNewsList() {
        viewModel.searchNews.observe(viewLifecycleOwner) { response ->
            checkReturnedResponseAndShowListOrError(response)
        }
    }

    private fun checkReturnedResponseAndShowListOrError(response: Resource<APIResponse>) {
        when (response) {
            is Resource.Success -> {
                hideProgressBar()
                response.data?.let {
                    newsAdapter.differ.submitList(it.articles.toList())
                    pages = if (it.totalResults % 20 == 0) {
                        it.totalResults / 20
                    } else {
                        it.totalResults / 20 + 1
                    }
                    isLastPage = page == pages
                }
            }
            is Resource.Loading -> {
                showProgressBar()
            }
            is Resource.Error -> {
                hideProgressBar()
                response.message?.let { showToast(it) }
            }
        }
    }

    private fun setSearchView() {
        with(binding.searchView) {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(searchQuery: String?): Boolean {
                    viewModel.getSearchedNews(BuildConfig.COUNTRY, searchQuery.toString(), page)
                    viewSearchNewsList()
                    return true
                }

                override fun onQueryTextChange(searchQuery: String?): Boolean {
                    // This cause bug when back from a article
                    MainScope().launch {
                        delay(2000)
                        viewModel.getSearchedNews(BuildConfig.COUNTRY, searchQuery.toString(), page)
                        viewSearchNewsList()
                    }
                    return true
                }
            })

            setOnCloseListener {
                viewNewsList()
                initRecyclerView()
                true
            }
        }
    }

    private fun initRecyclerView() {
        newsAdapter.setOnClickListener {
            val bundle = bundleOf("selected_article" to it)
            findNavController().navigate(R.id.action_newsFragment_to_newsInfoFragment, bundle)
        }
        with(binding.recyclewView) {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
            addOnScrollListener(onScrollListener)
        }
    }

    private fun showProgressBar() {
        isLoading = true
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        isLoading = false
        binding.progressBar.visibility = View.GONE
    }

    private fun showToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }
}