package com.example.mypresentation

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mypresentation.ui.theme.MyPresentationTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPresentationTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("main_screen") {
            MainSreen()
        }
    }
}

@Preview
@Composable
fun MainSreen() {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        Box(contentAlignment = Alignment.TopCenter,
            modifier = Modifier.fillMaxSize().padding(top = 8.dp)) {
            Image(painter = painterResource(id = R.drawable.banner),
                contentDescription = "Banner",
                modifier = Modifier.fillMaxSize())
        }

        Text("I'm Yanet DevMobile")

        Box(contentAlignment = Alignment.TopCenter,
            modifier = Modifier.fillMaxSize().padding(top = 8.dp)) {
            Image(painter = painterResource(id = R.drawable.perfil),
                contentDescription = "Splash",
                modifier = Modifier.width(100.dp).height(100.dp))
        }

        Column {
            Box(contentAlignment = Alignment.TopCenter,
                modifier = Modifier.fillMaxSize().padding(top = 8.dp)) {
                Image(painter = painterResource(id = R.drawable.linkedin),
                    contentDescription = "Splash",
                    modifier = Modifier.width(10.dp).height(10.dp))
            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        Animatable(0f)
    }

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(3000L)
        navController.navigate("main_screen")
    }

    // Image
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().background(
            colorResource(id = R.color.lightBlue)
        )) {
        Image(painter = painterResource(id = R.drawable.banner),
            contentDescription = "Splash",
            modifier = Modifier.scale(scale.value).width(900.dp).height(900.dp))
    }
}