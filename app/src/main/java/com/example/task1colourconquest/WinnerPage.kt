package com.example.task1colourconquest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DisplayWinner(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .width(275.dp)
                .height(290.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(62,65,113),
                contentColor = Color.Black
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 12.dp
            )
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Button(
                    modifier = Modifier.width(275.dp),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    )
                ){
                    Text(
                        text = winnerName.value.uppercase(),
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 26.sp
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Image(
                    painter = painterResource(id = R.drawable.winner),
                    contentDescription = "winner",
                    modifier = Modifier.aspectRatio(16f/5f)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "WINS!",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 26.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        navController.navigate(Screen.PlayerInformation.route)
                    },
                    modifier = Modifier
                        .width(275.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(87,190,235),
                        contentColor = Color.White
                    )
                ){
                    Text(
                        text = "Play Again",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 25.sp
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(275.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(237,106,94),
                        contentColor = Color.White
                    )
                ){
                    Text(
                        text = "Home",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 25.sp
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    DisplayWinner("William", navController = )
//}