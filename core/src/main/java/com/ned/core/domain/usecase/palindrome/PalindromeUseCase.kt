package com.ned.core.domain.usecase.palindrome

import com.ned.core.domain.model.PalindromeResult
import kotlinx.coroutines.flow.Flow

interface PalindromeUseCase {
    fun checkPalindrome(text: String): Flow<PalindromeResult>
}