package br.com.itidigitalchallenge.application.config

import org.koin.dsl.module

val configModule = module {
    single { ObjectMapperProvider.provide() }
}
