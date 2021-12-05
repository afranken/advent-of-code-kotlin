package com.github.afranken.aoc

import java.io.File

fun getInput(fileName: String): Array<String> {
    val input = Day202103Test::class.java.classLoader.getResource(fileName)
    return File(input.toURI()).readLines().toTypedArray()
}
