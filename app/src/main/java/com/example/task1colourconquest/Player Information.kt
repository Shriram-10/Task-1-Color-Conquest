package com.example.task1colourconquest

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlayerPage() {

    var goGame by remember { mutableStateOf(false) }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = gradientBackground(
                    colors = gradientColorList,
                    isVerticalGradient = true
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(56.dp))

        Button(
            onClick = { },
            shape = CutCornerShape(
                topStartPercent = 45,
                topEndPercent = 45,
                bottomStartPercent = 45,
                bottomEndPercent = 45),
            modifier = Modifier
                .width(330.dp)
                .height(56.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 16.dp
            ),
            border = BorderStroke(3.dp, Color(0xFFDABA9F)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF8D8BC)
            )
        ) {
            Text(text = "PLAYER INFORMATION",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                color = Color.Black)
        }

        Spacer(modifier = Modifier.height(100.dp))

        Row (modifier = Modifier.fillMaxWidth()) {

            Spacer(modifier = Modifier.width(22.dp))

            Card(modifier = Modifier
                .width(175.dp)
                .height(100.dp),
                shape = RoundedCornerShape(
                    topStartPercent = 30,
                    topEndPercent = 30,
                    bottomStartPercent = 30,
                    bottomEndPercent = 30),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 16.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF3E4171)
                )) {

            }

            Spacer(modifier = Modifier.width(20.dp))

            Card(modifier = Modifier
                .width(175.dp)
                .height(100.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 16.dp
                ),
                shape = RoundedCornerShape(
                    topStartPercent = 30,
                    topEndPercent = 30,
                    bottomStartPercent = 30,
                    bottomEndPercent = 30),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF3E4171)
                )) {
            }

            Spacer(modifier = Modifier.width(20.dp))
        }

        Spacer(modifier = Modifier.height(45.dp))

        Row (modifier = Modifier.fillMaxWidth()) {

            Spacer(modifier = Modifier
                .width(22.dp))

            Card(modifier = Modifier
                .width(175.dp)
                .height(100.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 16.dp
                ),
                shape = RoundedCornerShape(
                    topStartPercent = 30,
                    topEndPercent = 30,
                    bottomStartPercent = 30,
                    bottomEndPercent = 30),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF3E4171)
                )) {

            }

            Spacer(modifier = Modifier.width(20.dp))

            Card(modifier = Modifier
                .width(175.dp)
                .height(100.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 16.dp
                ),
                shape = RoundedCornerShape(
                    topStartPercent = 30,
                    topEndPercent = 30,
                    bottomStartPercent = 30,
                    bottomEndPercent = 30),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF3E4171)
                )) {
            }

            Spacer(modifier = Modifier.width(20.dp))
        }

        Image(
            painter = painterResource(id = R.drawable.players),
            contentDescription = "Players")

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                goGame = true
            },
            modifier = Modifier
                .width(164.dp)
                .height(64.dp),
            enabled = true,
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0FA6F7)
            )
        ){
            Text(text = "START",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                color = Color.White)
        }
    }
    if(goGame) {
        GamePage()
    }
}