package com.example.composepart2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import com.example.composepart2.repository.PersonRepository
import com.example.composepart2.ui.theme.ComposePart2Theme

class MainActivity : ComponentActivity() {
    //@OptIn(ExperimentalCoilApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                val repository = PersonRepository()
                val data = repository.getAllData()

            LazyColumn(
                contentPadding = PaddingValues(2.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ){

                items(items = data) {
                    CustomItem(person = it)
        }
            }

        }
    }
}




@Composable
fun Greeting(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Top,
    ) {
        var text by remember { mutableStateOf("type here") }

        TextField(value = "please text here ", onValueChange = {
                text = it

        },
            readOnly = false,
            label = {
                Text(text = "Title")
            },
            singleLine = true,
            maxLines = 2,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Email,contentDescription = null)
                }
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Menu,contentDescription = null)
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onSearch = {

                }
            )
        )
        OutlinedTextField(value = "please text here ", onValueChange = {
            text = it

        },
            readOnly = false,
            label = {
                Text(text = "Title")
            },
            singleLine = true,
            maxLines = 2,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Email,contentDescription = null)
                }
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Menu,contentDescription = null)
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onSearch = {

                }
            )
        )

    }

}

@ExperimentalCoilApi
@Composable
fun LoadImage(){

    Box(modifier = Modifier
        .width(150.dp)
        .height(150.dp),
    contentAlignment = Alignment.Center,
    )
    {
        val painter = rememberImagePainter(data = "https://images.app.goo.gl/7NLShvRasnZ9hiXA8",
        builder = {
            placeholder(R.drawable.ic_google_logo)
            error(R.drawable.ic_launcher_background)
            crossfade(1000)
            transformations(
                GrayscaleTransformation(),
                CircleCropTransformation()
            )
        }
        )
        val painterState = painter.state
        Image(painter = painter, contentDescription = "")
        if (painterState is ImagePainter.State.Loading){
            CircularProgressIndicator()
        }
    }
}



@OptIn(ExperimentalCoilApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePart2Theme {
        Column(modifier = Modifier.fillMaxSize()) {

        }
    }
}