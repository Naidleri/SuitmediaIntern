package com.ned.suitmediaintern.ui.presentation.firstscreen

data class PalindromeState(
    val name: String = "",
    val palindromeText: String = "",
    val isPalindrome: Boolean? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)
