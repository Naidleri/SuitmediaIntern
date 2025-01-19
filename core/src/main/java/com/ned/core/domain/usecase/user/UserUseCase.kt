package com.ned.core.domain.usecase.user

import androidx.paging.PagingData
import com.ned.core.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserUseCase {
    fun getUsers(): Flow<PagingData<User>>
}