package com.example.movielistapp.opening_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movielistapp.Home_Screen.Components.nav_routes
import com.example.movielistapp.R
import com.example.movielistapp.core.component.PrimaryBtn
import com.example.movielistapp.ui.theme.MovieListAppTheme


@Composable
fun IntroScreen(modifier: Modifier = Modifier,navigationController:NavController){

    Column(modifier = modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.primary), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Image(painter = painterResource(id = R.drawable.intro_pic), contentDescription = "Intro Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .weight(0.4f)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(bottomStart = 25.dp, bottomEnd = 25.dp)))

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.Start) {

            Text(text = "Discover Your",
                style = MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.secondary) )

            Text(text = "Favourite Show",
                style = MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.tertiary) )

            Text(text = "Watch Now or Watch Later",
                style = MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.secondary) )
        }

        Text(text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley.",
            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.secondary),
            modifier = Modifier.padding(start = 20.dp, end = 20.dp))

        PrimaryBtn(modifier = Modifier.padding(bottom = 25.dp, start = 20.dp, end = 20.dp)
            ,btnTxt = "Get Started"
        ) {
            navigationController.navigate(nav_routes.HOME)
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewIntroScreen() {
    MovieListAppTheme {
        IntroScreen(modifier = Modifier.fillMaxSize(), rememberNavController())
    }
}


