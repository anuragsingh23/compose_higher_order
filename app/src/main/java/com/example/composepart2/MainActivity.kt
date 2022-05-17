package com.example.composepart2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepart2.ui.theme.ComposePart2Theme
import com.example.composepart2.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ComposePart2Theme {
                androidx.compose.material.Surface(color = MaterialTheme.colors.background) {
                    Column (modifier = Modifier.fillMaxSize()
                        , horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        CustomItem(color = MaterialTheme.colors.secondaryVariant, weight =3f )
                        CustomItem(weight = 1f)
                    }
                }
            }
                }
            }
        }




@Composable
//Column extension function
fun ColumnScope.CustomItem(color: Color = MaterialTheme.colors.onPrimary , weight : Float ) {
    Surface(
        modifier = Modifier
            .weight(weight)
            .width(200.dp)
            ,color = color,
    ) {

    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePart2Theme {
        Column (modifier = Modifier.fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally)
        {
             CustomItem(color = MaterialTheme.colors.onError, weight =3f )
            CustomItem(weight = 1f)
        }
    }
}