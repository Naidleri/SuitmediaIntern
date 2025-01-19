package com.ned.suitmediaintern.ui.presentation.thirdscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.ned.core.domain.model.User
import com.ned.suitmediaintern.R
import com.ned.suitmediaintern.ui.component.UserList
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirdScreen(
    viewModel: ThirdScreenViewModel = koinViewModel(),
    onBackClick: () -> Unit
) {
    val users = viewModel.users.collectAsLazyPagingItems()
    Column {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.header_third_screen),
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
        ThirdScreenContent(user = users)
    }
}

@Composable
fun ThirdScreenContent(
    user: LazyPagingItems<User>,
    modifier: Modifier = Modifier
) {
    val loadState = user.loadState

    when {
        loadState.refresh is androidx.paging.LoadState.Loading -> {
            LoadingScreen()
        }
        loadState.refresh is androidx.paging.LoadState.Error -> {
            val error = loadState.refresh as androidx.paging.LoadState.Error
            ErrorScreen(message = error.error.localizedMessage ?: "Unknown Error")
        }
        else -> {
            LazyColumn(modifier = modifier.fillMaxSize()) {
                items(user.itemCount) { index ->
                    val userItem = user[index]
                    userItem?.let {
                        Column {
                            UserList(
                                avatar = it.avatar,
                                firstname = it.firstName,
                                lastname = it.lastName,
                                email = it.email
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
                                    modifier = Modifier.fillMaxWidth(0.8f)
                                )
                            }

                        }
                    }
                }
                if (loadState.append is androidx.paging.LoadState.Loading) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
                if (loadState.append is androidx.paging.LoadState.Error) {
                    val error = loadState.append as androidx.paging.LoadState.Error
                    item {
                        Text(
                            text = error.error.localizedMessage ?: "Unknown Error",
                            color = Color.Red,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LoadingScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorScreen(message: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = message,
            color = Color.Red
        )
    }
}