package com.example.carpoolingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carpoolingapp.ui.theme.CarPoolingAppTheme


@Composable
fun ContentsAccountPage() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center){
            Image(painterResource(id = R.drawable.ic_usericon),
                  contentDescription = "Avatar",
                  modifier = Modifier
                      .height(100.dp)
                      .aspectRatio(1f)
                )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row(horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()
            ){
            Text(text = "Joshua", fontSize = 35.sp, color = MaterialTheme.colors.primary)}
        Spacer(modifier = Modifier
            .height(50.dp)
            .background(color = Color.Magenta))
        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth()
        ){
            Text(text = "Change Password",fontSize = 25.sp,color = MaterialTheme.colors.primary)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Pending Requests",fontSize = 25.sp,color = MaterialTheme.colors.primary)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text= "Sign out",fontSize = 25.sp, color = MaterialTheme.colors.primary)
            Spacer(modifier= Modifier.height(20.dp))
            Text(text= "Stats",fontSize= 25.sp, color = MaterialTheme.colors.primary)
            Spacer(modifier= Modifier.height(15.dp))
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth()
            ){
                Text(text = "Rides Shared:",fontSize = 22.sp,color = MaterialTheme.colors.primary)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text= "Rides Contributed:",fontSize = 22.sp, color = MaterialTheme.colors.primary)
                Spacer(modifier= Modifier.height(10.dp))
                Text(text= "Percent Contributed:",fontSize= 22.sp, color = MaterialTheme.colors.primary)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAccountPage() {
    CarPoolingAppTheme {
        ContentsAccountPage()
    }
}