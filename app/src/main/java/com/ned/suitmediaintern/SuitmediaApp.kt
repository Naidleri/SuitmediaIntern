package com.ned.suitmediaintern

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ned.suitmediaintern.ui.navigation.Screen
import com.ned.suitmediaintern.ui.presentation.firstscreen.FirstScreen
import com.ned.suitmediaintern.ui.presentation.secondscreen.SecondScreen
import com.ned.suitmediaintern.ui.presentation.thirdscreen.ThirdScreen

@Composable
fun SuitmediaApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.FirstScreen.route
    ) {
        composable(Screen.FirstScreen.route) {
            FirstScreen(
                navController = navController
            )
        }
        composable(Screen.SecondScreen.route) {
            SecondScreen(
                onBackClick = { navController.popBackStack() },
                navController = navController,
            )
        }

        composable(Screen.ThirdScreen.route) {
            ThirdScreen(
                onBackClick = { navController.popBackStack() },
                navigateToSecondScreen = {
                    navController.navigate(Screen.SecondScreen.route)
                },
            )
        }
    }
}
