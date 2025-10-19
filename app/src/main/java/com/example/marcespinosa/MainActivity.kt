package com.example.marcespinosa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           MaterialTheme {
               DiceRollerApp()
           }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result1 by remember { mutableIntStateOf(1) }
    var result2 by remember { mutableIntStateOf(1) }
    val imageResource1 = when (result1){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    val imageResource2 = when (result2){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row (
            horizontalArrangement =  Arrangement.SpaceBetween
        ){
            Image(
                painter = painterResource(imageResource1),
                contentDescription = result1.toString()
            )

            Image(
                painter = painterResource(imageResource2),
                contentDescription = result2.toString()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                result1 = (1..6).random()
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFAD7FF5)
                ),
                modifier = Modifier.width(150.dp)
            ){
                Text(stringResource(R.string.roll))
            }

            Spacer(modifier = Modifier.width(40.dp))

            Button(onClick = {
                result2 = (1..6).random()
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFAD7FF5)
                ),
                modifier = Modifier.width(150.dp)
            ){
                Text(stringResource(R.string.roll2))
            }
        }
        Spacer(modifier = Modifier.width(23.dp))
        Button(onClick = {
            result1 = (1..6).random()
            result2 = (1..6).random()
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFAD5AF5)
            ),
            modifier = Modifier.width(345.dp)
        ){
            Text(stringResource(R.string.roll2))
        }
    }
}