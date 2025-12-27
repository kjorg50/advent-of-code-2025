// Advent of Code
// Day 01
// https://adventofcode.com/2025/day/1

import java.io.File

fun part1(filename: String) {

    var result = 0
    var current = 50

    File(filename).forEachLine {
        // access each line with `it` (type String)
        val firstChar = it.first()
        val number = it.substring(1).toInt()
        when (firstChar) {
            'L' -> {
                current = (current - number + 100) % 100
                if (current == 0) result++
            }
            'R' -> {
                current = (current + number) % 100
                if (current == 0) result++
            }
            else -> {
                throw IllegalArgumentException("Unknown direction: $firstChar")
            }
        }
    }

    println("Result: $result")
}

fun part2(filename: String) {

    File(filename).forEachLine {
        // access each line with `it` (type String)
    }

}

fun main(args: Array<String>) {
    part1("input")
//    part2("input")
}

