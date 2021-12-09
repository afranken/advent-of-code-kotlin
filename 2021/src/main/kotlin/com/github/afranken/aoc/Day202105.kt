package com.github.afranken.aoc

object Day202105 {


    fun part1(inputs: Array<String>): Int {
        val coordinates = getCoordinates(inputs)
        val matrix = createMatrix(coordinates)

        coordinates.forEach {
            val from = Pair(it[0], it[1])
            val to = Pair(it[2], it[3])
            mark(matrix, from, to)
        }

        var count = 0
        matrix.forEach { it.forEach { if (it >= 2) count++ } }

        return count
    }

    fun part2(inputs: Array<String>): Int {
        val coordinates = getCoordinates(inputs)
        val matrix = createMatrix(coordinates)

        coordinates.forEach {
            val from = Pair(it[0], it[1])
            val to = Pair(it[2], it[3])
            mark(matrix, from, to, true)
        }

        var count = 0
        matrix.forEach { it.forEach { if (it >= 2) count++ } }

        return count
    }

    data class Pair(val x: Int, val y: Int)

    private fun createMatrix(coordinates: List<List<Int>>): Array<IntArray> {
        val size = coordinates[0][0].toString().length
        var maxSizeString = ""
        for (i in 0 until size) {
            maxSizeString += "9"
        }
        val maxSize = Integer.valueOf(maxSizeString) + 1 //9->10, 99->100, 999->1000
        return Array(maxSize) { IntArray(maxSize) { 0 } } //maxSize*maxSize array with '0's
    }

    private fun sort(from: Pair, to: Pair): List<Pair> {
        return if (from.x < to.x || from.x == to.x && from.y < to.y) {
            listOf(from, to)
        } else {
            listOf(to, from)
        }
    }

    private fun mark(
        matrix: Array<IntArray>,
        from: Pair, to: Pair,
        diagonals: Boolean = false
    ) {
        val (lower, higher) = sort(from, to)

        if (lower.x == higher.x) {
            //vertical line.
            (lower.y..higher.y).forEach {
                matrix[it][lower.x]++
            }
        } else if (lower.y == higher.y) {
            //horizontal line.
            (lower.x..higher.x).forEach {
                matrix[lower.y][it]++
            }
        } else if (diagonals) {
            //diagonal line
            val deltaX = higher.x - lower.x
            val deltaY = higher.y - lower.y
            val direction = when {
                deltaY > 0 -> 1
                deltaY < 0 -> -1
                else -> 0
            }
            (0..deltaX).forEach { delta ->
                matrix[lower.y + direction * delta][lower.x + delta]++
            }
        }
    }

    private fun getCoordinates(inputs: Array<String>): List<List<Int>> {
        return inputs.map { it.split(",", " -> ") }.map { it.map { Integer.valueOf(it) } }
    }
}
