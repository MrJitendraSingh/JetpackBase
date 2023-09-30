package com.cis.baseapp.data.model

import com.cis.baseapp.data.model.Hit

data class PixabayResponse(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)