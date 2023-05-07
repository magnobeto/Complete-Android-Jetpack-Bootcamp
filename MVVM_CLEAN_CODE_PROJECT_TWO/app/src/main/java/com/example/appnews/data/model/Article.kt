package com.example.appnews.data.model

import java.io.Serializable

data class Article(
    val source: Source,
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
) : Serializable {
    override fun hashCode(): Int {
        var result = author.hashCode()
        if(author.isNullOrEmpty()){
            result = 1
        }
        return result
    }
}