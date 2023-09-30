package com.cis.baseapp.ui.auth

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.coroutines.launch

data class RegisterScreen(val name: String) : Screen{


    @Composable
    override fun Content() {
        Column {
            Text(text = "Hello $name")
//            RadioButtons()
//            CheckBoxs()
//            PickImageFromGallery()
//            PickImageFromCamera()


//            val scaffoldState = rememberScaffoldState()
//            Scaffold (scaffoldState = scaffoldState){ ShowSnackBar(scaffoldState = scaffoldState) }

            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            Scaffold (scaffoldState = scaffoldState,
            drawerContent = {
                IconButton(onClick = {
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                }) {
                    Icon(Icons.Default.Close, contentDescription = "", tint = Color.Black)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Close, contentDescription = "Hello", tint = Color.Black)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Close, contentDescription = "Hey", tint = Color.Black)
                }

            },
            drawerGesturesEnabled = false){ ShowNavigationDrawer(scaffoldState = scaffoldState) }

        }



    }

    @Composable
    fun RadioButtons(){
        val genderList by remember { mutableStateOf(listOf("male", "female", "others")) }
        var genderState by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                genderList.forEach{
                    Row {
                        Text(text = it, modifier = Modifier.align(CenterVertically))
                        RadioButton(selected = genderState == it,
                            onClick = {
                                genderState = it
                            })
                    }
                }
            }
        }

    }

    @Composable
    fun CheckBoxs(){
        val genderList by remember { mutableStateOf(listOf("I am good.", "Work on cis", "I am from indore")) }
        var isChecked by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                genderList.forEach{
                    Row {
                        Text(text = it, modifier = Modifier.align(CenterVertically))
                        Checkbox(checked = isChecked, onCheckedChange = {
                            isChecked = it
                        })
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            CheckBoxItem()
        }

    }

    @Composable
    fun CheckBoxItem(){
        var isCheck by remember { mutableStateOf(false) }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(),
        horizontalArrangement = Arrangement.Center){
            Card(elevation = 0.dp,
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, color = Color.Black),
                backgroundColor = Color.White
            ) {
                Box(modifier = Modifier
                    .background(
                        if (isCheck) Color.Green else Color.White
                    )
                    .clickable {
                        isCheck = !isCheck
                    }
                    .size(24.dp)
                ){
                    if (isCheck)
                        Icon(Icons.Default.Check, contentDescription = "", tint = Color.White)
                }
            }
        }
    }

    @Composable
    fun PickImageFromGallery(){

        val context = LocalContext.current
        var imageUri by remember {
            mutableStateOf<Uri?>(null)
        }
        var bitmap by remember {
            mutableStateOf<Bitmap?>(null)
        }
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()){
            imageUri = it
        }
        
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { 
                launcher.launch("image/*")
            }) {
                Text(text = "Pic image")
            }
            Spacer(modifier = Modifier.height(20.dp))

            imageUri?.let {

                bitmap = if (Build.VERSION.SDK_INT < 28){
                    MediaStore.Images.Media.getBitmap(context.contentResolver,it)
                }else{
                    val source = ImageDecoder.createSource(context.contentResolver, it)
                    ImageDecoder.decodeBitmap(source)
                }
                
                Image(bitmap= bitmap?.asImageBitmap()!!, contentDescription = "", modifier = Modifier.size(200.dp))
            }
        }

    }

    @Composable
    fun PickImageFromCamera(){

        var bitmap by remember {
            mutableStateOf<Bitmap?>(null)
        }
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.TakePicturePreview()){
            bitmap = it
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                launcher.launch()
            }) {
                Text(text = "Pic image")
            }

            Spacer(modifier = Modifier.height(20.dp))


            bitmap?.let {
                Image(bitmap= bitmap?.asImageBitmap()!!, contentDescription = "", modifier = Modifier.size(200.dp))
            }
        }
    }

    @Composable
    fun ShowSnackBar(scaffoldState: ScaffoldState){
        val scope = rememberCoroutineScope()
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("Hey this is wrong")
                }
            }) {
                Text(text = "Show SnackBar")
            }
        }
    }

    @Composable
    fun ShowNavigationDrawer(scaffoldState: ScaffoldState){
        val scope = rememberCoroutineScope()
        Button(onClick = {
            scope.launch {
                scaffoldState.drawerState.open()
            }

        }) {
            Icon(Icons.Default.Menu, contentDescription = "", tint = Color.Black)
        }
    }

    @Composable
    fun ConstraintsLayout(){

    }

    @Composable
    fun SetTabView(modifier: Modifier= Modifier,
    onTabSelected: (selectedIndex: Int) -> Unit){
        val index = 0
        
        Tab(selected = index == 0, onClick = {},
        selectedContentColor = Color.Black,
        unselectedContentColor = Color.Blue) {

            Icon(Icons.Default.Home, contentDescription = "", tint = Color.Blue)
            Icon(Icons.Default.Settings, contentDescription = "", tint = Color.Blue)
            Icon(Icons.Default.Person, contentDescription = "", tint = Color.Blue)
        }

    }

}
data class TabView(val tab: String, val des: String)
val tabList = listOf(
    TabView(
        "Home",
        "This is home"
    ),
    TabView(
        "Setting",
        "This is Setting"
    ),
    TabView(
        "Profile",
        "This is Profile"
    )
)


