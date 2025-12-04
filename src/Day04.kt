fun main() {
    val paperRoll = '@'
    fun part1(input: List<String>): Int {
        var accessibleRolls = 0

        val lineCount = input.size
        for ((i, line) in input.withIndex()) {
            for ((j, _) in input[i].withIndex()) {
                if (input[i][j] != paperRoll) continue
                var freePositions = 0


                val columnBefore = j - 1
                val columnAfter = j + 1
                val lineBefore = i - 1
                val lineAfter = i + 1

                // adjacencies

                // top left
                if (lineBefore >= 0 && columnBefore >= 0) {
                    if (input[lineBefore][columnBefore] != paperRoll) {
                        freePositions++
                    }
                } else {
                    freePositions++
                }

                // top mid
                if (lineBefore >= 0) {
                    if (input[lineBefore][j] != paperRoll) {
                        freePositions++
                    }
                } else {
                    freePositions++
                }

                // top right
                if (lineBefore >= 0 && columnAfter < line.length) {
                    if (input[lineBefore][columnAfter] != paperRoll) {
                        freePositions++
                    }
                } else {
                    freePositions++
                }

                // mid left

                if (columnBefore >= 0) {
                    if (input[i][columnBefore] != paperRoll) {
                        freePositions++
                    }
                } else {
                    freePositions++
                }

                // mid right
                if (columnAfter < line.length) {
                    if (input[i][columnAfter] != paperRoll) {
                        freePositions++
                    }
                } else {
                    freePositions++
                }

                // bot left
                if (lineAfter < lineCount && columnBefore >= 0) {
                    if (input[lineAfter][columnBefore] != paperRoll) {
                        freePositions++
                    }
                } else {
                    freePositions++
                }
                // bot mid
                if (lineAfter < lineCount) {
                    if (input[lineAfter][j] != paperRoll) {
                        freePositions++
                    }
                } else {
                    freePositions++
                }

                // bot right
                if (lineAfter < lineCount && columnAfter < line.length) {
                    if (input[lineAfter][columnAfter] != paperRoll) {
                        freePositions++
                    }
                } else {
                    freePositions++
                }
                
                if (freePositions >= 5) {
                    accessibleRolls++
                }
            }
            println(line)
        }
        return accessibleRolls
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    try {

        val testInput = readInput("Day04_test")
        part1(testInput).println()

        val input = readInput("Day04")
        part1(input).println()
        part2(input).println()
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }

}