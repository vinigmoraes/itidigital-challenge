package br.com.itidigitalchallenge.application.password

import io.ktor.application.call
import io.ktor.routing.Route
import io.ktor.routing.post

fun Route.password(controller: PasswordController) {

    post("/password/validate") { controller.validate(call) }
}
