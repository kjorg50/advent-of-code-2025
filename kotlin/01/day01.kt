// Advent of Code
// Day 01
// https://adventofcode.com/2025/day/1

import java.io.File
import kotlin.math.abs

fun part1(filename: String) {

    var result = 0
    var current = 50

    File(filename).forEachLine {
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
    var result = 0
    var current = 50

    File(filename).forEachLine {
        val firstChar = it.first()
        val number = it.substring(1).toInt()

        val wraps = number / 100
        result += wraps
//        println("Adding wraps: $wraps, total now: $result")

        val remaining = number % 100

        if (remaining > 0) {
            val start = current
            val end: Int

            if (firstChar == 'R') {
                end = (start + remaining) % 100
                if (start != 0 && end < start || end == 0) {
                    result++
//                    println("Additional wrap from $start to $end, new total is $result" )
                }
            } else {
                end = (start - remaining + 100) % 100
                if (start != 0 && end > start || end == 0) {
                    result++
//                    println("Additional wrap from $start to $end, new total is $result" )
                }
            }
            current = end
        } else {
            // exactly divisible by 100
            // current remains the same, no additional wrap
            current = current
        }
    }
    println("Result: $result")
}

fun main(args: Array<String>) {
//    part1("input")
    part2("input")
}

