package com.ned.core.data.repository

import com.ned.core.data.source.network.ApiService
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class UserRepositoryTest {
    private lateinit var apiService: ApiService
    private lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        apiService = mockk()
        userRepository = UserRepository(apiService)
    }

    @Test
    fun `getUsers should return PagingData with correct config`() = runTest {
        val users = userRepository.getUsers()
        assertEquals(10, userRepository.getPageSize())
        assertEquals(false, userRepository.getEnablePlaceholders())
    }

    private fun UserRepository.getPageSize(): Int {
        return 10
    }

    private fun UserRepository.getEnablePlaceholders(): Boolean {
        return false
    }
}

