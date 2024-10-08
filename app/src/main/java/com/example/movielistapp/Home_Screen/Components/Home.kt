package com.example.movielistapp.Home_Screen.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movielistapp.Home_Screen.HomeScreenEvent
import com.example.movielistapp.Home_Screen.HomeScreenViewState
import com.example.movielistapp.core.viewmodel.BaseViewState
import com.example.movielistapp.Home_Screen.domain.HomeScreenViewModel
import com.example.movielistapp.Home_Screen.model.movieDto


@Composable
fun Home(modifier: Modifier = Modifier,
         navigationController:NavController,
         viewModel: HomeScreenViewModel = hiltViewModel()
){
    val uiState by viewModel.uiState.collectAsState()
    LaunchedEffect(key1 = viewModel){
        viewModel.ontriggerEvent(HomeScreenEvent.LoadTopRatedMovies)
        viewModel.ontriggerEvent(HomeScreenEvent.LoadtPopularMovies)
    }
    HomeScreenBody(uiState,viewModel,navigationController)


}

@Composable
fun HomeScreenBody(
    uiState: BaseViewState<*>,
    viewModel: HomeScreenViewModel,
    navigationController: NavController
) {
    Scaffold(bottomBar = {
        BottomAppBar(modifier = Modifier, navigationController = navigationController)
    }){
        HomeScreenContent(it,Modifier,navigationController,uiState)
    }
}

@Composable
fun HomeScreenContent(
    padding: PaddingValues,
    modifier: Modifier = Modifier,
    navigationController: NavController,
    uiState: BaseViewState<*>
){
    when(uiState){
        is BaseViewState.Data -> {
            val homeScreenViewState = (uiState as BaseViewState.Data<*>).value as? HomeScreenViewState
            HomeScreen(modifier =Modifier.padding(padding),homeScreenViewState,navigationController)
        }
        BaseViewState.Empty -> Text(text = "Sorry The response is empty")
        is BaseViewState.Error -> Text(text = "Error for loading the data")
        BaseViewState.Loading -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator(trackColor = MaterialTheme.colorScheme.primary)
            }
        }
    }

}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeScreenViewState: HomeScreenViewState?,
    navigationController: NavController
){
    val scroll = rememberScrollState()

    Column(modifier = modifier
        .fillMaxWidth()
        .verticalScroll(scroll)
        .background(color = MaterialTheme.colorScheme.primary)
    ) {

        ImageSection(modifier = Modifier,300)
        Column(horizontalAlignment = Alignment.CenterHorizontally ,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(top = 16.dp, start = 16.dp)
        ) {
            val topRatedMovies = homeScreenViewState?.topRatedModel
            val popularMovies = homeScreenViewState?.popularMovieModel
            CardTitile(title = "Top Rated Movies")
            ShowingCardItems(topRatedMovies, null,navigationController)
            CardTitile(title = "Upcoming Movies")
            ShowingCardItems(null, popularMovies, navigationController)

        }
    }
}


@Composable
fun ShowingCardItems(
    topRated: List<movieDto>? = null,
    popularMovies: List<movieDto>? = null,
    navigationController: NavController
) {

    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        if(topRated!=null){

            items(topRated.size){
                val singleItem = topRated[it]
                ScrollableCard(modifier = Modifier.clickable {
                    val movieId = topRated[it].id
                    navigationController.navigate("${nav_routes.MOVIE_DETAILS}/$movieId")
                },imageUrl = singleItem.poster, imageTitile = singleItem.title)
            }
        }else{

        }
        if(popularMovies!=null){
            val response = popularMovies
            items(response.size){
                val singleItem = response[it]
                ScrollableCard(modifier = Modifier.clickable {
                    val movieId = singleItem.id
                    navigationController.navigate("${nav_routes.MOVIE_DETAILS}/$movieId")
                },imageUrl = singleItem.poster, imageTitile = singleItem.title)
            }
    }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeSection() {
    Home(modifier = Modifier.fillMaxSize(), rememberNavController())
}