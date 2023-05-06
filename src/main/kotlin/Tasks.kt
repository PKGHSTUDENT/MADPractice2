import kotlin.math.pow

class Tasks {
    fun consecutiveLetters(original: String): String {
        if (original == "") return "";
        var result: StringBuilder = StringBuilder()
        var lastChar: Char? = null
        var index: Int = 1;
        for (char in original.uppercase().toCharArray()) {
            if (char == lastChar) index++
            else if (index > 1) {
                result.append("$lastChar${index.toString()}")
                index = 1
            } else if (index == 1 && lastChar != null)
                result.append(lastChar)
            lastChar = char
        }
        if (index > 1) result.append("$lastChar${index.toString()}")
        else result.append(lastChar)
        return result.toString()
    }

    // Task 2
    fun numberOfLetters(original: String): MutableMap<Char, Int> {
        var result: MutableMap<Char, Int> = mutableMapOf()
        for (char in original.replace("[^A-Za-z0-9 ]", "").uppercase().toCharArray()) {
            if (result.containsKey(char))
            {
                result.put(char, result.getValue(char) + 1)
            }
            else result.put(char, 1)
        }

        return result.toSortedMap()
    }

    // Task 3
    fun decimalToBinary(a: Int): String {
        return Integer.toBinaryString(a).toString()
    }

    // Task 4
    fun calculator(a: Double = 1.0, b: Double = 1.0, action: Char = '+'): Double {
        when (action) {
            '+' -> return a + b
            '-' -> return a - b
            '*' -> return a * b
            '/' -> return a / b
        }
        return 0.0
    }

    // Task 5
    fun findPower(n: Int, x: Int): String {
        var y = 1
        while (x.toDouble().pow(y) <= n.toDouble()) {
            if (x.toDouble().pow(y) == n.toDouble()) {
                return y.toString()
            }
            y++
        }
        return "Integer exponent does not exist."
    }

    // Task 6
    fun createOddNumber(num1: Int, num2: Int): String {
        val digits = (num1.toString() + num2.toString()).toCharArray()
        var oddFound = false

        var result: String = "It is impossible to create an odd number"

        for (digit in digits) {
            val digitInt = digit.toString().toInt()
            if (digitInt % 2 != 0) {
                result = digits.joinToString("")
                oddFound = true
                break
            }
        }

        return result
    }

    // Task 7
    fun findIntersection(arr1: IntArray, arr2: IntArray): IntArray {
        val map = mutableMapOf<Int, Int>()
        val result = mutableListOf<Int>()

        arr1.forEach {
            map[it] = (map[it] ?: 0) + 1
        }

        arr2.forEach {
            if (map.containsKey(it) && map[it]!! > 0) {
                result.add(it)
                map[it] = map[it]!! - 1
            }
        }
        result.sort()

        return result.toIntArray()
    }

    // Task 8
    fun groupWords(words: Array<String>): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val groupedWords = mutableMapOf<String, MutableList<String>>()

        words.forEach { word ->
            val sortedWord = word.toCharArray().sorted().joinToString("")
            if (!groupedWords.containsKey(sortedWord)) {
                groupedWords[sortedWord] = mutableListOf(word)
            } else {
                groupedWords[sortedWord]?.add(word)
            }
        }

        groupedWords.values.forEach { group ->
            result.add(group)
        }

        return result
    }
}