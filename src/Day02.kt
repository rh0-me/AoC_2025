fun main() {
    fun part1(input: List<String>): ULong {
        fun isInvalid(id: ULong): Boolean {
            val idStr = id.toString()
            val len = idStr.length
            val middle = len / 2
            if (idStr.length % 2 != 0) {
                return false
            }
            for (index in 0..<middle) {
                val char = idStr[index]
                if (char != idStr[middle + index]) return false

            }
            return true
        }

        fun invalidIdsInRange(start: ULong, end: ULong): List<ULong> {
            val invalidIds = mutableListOf<ULong>()

            for (id in start..end) {
                if (isInvalid(id)) invalidIds.add(id)
            }
            println("For range $start to $end")
            println(invalidIds)
            return invalidIds
        }

        val invalidIds = mutableListOf<ULong>()

        val ranges = input[0].split(",")

        for (range in ranges) {
            val entries = range.split("-")
            if (entries.size != 2) throw Exception("Invalid range: $range")

            val start = entries[0].toULong()
            val end = entries[1].toULong()

            invalidIds.addAll(invalidIdsInRange(start, end))
        }


        return invalidIds.sum()

    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    try {

        // Test if implementation meets criteria from the description, like:

        // Or read a large test input from the `src/Day01_test.txt` file:
        val testInput = readInput("Day02_test")
        println(part1(testInput))

        val input = readInput("Day02")
        part1(input).println()
        part2(input).println()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
