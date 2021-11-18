package com.example.carpoolingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
//import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
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
import com.example.carpoolingapp.ui.theme.CarPoolingAppTheme


@Composable
fun ContentsSignup(navController: NavController){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Sign Up", fontSize = 70.sp, color = MaterialTheme.colors.primary)
        Spacer(modifier = Modifier.height(20.dp))
        val (supname,setsupname) = remember{ mutableStateOf("") }
        customTextFieldS(content = "Name", VisualTransformation.None,supname,setsupname)
        Spacer(modifier = Modifier.height(2.dp))
        val (supemail,setsupemail)= remember{ mutableStateOf("") }
        customTextFieldS(content = "Email", VisualTransformation.None,supemail,setsupemail)
        Spacer(modifier = Modifier.height(2.dp))
        val (suppassword,setsuppassword)= remember { mutableStateOf("") }
        customTextFieldS(content = "Password",
            PasswordVisualTransformation(),suppassword,setsuppassword)
        Spacer(modifier = Modifier.height(2.dp))
        val (cnfrmpassword,setcnfmpassword)= remember{ mutableStateOf("") }
        customTextFieldS(content = "Confirm Password",
            PasswordVisualTransformation(),cnfrmpassword,setcnfmpassword)
        Spacer(modifier = Modifier.height(70.dp))
        ButtonExampleSup1("Sign Up",supname,supemail,suppassword,cnfrmpassword)
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text="Already a User? Sign in",
            fontSize = 15.sp,
            color = MaterialTheme.colors.primary,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.clickable { navController.navigate(Screens.signinpage.route) }
        )
    }
}

@Composable
fun ButtonExampleSup1(btnname:String,value: String,value1: String,pass: String,cpass: String) {
    Button(
        onClick = { navController.navigate(Screens.landingpage.route) },
        modifier = Modifier
            .clip(RoundedCornerShape(50.dp))
            .background(color = MaterialTheme.colors.primaryVariant)
            .clickable { navController.navigate(Screens.landingpage.route) },
        enabled = value.isNotBlank() && value1.isNotBlank() && pass.isNotBlank() && cpass.isNotBlank() && pass==cpass,
    ) {
        Text(text = btnname,fontSize = 20.sp,modifier= Modifier.padding(start = 10.dp,top=2.dp,bottom = 2.dp,end = 10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewSUP1(){
    CarPoolingAppTheme {
       ContentsSignup(navController = rememberNavController())
    }
}