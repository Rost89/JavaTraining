//1 Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3
//        попытки угадать это число. При каждой попытке компьютер должен сообщить больше ли
//        указанное пользователем число чем загаданное, или меньше. После победы или проигрыша
//        выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
//2 * Создать массив из слов
//        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
//        "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
//        "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
//        При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//        сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если
//        слово не угадано, компьютер показывает буквы которые стоят на своих местах.
//        apple – загаданное
//        apricot - ответ игрока
//        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//        Для сравнения двух слов посимвольно, можно пользоваться:
//        String str = "apple";
//        str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//        Играем до тех пор, пока игрок не отгадает слово
//        Используем только маленькие буквы


package homeworkJava3;

import java.util.Random;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static void main(String[] args) {
//Task 1.
        System.out.println("Task 1.");
        int x;
        int exit = 1;
        while (exit != 0) {
            int value = random.nextInt(10);
            System.out.println("Угадайте число от 0 до 9.");
            System.out.println("Подсказка: " + value);
            for (int i = 0; i < 3; i++) {
                x = scanner.nextInt();
                if (x > value) System.out.println("Загаданное число меньше x.");
                else if (x < value) System.out.println("Загаданное число больше x.");
                else {
                    System.out.println("Вы угадали value.");
                    break;
                }
            }
            System.out.println("Начать заново? 1/0");
            exit = scanner.nextInt();
        }

//task 2.
        System.out.println("Task 2.");
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
        "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
        "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Угадайте слово из \"apple\", \"orange\", \"lemon\", \"banana\", \"apricot\", \"avocado\", \n" +
                "\"broccoli\", \"carrot\", \"cherry\", \"garlic\", \"grape\", \"melon\", \"leak\", \"kiwi\",\n\"mango\"," +
                "\"mushroom\", \"nut\", \"olive\", \"pea\", \"peanut\", \"pear\", \"pepper\", \"pineapple\",\n" +
                "\"pumpkin\", \"potato\"");
        int possition = random.nextInt(words.length-1);
        String str1 = words[possition];
        System.out.println("Подсказка: " + str1);
        String str2 = scanner.next();
        do {
            if (str1.equals(str2)) {
                System.out.println("Вы угадали.");
                break;
            }
            else {
                for (int i = 0; i < str2.length(); i++) {
                    if (str2.charAt(i) == words[possition].charAt(i)) System.out.print(str2.charAt(i));
                    else break;
                }
            }
            System.out.println("###############");
            str2 = scanner.next();
        } while (true);
    }
}
