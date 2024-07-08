package com.example.movielistapp.core.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movielistapp.ui.theme.MovieListAppTheme


@Composable
fun PrimaryBtn(modifier: Modifier = Modifier, btnTxt: String, getStartedClick: () -> Unit){

    FilledTonalButton(onClick = { getStartedClick() },
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
            ) {
        Text(text = btnTxt, modifier = Modifier.padding(vertical = 8.dp))
    }
}

@Preview(showBackground = false)
@Composable
private fun PreviewBtn() {
    MovieListAppTheme {
        PrimaryBtn(modifier = Modifier, btnTxt = "Get Started") {

//            navigationController.navigate(com.example.movielistapp.Home_Screen.Components.nav_routes.HOME)
        }
    }
}