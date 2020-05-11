package br.com.itidigitalchallenge.commons.extensions

private val specialCharacters = charArrayOf(
    '<',
    '(',
    '[',
    '{',
    '\\',
    '^',
    '-',
    '=',
    '$',
    '!',
    '|',
    ']',
    '}',
    ')',
    '?',
    '*',
    '+',
    '.',
    '>'
)

fun Char.isSpecialCharacter() = specialCharacters.contains(this)
