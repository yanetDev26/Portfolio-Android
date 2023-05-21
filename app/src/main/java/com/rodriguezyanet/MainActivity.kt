package com.rodriguezyanet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.rodriguezyanet.navigations.Destinations
import com.rodriguezyanet.ui.theme.PortfolioAndroidTheme
import com.rodriguezyanet.views.home.HomeView
import com.rodriguezyanet.views.splash.SplashView

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortfolioAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberAnimatedNavController()
                    BoxWithConstraints {
                        AnimatedNavHost(
                            navController = navController,
                            startDestination = Destinations.Splash.route
                        ) {
                            addSplash(navController)
                            addHome(navController)
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addSplash(
    navController: NavController
) {
    composable(
        route = Destinations.Splash.route
    ) {
        SplashView(
            onNavigateToHome = {
                navController.navigate(Destinations.Home.route)
            }
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addHome(
    navController: NavController
) {
    composable(
        route = Destinations.Home.route
    ) {
        HomeView()
    }
}

