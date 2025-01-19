package com.ned.core.injection

import com.ned.core.data.repository.PalindromeRepository
import com.ned.core.data.repository.UserRepository
import com.ned.core.data.source.network.ApiConfig
import com.ned.core.domain.repository.IPalindromeRepository
import com.ned.core.domain.repository.IUserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IPalindromeRepository> { PalindromeRepository() }
    single<IUserRepository> { UserRepository(get()) }
}

val networkModule = module {
    single { ApiConfig.getApiServices() }
}