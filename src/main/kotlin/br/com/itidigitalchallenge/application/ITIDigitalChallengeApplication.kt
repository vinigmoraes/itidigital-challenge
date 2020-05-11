package br.com.itidigitalchallenge.application

import br.com.itidigitalchallenge.application.config.ObjectMapperProvider
import br.com.itidigitalchallenge.application.config.configModule
import br.com.itidigitalchallenge.application.password.password
import br.com.itidigitalchallenge.application.password.passwordModule
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.jackson.JacksonConverter
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.netty.NettyApplicationEngine
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.get

fun Application.main() {

    install(Koin) {
        modules(listOf(configModule, passwordModule))
    }


    install(ContentNegotiation) {
        register(ContentType.Application.Json, JacksonConverter(ObjectMapperProvider.provide()))
    }

    routing {
        password(get())
    }
}

object ITIDigitalChallengeApplication {

    fun start(port: Int): NettyApplicationEngine = embeddedServer(
        factory = Netty,
        watchPaths = listOf("src/main/kotlin/br.com.itidigitalchallenge"),
        port = port,
        module = Application::main
    ).start(false)
}

fun main() {
    embeddedServer(Netty, 8080) {
        main()
    }.start(wait = true)
}
