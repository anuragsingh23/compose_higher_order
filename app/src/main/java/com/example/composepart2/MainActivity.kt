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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepart2.ui.theme.ComposePart2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ComposePart2Theme {
                    Surface(color = MaterialTheme.colors.background) {
                        Greeting("inder","63")
                }
            }
                }
            }
        }




@Composable
//Box compose function
fun Greeting(
    normal :String,
    script : String
){
    Text(text = buildAnnotatedString {
        withStyle (
            style = SpanStyle(
                fontSize = MaterialTheme.typography.h3.fontSize
            )
                ){
            append(normal)
        }
    })
    Text(text = buildAnnotatedString {
        withStyle (
            style = SpanStyle(
                fontSize = MaterialTheme.typography.h6.fontSize,
                baselineShift = BaselineShift.Superscript
            )
        ){
            append(normal)
        }
    })
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePart2Theme {
        Greeting("inder","63")
    }
}