package com.ned.suitmediaintern.ui.presentation.firstscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ned.core.domain.usecase.palindrome.PalindromeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FirstScreenViewModel(
    private val palindromeUseCase: PalindromeUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(PalindromeState())
    val state = _state.asStateFlow()

    fun onEvent(event: PalindromeEvent) {
        when (event) {
            is PalindromeEvent.OnNameTextChange -> {
                _state.value = _state.value.copy(
                    name = event.text,
                    isError = false,
                    errorMessage = ""
                )
            }
            is PalindromeEvent.OnPalindromeTextChange -> {
                _state.value = _state.value.copy(
                    palindromeText = event.text,
                    isPalindrome = null,
                    isError = false,
                    errorMessage = ""
                )
            }
            PalindromeEvent.OnCheckPalindrome -> {
                if (_state.value.palindromeText.trim().isEmpty()) {
                    _state.value = _state.value.copy(
                        isError = true,
                        errorMessage = "Palindrome text cannot be empty",
                        isPalindrome = null
                    )
                    return
                }

                viewModelScope.launch {
                    try {
                        _state.value = _state.value.copy(
                            isLoading = true,
                            isError = false,
                            errorMessage = ""
                        )

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
                            errorMessage = e.message ?: "Unknown error",
                            isPalindrome = null
                        )
                    }
                }
            }
            PalindromeEvent.OnNextClicked -> {
                if (_state.value.name.trim().isEmpty()) {
                    _state.value = _state.value.copy(
                        isError = true,
                        errorMessage = "Name cannot be empty"
                    )
                }
            }
            PalindromeEvent.OnDismissError -> {
                _state.value = _state.value.copy(
                    isError = false,
                    errorMessage = ""
                )
            }
        }
    }
}