var count: Int = 15_000_000
fun main() {
    println("Добрый день, Вы используйте систему оплаты ShvetsPay. Просим Вас выбрать действие в меню ниже.")
    while (true) {
        println(
            """
            Введите следующее действие:
            1. Посмотреть баланс;
            2. Посмотреть условия перевода;
            3. Осуществить перевод;
            4. Завершить работу с приложением.
        """.trimIndent()
        )
        try {
            var chose: Int = readLine()?.toInt() ?: 0
            when (chose) {
                1 -> {
                    println("Ваш баланс = ${count.toDouble() / 100} руб. (или $count копеек)")
                }
                2 -> println(
                    """
                    Условия перевода: 
                    Отправлять деньги можно получателю введя имя и фамилию. Номер карты указывать не надо.
                    За переводы с любых карт комиссия 0.75%, минимум 35 рублей.
                """.trimIndent()
                )
                3 -> {
                    transitMoney()
                }
                4 -> break
                else -> println("Вы вели число, которого нет в меню. \n")
            }
        } catch (e: Exception) {
            println("Необходимо выбрать цифру")
        } finally {
            println("----------------------------------------------------------------------------------------------------")
        }

    }
    println(" Спасибо, что воспользовались системой ShvetsPay. Ваш баланс ${count.toDouble() / 100} руб. (или $count копеек)")
}

fun transitMoney() {
    println("Введите имя и фамилию получателя через пробел для перевода:")
    var nameAndSurname: String? = readLine()
    println("Введите сумму (руб.) для перевода:")
    var amount: Int = (readLine()?.toInt() ?: 0) * 100
    var result: Int = if ((amount * 75 / 10000) < 3500) 3500 else (amount * 75 / 10000)
    count -= (result + amount)
    println("Вы перевели пользователю $nameAndSurname ${amount.toDouble() / 100} руб. (или $amount копеек), " +
            "комиссия составляет ${result.toDouble() / 100} руб. (или $result копеек), остаток на счете ${count.toDouble() / 100} руб. (или $count копеек)")

}