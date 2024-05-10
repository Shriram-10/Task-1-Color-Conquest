package com.example.task1colourconquest

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

var points = mutableStateListOf<Int>(
    0,0,0,0,0,
    0,0,0,0,0,
    0,0,0,0,0,
    0,0,0,0,0,
    0,0,0,0,0
)

var clicked = mutableStateListOf<Boolean>(
    false,false,false,false,false,
    false,false,false,false,false,
    false,false,false,false,false,
    false,false,false,false,false,
    false,false,false,false,false
)

var colorTile = mutableStateListOf<Color>(
    Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),
    Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),
    Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),
    Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),
    Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1)
)

var colorButton = mutableStateListOf<Color>(
    Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),
    Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),
    Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),
    Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),
    Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1),Color(0xFFF2E6D1)
)

var playerCover : SnapshotStateList<SnapshotStateList<Boolean>> = mutableStateListOf(
    mutableStateListOf(
        false, false, false, false, false,
        false, false, false, false, false,
        false, false, false, false, false,
        false, false, false, false, false,
        false, false, false, false, false
    ),
    mutableStateListOf(
        false, false, false, false, false,
        false, false, false, false, false,
        false, false, false, false, false,
        false, false, false, false, false,
        false, false, false, false, false
    )
)

var counter = mutableStateOf(0)
var backgroundColor = mutableStateOf(Color(0xFFED6A5E))
var player1Score = mutableStateOf(0)
var player2Score = mutableStateOf(0)
val otherPlayer = mutableStateOf(if(counter.value % 2 == 0) 1 else 0)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GamePage(navController: NavController, name1: String?, name2: String?) {

    val nonNullableString1: String = requireNotNull(name1) { "Player 1" }
    val nonNullableString2: String = requireNotNull(name2) { "Player 2" }
    var exitDialog by remember { mutableStateOf(false) }

    if(exitDialog) {
        AlertDialog(onDismissRequest = {
            exitDialog = false
        },
            confirmButton = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Button(
                        onClick = {
                        exitDialog = false
                    },
                        modifier = Modifier
                            .height(40.dp)
                            .width(150.dp),
                        enabled = true,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFED6A5E),
                            contentColor = Color.White
                        ),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 8.dp,
                            pressedElevation = 12.dp
                        ),
                        shape = RoundedCornerShape(10)
                    ) {
                        Text(
                            text = "Continue",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            exitDialog = false
                            navController.navigate(Screen.HomePage.route)
                            counter.value = 0
                            for(t in 0 .. 24){
                                points[t] = 0
                            }
                            backgroundColor.value = Color(0xFFED6A5E)
                            player1Score.value = 0
                            player2Score.value = 0
                            for(i in 0 .. 1) {
                                for (j in 0..24) {
                                    colorTile[j] = Color(0xFFF2E6D1)
                                    colorButton[j] = Color(0xFFF2E6D1)
                                    playerCover[i][j] = false
                                }
                            }
                        },
                        modifier = Modifier
                            .height(40.dp)
                            .width(150.dp),
                        enabled = true,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFED6A5E),
                            contentColor = Color.White
                        ),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 8.dp,
                            pressedElevation = 12.dp
                        ),
                        shape = RoundedCornerShape(10)
                        ) {
                        Text(
                            text = "Leave Game",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .height(40.dp)
                            .width(150.dp),
                        enabled = true,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFED6A5E),
                            contentColor = Color.White
                        ),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 8.dp,
                            pressedElevation = 12.dp
                        ),
                        shape = RoundedCornerShape(10)
                    ) {
                        Text(
                            text = "Exit",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    }
                }
            },
            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "Are you Sure?",
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF0FA6F7)
                    )
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor.value)
    ){
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Column(
                modifier = Modifier.width(330.dp)
            ){
                Spacer(modifier = Modifier.height(30.dp))

                Row{
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .width(80.dp)
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.DarkGray,
                            contentColor = Color(0xFF323232)
                        ),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 16.dp
                        ),
                        shape = RoundedCornerShape(
                            topEndPercent = 50,
                            bottomEndPercent = 50
                        )
                    ){
                        Text(
                            text = player2Score.value.toString(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp,
                            color = Color(0xFF0FA6F7)
                        )
                    }

                    Spacer(modifier = Modifier.width(6.dp))

                    Card(
                        shape = CutCornerShape(
                            topStartPercent = 45,
                            bottomStartPercent = 45,
                        ),
                        modifier = Modifier
                            .height(56.dp)
                            .width(150.dp)
                            .clip(
                                shape = RoundedCornerShape(
                                    topEndPercent = 10,
                                    bottomEndPercent = 10
                                )
                            ),
                        colors = CardDefaults.cardColors(
                            contentColor = Color(0xFF0FA6F7),
                            containerColor = Color.DarkGray
                        ),
                        border = BorderStroke(
                            width = 2.dp,
                            color = Color.Black
                        )
                    ){
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ){

                            Text(
                                text = nonNullableString2.uppercase(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 28.sp,
                                color = Color(0xFF0FA6F7),
                                modifier = Modifier.rotate(180f)
                            )
                        }
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

        Spacer(modifier = Modifier.height(120.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            Spacer(modifier = Modifier.width(17.dp))

            LazyVerticalGrid(
                modifier = Modifier.width(375.dp),
                columns = GridCells.Fixed(5),
            ) {
                items(25){ i->
                    Box(
                        modifier = Modifier
                            .height(72.dp)
                            .padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            modifier = Modifier
                                .fillMaxSize(),
                            shape = RoundedCornerShape(percent = 15),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorTile[i]
                            ),
                            onClick = {
                                clicked[i] = true
                            },
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 8.dp,
                                pressedElevation = 12.dp
                            )
                        ){
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ){
                                Box(
                                    modifier = Modifier
                                        .clip(shape = RoundedCornerShape(50)),
                                    contentAlignment = Alignment.Center
                                ){

                                }
                                Text(
                                    text = points[i].toString(),
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 32.sp,
                                    color = Color.Black
                                )
                            }
                        }
                    }
                    if((clicked[i] && (counter.value == 1 || counter.value == 0)) || (clicked[i] && playerCover[otherPlayer.value][i])) {
                        counter.value++
                        incrementAndExpansion(i)
                        clicked[i] = false
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(120.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            Card(
                modifier = Modifier
                    .height(56.dp)
                    .width(150.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            topStartPercent = 10,
                            bottomStartPercent = 10
                        )
                    ),
                shape = CutCornerShape(
                    topEndPercent = 45,
                    bottomEndPercent = 45,
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color(0xFFED6A5E)
                ),
                border = BorderStroke(
                    width = 2.dp,
                    color = Color.Black
                )
            ){
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = nonNullableString1.uppercase(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp,
                        color = Color(0xFFED6A5E)
                    )
                }
            }

            Spacer(modifier = Modifier.width(6.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .width(80.dp)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color(0xFF323232)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 16.dp
                ),
                shape = RoundedCornerShape(
                    topStartPercent = 50,
                    bottomStartPercent = 50
                )
            ){
                Text(
                    text = player1Score.value.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    color = Color(0xFFED6A5E)
                )
            }
        }
    }
}

fun incrementAndExpansion(i: Int) {

    if(counter.value % 2 == 1) {
        backgroundColor.value = Color(0xFF0FA6F7)
        playerCover[counter.value % 2][i] = true
    } else {
        backgroundColor.value = Color(0xFFED6A5E)
        playerCover[counter.value % 2][i] = true
    }

    if(counter.value == 2 || counter.value == 1) {
        points[i] += 3
        if(counter.value % 2 == 1) {
            colorButton[i] = Color(0xFFED6A5E)
            colorTile[i] = Color(0xFFF2D1CD)
            player1Score.value += 3
            playerCover[counter.value % 2][i] = true
        } else {
            colorButton[i] = Color(0xFF0FA6F7)
            colorTile[i] = Color(0xFFC7F1FD)
            player2Score.value += 3
            playerCover[counter.value % 2][i] = true
        }
    } else {
        var surround = mutableListOf(
            i - 5,
            i - 1,
            i + 1,
            i + 5
        )

        val surroundFilter = (surround.filter { it in 0..24 }).toMutableList()

        if(i != 0 && i != 4 && i != 20 && i != 24){
            if (i % 5 == 4) {
                surroundFilter.remove(surroundFilter[2])
            } else if (i % 5 == 0) {
                surroundFilter.remove(surroundFilter[1])
            }
        } else if(i == 4) {
            surroundFilter.remove(surroundFilter[1])
        }

        if(points[i] == 3) {
            points[i] = 0
            playerCover[counter.value % 2][i] = false
            colorButton[i] = Color(0xFFF2E6D1)
            colorTile[i] = Color(0xFFF2E6D1)

            for (j in surroundFilter) {
                if(counter.value % 2 == 1){
                    colorButton[j] = Color(0xFFED6A5E)
                    colorTile[j] = Color(0xFFF2D1CD)
                } else {
                    colorButton[j] = Color(0xFF0FA6F7)
                    colorTile[j] = Color(0xFFC7F1FD)
                }
            }

            surroundFilter.forEach{ j ->
                points[j]++
                if(points[j] > 3) {
                    incrementAndExpansion(j)
                }
                playerCover[counter.value % 2][j] = true
            }
        } else {
            points[i]++

            if(counter.value % 2 == 1){
                colorButton[i] = Color(0xFFED6A5E)
                colorTile[i] = Color(0xFFF2D1CD)
            } else {
                colorButton[i] = Color(0xFF0FA6F7)
                colorTile[i] = Color(0xFFC7F1FD)
            }
        }
    }
}


