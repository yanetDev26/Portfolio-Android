package com.example.mypresentation

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
                Navigation()
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
            CreateBizCard()
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

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().background(
            colorResource(id = R.color.lightBlue)
        )) {
        Image(painter = painterResource(id = R.drawable.banner),
            contentDescription = "Splash",
            modifier = Modifier.scale(scale.value).width(900.dp).height(900.dp))
    }
}

@Preview
@Composable
fun CreateBizCard() {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {

        Card(modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            backgroundColor = colorResource(id = R.color.lightBlue)) {

            Card(modifier = Modifier.width(200.dp)
                .height(390.dp)
                .padding(16.dp),
                shape = RoundedCornerShape(corner = CornerSize(15.dp)),
                backgroundColor = colorResource(id = R.color.gray),
                elevation = 4.dp) {

                Column(modifier = Modifier.height(300.dp)
                    .padding(5.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    CreateImageProfile()
                    Divider()
                    Presentation()
                    Skills()
                }
            }
        }
    }
}

@Composable
private fun Skills() {
    Button(onClick = {/*TODO*/ }) {

    }
}

@Composable
private fun Presentation() {
    Column(modifier = Modifier.padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Yanet Rodriguez",
            style = MaterialTheme.typography.h4,
            color = colorResource(id = R.color.black))

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Mobile developer.",
            style = MaterialTheme.typography.subtitle1,
            color = colorResource(id = R.color.black))

        Spacer(modifier = Modifier.height(30.dp))

        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Box() {
                IconButton(onClick = {

                }) {
                    Image(painter = painterResource(id = R.drawable.linkedin),
                        contentDescription = "LinkedIn",
                        modifier = Modifier.size(45.dp))
                }
            }

            Spacer(modifier = Modifier.width(20.dp))

            Box() {
                IconButton(onClick = {

                }) {
                    Image(painter = painterResource(id = R.drawable.github),
                        contentDescription = "GitHub",
                        modifier = Modifier.size(45.dp))
                }
            }

            Spacer(modifier = Modifier.width(20.dp))

            Box() {
                IconButton(onClick = {

                }) {
                    Image(painter = painterResource(id = R.drawable.twitter),
                        contentDescription = "Twitter",
                        modifier = Modifier.size(45.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Box() {
                IconButton(onClick = {

                }) {
                    Image(painter = painterResource(id = R.drawable.discord),
                        contentDescription = "Discord",
                        modifier = Modifier.size(45.dp))
                }
            }

            Spacer(modifier = Modifier.width(20.dp))

            Box() {
                IconButton(onClick = {

                }) {
                    Image(painter = painterResource(id = R.drawable.outlook),
                        contentDescription = "Outlook",
                        modifier = Modifier.size(45.dp))
                }
            }

            Spacer(modifier = Modifier.width(20.dp))

            Box() {
                IconButton(onClick = {

                }) {
                    Image(
                        painter = painterResource(id = R.drawable.gmail),
                        contentDescription = "Gmail",
                        modifier = Modifier.size(45.dp))
                }
            }
        }
    }
}

@Composable
private fun Divider() {
    Divider(thickness = 5.dp,
        modifier = Modifier.padding(5.dp)
            .background(colorResource(id = R.color.lightBlue)))
}

@Composable
private fun CreateImageProfile() {
    Surface(modifier = Modifier.size(150.dp)
        .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)) {

        Image(painter = painterResource(id = R.drawable.profile),
            contentDescription = "profile_picture",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop)
    }
}