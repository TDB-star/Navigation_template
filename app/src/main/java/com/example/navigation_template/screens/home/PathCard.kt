package com.example.navigation_template.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.navigation_template.R
import com.example.navigation_template.ui.theme.BlueESI

@Composable

fun PathCard(
    modifier: Modifier = Modifier,
    path: Path,
    onPathClickListener: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = onPathClickListener
            ),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(((-30).dp)),
            modifier = Modifier
                .padding(8.dp)
        ) {
            Surface(
                modifier = Modifier
                    .size(90.dp)
                    .zIndex(1f),
                shape = CircleShape,
                shadowElevation = 4.dp
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.mouse_group
                    ),
                    contentScale = ContentScale.Fit,
                    contentDescription = null
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(BlueESI),
            ) {
                Text(
                    text = "Mouse",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 38.dp,
                            end = 20.dp,
                            top = 23.dp,
                            bottom = 23.dp
                        )
                )
            }
        }
    }
}

@Preview
@Composable
fun CardTest() {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(((-30).dp))
        ) {
            Surface(
                modifier = Modifier
                .zIndex(1f),
                shape = CircleShape,
                shadowElevation = 4.dp
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.mouse_group
                    ),
                    contentDescription = null
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(BlueESI),
            ) {
                Text(
                    text = "Mouse",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 38.dp,
                            end = 20.dp,
                            top = 23.dp,
                            bottom = 23.dp
                        )
                )
            }
        }
    }
}


