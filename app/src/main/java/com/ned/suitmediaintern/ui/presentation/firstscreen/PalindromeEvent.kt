package com.ned.suitmediaintern.ui.presentation.firstscreen

sealed class PalindromeEvent {
    data class OnNameTextChange(val text: String): PalindromeEvent()
    data class OnPalindromeTextChange(val text: String) : PalindromeEvent()
    object OnCheckPalindrome : PalindromeEvent()
    object OnNextClicked : PalindromeEvent()
}