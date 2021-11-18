package com.example.carpoolingapp

//import androidx.compose.foundation.Image
import androidx.compose.foundation.background
//import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
//import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.carpoolingapp.ui.theme.CarPoolingAppTheme

@Composable
fun ContentsFindRidepg(navController: NavController) {
  Column(modifier = Modifier.fillMaxSize()) {

      /*Query Column*/
      Column(modifier = Modifier
          .shadow(elevation = 8.dp)
          .background(color = Color.White)
          .fillMaxWidth()
      ) {
          Column(
              modifier = Modifier
                  .padding(10.dp)
                  .fillMaxWidth()
          ) {
              val (start, setstart) = remember { mutableStateOf("") }
              customTextFieldSh(
                  content = "Start",
                  VisualTransformation.None,
                  value = start,
                  onValueChanged = setstart
              )
              val (destination, setdestination) = remember { mutableStateOf("") }
              customTextFieldSh(
                  content = "Destination",
                  VisualTransformation.None,
                  value = destination,
                  onValueChanged = setdestination
              )
              val (time, settime) = remember { mutableStateOf("") }
              customTextFieldSh(
                  content = "Time",
                  VisualTransformation.None,
                  value = time,
                  onValueChanged = settime
              )
          }

          Spacer(modifier = Modifier.width(10.dp))

          Column(
              horizontalAlignment = Alignment.CenterHorizontally,
              verticalArrangement = Arrangement.Center,
              modifier = Modifier.padding(start = 10.dp, end = 10.dp)
          )
          {
              Box(
                  modifier = Modifier
                      .shadow(elevation = 8.dp, shape = RoundedCornerShape(20.dp))
                      .background(color = Color.White)
                      .clip(shape = RoundedCornerShape(50.dp))
                      .padding(top = 5.dp, bottom = 5.dp)
                      .fillMaxWidth()
                      .clickable {}, contentAlignment = Alignment.Center
              ) {
                  Text(text = "GO", fontSize = 25.sp, color = MaterialTheme.colors.primary)
              }
          }


          /*Query Column ends*/


          val number = 9
          /*Results*/
          Text(
              text = "$number results found",
              fontSize = 20.sp,
              color = MaterialTheme.colors.primary,
              modifier = Modifier.padding(start = 10.dp, top = 10.dp, bottom = 10.dp),
              fontStyle = FontStyle.Italic
          )
          /*End of results*/
      }
      var scrollState = rememberScrollState()

      /*Result Lists- Actually lazy column to be used for simplicity and is a small project
      * Column is used with scroll state
      * */
      Column(modifier = Modifier
          .padding(start = 15.dp, end = 15.dp, bottom = 10.dp)
          .verticalScroll(enabled = true, state = scrollState)) {
          Spacer(modifier = Modifier.height(8.dp))
          RideCard("James","Honda City","13:00","GreenWood","48")
          RideCard("Tony","Suzuki Swift","18:00","Mount Chilliad","45")
          RideCard("Peter","Alto","06:00","Vine Wood","105")
          RideCard("James","Honda City","13:00","GreenWood","48")
          RideCard("Tony","Suzuki Swift","18:00","Mount Chilliad","45")
          RideCard("Peter","Alto","06:00","Vine Wood","105")
          RideCard("James","Honda City","13:00","GreenWood","48")
          RideCard("Tony","Suzuki Swift","18:00","Mount Chilliad","45")
          RideCard("Peter","Alto","06:00","Vine Wood","105")
      }
  }
}

@Composable
fun RideCard(name:String,car:String,time:String,place:String,cost:String) {
    Box(modifier = Modifier
        .shadow(elevation = 8.dp, shape = RoundedCornerShape(10.dp))
        .background(color = Color.White)
        .clip(shape = CircleShape)
        .padding(start = 14.dp, end = 14.dp)
        .fillMaxWidth()
        .clickable { navController.navigate(Screens.ridedetailspage.route) },
    ) {
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,){
            Column(Modifier.padding(top=10.dp,end=5.dp,bottom=10.dp,start=5.dp)){
                Text(text=name,fontSize = 25.sp,color=MaterialTheme.colors.primary)
                Text(text=car,fontSize = 18.sp,color=MaterialTheme.colors.primaryVariant)
                Text(text =time,fontSize = 18.sp, color=MaterialTheme.colors.primaryVariant)
                Text(text =place, fontSize = 18.sp,color= MaterialTheme.colors.primaryVariant)
            }
            Column(verticalArrangement = Arrangement.SpaceAround,
                   horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text=cost,fontSize = 60.sp, color= MaterialTheme.colors.primary)
            }
        }
    }
    Spacer(Modifier.height(8.dp))
}

@Preview(showBackground = true)
@Composable
fun PreviewFindridepage() {
    CarPoolingAppTheme {
        ContentsFindRidepg(navController = rememberNavController())
    }
}