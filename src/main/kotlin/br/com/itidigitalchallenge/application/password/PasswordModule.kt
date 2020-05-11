package br.com.itidigitalchallenge.application.password

import br.com.itidigitalchallenge.core.password.PasswordService
import org.koin.dsl.module

val passwordModule = module {
    single { PasswordController(get(), get()) }
    single { PasswordService() }
}
