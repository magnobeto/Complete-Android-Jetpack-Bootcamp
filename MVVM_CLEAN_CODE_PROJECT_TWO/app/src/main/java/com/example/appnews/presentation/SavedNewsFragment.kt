package com.example.appnews.presentation

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appnews.R
import com.example.appnews.data.model.Article
import com.example.appnews.databinding.FragmentNewsBinding
import com.example.appnews.databinding.FragmentSavedNewsBinding
import com.example.appnews.presentation.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SavedNewsFragment : Fragment() {

    private lateinit var binding: FragmentSavedNewsBinding
    private val viewModel: NewsViewModel by activityViewModels()

    @Inject
    lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSavedNewsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observe()
    }

    private fun initRecyclerView() {
        newsAdapter.setOnClickListener {
            val bundle = bundleOf("selected_article" to it)
            findNavController().navigate(R.id.action_savedNewsFragment_to_newsInfoFragment, bundle)
        }

        newsAdapter.setOnLongClickListener {
            setupDialogFragment(it)
        }

        with(binding.recyclewView) {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun setupDialogFragment(article: Article) {
        DeleteActionDialogFragment.newInstance { viewModel.deleteArticle(article) }
            .show(childFragmentManager, "DeleteDialog")
    }

    private fun observe() {
        viewModel.getSavedArtiles().observe(viewLifecycleOwner) {
            newsAdapter.differ.submitList(it)
        }
    }
}