package com.example.carpoolingapp
//Naming Screens with objects for navigation purposes
sealed class Screens (val route: String){

    object signinpage : Screens(route = "signin_screen")
    object signuppage : Screens(route = "signup_screen")
    object accountpage : Screens(route="account_screen")
    object landingpage : Screens(route="landing_screen")
    object findridepage : Screens(route="findride_screen")
    object shareridepage : Screens(route="shareride_screen")
    object ridedetailspage : Screens(route="ridedeatails_screen")
    object SSsharedsuccess : Screens(route="SS_sharesuccess")
}