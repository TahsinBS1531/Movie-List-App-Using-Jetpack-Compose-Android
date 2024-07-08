package com.example.movielistapp.movie_details.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ChipColors
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movielistapp.R
import com.example.movielistapp.core.color.MyColor
import com.example.movielistapp.ui.theme.MovieListAppTheme


@Composable
fun MovieDetailsImage(modifier: Modifier =Modifier){
    Box (modifier = modifier
        .fillMaxWidth()){
        Image(painter = painterResource(id =  R.drawable.wide),
            contentDescription =null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight())

        FilledIconButton(onClick = { /*TODO*/ },
            colors = IconButtonDefaults.iconButtonColors(containerColor = MyColor.myPrimary, contentColor = MaterialTheme.colorScheme.secondary),) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
        }

        FilledIconButton(onClick = { /*TODO*/ },
            colors = IconButtonDefaults.iconButtonColors(containerColor = MyColor.myPrimary, contentColor = MaterialTheme.colorScheme.secondary),
            modifier = Modifier.align(Alignment.TopEnd)) {
            Icon(Icons.Filled.Favorite, contentDescription = null)
        }
//        AsyncImage(model = painterResource(id = R.drawable.wide),
//            contentDescription ="Null",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight())
    }
}

@Composable
fun DetailsSection(modifier: Modifier =Modifier){
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(text = "Avatar the way of Water", color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.headlineMedium)
        Row(horizontalArrangement = Arrangement.spacedBy(30.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                Icon(Icons.Filled.Star, contentDescription ="Star", tint = MaterialTheme.colorScheme.tertiary )
                Text(text = "9.4",color = MaterialTheme.colorScheme.secondary)
            }

            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                Icon(Icons.Filled.DateRange, contentDescription ="Star", tint = MaterialTheme.colorScheme.secondary )
                Text(text = "9.4",color = MaterialTheme.colorScheme.secondary)
            }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(26.dp)){
            SuggestionChip(onClick = { /*TODO*/ }, label = {
                Text(text = "Drama")
            }, border = BorderStroke(1.dp,Color.White),
                colors = SuggestionChipDefaults.suggestionChipColors(labelColor = MaterialTheme.colorScheme.secondary))

            SuggestionChip(onClick = { /*TODO*/ }, label = {
                Text(text = "Action")
            }, border = BorderStroke(1.dp,Color.White),
                colors = SuggestionChipDefaults.suggestionChipColors(labelColor = MaterialTheme.colorScheme.secondary))
        }

        Column {
            Text(
                text = "Summary",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.tertiary
            )

            Text(text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing",
                style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.secondary)
        }
    }

}




@Composable
fun MovieDetailsMainScreen(modifier: Modifier=Modifier){
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(20.dp)) {
        MovieDetailsImage(modifier = Modifier.weight(0.5f))
        DetailsSection(modifier = Modifier.padding(start = 16.dp, end = 16.dp).weight(0.5f))
    }
}

@Preview
@Composable
private fun MovieDetailsMainPrev() {
    MovieListAppTheme {
        MovieDetailsMainScreen(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primary))
    }
}

@Preview
@Composable
private fun PreviewMoviewDetailsImg() {
    MovieListAppTheme {
        MovieDetailsImage()
    }
}

@Preview()
@Composable
private fun PreviewDetails() {
    MovieListAppTheme {
        DetailsSection()
    }
    
}