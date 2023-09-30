package com.cis.baseapp.data.model

import com.cis.baseapp.data.model.Hit


data class MainState(
    val isLoading:Boolean=false,
    val data:List<Hit> = emptyList(),
    val error:String=""
)
