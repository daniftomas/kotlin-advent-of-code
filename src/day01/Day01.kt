package day01

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    fun orderList (list: List<Int>): List<Int> {
        return list.sorted()
    }

    fun theDifference (firstNumber: Int, secondNumber: Int, ): Int {
        if (firstNumber < secondNumber)
            return secondNumber - firstNumber
        else
            return firstNumber - secondNumber
    }

    // Test if implementation meets criteria from the description, like:
    check(part1(listOf("test_input")) == 1)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    input.println()

    val firstList = mutableListOf<Int>()
    val secondList = mutableListOf<Int>()

    for (element in input) {
        firstList.add(element.split("   ")[0].toInt())
        secondList.add(element.split("   ")[1].toInt())
    }

    val firstListOrdered = orderList(firstList)
    firstListOrdered.println()

    val secondListOrdered =  orderList(secondList)
    secondListOrdered.println()

    var difference = 0

    for (i in firstListOrdered.indices) {
        difference += theDifference(firstListOrdered[i], secondListOrdered[i])
    }

    // Part two

    var similarity = 0
    var totalSimilarity = 0

    for (i in firstListOrdered.indices) {
        println("Total similarity: $totalSimilarity")

        similarity = 0

        for(j in secondListOrdered.indices) {
            if (firstListOrdered[i] == secondListOrdered[j]) {
                similarity += 1
            }

        }
        println("similarity of ${firstListOrdered[i]} : $similarity")
        println("Total similarity count next sum: $totalSimilarity + ${firstListOrdered[i]} * $similarity")
        totalSimilarity += firstListOrdered[i] * similarity
    }



    println("The difference is: $difference")
    println("The similarity: $totalSimilarity")
    //part1(input).println()
    //part2(input).println()
}
