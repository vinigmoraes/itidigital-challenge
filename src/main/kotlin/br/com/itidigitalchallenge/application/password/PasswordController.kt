package br.com.itidigitalchallenge.application.password

import br.com.itidigitalchallenge.application.password.response.ValidatePasswordResponse
import br.com.itidigitalchallenge.core.password.PasswordService
import br.com.itidigitalchallenge.core.password.ports.ValidatePasswordRequest
import com.fasterxml.jackson.databind.ObjectMapper
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.request.receiveText
import io.ktor.response.respond
import org.slf4j.LoggerFactory

class PasswordController(
    private val mapper: ObjectMapper,
    private val service: PasswordService
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    suspend fun validate(call: ApplicationCall) {
        val json = call.receiveText()

        logger.info("Validating password")

        val request = mapper.readValue(json, ValidatePasswordRequest::class.java)

        val valid = service
            .validate(request.password)
            .isValid()

        val statusCode = if (valid) HttpStatusCode.OK else HttpStatusCode.UnprocessableEntity

        logger.info("Password validated result - valid: $valid status code: $statusCode")

        return call.respond(statusCode, ValidatePasswordResponse.create(valid))
    }
}
