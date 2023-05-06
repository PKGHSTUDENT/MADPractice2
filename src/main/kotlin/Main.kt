fun main(args: Array<String>) {
    println("@dobrodelete")

    val tasks: Tasks = Tasks()
    print("Enter number task: ")
    val input: Int = readln().toInt();

    when (input) {
        1 -> {
            print("Enter your string: ")
            var str = readln()
            println(tasks.consecutiveLetters(str))

//            if (tasks.consecutiveLetters("ADSSSRRTTHA") == "ADS3R2T2HA")
//                println(true)
        }

        2 -> {
            print("Enter your string: ")
            var str = readln()
            var numberOfLetter: MutableMap<Char, Int> = tasks.numberOfLetters(str);
            numberOfLetter.forEach {k, v -> println("$k: $v")}
        }

        3 -> {
            print("Enter a: ")
            var a = readln().toInt()
            println(tasks.decimalToBinary(a))
        }

        4 -> {
            print("Enter a: ")
            var a = readln().toDouble()
            print("Enter b: ")
            var b = readln().toDouble()

            print("Enter action(+-*/): ")
            var act = readln().single()
            println("The result of your choice:")
            println(tasks.calculator(a, b, act))

            println("Other result:")
            println(tasks.calculator(a, b, '-'))
            println(tasks.calculator(a, b, '+'))
            println(tasks.calculator(a, b, '*'))
            println(tasks.calculator(a, b, '/'))
            println(tasks.calculator(a, b, 'd'))
            println(tasks.calculator())
        }

        5 -> {
            print("Enter a: ")
            var a = readln().toInt()
            print("Enter b: ")
            var b = readln().toInt()
            println(tasks.findPower(a, b))
        }

        6 -> {
            print("Enter a: ")
            var a = readln().toInt()
            print("Enter b: ")
            var b = readln().toInt()
            println(tasks.createOddNumber(a, b))
        }

        7 -> {
            println("Enter numbers separated by spaces.")
            print("Enter array a: ")
            var a: String = readln()
            print("Enter array b: ")
            var b: String = readln()

            var aArray = a.split(" ").map { it.toInt() }
            var bArray = b.split(" ").map { it.toInt() }


            val result: IntArray = tasks.findIntersection(aArray.toIntArray(), bArray.toIntArray())
            result.forEach { e -> print("$e ") }
        }

        8 -> {
            println("Enter words separated by spaces.")
            print("Enter you words: ")
            val words = readln().split(" ").toTypedArray()
//            val words = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
            val groupedWords = tasks.groupWords(words)

            groupedWords.forEach { group ->
                println(group.joinToString(", "))
            }
        }
    }
}