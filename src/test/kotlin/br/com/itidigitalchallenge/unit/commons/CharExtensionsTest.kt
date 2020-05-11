package br.com.itidigitalchallenge.unit.commons

import br.com.itidigitalchallenge.commons.extensions.isSpecialCharacter
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class CharExtensionsTest {

    @Test
    fun `given char with special character content should return true`() {
        val char = '!'

        assertTrue(char.isSpecialCharacter())
    }

    @Test
    fun `given char without special character content should return false`() {
        val char = 'b'

        assertFalse(char.isSpecialCharacter())
    }
}
