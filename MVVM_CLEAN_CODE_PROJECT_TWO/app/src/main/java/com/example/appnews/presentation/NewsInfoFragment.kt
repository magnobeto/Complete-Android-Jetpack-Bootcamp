package com.example.appnews.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.appnews.R
import com.example.appnews.databinding.FragmentNewsInfoBinding

class NewsInfoFragment : Fragment() {

    private lateinit var binding: FragmentNewsInfoBinding

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
            if (selectedArticle.url != "") {
                loadUrl(selectedArticle.url)
            }
        }
    }
}