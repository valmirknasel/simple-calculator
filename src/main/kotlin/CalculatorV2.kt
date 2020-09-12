import java.lang.IllegalArgumentException

enum class MathematicalOperator(val op: Char) {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/')
}

fun checkOperator(op: MathematicalOperator): (Double, Double) -> Double {
    return when (op) {
        MathematicalOperator.PLUS -> { x, y -> x + y }
        MathematicalOperator.MINUS -> { x, y -> x - y }
        MathematicalOperator.MULTIPLY -> { x, y -> x * y }
        MathematicalOperator.DIVIDE -> { x, y -> x / y }
    }
}

fun errorMessage() = "Invalid argument!"

fun readUserInputs(): MutableList<Any> {
    val operators = mutableListOf<Any>()
    return try {
        operators.add(readOperator())
        operators.add(readOperandOne())
        operators.add(readOperandTwo())
        return operators
    } catch (e: IllegalArgumentException) {
        println(e.message)
        println("Please inform a valid operator (+ - * /)")
        readUserInputs()
    }
}

@Throws(IllegalArgumentException::class)
fun readOperator(): MathematicalOperator {
    println("Inform the operator:")
    var operator = readLine().toString()
    while (isNotValidOperator(operator)) {
        println("Invalid Operator! Please inform a valid operator (+ - * /)")
        operator = readLine().toString()
    }
    return when (operator) {
        "+" -> MathematicalOperator.PLUS
        "-" -> MathematicalOperator.MINUS
        "*" -> MathematicalOperator.MULTIPLY
        "/" -> MathematicalOperator.DIVIDE
        else -> throw IllegalArgumentException(errorMessage() + " $operator")
    }
}

fun readOperandOne(): String {
    println("Inform the first operand:")
    var operandOne = readLine().toString()
    while (isNotValidOperand(operandOne)) {
        println("Inform the first operand:")
        operandOne = readLine().toString()
    }
    return operandOne
}

fun readOperandTwo(): String {
    println("Inform the second operand:")
    var operandTwo = readLine().toString()
    while (isNotValidOperand(operandTwo)) {
        println("Inform the second operand:")
        operandTwo = readLine().toString()
    }
    return operandTwo
}

fun isNotValidOperator(s: String): Boolean {
    if (s.isEmpty()) {
        println(errorMessage())
        return true
    }
    return false
}

fun isNotValidOperand(s: String): Boolean {
    if (s.isEmpty()) {
        println(errorMessage())
        return true
    }
    return try {
        s.toInt()
        false
    } catch (e: NumberFormatException) {
        println("Invalid operand $s! Please use only positive integer numbers")
        true
    }

}

fun main() {
    val op = readUserInputs()

    TODO()

}