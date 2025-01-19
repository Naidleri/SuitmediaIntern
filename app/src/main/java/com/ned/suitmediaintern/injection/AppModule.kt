package com.ned.suitmediaintern.injection

import com.ned.core.domain.usecase.palindrome.PalindromeInteractor
import com.ned.core.domain.usecase.palindrome.PalindromeUseCase
import com.ned.core.domain.usecase.user.UserInteractor
import com.ned.core.domain.usecase.user.UserUseCase
import com.ned.suitmediaintern.ui.presentation.firstscreen.FirstScreenViewModel
import com.ned.suitmediaintern.ui.presentation.thirdscreen.ThirdScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module

val useCaseModule = module {
    factory<PalindromeUseCase> { PalindromeInteractor(get()) }
    factory<UserUseCase> { UserInteractor(get()) }
}

val viewModelModule = module {
    viewModel { FirstScreenViewModel(get()) }
    viewModel { ThirdScreenViewModel(get()) }
}