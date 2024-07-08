package com.example.movielistapp.Home_Screen.Components

import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movielistapp.R

class ImageSliderSection {
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSection(modifier: Modifier=Modifier,height:Int){

    var gradientColor = listOf(Color(0XFFFF8F71),Color(0XFFEF2D1A))
    val images = remember {
        mutableStateListOf(
            R.drawable.wide,
            R.drawable.wide1,
            R.drawable.wide3
        )
    }

    val pagerState = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0f, pageCount = {images.size})

    Column (modifier = modifier
        .fillMaxWidth()
        .height(height.dp)){
        HorizontalPager(state = pagerState, modifier = Modifier.fillMaxWidth()) {
            val pageOffset =  (pagerState.currentPage-it)+ pagerState.currentPageOffsetFraction
            val imageSize by animateFloatAsState(
                targetValue = if(pageOffset!=0.0f) 0.75f else 1f,
                animationSpec = tween(300), label = ""
            )

            Image(painter = painterResource(id = images[it]), contentDescription = "images",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(16.dp))
                    .graphicsLayer {
                        scaleX = imageSize
                        scaleY = imageSize
                    })
        }
        }
}

@Composable
fun CardTitile(title:String){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = title, style = MaterialTheme.typography.headlineMedium.copy(
            color = MaterialTheme.colorScheme.tertiary
        ))
    }
}


@Composable
fun ScrollableCard(modifier: Modifier=Modifier,imageUrl:String,imageTitile:String){
    ElevatedCard(modifier = modifier
        .height(270.dp)
        .width(150.dp), shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            AsyncImage(model ="https://image.tmdb.org/t/p/w500/${imageUrl}", contentDescription = "Movie", modifier = Modifier
                .height(180.dp)
                .fillMaxWidth(), contentScale = ContentScale.Crop
            )
            Text(text = imageTitile, modifier = Modifier.padding(vertical = 10.dp,horizontal = 10.dp),
                style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.secondary))
//            Text(text = "IMDB : $rating", modifier = Modifier.padding(horizontal = 10.dp), style = MaterialTheme.typography.bodyMedium)
        }

    }

}



@Composable
fun CardSection(){


}


@Preview(showBackground = true)
@Composable
private fun PreviewOutlinedCard() {
    var img = "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg"
//    ScrollableCard(modifier = Modifier, imageUrl = img)
}

@Composable
fun Spacer(size:Int){
    Spacer(size = size)
}


@Preview
@Composable
private fun PreviewImageSection() {
    ImageSection(modifier = Modifier, height = 300)
}
