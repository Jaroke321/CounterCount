 package com.example.introtocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.introtocompose.ui.theme.IntroToComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroToComposeTheme {

                myApp()

            }
        }
    }
}

@Composable
fun myApp() {

    val moneyCounter = remember {
        mutableStateOf(0)
    }
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(3.dp),
        color = MaterialTheme.colors.primaryVariant,
        elevation = 5.dp,
        shape = RoundedCornerShape(20.dp) ) {

        // Inside of Main Surface

        // Create column to hold all of the elements
        Column(verticalArrangement = Arrangement.Bottom,
               horizontalAlignment = Alignment.CenterHorizontally) {
            
            // Inside of the column
            
            Text(
                text = "COUNT",
                style = MaterialTheme.typography.h2,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold
            )
            
            Spacer(modifier = Modifier.height(50.dp))
            
            // Create the text
            Text(text = "$${moneyCounter.value}",
                style = MaterialTheme.typography.h3,
                color = Color.White,
                fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(300.dp))
            
            // Create the Tap button
            CreateCircle(moneyCounter.value) {
                moneyCounter.value = it
            }

        } // End column

    } // End Surface
}
 

@Composable
fun CreateCircle(moneyCounter: Int, updateMoneyCounter: (Int) -> Unit) {
    
    Card(modifier = Modifier
        .padding(50.dp)
        .size(100.dp)
        .clickable { // Tap button clicked
            updateMoneyCounter(moneyCounter + 1)
        },
        shape = CircleShape,
        elevation = 5.dp) {

        // Inside of Card

        // Create a box to hold the text inside of the button
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Tap!",
                modifier = Modifier,
                style = MaterialTheme.typography.h6)
        }
        
    } // End card
    
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    IntroToComposeTheme {
        myApp()
    }
}