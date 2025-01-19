package com.ned.core.data.repository

import com.ned.core.domain.model.PalindromeResult
import com.ned.core.domain.repository.IPalindromeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PalindromeRepository : IPalindromeRepository {
    override fun checkPalindrome(text: String): Flow<PalindromeResult> = flow {
        val cleanText = text
            .replace("\\s".toRegex(), "")
            .lowercase()

        var isPalindrome = true
        val length = cleanText.length

        for (i in 0 until length / 2) {
            if (cleanText[i] != cleanText[length - i - 1]) {
                isPalindrome = false
                break
            }
        }

        emit(PalindromeResult(text, isPalindrome))
    }
}
