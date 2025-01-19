package com.ned.suitmediaintern.ui.presentation.thirdscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ned.core.domain.model.User
import com.ned.core.domain.usecase.user.UserUseCase
import kotlinx.coroutines.flow.Flow
import androidx.paging.PagingData
import androidx.paging.cachedIn

class ThirdScreenViewModel(private val userUseCase: UserUseCase) : ViewModel() {
    val users: Flow<PagingData<User>> = userUseCase
        .getUsers()
        .cachedIn(viewModelScope)
}