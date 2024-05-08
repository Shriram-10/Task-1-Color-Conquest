package com.example.task1colourconquest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GamePage() {

    var exitDialog by remember { mutableStateOf(false) }

    if(exitDialog) {
        AlertDialog(onDismissRequest = {
            exitDialog = true
        },
            confirmButton = {

            })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = gradientBackground(
                    colors = gradientColorList,
                    isVerticalGradient = true
                )
            )
    ){
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Column(
                modifier = Modifier.width(330.dp)
            ){
                Spacer(modifier = Modifier.height(30.dp))

                Row(){
                    Card(
                        modifier = Modifier
                            .width(80.dp)
                            .height(56.dp),
//                            .border(
//                                border = BorderStroke(4.dp, Color.Black),
//                                shape = RoundedCornerShape(topEndPercent = 50, bottomEndPercent = 50)
//                            ),
//                            .drawBehind {
//                                val borderSize = 8.dp.toPx()
//                                val y = size.height - borderSize / 2
//                                drawLine(
//                                    color = Color.Black,
//                                    start = Offset(0f,0f),
//                                    end = Offset(0.68f * size.width , 0f),
//                                    strokeWidth = borderSize
//                                )
//                                drawLine(
//                                    color = Color.Black,
//                                    start = Offset(0f, size.height),
//                                    end = Offset(0.68f * size.width , size.height),
//                                    strokeWidth = borderSize
//                                )
//                            },
                        colors = CardDefaults.cardColors(
                            containerColor = Color.DarkGray,
                            contentColor = Color(0xFF323232)
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 8.dp
                        ),
                        shape = RoundedCornerShape(
                            topEndPercent = 50,
                            bottomEndPercent = 50
                        )
                    ){

                    }
                    Card(){

                    }
                }
            }

            Column(
                modifier = Modifier.width(60.dp),
                horizontalAlignment = Alignment.End
            ){
                Card(
                    modifier = Modifier
                        .size(48.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 12.dp
                    ),
                    shape = RoundedCornerShape(percent = 50),
                    onClick = {
                        exitDialog = true
                    }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.close),
                        contentDescription = "Players",
                        contentScale = ContentScale.Inside
                    )
                }

                Spacer(modifier = Modifier.width(24.dp))
            }
        }
    }
}