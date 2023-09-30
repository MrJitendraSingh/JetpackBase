package com.cis.baseapp.ui.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AlertDialogBox(openDialog:MutableState<Boolean>) {

    val title = remember {
        mutableStateOf("")
    }
    val description = remember {
        mutableStateOf("")
    }

    if (openDialog.value) {

        AlertDialog(onDismissRequest = {
            openDialog.value = false
        },
            modifier = Modifier.padding(10.dp),
            title = { Text(text = "AlertDialog") },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    OutlinedTextField(
                        value = title.value,
                        onValueChange = {
                            title.value = it
                        },
                        placeholder = { Text(text = "Enter title") },
                        label = { Text(text = "Enter title") },
                        modifier = Modifier.padding(10.dp)
                    )
                    OutlinedTextField(
                        value = description.value,
                        onValueChange = {
                            description.value = it
                        },
                        placeholder = { Text(text = "Enter description") },
                        label = { Text(text = "Enter description") },
                        modifier = Modifier.padding(10.dp)
                    )
                }
            },
            confirmButton = {
                OutlinedButton(onClick = {
                }) {
                    Text(text = "Save")
                }
            })
    }
}