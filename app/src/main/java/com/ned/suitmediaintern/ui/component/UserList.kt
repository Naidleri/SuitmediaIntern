package com.ned.suitmediaintern.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest


@Composable
fun UserList(
    avatar: String?,
    firstname: String,
    lastname: String,
    email: String,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(avatar)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = Modifier
                .size(96.dp)
                .clip(CircleShape)
        )
        Column (
            modifier = modifier.padding(start = 16.dp,end = 24.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "$firstname $lastname", fontSize = 20.sp ,fontWeight = FontWeight.Medium)
            Text(
                text = email,
                fontSize = 16.sp,
                color = Color.Gray )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserListPreview() {
    UserList(
        avatar = "https://reqres.in/img/faces/1-image.jpg",
        firstname = "haris",
        lastname = "ardiansyah",
        email = "harisss@gmail.com",
    )
}