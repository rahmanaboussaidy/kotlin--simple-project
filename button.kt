package com.example.myapplication

import android.R.attr.contentDescription
import android.R.attr.right
import android.R.style
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontSynthesis.Companion.Style
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }
    }
}

@Composable
fun Timely(){
    var showTime by remember { mutableStateOf(true)}
   Column(
       horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.Center,
       modifier = Modifier.fillMaxSize()
   ) {
       TextField(
           value = "",
           onValueChange = {},
           modifier = Modifier.padding(200.dp)

       )

       if (showTime) {
           Text(
               "20",
               fontSize = 50.sp,
               fontWeight = FontWeight.Bold
           )
       } else {
           Text(
               "List of activities",
               style = TextStyle(
                   fontSize = 50.sp,
                   fontWeight = FontWeight.Bold
               )
           )
       }
           Spacer(Modifier.height(40.dp))
           Button(onClick = { showTime = !showTime }) {
               Text(
                   if (showTime) "Show activities" else "Show time", style = TextStyle(
                       fontSize = 28.sp
                   )
               )
           }
       }


   }

@Preview(showSystemUi = true)
@Composable
fun TimelyPreview(){
    Timely()
}

