package com.ned.suitmediaintern.ui.presentation.firstscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ned.suitmediaintern.R
import com.ned.suitmediaintern.ui.component.Button
import com.ned.suitmediaintern.ui.component.TextField
import org.koin.androidx.compose.koinViewModel

@Composable
fun FirstScreen(
    modifier: Modifier = Modifier,
    viewModel: FirstScreenViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()

    FirstScreenContent(
        state = state,
        onEvent = viewModel::onEvent,
        modifier = modifier
    )
}

@Composable
fun FirstScreenContent(
    state: PalindromeState,
    onEvent: (PalindromeEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.btn_add_photo),
                contentDescription = stringResource(R.string.button_add_photo),
                modifier = Modifier.padding(20.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(40.dp))

            TextField(
                value = state.name,
                onValueChange = { onEvent(PalindromeEvent.OnNameTextChange(it)) },
                placeholder = "Name"
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = state.palindromeText,
                onValueChange = { onEvent(PalindromeEvent.OnPalindromeTextChange(it)) },
                placeholder = "Palindrome"
            )

            if (state.isError) {
                Text(
                    text = state.errorMessage,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.padding(8.dp)
                )
            }

            state.isPalindrome?.let { isPalindrome ->
                Text(
                    text = if (isPalindrome) "Is Palindrome" else "Not Palindrome",
                    color = if (isPalindrome) Color.Green else Color.Red,
                    modifier = Modifier.padding(8.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                text = "Check",
                onClick = { onEvent(PalindromeEvent.OnCheckPalindrome) }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                text = "NEXT",
                onClick = {  }
            )
        }
    }
}
