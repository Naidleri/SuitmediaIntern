package com.ned.suitmediaintern.ui.presentation.firstscreen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ned.core.domain.usecase.palindrome.PalindromeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FirstScreenViewModel (private val palindromeUseCase: PalindromeUseCase
): ViewModel() {
    private val _state = MutableStateFlow(PalindromeState())
    val state = _state.asStateFlow()


    fun onEvent(event: PalindromeEvent) {
        when (event) {
            is PalindromeEvent.OnNameTextChange -> {
                _state.value = _state.value.copy(name = event.text)
            }
            is PalindromeEvent.OnPalindromeTextChange -> {
                _state.value = _state.value.copy(palindromeText = event.text)
            }
            PalindromeEvent.OnCheckPalindrome -> {
                viewModelScope.launch {
                    try {
                        _state.value = _state.value.copy(isLoading = true, isError = false)
                        palindromeUseCase.checkPalindrome(_state.value.palindromeText).collect { result ->
                            _state.value = _state.value.copy(
                                isPalindrome = result.isPalindrome,
                                isLoading = false,
                                isError = false
                            )
                        }
                    } catch (e: Exception) {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            isError = true,
                            errorMessage = e.message ?: "Unknown error"
                        )
                    }
                }
            }
        }
    }

}
