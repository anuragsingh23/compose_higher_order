package com.example.composepart2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepart2.ui.theme.ComposePart2Theme
import com.example.composepart2.ui.theme.Typography
import java.security.AllPermission

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ComposePart2Theme {
                    Surface(color = MaterialTheme.colors.background) {
                   Greeting()
                }
            }
                }
            }
        }




@Composable
//Box compose function
fun Greeting(){
    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.TopCenter){
        Box(modifier = Modifier
            .height(400.dp)
            .width(400.dp)
            .verticalScroll(rememberScrollState())
            .background(color = Color.Green)) {

            Text(text = "i am anurag shekhawat", color = MaterialTheme.colors.onPrimary, fontSize = 60.sp)

        }

    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePart2Theme {
        Greeting()
    }
}