package com.example.navigation_template.screens.home

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorProducer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.navigation_template.R
import com.example.navigation_template.ui.theme.BlueESI
import com.example.navigation_template.ui.theme.WhiteTransparent

@Composable
fun MainScreen(
    userId: String,
    onPathClick: () -> Unit
) {

    val viewModel: HomeViewModel = viewModel(factory = HomeViewModelFactory(userId))
    val screenState = viewModel.screenState.observeAsState(HomeScreenState.Initial)


    when(val currentState = screenState.value) {

        is HomeScreenState.Home -> {
            HomeContent(viewModel)
            Log.d("TAG", "user" +
                    userId
            )
        }
        HomeScreenState.Initial -> {

        }

        is HomeScreenState.SkierPath -> {

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    viewModel: HomeViewModel
) {

    val skiers = viewModel.skiers.observeAsState(listOf())
    val paths = viewModel.paths.observeAsState(listOf())
    val selectedSkier = viewModel.skier.observeAsState(Skier(0))



        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 0.dp, end = 0.dp),
            painter = painterResource(R.drawable.top_snowball),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 50.dp,
                    start = 0.dp, end = 0.dp
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "+ Add Skier",
                    color = BlueESI,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .clickable { })

            }
            Spacer(modifier = Modifier.height(20.dp))
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp)
                    .height(1.dp),
                color = Color.LightGray
            ) {}
            Spacer(modifier = Modifier.height(10.dp))
            Text(modifier = Modifier.padding(start = 16.dp),
                text = "Skiers",
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(modifier = Modifier
                .fillMaxWidth()
            ) {
                items(skiers.value, key = {it.skierId}) { skier ->
                    SkierCell(skier = skier,
                        changeStatus = {
                            viewModel.changeStatus(skier = skier)
                            viewModel.selectedSkier(skier)
                        })
                }
            }
           // Spacer(modifier = Modifier.height(8.dp))


            //Spacer(modifier = Modifier.height(8.dp))

//                Text(modifier = Modifier
//                    .padding(start = 16.dp),
//                    text = "Paths",
//                    fontWeight = FontWeight.Medium,
//                    fontSize = 18.sp)


            LazyColumn(
                modifier = Modifier.padding(start = 16.dp,top = 16.dp, bottom = 16.dp, end = 0.dp)
                .background(Color.White),
                verticalArrangement = Arrangement.spacedBy(0.dp)
            ) {

                stickyHeader {
                    Column(modifier = Modifier.fillMaxWidth()
                        .background(WhiteTransparent)) {
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 16.dp)
                                .height(1.dp),
                            color = Color.LightGray
                        ) {}

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(modifier = Modifier
                            .padding(start = 4.dp, bottom = 8.dp),
                            text = "Paths",
                            fontWeight = FontWeight.Medium,
                            fontSize = 18.sp)
                    }

                }
                items(paths.value) { path ->
                    PathCard(path = path, onPathClickListener = {
                        viewModel.selectedPath(path = path, skier = selectedSkier.value)

                    }
                    )
                }
            }
        }
    }
