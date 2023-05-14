package com.example.appnews.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.appnews.R
import com.example.appnews.databinding.FragmentNewsInfoBinding
import com.example.appnews.presentation.viewmodel.NewsViewModel
import com.google.android.material.snackbar.Snackbar

class NewsInfoFragment : Fragment() {

    private lateinit var binding: FragmentNewsInfoBinding
    private val viewModel: NewsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsInfoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val extras by navArgs<NewsInfoFragmentArgs>()
        val selectedArticle = extras.selectedArticle
        binding.webviewInfo.apply {
            webViewClient = WebViewClient()
            if (!selectedArticle.url.isNullOrEmpty()) {
                loadUrl(selectedArticle.url)
            }
        }
        binding.floatingActionButton.setOnClickListener {
            viewModel.saveArticle(selectedArticle)
            Snackbar.make(view, "Saved successfully", Snackbar.LENGTH_LONG).show()
        }
    }
}