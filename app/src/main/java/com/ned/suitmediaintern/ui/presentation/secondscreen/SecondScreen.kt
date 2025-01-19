package com.ned.suitmediaintern.ui.presentation.secondscreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ned.core.data.helper.SharedPreferencesHelper
import com.ned.suitmediaintern.R
import com.ned.suitmediaintern.ui.component.Button
import com.ned.suitmediaintern.ui.navigation.Screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    navController: NavHostController,
) {
    val context = LocalContext.current
    val sharedPreferencesHelper = remember { SharedPreferencesHelper(context) }

    val userName = sharedPreferencesHelper.getUsername() ?: "User"
    val dataName = sharedPreferencesHelper.getUserFullName() ?: "Selected User Name"

    Log.d("SecondScreen", "userName: $userName, dataName: $dataName")

    Column {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.header_second_screen),
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
                        contentDescription = stringResource(R.string.back_arrow),
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            HorizontalDivider(
                thickness = 1.dp,
                color = Color.LightGray,
            )
        }
        SecondScreenContent(
            userName = userName,
            dataName = dataName,
            onNavigateToThirdScreen = {
                navController.navigate(Screen.ThirdScreen.route) {
                    popUpTo(Screen.SecondScreen.route) { saveState = true }
                }
            },
            modifier = modifier
        )
    }
}

@Composable
fun SecondScreenContent(
    userName: String,
    dataName: String,
    modifier: Modifier = Modifier,
    onNavigateToThirdScreen: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .padding(bottom = 24.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(text = stringResource(R.string.welcome_hint), fontSize = 12.sp, fontWeight = FontWeight.Medium)
                Text(text = userName, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = dataName,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            text = stringResource(R.string.choose_a_user_hint),
            onClick = { onNavigateToThirdScreen() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
    }
}
