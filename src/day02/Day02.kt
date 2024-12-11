package day02

import println
import readInput
import kotlin.math.abs

fun main() {

    // Read the input from the `src/Day02.txt` file.
    val input = readInput("day02","Day02")
    //input.println()

    fun isListOrdered(list: List<Int>): Boolean {
        return list == list.sorted()
    }

    fun howManyReportsAreSafe(input: List<String>): Int {
        var safeReports = 0
        for (element in input) {
            val report = element.split("   ")
            for(i in report.indices) {
                val data = report[i].split(" ").map{it.toInt()}
                val isSorted = data == data.sorted() || data == data.sortedDescending()
                //"this $data is sorted $isSorted".println()

                if (isSorted) {
                    var isValid = true
                    for(j in 0 until data.size-1) {
                        val differenceCondition = abs(data[j]-data[j+1])

                        if (differenceCondition !in 1..3) {
                            isValid = false
                            //"the difference condition is $differenceCondition and is valid $isValid".println()
                            break
                        }
                    }
                    if (!isValid) break
                    safeReports++
                    //"Safe reports $safeReports".println()

                }
            }
        }
        return safeReports
    }

    howManyReportsAreSafe(input).println()



}
