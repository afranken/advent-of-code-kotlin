package com.github.afranken.aoc

object Day202106 {

    fun part1(inputs: Array<String>): Long {
        val fish = fishMap(inputs.map { Integer.valueOf(it) })

        val agedFish = age(fish, 80)

        return agedFish.values.sum()
    }

    fun part2(inputs: Array<String>): Long {
        val fish = fishMap(inputs.map { Integer.valueOf(it) })

        val agedFish = age(fish, 256)

        return agedFish.values.sum()
    }

    private fun fishMap(inputs: List<Int>): MutableMap<Int, Long> {
        val fish = mutableMapOf<Int, Long>()

        inputs.forEach { fish.merge(it, 1, Long::plus) }

        return fish
    }

    private fun age(fish: MutableMap<Int, Long>, days: Int): Map<Int, Long> {
        repeat(days) {
            val eights = fish.getOrDefault(8, 0)
            val sevens = fish.getOrDefault(7, 0)
            val sixes = fish.getOrDefault(6, 0)
            val fives = fish.getOrDefault(5, 0)
            val fours = fish.getOrDefault(4, 0)
            val threes = fish.getOrDefault(3, 0)
            val twos = fish.getOrDefault(2, 0)
            val ones = fish.getOrDefault(1, 0)
            val zeroes = fish.getOrDefault(0, 0)

            //zeroes spawn new 8s
            fish[8] = zeroes
            fish[7] = eights
            //zeroes are set to 6s after spawning, 7s degrade to 6s
            fish[6] = zeroes + sevens
            fish[5] = sixes
            fish[4] = fives
            fish[3] = fours
            fish[2] = threes
            fish[1] = twos
            fish[0] = ones
        }
        return fish
    }
}
