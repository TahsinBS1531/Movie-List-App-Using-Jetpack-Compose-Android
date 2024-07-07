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
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movielistapp.Home_Screen.HomeScreenEvent
import com.example.movielistapp.Home_Screen.domain.HomeScreenViewModel


@Composable
fun NavigationRoutes(){
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = nav_routes.HOME ){
        composable(nav_routes.HOME){
            Home(modifier = Modifier)
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
            Home()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainNavigation(){


//    when(uiState){
//        is BaseViewState.Data -> TODO()
//        BaseViewState.Empty -> TODO()
//        is BaseViewState.Error -> TODO()
//        BaseViewState.Loading -> TODO()
//    }

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
                Icon(Icons.Filled.Home, contentDescription ="Home", tint = if(selected==Icons.Filled.Home) Color.Green else Color.Gray )
            }


            IconButton(onClick = {
                selected = Icons.Filled.Search
                navigationController.navigate(nav_routes.SEARCH)
            }, modifier = Modifier.weight(1f)) {
                Icon(Icons.Filled.Search, contentDescription ="Home", tint = if(selected==Icons.Filled.Search) Color.Green else Color.Gray )
            }

            Box(modifier = Modifier.weight(1f)) {
                FloatingActionButton(onClick = { Toast.makeText(context,"Item is Added",Toast.LENGTH_SHORT).show() }, shape = FloatingActionButtonDefaults.largeShape) {
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
        Home(modifier = Modifier.padding(paddingValues))

    }
}

@Preview
@Composable
private fun Previewnavigation() {
    MainNavigation()
}


object nav_routes{
    const val HOME = "home"
    const val FILE ="file"
    const val ADD = "add"
    const val DOWNLOAD = "download"
    const val ACCOUNT ="account"
    const val SEARCH = "search"
}
