@file:OptIn(ExperimentalMaterialApi::class)

package com.example.composepart2.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepart2.ui.theme.Shapes


@Composable
fun CardExpandable (){
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue =if (!expandedState) 180f else 0f )
    
    Card(modifier = Modifier
        .fillMaxWidth()
        .animateContentSize(
            animationSpec = tween(
                durationMillis = 300
            )
        ),
        shape = Shapes.medium,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp))
        { Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Expand",
               modifier = Modifier.weight(6f),
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h6.fontSize,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            IconButton(modifier = Modifier
                .alpha(ContentAlpha.medium)
                .weight(1f)
                .rotate(rotationState)
                , onClick =
                {
                    expandedState =! expandedState
                })
            {
                Icon(imageVector = Icons.Default.ArrowDropDown , contentDescription = "Drop-Down Arrow")

            }
        }
            if (expandedState){
                Text(text = "To support as many screen sizes as possible, design your app layouts to be responsive and adaptive." +
                        " Responsive/adaptive layouts provide an optimized user experience regardless of screen size," +
                        " enabling your app to accommodate phones, tablets, foldable and Chrome OS devices, portrait and " +
                        "landscape orientations, and resizable configurations such as multi-window mode.",
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis)
            }
        }
        
    }
}
@ExperimentalMaterialApi
@Preview
@Composable
fun DefaultPreview(){
    CardExpandable()
}