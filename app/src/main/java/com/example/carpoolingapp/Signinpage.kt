package com.example.carpoolingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
//import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
import com.example.carpoolingapp.ui.theme.CarPoolingAppTheme



@Composable
fun ContentsSignin(navController: NavController){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(),
    ) {
        val (emailstate,setemailstate)= remember{ mutableStateOf("") }
        val (passwordstate,setpasswordstate)= remember{ mutableStateOf("") }
        Text(text = "Login", fontSize = 70.sp, color = MaterialTheme.colors.primary)
        Spacer(modifier = Modifier.height(20.dp))
        customTextFieldS(content = "Email", VisualTransformation.None,emailstate,setemailstate)
        Spacer(modifier = Modifier.height(2.dp))
        customTextFieldS(content = "Password",
            PasswordVisualTransformation(),passwordstate,setpasswordstate)
        Spacer(modifier = Modifier.height(70.dp))
        ButtonExampleS("Login",emailstate,passwordstate)
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text="New User? Sign up",
            fontSize = 15.sp,
            color = MaterialTheme.colors.primary,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.clickable { navController.navigate(Screens.signuppage.route) }
        )
    }
}

/*
* State hosting is done here
* Customtextfield has a stateless outlinedtextfield,
* State is created for each called composable
* Passed to the customTextField
* Benefits => differentiation of values in state,fieldvalidation
* */

@Composable
fun customTextFieldS(content: String,
                    V: VisualTransformation = VisualTransformation.None,
                    value: String,
                    onValueChanged: (String )->Unit
){
    Column(Modifier.padding(2.dp)) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChanged,
            placeholder ={ Text(text = content,fontSize = 20.sp,color = MaterialTheme.colors.secondary) },
            shape = RoundedCornerShape(50.dp),
            visualTransformation = V,
            modifier = Modifier.clickable { navController.navigate(Screens.landingpage.route) }
        )
    }
}



@Composable
fun ButtonExampleS(btnname:String,value: String,value1: String) {
    Button(onClick = { navController.navigate(Screens.landingpage.route) },
        modifier = Modifier
            .clip(RoundedCornerShape(50.dp))
            .background(color = MaterialTheme.colors.primaryVariant)
            .clickable { navController.navigate(Screens.landingpage.route) },
        enabled = value.isNotBlank() && value1.isNotBlank() ,
    ) {
        Text(text = btnname,fontSize = 20.sp,modifier= Modifier.padding(start = 10.dp,top=2.dp,bottom = 2.dp,end = 10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun Signinpage() {
    CarPoolingAppTheme {
       ContentsSignin(navController = rememberNavController())
    }
}

