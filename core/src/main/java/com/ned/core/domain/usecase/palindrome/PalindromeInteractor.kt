package com.ned.core.domain.usecase.palindrome

import com.ned.core.domain.model.PalindromeResult
import com.ned.core.domain.repository.IPalindromeRepository
import kotlinx.coroutines.flow.Flow

class PalindromeInteractor (private val palindromeRepository: IPalindromeRepository) : PalindromeUseCase {
    override fun checkPalindrome(text: String): Flow<PalindromeResult> {
        return palindromeRepository.checkPalindrome(text)
    }

}