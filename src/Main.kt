fun main() {
    /*
    Создать каталог пользователей вместимостью не более 10 персон.
    */
    val list = Array(10, { "" })
    println(list.contentDeepToString())
    while (true) {
        println("Введите номер команды: 1 - Добавить пользователя в каталог 2 - Передать приветствие пользователю")
        println("Любая клавиша кроме 1 и 2 - Выход")
        try {
            val temp = readln().toInt()
            when (temp) {
                1 -> createList(list)
                2 -> greeting(list)
                else -> return
            }
        } catch (e: NumberFormatException) {
            return
        }
    }
}

/*
Она будет содержать функцию приветствия greeting().
*/
fun greeting(list: Array<String>) {
    println("Введите номер пользователя:")
    try {
        val number = readln().toInt()
        if (list[number].isEmpty()) throw MyException() else println("Здравствуйте ${list[number]}!")
    } catch (e: NumberFormatException) {
        println("Введенный символ не является цифрой")
    } catch (e: MyException) {
        println("В данной позиции нет данных пользователя")
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("Введен недопустимый номер позиции")
    }
}

/*
Необходимо написать функцию createList(list: Array<String>), в которой нужно вводить имя и фамилию,
предлагать пользователю разместить созданного члена каталога на ту или иную позицию в каталоге list.
Помещать его туда.
Программа должна перехватывать исключения на ввод пустого имени и определения места в каталоге, которого не существует.
Как пожелание, предлагаем написать свой класс исключений, например, с названием MyException.
*/
fun createList(list: Array<String>) {
    println("Введите имя")
    val firstName = readln()
    println("Введите фамилию")
    val secondName = readln()
    println("Введите номер позиции в каталоге 0-9")
    try {
        val position = readln().toInt()
        if (firstName != "" && secondName != "") list[position] = "$firstName $secondName"
        else throw MyException()
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("Введен недопустимый номер позиции")
    } catch (e: NumberFormatException) {
        println("Введенный символ не является цифрой")
    } catch (e: MyException) {
        println("Не введены имя пользователя и/или фамилия")
    }
    println(list.contentDeepToString())
}

class MyException : Throwable()

