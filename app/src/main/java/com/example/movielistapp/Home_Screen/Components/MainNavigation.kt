package com.example.movielistapp.Home_Screen.Components

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movielistapp.opening_screen.IntroScreen


@Composable
fun NavigationRoutes() {
    val navigationController = rememberNavController()

    NavHost(navController = navigationController, startDestination = nav_routes.INTRO ){
        composable(nav_routes.INTRO){
            IntroScreen(navigationController = navigationController)
        }
        composable(nav_routes.HOME){
            MainNavigation(navigationController)
        }
        composable(nav_routes.SEARCH){
            Search()
        }
        composable(nav_routes.ADD){
            Add()
        }
        composable(nav_routes.ACCOUNT){
            Account()
        }
        composable(nav_routes.FILE){
            Home(modifier = Modifier,navigationController)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainNavigation(navigationController: NavHostController) {
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    var selected by remember {
        mutableStateOf(Icons.Filled.Home)
    }

    Scaffold(bottomBar = {
        NavigationBar {
            IconButton(onClick = {
                selected = Icons.Filled.Home
                navigationController.navigate(nav_routes.HOME)
            }, modifier = Modifier.weight(1f)) {
                Icon(Icons.Filled.Home, contentDescription ="Home", tint = if(selected==Icons.Filled.Home) MaterialTheme.colorScheme.tertiary else Color.Gray )
            }


            IconButton(onClick = {
                selected = Icons.Filled.Search
                navigationController.navigate(nav_routes.SEARCH)
            }, modifier = Modifier.weight(1f)) {
                Icon(Icons.Filled.Search, contentDescription ="Home", tint = if(selected==Icons.Filled.Search) Color.Green else Color.Gray )
            }

            Box(modifier = Modifier.weight(1f)) {
                FloatingActionButton(onClick = { Toast.makeText(context,"Item is Added",Toast.LENGTH_SHORT).show() },
                    shape = FloatingActionButtonDefaults.largeShape,
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.align(Alignment.Center)) {
                    Icon(Icons.Filled.Add, contentDescription = "Add")
                }
            }

            IconButton(onClick = {
                selected = Icons.Filled.Favorite
                navigationController.navigate(nav_routes.FILE)
            }, modifier = Modifier.weight(1f)) {
                Icon(Icons.Filled.Favorite, contentDescription ="Home", tint = if(selected==Icons.Filled.Favorite) Color.Green else Color.Gray )
            }

            IconButton(onClick = {
                selected = Icons.Filled.AccountCircle
                navigationController.navigate(nav_routes.ACCOUNT)
            }, modifier = Modifier.weight(1f)) {
                Icon(Icons.Filled.Person, contentDescription ="Home", tint = if(selected==Icons.Filled.AccountCircle) Color.Green else Color.Gray )
            }

        }
    }) {paddingValues->
        Home(modifier = Modifier.padding(paddingValues),navigationController)
//        IntroScreen(navigationController = navigationController)
//        NavigationRoutes(navigationController)

    }
}

@Preview
@Composable
private fun Previewnavigation() {
    MainNavigation(rememberNavController())
}


object nav_routes{
    const val INTRO ="intro"
    const val HOME = "home"
    const val FILE ="file"
    const val ADD = "add"
    const val DOWNLOAD = "download"
    const val ACCOUNT ="account"
    const val SEARCH = "search"
}
