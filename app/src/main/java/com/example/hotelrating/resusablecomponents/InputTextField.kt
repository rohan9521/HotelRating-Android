package com.example.hotelrating.resusablecomponents

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.format.TextStyle

@Composable
fun InputTextField(
    mutableTextState: MutableState<String>,
    mutableErrorState: MutableState<String>,
    errorMessage: String,
    placeHolderText: String
) {
    Column(
        modifier = Modifier

            .background(Color.Transparent)
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top=5.dp)
        )
        OutlinedTextField(
            placeholder = { Text(placeHolderText) },
            shape = RoundedCornerShape(28.dp),
            modifier = Modifier
                .fillMaxWidth(),
            value = mutableTextState.value,
            onValueChange = {
                mutableTextState.value = it
            },
        )

//        if (mutableErrorState.value.isNotEmpty()) {
//            errorText(errorMessage)
//        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top =5.dp)
        )
    }
}

@Composable
fun errorText(errorMessage: String) {
    Text(
        modifier = Modifier.background(Color.Black),
        text = errorMessage,
        textAlign = TextAlign.Start,
        color = Color.White
    )
}

@Preview
@Composable
fun preview(

) {
    InputTextField(
        mutableStateOf("Text"),
        mutableStateOf("Text"),
        "error",
        "",
    )
}