package com.example.hotelrating.feature.auth.login

import android.app.Activity
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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Brush
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
import com.example.hotelrating.resusablecomponents.InputTextField
import com.example.hotelrating.utils.Screen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun Login(firebaseAuth: FirebaseAuth, setAuthView: (String) -> Unit, mainActivity: Activity) {
    val navController = LocalCompOfNavController.current
    var emailMutableState = remember { mutableStateOf("") }
    var passwordMutableState = remember { mutableStateOf("") }
    var errorEmail = remember { mutableStateOf("") }
    var errorPassword = remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier

            .padding(horizontal = 30.dp)
            .fillMaxWidth()
    ) {

        InputTextField(emailMutableState, errorEmail, "Error", "Name")
        InputTextField(passwordMutableState, errorPassword, "Error", "Password")

        forgotPassword()
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier

            .fillMaxWidth()
    ) {
        loginButton(
            navController,
            setAuthView,
            firebaseAuth,
            mainActivity = mainActivity,
            email = emailMutableState.value,
            password = passwordMutableState.value
        )
    }
}


@Composable
fun forgotPassword() {

    Text(
        text = "forgot Password?",
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
fun errorPassword() {
    Text(
        modifier = Modifier.background(Color.Black),
        text = "Error in name",
        textAlign = TextAlign.Start,
        color = Color.White
    )
}

@Composable
fun loginButton(
    navController: NavController?,
    setAuthView: (String) -> Unit,
    firebaseAuth: FirebaseAuth,
    email: String,
    password: String,
    mainActivity: Activity
) {

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
                firebaseAuth.signInWithEmailAndPassword(email, password)
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

                Log.d("test", "LoginButton")
            }) {
            Text("Login")
        }

        Log.d("test", "LoginButton")
        Text(
            text = "Dont have an account! Click here to signup",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
            style = TextStyle(
                color = Color.Blue,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.clickable {
                setAuthView("SignUp")
            }
        )
    }

}