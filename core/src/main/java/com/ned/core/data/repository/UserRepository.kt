package com.ned.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ned.core.data.source.UserPagingSource
import com.ned.core.data.source.network.ApiService
import com.ned.core.domain.model.User
import com.ned.core.domain.repository.IUserRepository
import kotlinx.coroutines.flow.Flow

class UserRepository (private val apiService: ApiService
): IUserRepository {
    override fun getUsers(): Flow<PagingData<User>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UserPagingSource(apiService) }
        ).flow
    }
}