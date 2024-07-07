package com.example.movielistapp.Home_Screen.Components

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movielistapp.R

class ImageSliderSection {
}

@Composable
fun ImageSection(modifier: Modifier=Modifier,height:Int){

    var gradientColor = listOf(Color(0XFFFF8F71),Color(0XFFEF2D1A))
    Box (modifier = modifier
        .fillMaxWidth()
        .height(height.dp)){
        Image(painter = painterResource(id = R.drawable.star_war),
            contentDescription = "Star War",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop)

        IconButton(onClick = { /*TODO*/ }, modifier = Modifier
            .size(50.dp)
            .background(
                brush = Brush.linearGradient(gradientColor), shape = RoundedCornerShape(30.dp)
            )
            .border(1.dp, color = Color.White, shape = RoundedCornerShape(30.dp))
            .align(Alignment.Center)) {
            Icon(Icons.Default.PlayArrow, contentDescription = "Null", tint = Color.White)
        }
    }
}

@Composable
fun CardTitile(title:String){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = title, style = MaterialTheme.typography.titleMedium)
    }
}


@Composable
fun ScrollableCard(modifier: Modifier=Modifier,imageUrl:String,imageTitile:String, rating:Int){
    ElevatedCard(modifier = modifier
        .height(250.dp)
        .width(200.dp), shape = MaterialTheme.shapes.medium) {
        Column(modifier = Modifier
            .width(200.dp)
            .height(250.dp)) {
            AsyncImage(model = imageUrl, contentDescription = "Movie", modifier = Modifier
                .height(180.dp)
                .fillMaxWidth(), contentScale = ContentScale.Crop
            )
            Text(text = imageTitile, modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp), style = MaterialTheme.typography.titleMedium)
            Text(text = "Ranking $rating", modifier = Modifier.padding(horizontal = 10.dp), style = MaterialTheme.typography.bodyMedium)
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
