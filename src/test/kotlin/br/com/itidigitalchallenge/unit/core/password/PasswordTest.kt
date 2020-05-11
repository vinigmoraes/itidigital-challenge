package br.com.itidigitalchallenge.unit.core.password

import br.com.itidigitalchallenge.core.password.Password
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordTest {

    @Test
    fun `given valid password should return true`() {
        val password = Password.create("AbTp9!foo")

        assertTrue(password.isValid())
    }

    @Test
    fun `given password without minimum length required should return false`() {
        val password = Password.create("AAAbbbCc")

        assertFalse(password.isValid())
    }

    @Test
    fun `given empty password should return false`() {
        val password = Password.create("")

        assertFalse(password.isValid())
    }


    @Test
    fun `given password without at lest one uppercase letter should return false`() {
        val password = Password.create("abtp9!foo")

        assertFalse(password.isValid())
    }


    @Test
    fun `given password without at lest one lowercase letter should return false`() {
        val password = Password.create("ABTP9!FOO")

        assertFalse(password.isValid())
    }

    @Test
    fun `given password without at lest one special character should return false`() {
        val password = Password.create("AAAbbbCcC")

        assertFalse(password.isValid())
    }
}
