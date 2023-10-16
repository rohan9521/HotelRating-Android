package com.example.hotelrating.feature.auth.main

import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import com.example.hotelrating.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
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
import com.example.hotelrating.MainActivity
import com.example.hotelrating.feature.auth.login.Login
import com.example.hotelrating.feature.auth.signup.view.SignUp
import com.google.firebase.auth.FirebaseAuth

@Composable
fun AuthMainView(firebaseAuth: FirebaseAuth,mainActivity: MainActivity) {
    val authView = remember{ mutableStateOf<String>("Login")}
    val setAuthView:(String)->Unit = {value -> authView.value = value }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {

        val colorStops = arrayOf(
            0.2f to Color.Black,
            1f to Color.Green
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(colorStops = colorStops))
                .padding(20.dp)
                .clip(RoundedCornerShape(20.dp))
                .alpha(0.6f)
                .background(Color.White),

            ) {
            Column(
                modifier = Modifier
                    .padding(bottom = 10.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id=R.mipmap.ic_hotel_icon_foreground),
                        contentDescription = "",
                        modifier = Modifier
                            .width(200.dp)
                            .height(200.dp)
                           ,
                        contentScale = ContentScale.FillBounds
                    )
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
                if(authView.value == "Login"){
                    Login(firebaseAuth = firebaseAuth,setAuthView,mainActivity)
                }else{
                    SignUp(firebaseAuth = firebaseAuth, mainActivity = mainActivity,setAuthView)
                }
            }
        }
    }
}