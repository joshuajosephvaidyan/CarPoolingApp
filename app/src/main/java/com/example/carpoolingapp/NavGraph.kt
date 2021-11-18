package com.example.carpoolingapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.signinpage.route){
        composable(Screens.signinpage.route){ ContentsSignin(navController)}
        composable(Screens.signuppage.route){ ContentsSignup(navController) }
        composable(Screens.landingpage.route){ ContentsLandingPage(navController) }
        composable(Screens.findridepage.route){ ContentsFindRidepg(navController) }
        composable(Screens.shareridepage.route){ ContentsShareRidePage() }
        composable(Screens.accountpage.route){ ContentsAccountPage()}
        composable(Screens.ridedetailspage.route){ ContentsRideDetails() }
        composable(Screens.SSsharedsuccess.route){ ContentsSharedSplashScreen() }
    }

}