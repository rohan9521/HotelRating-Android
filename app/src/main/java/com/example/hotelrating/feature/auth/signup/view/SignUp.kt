package com.example.hotelrating.feature.auth.signup.view

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hotelrating.MainActivity
import com.example.hotelrating.R
import com.example.hotelrating.resusablecomponents.InputTextField
import com.example.hotelrating.utils.findActivity
import com.example.hotelrating.viewmodel.MainViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUp( firebaseAuth:FirebaseAuth,mainActivity: MainActivity ){
    val mainNavController = compositionOfMainNavController.current
    var userNameMutableState = remember { mutableStateOf("") }
    var errorUserName = remember { mutableStateOf("") }

    var passwordMutableState = remember { mutableStateOf("") }
    var errorPassword =  remember { mutableStateOf("")}

    var emailMutableState = remember { mutableStateOf("") }
    var errorEmail = remember { mutableStateOf("") }

    var reEnterPasswordMutableState = remember { mutableStateOf("") }
    var errorReEnterPassword =  remember { mutableStateOf("")}

        Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {
        Image(
            painter = painterResource(id = R.mipmap.ic_launcher_foreground),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .blur(10.dp),
            contentScale = ContentScale.Crop
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
                    InputTextField(userNameMutableState,errorUserName,"Error","Name")
                    InputTextField(emailMutableState,errorEmail,"Error","Email")
                    InputTextField(passwordMutableState,errorPassword,"Error","Password")
                    InputTextField(reEnterPasswordMutableState,errorReEnterPassword,"Error","Re enter password")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxWidth()
                ) {
                    loginButton(mainActivity,mainNavController, firebaseAuth,emailMutableState.value,passwordMutableState.value)
                }
            }


        }
    }

}

@Composable
fun loginButton(
    mainActivity: MainActivity,
    navController: NavController,
    firebaseAuth:FirebaseAuth,
    email:String,
    password:String
) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            onClick = {
                firebaseAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(mainActivity) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("SignUp", "createUserWithEmail:success")
                            val user = firebaseAuth.currentUser
                            Log.d("SignUp", "${user.toString()}")
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("SignUp", "createUserWithEmail:failure", task.exception)
                        }
                    }

//                navController.navigate(Screen.HomeScreen.route){
//                    popUpTo(Screen.LoginScreen.route){inclusive = true}
//                }
            }) {
            Text("Sign up")
        }

        Log.d("test","LoginButton")
    }

}