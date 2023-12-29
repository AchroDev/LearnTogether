package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Calls the function to start the app
                    ComposeArticleApp()
                }
            }
        }
    }
}

@Composable
// Function for the app to start and initializing strings and image resources
fun ComposeArticleApp() {
    // Calling the private function "ArticleCard" and assigning the variables
    ArticleCard(
        // First string for the title bar
        title = stringResource(R.string.title),
        // Second string for the first passage
        summary = stringResource(R.string.summary),
        // Third string for the last passage
        description = stringResource(R.string.description),
        // Initializes/Loads the image resource
        imagePainter = painterResource(R.drawable.bg_compose_background)
    )
}

@Composable
// Private function for the main structure and styling to images and text
private fun ArticleCard(
    // Sets the "title" variable to a String type
    title: String,
    // Sets the "summary" variable to a String type
    summary: String,
    // Sets the "description" variable to a String type
    description: String,
    // Sets the "imagePainter" variable to a Painter type declaring something that can be drawn
    imagePainter: Painter,
    // MoDiFiEr
    modifier: Modifier = Modifier,

) {
    // Column to orient the image and text on the app scren properly
    Column(modifier = modifier) {
        // Draws the image and sets a block for it in the structure
        Image(painter = imagePainter, contentDescription = null)
        // Displays the title text and sets a block for it in the structure
        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        // Displays the summary text and sets a block for it in the structure
        Text(
            text = summary,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        // Displays the description text and sets a block for it in the structure
        Text(
            text = description,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    LearnTogetherTheme {
        // Calls the function to run the app
        ComposeArticleApp()
    }
}