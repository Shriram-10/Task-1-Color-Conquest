package com.example.task1colourconquest

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = Screen.HomePage.route) {
        composable(route = Screen.HomePage.route) {
            HomePage(navController = navController)
        }
        composable(route = Screen.PlayerInformation.route) {
            PlayerPage(navController = navController)
        }
        composable(
            route = Screen.GamePage.route + "/{name1}/{name2}",
            arguments = listOf(
                navArgument("name1") {
                    type = NavType.StringType
                    defaultValue = "Player 1"
                },
                navArgument("name2") {
                    type = NavType.StringType
                    defaultValue = "Player 2"
                }
            )
        ){entry ->
            val name1 = entry.arguments?.getString("name1")
            val name2 = entry.arguments?.getString("name2")

            GamePage(navController = navController, name1 = name1, name2 = name2)
        }
    }
}







