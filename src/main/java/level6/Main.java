package level6;

/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
 Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
плавание: кот не умеет плавать, собака 10 м.).
4. * Добавить подсчет созданных котов, собак и животных.
 */

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InputMismatchException {

        Scanner scanner = new Scanner(System.in);

        //сгенерируем количество участников кошек, собак в забеге и плавании
        Random random = new Random();
        int countCats = random.nextInt(2, 5);
        System.out.println("Количество участниц-кошек в соревнованиях: " + countCats);

        int countDog = random.nextInt(2, 5);
        System.out.println("Количество участников-собак в соревнованиях: " + countDog);
        System.out.println("Всего участников: " + (countCats + countDog));

        //создадим массив животных
        Animal[] animals = new Animal[countCats + countDog];

        for (int i = 0; i < animals.length; i++) {

            if (i < countCats) {
                double distanceRun = Math.random() * 200;
                double distanceSwim = Math.random() * 0;
                Animal cat = new Cat(distanceRun, distanceSwim);
                animals[i] = cat;
                System.out.println("\nКошка под номером #" + (i+1)  + " может пробежать: " + animals[i].getAnimalDistanceRun() + " м.");
            } else {
                double distanceRun = Math.random() * 500;
                double distanceSwim = Math.random() * 10;
                Animal dog = new Dog(distanceRun, distanceSwim);
                animals[i] = dog;
                System.out.println("\nСобака под номером #" + (i+1) + " может пробежать: " + animals[i].getAnimalDistanceRun() + " м.");
            }
        }

        System.out.println("\nСтарт соревнований. Введите дистанцию для забега животных:");
        double distance = scanner.nextDouble();

        for (int i = 0; i < animals.length; i++) {

            if (i < countCats) {
                boolean catJustDoIt = animals[i].run(distance);
                if (catJustDoIt) {
                    System.out.println("Кошка под номером #" + (i+1) + " пробежала дистанцию " + distance + " м.");
                } else {
                    System.out.println("Кошка под номером #" + (i+1) + " не смогла пробежать дистанцию " + distance + " м.");
                }
            } else {
                boolean dogJustDoIt = animals[i].run(distance);
                if (dogJustDoIt) {
                    System.out.println("Собака под номером #" + (i+1) + " пробежала дистанцию " + distance + " м.");
                } else {
                    System.out.println("Собака под номером #" + (i+1) + " не смогла пробежать дистанцию " + distance + " м.");
                }
            }
        }


        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        for (int i = 0; i < animals.length; i++) {

            if (i < countCats) {
                System.out.println("\nКошка под номером #" + (i+1)  + " может проплыть: " + animals[i].getAnimalDistanceSwim() + " м.");
            } else {
                System.out.println("\nСобака под номером #" + (i+1) + " может проплыть: " + animals[i].getAnimalDistanceSwim() + " м.");
            }
        }

        System.out.println("\nСтарт соревнований для собак, кошки не участвуют. Введите дистанцию для забега собак:");
        distance = scanner.nextDouble();

        for (int i = countCats - 1; i < animals.length; i++) {
            boolean dogJustDoIt = animals[i].swim(distance);
            if (dogJustDoIt) {

                System.out.println("Собака под номером #" + (i+1) + " проплыла дистанцию " + distance + " м.");
            }
            else {
                System.out.println("Собака под номером #" + (i+1) + " не смогла проплыть дистанцию " + distance + " м.");
            }
        }

    }

}
