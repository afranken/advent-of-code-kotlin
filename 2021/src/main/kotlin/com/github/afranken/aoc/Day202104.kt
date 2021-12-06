package com.github.afranken.aoc

object Day202104 {

    fun part1(inputs: Array<String>): Int {
        val draws = inputs[0].split(',')
        val boards = inputs
            .drop(1)
            .filter { it.isNotEmpty() }
            .chunked(5)
            .map {
                Board.of(it.map {
                    it.split("  ", " ")
                        .filter { it.isNotBlank() } // Leading whitespace
                        .map { it.toInt() }
                })
            }

        for (draw in draws) {
            boards.forEach { it.markField(Integer.valueOf(draw)) }
            val bingoBoard = boards.firstOrNull { it.isBingo() }
            if (bingoBoard != null) {
                return bingoBoard.getUnmarked().sum() * Integer.valueOf(draw)
            }
        }

        return -1
    }

    fun part2(inputs: Array<String>): Int {
        val draws = inputs[0].split(',')
        var boards = inputs
            .drop(1)
            .filter { it.isNotEmpty() }
            .chunked(5)
            .map {
                Board.of(it.map {
                    it.split("  ", " ")
                        .filter { it.isNotBlank() } // Leading whitespace
                        .map { it.toInt() }
                })
            }

        for ((count, draw) in draws.withIndex()) {
            boards.forEach { it.markField(Integer.valueOf(draw)) }
            boards.filter { it.isBingo() }
                .forEach {
                    // there are 100 draws. If this is not the last board, it's still the last one to win.
                    if (boards.size == 1 || count == 100) {
                        return it.getUnmarked().sum() * Integer.valueOf(draw)
                    }
                    boards = boards - it
                }
        }

        return -1
    }

    data class Field(val value: Int, var marked: Boolean = false)

    data class Board(val fields: List<MutableList<Field>>) {
        private val widthIndices = fields[0].indices
        private val heightIndices = fields.indices

        companion object {
            fun of(lines: List<List<Int>>): Board {
                return Board(lines.map { it.map { Field(it) }.toMutableList() })
            }
        }

        fun markField(value: Int) {
            fields.forEach { it.filter { it.value == value }.forEach { it.marked = true } }
        }

        fun getUnmarked(): List<Int> {
            return fields.flatten().filter { !it.marked }.map { it.value }
        }

        fun isBingo(): Boolean {
            return checkColumnMarked() || checkRowMarked()
        }

        private fun checkRowMarked(): Boolean {
            return fields.any { it.all { it.marked } }
        }

        private fun checkColumnMarked(): Boolean {
            for (column in widthIndices) {
                var columnMarked = true
                for (row in heightIndices) {
                    if (!fields[row][column].marked) {
                        columnMarked = false
                        continue
                    }
                }
                if (columnMarked) return true
            }
            return false
        }
    }
}
