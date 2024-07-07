package com.example.movielistapp.Home_Screen.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
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
import com.example.movielistapp.Home_Screen.HomeScreenEvent
import com.example.movielistapp.Home_Screen.HomeScreenViewState
import com.example.movielistapp.Home_Screen.domain.BaseViewState
import com.example.movielistapp.Home_Screen.domain.HomeScreenViewModel


@Composable
fun Home(modifier: Modifier = Modifier, viewModel: HomeScreenViewModel = hiltViewModel()){
    val scroll = rememberScrollState()
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = viewModel){
        viewModel.ontriggerEvent(HomeScreenEvent.LoadTopRatedMovies)
    }

    Column(modifier = modifier
        .fillMaxWidth()
        .padding(bottom = 20.dp)
        .verticalScroll(scroll)) {

        ImageSection(modifier = Modifier,300)
        Column(horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp)) {
            CardTitile(title = "Top Rated Movies")
            ShowingCardItems(uiState)
            CardTitile(title = "Upcoming Movies")
            ShowingCardItems(uiState)

        }
    }

}

@Composable
fun ShowingCardItems(uiState: BaseViewState<*>) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        when(uiState){
            is BaseViewState.Data -> {
                val homeScreenViewState = uiState.value as? HomeScreenViewState
                homeScreenViewState?.topRatedModel?.data?.titleChartRankings?.edges?.let { edges ->
                    items(edges) { edge ->
                        val item =edge.node.item
                        ScrollableCard(modifier = Modifier,imageUrl = item.primaryImage.url, imageTitile = item.originalTitleText.text.toString(), rating = item.ratingsSummary.topRanking.rank)
                    }
                }
            }

            BaseViewState.Empty -> {
                item {
                    Text("No data available", modifier = Modifier.padding(16.dp))
                }
            }
            is BaseViewState.Error -> {
                item {
                    Text("An error occurred: ${uiState.throwable.message}", modifier = Modifier.padding(16.dp))
                }
            }
            BaseViewState.Loading -> {
                item {
                    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeSection() {
    Home(modifier = Modifier.fillMaxSize())
}