package com.cis.baseapp.ui.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.cis.baseapp.R
import com.cis.baseapp.data.model.JobActivityDTO
import com.cis.baseapp.ui.main.nav.MainNavHost


@Composable
fun HomeScreen(){
    val viewModel:HomeViewModel = hiltViewModel()
    Surface {
        Column {
            ItemView()
        }
    }
}


@Preview
@Composable
fun ItemView(){
    val itemSelected = remember {
        mutableStateOf(-1)
    }
    val jobActivityDTO : ArrayList<JobActivityDTO> = ArrayList()
    jobActivityDTO.add(JobActivityDTO(0,"Not Working", "Easy workout", R.drawable.ic_not_working_green, false))
    jobActivityDTO.add(JobActivityDTO(1,"Mostly Seated", "Braking a sweat", R.drawable.ic_seating, false))
    jobActivityDTO.add(JobActivityDTO(2,"Standing/Walking", "Challenging yourself", R.drawable.ic_stand, false))
    jobActivityDTO.add(JobActivityDTO(3,"Very Active", "Pushing your limits", R.drawable.ic_very_active, false))

    LazyColumn(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(items = jobActivityDTO) { item ->

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White, shape = RoundedCornerShape(8.dp))){
                Row(modifier = Modifier.padding(top = 8.dp, start = 8.dp)) {
                    Text(text = "Name:")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = item.title)
                }
                Row(modifier = Modifier.padding(bottom = 8.dp, start = 8.dp)) {
                    Text(text = "Phone:")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "8888888888")
                }
            }

        }
    }
}