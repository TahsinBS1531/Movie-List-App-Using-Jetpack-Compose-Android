package com.example.movielistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movielistapp.Home_Screen.Components.Home
import com.example.movielistapp.Home_Screen.Components.MainNavigation
import com.example.movielistapp.Home_Screen.Components.NavigationRoutes
import com.example.movielistapp.Home_Screen.Components.nav_routes
import com.example.movielistapp.opening_screen.IntroScreen
import com.example.movielistapp.ui.theme.MovieListAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieListAppTheme {
//                NavigationRoutes(navigationController)
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    NavigationRoutes()
                }
            }
        }
    }
}
