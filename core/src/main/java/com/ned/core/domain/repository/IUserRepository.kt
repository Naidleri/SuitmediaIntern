package com.ned.core.domain.repository

import androidx.paging.PagingData
import com.ned.core.domain.model.User
import kotlinx.coroutines.flow.Flow

interface IUserRepository {
    fun getUsers(): Flow<PagingData<User>>
}