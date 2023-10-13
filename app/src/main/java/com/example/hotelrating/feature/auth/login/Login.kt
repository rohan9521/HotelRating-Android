package com.example.hotelrating.feature.auth.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hotelrating.R
import com.example.hotelrating.feature.navigation.LocalCompOfNavController
import com.example.hotelrating.utils.Screen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun Login( firebaseAuth: FirebaseAuth) {
    val navController = LocalCompOfNavController.current
     var userNameMutableState = remember { mutableStateOf("") }
     var passwordMutableState = remember { mutableStateOf("") }
     var errorUserName = remember { mutableStateOf("") }
     var errorPassword =  remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {
        Image(
            painter = painterResource(id = R.mipmap.ic_launcher_2_foreground),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .blur(10.dp),
            contentScale = ContentScale.FillBounds
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .clip(CutCornerShape(10.dp))
                .alpha(0.6f)
                .background(Color.White),

            ) {
            Column() {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .weight(0.3f)
                        .padding(20.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Welcome",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Medium,
                        fontSize = 48.sp,
                        style = TextStyle(
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        ),
                    )
                    Text(
                        text = "Sign In To rate your Hotel",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        style = TextStyle(
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(horizontal = 30.dp)
                        .fillMaxWidth()
                ) {
                    userName(userNameMutableState,errorUserName)
                    password(passwordMutableState,errorPassword)
                    forgotPassword()
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxWidth()
                ) {
                    loginButton(navController)
                }
            }


        }
    }

}

@Composable
fun userName(userNameMutableState:MutableState<String>, errorState:MutableState<String>) {
    TextField(
        modifier = Modifier
            .shadow(3.dp)
            .clip(CutCornerShape(10.dp))
        ,
        value = userNameMutableState.value, onValueChange = {
            userNameMutableState.value = it
        })

    if (errorState.value.isNotEmpty()) {
        errorUserName()
    }

}

@Composable
fun forgotPassword() {

    Text(
        text="forgot Password?",
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Medium,
        style = TextStyle(
            color = Color.Blue,
            textAlign = TextAlign.End
        ),
        modifier = Modifier
            .fillMaxWidth(),
    )

}

@Composable
fun errorUserName() {
    Text(
        modifier = Modifier.background(Color.Black),
        text = "Error in name",
        textAlign = TextAlign.Start,
        color = Color.White
    )
}

@Composable
fun errorPassword() {
    Text(
        modifier = Modifier.background(Color.Black),
        text = "Error in name",
        textAlign = TextAlign.Start,
        color = Color.White
    )
}

@Composable
fun password(passwordMutableState:MutableState<String>,errorState: MutableState<String>) {
    TextField(
        modifier = Modifier
            .shadow(3.dp)
            .clip(CutCornerShape(10.dp))
        ,
        value = passwordMutableState.value,
        onValueChange = {
            passwordMutableState.value = it
        })
    if (errorState.value.isNotEmpty()) {
        errorPassword()
    }
}

@Composable
fun loginButton(navController: NavController?) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       // Log.d("test","${testState.value}")
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            onClick = {
                Log.d("test","LoginButtonClick")

//                navController.navigate(Screen.HomeScreen.route){
//                    popUpTo(Screen.LoginScreen.route){inclusive = true}
//                }
            }) {
            Text("Login")
        }

        Log.d("test","LoginButton")
        Text(
            text = "Dont have an account! Click here to signup",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
            style = TextStyle(
                color = Color.Blue,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.clickable {
                navController?.navigate(Screen.SignUpScreen.route)
            }
        )
    }

}