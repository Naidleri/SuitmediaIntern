package com.ned.core.data.injection

import com.ned.core.data.repository.PalindromeRepository
import com.ned.core.domain.repository.IPalindromeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IPalindromeRepository> { PalindromeRepository() }
}