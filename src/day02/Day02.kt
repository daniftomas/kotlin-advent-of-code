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

    val firstWaveList = mutableListOf<List<Int>>()

    fun howManyReportsAreSafe(input: List<String>): Int {
        var safeReports = 0
        for (element in input) {
            val report = element.split("   ")
            for(i in report.indices) {
                val data = report[i].split(" ").map{it.toInt()}
                val isSorted = data == data.sorted() || data == data.sortedDescending()
                //"this $data is sorted $isSorted".println()
                if (!isSorted) {
                    //"Not sorted $data".println()
                    firstWaveList.add(data)
                }

                if (isSorted) {
                    var isValid = true
                    for(j in 0 until data.size-1) {
                        val differenceCondition = abs(data[j]-data[j+1])

                        if (differenceCondition !in 1..3) {
                            isValid = false
                            //"the difference condition is $differenceCondition and is valid $isValid".println()
                            //data.println()
                            firstWaveList.add(data)
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

    //"This is the first failed list $firstWaveList".println()


    // Part two

    fun turnTheListToReports (input: List<String>) : List<List<Int>> {
        val inputToInt = mutableListOf<List<Int>>()
        //run through the input list
        for (element in input) {
            // make the list a list of Strings
            val report = element.split("   ")
            for(i in report.indices) {
                val data = report[i].split(" ").map { it.toInt() }
                inputToInt.add(data)
            }
        }
        return inputToInt
    }

    fun returnsValidReportValidation (report : List<Int>) : Boolean {
        val isSorted = report == report.sorted() || report == report.sortedDescending()
        //"this $data is sorted $isSorted".println()
        if (!isSorted) {
            return false
        }

        for(i in report.indices) {
            for(j in 0 until report.size-1) {
                val differenceCondition = abs(report[j]-report[j+1])

                if (differenceCondition !in 1..3) {
                    //"the difference condition is $differenceCondition and is valid $isValid".println()
                    return false
                }
            }
        }
        return true
    }

    val readyEvaluate = turnTheListToReports(input)
    val invalidReportsData = mutableListOf<List<Int>>()
    val validReportsData = mutableListOf<List<Int>>()

    for(element in readyEvaluate) {
        val isValid = returnsValidReportValidation(element)
        if (isValid) {
            validReportsData.add(element)
        } else {
            invalidReportsData.add(element)
        }
    }

    //"This is the invalid: $invalidReportsData".println()
    //"This is the valid: $validReportsData".println()

    for(report in invalidReportsData) {
        for (i in report.indices) {
            val tempList = mutableListOf<Int>()
            tempList.addAll(report)
            tempList.removeAt(i)

            val isValid = returnsValidReportValidation(tempList)

            if (isValid) {
                validReportsData.add(report)
                break
            }
        }
    }

    //"This is the valid: $validReportsData".println()
    "This is the valid List Size: ${validReportsData.size}".println()
}
