package com.ned.core.data.repository

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.jupiter.api.Assertions

class PalindromeRepositoryTest {
    private val palindromeRepository = PalindromeRepository()

    @Test
    fun `should return true when palindrome`() = runTest {
        val result = palindromeRepository.checkPalindrome("kasur rusak").first()
        Assertions.assertEquals(true, result.isPalindrome)
    }

    @Test
    fun `should return false when non-palindrome`() = runTest {
        val result = palindromeRepository.checkPalindrome("suitmedia").first()
        Assertions.assertEquals(false, result.isPalindrome)
    }
}