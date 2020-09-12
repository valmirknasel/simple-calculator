/*
* Version 1.0 - Initial Project @deprecated!
* */

const val ADD = "+"
const val SUBTRACT = "-"
const val MULTIPLY = "*"
const val DIVIDE = "/"

const val ERROR_MESSAGE = "Not a valid operator."

const val testOperandOne = 5.0
const val testOperandTwo = 4.0

fun main() {
    println("Please insert one of these operators to calculate: + - * /")
    var operatorSymbol = readLine()
    start(operatorSymbol)
}

fun start(operatorSymbol: String?) {
    if (checkArguments(operatorSymbol)) {
        displayResult(
            evaluateBinomial(testOperandOne, testOperandTwo, operatorSymbol)
        )
    } else {
        displayResult(ERROR_MESSAGE)
        println("Please insert one of these operators to calculate: + - * /")
        var opSymbol = readLine()
        start(opSymbol)
    }
}

fun displayResult(result: String) = println(result)

fun evaluateBinomial(opOne: Double, opTwo: Double, symbol: String?): String {
    return when (symbol) {
        ADD -> (opOne + opTwo).toString()
        SUBTRACT -> (opOne - opTwo).toString()
        MULTIPLY -> (opOne * opTwo).toString()
        DIVIDE -> (opOne / opTwo).toString()
        else -> ERROR_MESSAGE
    }
}

fun checkArguments(operatorSymbol: String?): Boolean {
    return when (operatorSymbol) {
        ADD -> true
        SUBTRACT -> true
        MULTIPLY -> true
        DIVIDE -> true
        else -> false
    }
}
