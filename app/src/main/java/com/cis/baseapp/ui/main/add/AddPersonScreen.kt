package com.cis.baseapp.ui.main.add

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cis.baseapp.R
import com.cis.baseapp.ui.theme.Yellow


@Composable
fun AddPersonScreen(){
    val viewModel: AddPersonViewModel = hiltViewModel()
    Surface {
        Column {
            AddNewUser()
        }
    }
}



@Preview
@Composable
fun AddNewUser(){
//    val focusRequester = remember {
//        FocusRequester()
//    }
//    val focusManager = LocalFocusManager.current
    var name = remember { mutableStateOf("") }
    var fathersName = remember { mutableStateOf("") }
    var age = remember { mutableStateOf("") }
    var blood = remember { mutableStateOf("") }
    var weight = remember { mutableStateOf("") }
    var height = remember { mutableStateOf("") }
    var email = remember {
        mutableStateOf("")
    }
    var phone = remember {
        mutableStateOf("")
    }

//    LaunchedEffect(Unit) {
//        focusRequester.requestFocus()
//    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painterResource(R.drawable.ic_seating), contentDescription = "", modifier = Modifier
                .size(100.dp)
                .padding(16.dp)
                .background(color = Color.Gray, shape = RoundedCornerShape(50.dp)),
            alignment = Alignment.Center
        )




        Row(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            OutlinedButton(
                onClick = {
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(width = 1.dp, color = Yellow)
            ) {
                Text(
                    text = "Save & Continue",
                    color = com.cis.baseapp.ui.theme.Yellow,
                    modifier = Modifier.padding(vertical = 4.dp),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.proxima_nova_bold)),
                        fontSize = 20.sp
                    )
                )
            }

        }
    }

}