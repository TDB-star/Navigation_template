package com.example.navigation_template.screens.home

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.navigation_template.R
import com.example.navigation_template.ui.theme.BlueESI


@Composable
fun SkierCell(
    skier: Skier,
    changeStatus: (Skier) -> Unit,
) {

    val interactionSource = remember { MutableInteractionSource() }

    Card(
        modifier = Modifier
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            val borderWidth by animateDpAsState(
                targetValue = if (skier.selected) 6.dp else 0.dp
            )

            val imageSize by animateDpAsState(
                targetValue = if (skier.selected) 100.dp else 90.dp
            )

            val borderColor = if (skier.selected) BlueESI else Color.White

            Surface(
                modifier = Modifier
                    .size(imageSize),
                shape = CircleShape,
                border = BorderStroke(width = borderWidth, color = borderColor)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.skier_boy),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                            true,
                            onClick = {
                            changeStatus(skier)
                        },
                            ),
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                text = skier.name,
                textAlign = TextAlign.Center
            )
        }
    }
}

