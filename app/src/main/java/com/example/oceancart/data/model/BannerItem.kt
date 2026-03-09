package com.example.oceancart.data.model

import com.example.oceancart.R

data class BannerItem(
    val image: Int
)

val banners = listOf(
    BannerItem(R.drawable.article_tuna),
    BannerItem(R.drawable.article_crab),
    BannerItem(R.drawable.article_crab2)
)