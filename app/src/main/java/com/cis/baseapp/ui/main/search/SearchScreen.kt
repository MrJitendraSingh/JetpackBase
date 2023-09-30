package com.cis.baseapp.ui.main.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.cis.baseapp.ui.main.add.AddPersonViewModel
import com.cis.baseapp.ui.main.home.ItemView

@Composable
fun SearchScreen(){
    val viewModel: AddPersonViewModel = hiltViewModel()
    Surface {
        Column {
            ItemView()
        }
    }
}