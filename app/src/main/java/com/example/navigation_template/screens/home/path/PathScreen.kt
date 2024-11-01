package com.example.navigation_template.screens.home.path

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.navigation_template.R
import com.example.navigation_template.screens.home.Path
import com.example.navigation_template.screens.home.PathScreenState
import com.example.navigation_template.screens.home.PathViewModel
import com.example.navigation_template.screens.home.Skier
import com.example.navigation_template.ui.theme.BlueESI

@Composable
fun PathScreen(
    onBackPressed: () -> Unit,
    path: Path,
    skier: Skier
) {
    val viewModel: PathViewModel = viewModel()
    val screenState = viewModel.screenState.observeAsState(PathScreenState.Initial)
    val currentState = screenState.value

    //if (currentState is PathScreenState.Skiers) {}
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = skier.name)
                    },
                    navigationIcon = {
                        IconButton(onClick = { onBackPressed() }) {
                            Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = null)
                        }
                    })
            }
        ) { paddingValues ->

            Text(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(top = 50.dp),
                text = "Path",
                textAlign = TextAlign.Center,
                fontSize = 20.sp)
        }
}

@Preview
@Composable
fun PathScreenTest() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Mouse",
                        color = Color.White)
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = "Anna",
                        color = Color.White)
                },
                backgroundColor = BlueESI,
                navigationIcon = {
                    IconButton(
                        onClick = {  }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = null,
                            tint = Color.White)
                    }
                })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
            .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                contentPadding = PaddingValues(bottom = 70.dp),
                verticalArrangement = Arrangement.spacedBy(0.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                item {
                    Image(
                    painterResource(R.drawable.mouse_path_header1),
                    contentDescription = null,
                        modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth)}
                items(5) {
                    CrystalCard()
                }
            }

        }
    }
}

@Composable
fun CrystalCard() {
    Column(modifier = Modifier.padding(bottom = 18.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(R.drawable.lock),
            contentDescription = null,
            modifier = Modifier.size(120.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "White Mouse",
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painterResource(R.drawable.points),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}