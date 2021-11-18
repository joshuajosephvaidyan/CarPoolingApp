package com.example.carpoolingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.carpoolingapp.ui.theme.CarPoolingAppTheme


@Composable
fun ContentsLandingPage(navController: NavController) {

    var name: String="Joshua"
    var percent: Int=1
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.height(80.dp))
        Image(
            painterResource(id = R.drawable.ic_happyearth),
            contentDescription = "happyearth",
            modifier = Modifier
                .height(400.dp)
                .width(400.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp),
            horizontalAlignment = Alignment.Start) {

            /*Text Parts*/
            Text(text = "Hi $name,", fontSize = 30.sp
                ,color = MaterialTheme.colors.primary,)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text= "Thank you for helping us reduce $percent% of pollutants. Let’s continue our mission. "
                ,fontSize = 22.sp,color = MaterialTheme.colors.primary)
            Spacer(modifier = Modifier.height(25.dp))

            /*ButtonRows*/
            Row(horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ){

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .shadow(elevation = 8.dp, shape = CircleShape)
                            .background(color = Color.White)
                            .clip(shape = CircleShape)
                            .padding(15.dp)
                            .clickable { navController.navigate(Screens.accountpage.route)},
                    ) {
                        Image(
                            painterResource(id = R.drawable.ic_usericon),
                            contentDescription = "usericon",
                            Modifier
                                .height(30.dp)
                                .width(30.dp),
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Account",
                        fontSize = 15.sp,
                        color = MaterialTheme.colors.primaryVariant
                    )
                }


                Column(horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Box(
                        modifier = Modifier
                            .shadow(elevation = 8.dp, shape = CircleShape)
                            .background(color = Color.White)
                            .clip(shape = CircleShape)
                            .padding(15.dp)
                            .clickable { navController.navigate(Screens.findridepage.route) },
                    ) {
                        Image(
                            painterResource(id = R.drawable.ic_searchicon),
                            contentDescription = "searchicon",
                            Modifier
                                .height(30.dp)
                                .width(30.dp),
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Find",
                        fontSize = 15.sp,
                        color = MaterialTheme.colors.primaryVariant
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Box(
                        modifier = Modifier
                            .shadow(elevation = 8.dp, shape = CircleShape, clip = true)
                            .background(color = Color.White)
                            .clip(shape = CircleShape)
                            .padding(15.dp)
                            .clickable { navController.navigate(Screens.shareridepage.route) }
                    ) {
                        Image(
                            painterResource(id = R.drawable.ic_londoncab),
                            contentDescription = "londoncab",
                            Modifier
                                .height(30.dp)
                                .width(30.dp),
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Share",
                        fontSize = 15.sp,
                        color = MaterialTheme.colors.primaryVariant
                    )

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewLandpg1() {
    CarPoolingAppTheme {
        ContentsLandingPage(navController = rememberNavController())
    }
}