package com.ned.core.domain.usecase.user

import androidx.paging.PagingData
import com.ned.core.domain.model.User
import com.ned.core.domain.repository.IUserRepository
import kotlinx.coroutines.flow.Flow

class UserInteractor (private val userRepository: IUserRepository) : UserUseCase {
    override fun getUsers(): Flow<PagingData<User>> {
        return userRepository.getUsers()
    }

}