package com.example.carpoolingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carpoolingapp.ui.theme.CarPoolingAppTheme

var name:String = "James"
var car:String ="Honda City"
var time:String = "13:00"
var place:String = "GreenWood"
var cost:String = "48"
var drating:Float = 5.0f
var crating:Float =4.8f

@Composable
fun ContentsRideDetails() {
    Column(modifier= Modifier.fillMaxSize()){
       Commons()
       InitialState()
    }
}

@Composable
fun Commons() {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,){
        Column(Modifier.padding(top=10.dp,end=10.dp,bottom=10.dp,start=10.dp)){
            Text(text=name,fontSize = 28.sp,color= MaterialTheme.colors.primary)
            Text(text=car,fontSize = 22.sp,color= MaterialTheme.colors.primaryVariant)
            Text(text =time,fontSize = 22.sp, color= MaterialTheme.colors.primaryVariant)
            Text(text =place, fontSize = 22.sp,color= MaterialTheme.colors.primaryVariant)
        }
        Column(verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(end=10.dp)){
            Text(text=cost,fontSize = 65.sp, color= MaterialTheme.colors.primary)}
    }
    Spacer(modifier = Modifier.height(10.dp))
    var co1:String = "Jake"
    var co2:String = "James"
    var co3:String = ""
    Column(Modifier.padding(top=10.dp,end=10.dp,bottom=10.dp,start=10.dp)){
        Text(text = "Co Passangers", fontSize = 25.sp, color = MaterialTheme.colors.primary)
        Text(text = co1, fontSize = 22.sp, color = MaterialTheme.colors.primaryVariant)
        Text(text = co2, fontSize = 22.sp,color = MaterialTheme.colors.primaryVariant)
        Text(text = co3, fontSize = 22.sp, color = MaterialTheme.colors.primaryVariant)
    }
}

@Composable
fun InitialState() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ){
        Text("Driver Rating",fontSize = 25.sp,color = MaterialTheme.colors.primary)
        Text("$drating/5.0",fontSize = 40.sp,color = MaterialTheme.colors.primaryVariant)
        Spacer(modifier = Modifier.height(20.dp))
        Text("Car Rating",fontSize = 25.sp,color = MaterialTheme.colors.primary)
        Text("$crating/5.0",fontSize = 40.sp,color = MaterialTheme.colors.primaryVariant)
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = { /* Do something! */ },
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .background(color = MaterialTheme.colors.primaryVariant),
         ) {
            Text(text = "Join",fontSize = 20.sp,modifier= Modifier.padding(start = 10.dp,top=2.dp,bottom = 2.dp,end = 10.dp))
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text ="You will get notified once $name accepts your request",
            fontSize = 14.sp,color = MaterialTheme.colors.secondary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRideDetails(){
    CarPoolingAppTheme {
        ContentsRideDetails()
    }
}