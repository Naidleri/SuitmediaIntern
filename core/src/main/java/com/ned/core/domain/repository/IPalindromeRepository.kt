package com.ned.core.domain.repository

import com.ned.core.domain.model.PalindromeResult
import kotlinx.coroutines.flow.Flow

interface IPalindromeRepository {
    fun checkPalindrome(text: String): Flow<PalindromeResult>
}