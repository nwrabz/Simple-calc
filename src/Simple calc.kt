fun add(num1: Double, num2: Double): Double = num1 + num2
fun subtract(num1: Double, num2: Double): Double = num1 - num2
fun multiply(num1: Double, num2: Double): Double = num1 * num2
fun divide(num1: Double, num2: Double): String {
    return if (num2.equals(0.0)) {
        return "Not visible by zero"
    } else {
        return "${num1 / num2}"
    }
}

fun getNumberInput(prompt: String): Double {
    while (true) {
        println(prompt)
        try {
            return readLine()?.toDouble() ?: throw Exception("Invalid input")
        } catch (e: Exception) {
            println("Please enter a valid number.")
        }
    }
}

fun getOperationInput(): String {
    while (true) {
        println("Choose -, +, *, / or type 'exit' to quit")
        val operation = readlnOrNull()
        if (operation in listOf("+", "-", "*", "/", "exit")) {
            return operation!!
        }
        println("Invalid operation. Please try again")
    }
}

fun main() {
    println("Welcome to Kotlin calculator")
    while (true) {
        val  operation = getOperationInput()
        if (operation == "exit"){
            println("Goodbye!")
            break
        }

        val number1 = getNumberInput("Enter the first number: ")
        val number2 = getNumberInput("Enter the second number: ")

        val  result = when(operation){
            "+" -> add(number1, number2)
            "-" -> subtract(number1, number2)
            "/" -> divide(number1, number2)
            "*" -> multiply(number1, number2)
            else -> {
                println("Unknown operation")
                continue
            }
        }
        println("Result $result")
    }

}