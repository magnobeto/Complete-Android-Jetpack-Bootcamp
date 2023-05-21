package com.example.composedemo1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                ButtonDemo()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = name,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(color = Color.Yellow)
            .border(2.dp, Color.Green)
            .padding(10.dp)
    )
}

@Composable
fun BoxExample1() {
    Box(
        modifier = Modifier
            .background(Color.Cyan)
            .size(180.dp, 300.dp)
    ) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .size(125.dp, 100.dp)
                .align(Alignment.TopEnd)
        ) {

        }

        Text(
            text = "Hi",
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .background(Color.White)
                .size(90.dp, 50.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun BoxExample2() {
    Box(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize()
    ) {
        Text(
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Magenta)
                .padding(10.dp)
                .align(Alignment.TopStart),
            text = "TopStart"
        )
        Text(
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Magenta)
                .padding(10.dp)
                .align(Alignment.TopCenter),
            text = "TopCenter"
        )
        Text(
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Magenta)
                .padding(10.dp)
                .align(Alignment.TopEnd),
            text = "TopEnd"
        )
        Text(
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Magenta)
                .padding(10.dp)
                .align(Alignment.CenterStart),
            text = "CenterStart"
        )
        Text(
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Magenta)
                .padding(10.dp)
                .align(Alignment.Center),
            text = "Center"
        )
        Text(
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Magenta)
                .padding(10.dp)
                .align(Alignment.CenterEnd),
            text = "CenterEnd"
        )
        Text(
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Magenta)
                .padding(10.dp)
                .align(Alignment.BottomStart),
            text = "BottomStart"
        )
        Text(
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Magenta)
                .padding(10.dp)
                .align(Alignment.BottomCenter),
            text = "BottomCenter"
        )
        Text(
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .background(Color.Magenta)
                .padding(10.dp)
                .align(Alignment.BottomEnd),
            text = "BottomEnd"
        )
    }
}

@Composable
fun BoxExample3() {
    Box {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Description",
            modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(400.dp)
        )
        Text(
            text = "Image Description",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.align(Alignment.BottomStart)
        )
        Button(
            onClick = {},
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.White,
                contentColor = Color.DarkGray
            ),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
                .border(5.dp, Color.DarkGray, RectangleShape)
        ) {
            Text("Add to cart")
        }
    }
}

@Composable
fun ButtonDemo() {
    val context = LocalContext.current
    Button(
        onClick = {
            Toast.makeText(context, "Clicked on Button", Toast.LENGTH_SHORT).show()
        }
    ) {
        Text(text = "Add to cart")
    }
    Button(
        onClick = {
            Toast.makeText(context, "Clicked on Button", Toast.LENGTH_SHORT).show()
        },
        enabled = false
    ) {
        Text(text = "Add to cart")
    }
    TextButton(
        onClick = {
            Toast.makeText(context, "Clicked on Text Button", Toast.LENGTH_SHORT).show()
        }
    ) {
        Text(text = "Add to cart")
    }
    OutlinedButton(
        onClick = {
            Toast.makeText(context, "Clicked on Out Lined Button", Toast.LENGTH_SHORT).show()
        }
    ) {
        Text(text = "Add to cart")
    }
    IconButton(
        onClick = {
            Toast.makeText(context, "Clicked on Icon Button", Toast.LENGTH_SHORT).show()
        }
    ) {
        Icon(
            Icons.Filled.Refresh,
            contentDescription = "Refresh Button",
            tint = Color.DarkGray,
            modifier = Modifier.size(80.dp)
        )
    }
    Button(
        onClick = {
            Toast.makeText(context, "Clicked on Button", Toast.LENGTH_SHORT).show()
        },
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.DarkGray,
            contentColor = Color.White
        )
    ) {
        Text(
            text = "Add to cart",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(5.dp)
        )
    }
    Button(
        onClick = {
            Toast.makeText(context, "Clicked on Button", Toast.LENGTH_SHORT).show()
        },
        shape = CutCornerShape(10.dp),
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.DarkGray,
            contentColor = Color.White
        )
    ) {
        Text(
            text = "Add to cart",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(5.dp)
        )
    }
    Button(
        onClick = {
            Toast.makeText(context, "Clicked on Button", Toast.LENGTH_SHORT).show()
        },
        shape = CircleShape,
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.DarkGray,
            contentColor = Color.White
        )
    ) {
        Text(
            text = "Add to cart",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(5.dp)
        )
    }
}