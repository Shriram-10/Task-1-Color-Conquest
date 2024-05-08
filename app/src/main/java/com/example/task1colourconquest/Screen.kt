package com.example.task1colourconquest

sealed class Screen(val route: String) {
    object HomePage : Screen("home_page")
    object PlayerInformation : Screen("player_info")
}
