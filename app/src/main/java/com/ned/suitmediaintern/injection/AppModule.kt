package com.ned.suitmediaintern.injection

import com.ned.core.domain.usecase.palindrome.PalindromeInteractor
import com.ned.core.domain.usecase.palindrome.PalindromeUseCase
import com.ned.suitmediaintern.ui.presentation.firstscreen.FirstScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module

val useCaseModule = module {
    factory<PalindromeUseCase> { PalindromeInteractor(get()) }
}

val viewModelModule = module {
    viewModel { FirstScreenViewModel(get()) }
}