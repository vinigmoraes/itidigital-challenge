package br.com.itidigitalchallenge.integration

import br.com.itidigitalchallenge.application.ITIDigitalChallengeApplication
import br.com.itidigitalchallenge.commons.extensions.json
import br.com.itidigitalchallenge.integration.utils.readJsonResource
import com.github.kittinunf.fuel.Fuel
import io.ktor.http.HttpStatusCode
import io.ktor.server.netty.NettyApplicationEngine
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.concurrent.TimeUnit

class PasswordIntegrationTest {

    private lateinit var server: NettyApplicationEngine
    private val baseUrl = "http://localhost:8081"

    @Before
    fun setUp() {
        server = ITIDigitalChallengeApplication.start(8081)
    }

    @After
    fun setDown() {
        server.stop(5, 10, TimeUnit.SECONDS)
    }

    @Test
    fun `given valid password pattern request should validate password successfully`() {
        val request = readJsonResource("password/request/password_validation_valid_request")
        val expectedResponse = readJsonResource("password/response/password_validation_valid_response")

        val (_, response, _) = Fuel.post("$baseUrl/password/validate")
            .body(request)
            .response()

        assertThat(expectedResponse).isEqualToIgnoringWhitespace(response.json)
        assertThat(HttpStatusCode.OK.value).isEqualTo(response.statusCode)
    }

    @Test
    fun `given invalid password pattern request should validate password successfully`() {
        val request = readJsonResource("password/request/password_validation_invalid_pattern_request")
        val expectedResponse = readJsonResource("password/response/password_validation_invalid_pattern_response")

        val (_, response, _) = Fuel.post("$baseUrl/password/validate")
            .body(request)
            .response()

        assertThat(expectedResponse).isEqualToIgnoringWhitespace(response.json)
        assertThat(HttpStatusCode.UnprocessableEntity.value).isEqualTo(response.statusCode)
    }
}
