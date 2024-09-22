package com.example.movielistapp.movie_details.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.movielistapp.core.color.MyColor
import com.example.movielistapp.core.viewmodel.BaseViewState
import com.example.movielistapp.movie_details.MovieDetailsEvent
import com.example.movielistapp.movie_details.MovieDetailsState
import com.example.movielistapp.movie_details.domain.MovieDetailsVGiewModel
import com.example.movielistapp.ui.theme.MovieListAppTheme


@Composable
fun MovieDetails(
    movieId: Int,
    navigationController: NavController,
    viewModel:MovieDetailsVGiewModel= hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.ontriggerEvent(MovieDetailsEvent.ShowDetails(movieId))
    }
    MovieDetailsBody(Modifier,uiState,navigationController)

}

@Composable
fun MovieDetailsBody(
    modifier: Modifier = Modifier,
    uiState: BaseViewState<*>,
    navigationController: NavController
){
    when(uiState){
        is BaseViewState.Data -> {
            MovieDetailsContent(Modifier,uiState,navigationController)
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
fun MovieDetailsContent(
    modifier: Modifier = Modifier,
    uiState: BaseViewState.Data<*>,
    navigationController: NavController
){
    val data = (uiState as BaseViewState.Data<*>).value as? MovieDetailsState
    val image = data?.movieData?.poster_path

    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(20.dp)) {
        MovieDetailsImage(modifier = Modifier.weight(0.5f),image,navigationController)
        DetailsSection(modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .weight(0.5f),
            data)
    }
}


@Composable
fun MovieDetailsImage(
    modifier: Modifier = Modifier,
    image: String?,
    navigationController: NavController
){
    Box (modifier = modifier
        .fillMaxWidth()){

        AsyncImage(model ="https://image.tmdb.org/t/p/w500/${image}",
            contentDescription = "Movie",
            modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        FilledIconButton(onClick = { navigationController.popBackStack() },
            colors = IconButtonDefaults.iconButtonColors(containerColor = MyColor.myPrimary, contentColor = MaterialTheme.colorScheme.secondary),) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
        }

        FilledIconButton(onClick = { /*TODO*/ },
            colors = IconButtonDefaults.iconButtonColors(containerColor = MyColor.myPrimary, contentColor = MaterialTheme.colorScheme.secondary),
            modifier = Modifier.align(Alignment.TopEnd)) {
            Icon(Icons.Filled.Favorite, contentDescription = null)
        }

    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DetailsSection(modifier: Modifier = Modifier, data: MovieDetailsState?){
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(text = "${data?.movieData?.title}", color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.headlineMedium)
        Row(horizontalArrangement = Arrangement.spacedBy(30.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                Icon(Icons.Filled.Star, contentDescription ="Star", tint = MaterialTheme.colorScheme.tertiary )
                Text(text = "${data?.movieData?.vote}",color = MaterialTheme.colorScheme.secondary)
            }

            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                Icon(Icons.Filled.DateRange, contentDescription ="Star", tint = MaterialTheme.colorScheme.secondary )
                Text(text = "${data?.movieData?.release_date}",color = MaterialTheme.colorScheme.secondary)
            }
        }
        FlowRow(horizontalArrangement = Arrangement.spacedBy(26.dp)){
            data?.movieData?.genres?.forEach {
                SuggestionChip(onClick = { /*TODO*/ }, label = {
                    Text(text = it)
                }, border = BorderStroke(1.dp,Color.White),
                    colors = SuggestionChipDefaults.suggestionChipColors(labelColor = MaterialTheme.colorScheme.secondary))
            }
        }

        Column {
            Text(
                text = "Summary",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.tertiary
            )

            Text(text = "${data?.movieData?.overview}",
                style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.secondary)
        }
    }

}

@Preview
@Composable
private fun MovieDetailsMainPrev() {
//    MovieListAppTheme {
//        MovieDetailsBody(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(MaterialTheme.colorScheme.primary), uiState = uiState
//        )
//    }
}
//
//@Preview
//@Composable
//private fun PreviewMoviewDetailsImg() {
//    MovieListAppTheme {
//        MovieDetailsImage(image = image, navigationController = navigationController)
//    }
//}
//
//@Preview()
//@Composable
//private fun PreviewDetails() {
//    MovieListAppTheme {
//        DetailsSection(data = data)
//    }
//
//}