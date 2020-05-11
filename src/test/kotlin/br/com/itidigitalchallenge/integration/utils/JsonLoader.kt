package br.com.itidigitalchallenge.integration.utils

fun readJsonResource(fileName: String) = ClassLoader.getSystemResource("json/$fileName.json").readText()
