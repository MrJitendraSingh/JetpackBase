package com.cis.baseapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun BaseAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White,
            darkIcons = true
        )
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}


@Composable
fun InputTextMedium(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    textStyle: TextStyle = TextStyle(textAlign = TextAlign.Start,fontSize = 14.sp),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    isError: Boolean = false
) {
    val customTextFieldDefaults = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = Color.Blue,
        unfocusedBorderColor = Color.Gray,
        cursorColor = Color.Black,
        errorCursorColor = Color.Red
    )

    OutlinedTextField(
        modifier = modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(0.dp),
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholder, style = textStyle, color = Color.Gray, modifier = Modifier.fillMaxWidth()) },
        keyboardOptions = keyboardOptions,
        textStyle = textStyle,
        singleLine = true,
        shape = RoundedCornerShape(8.dp),
        isError = isError,
        colors = customTextFieldDefaults,
    )
}


@Composable
fun TextMedium(
    text:String,
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle(fontSize = 14.sp, color = Color.Gray)
){
    Text(text = text,
        modifier = modifier,
        style = style)
}

@Composable
fun ButtonBlue(
    text:String,
    click:() -> Unit,
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle(fontSize = 14.sp, color = Color.Gray, fontFamily = FontFamily.Cursive)
){
    val buttonColors = ButtonDefaults.buttonColors(
        backgroundColor = Color.Blue,
        contentColor = Color.White
    )
    Button(onClick = click,
        colors = buttonColors) {
        TextMedium(text = text)
    }
}
