package pro.sky.java.course2;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        task1();
//        task2();
//        task3();
//        task4();

    }
    private static void task1() {
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 6, 3, 4, 4, 5, 5, 2, 7));
        //Выводим исходный список
        System.out.println(nums);
        //Выводим только нечетные числа из исходного списка
        System.out.println(deleteEvenNumbers(nums));
    }

    private static void task2() {
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 6, 3, 4, 4, 5, 5, 2, 7));
        //Выводим исходный список
        System.out.println(nums);
        //Выводим из исходного списка только четные числа без повторений в порядке возрастания
        System.out.println(removeOddAndDuplicateNumbersAndSorting(nums));
    }

    private static void task3() {
        List<String> words = new ArrayList<>(List.of
                ("Список", "дублей", "слов", "без", "слов", "дублей", "сделать", "слов"));
        //Выводим исходный список
        System.out.println(words);
        //Выводим список слов без дублей
        System.out.println(removeDuplicateWords(words));
    }

    private static void task4() {
        List<String> words = new ArrayList<>(List.of
                ("Список", "дублей", "слов", "без", "слов", "дублей", "сделать", "слов"));
        //Выводим исходный список
        System.out.println(words);
        //Выводим количество дублей (повторений) слов присутствующих в исходном списке
        System.out.println("Количество повторяющихся слов (дублей) = " +
                calculationOfNumberDuplicateWords(words));
    }

    //Удаление четных чисел из списка, возвращается новый список c нечетными числами
    private static List deleteEvenNumbers(List<Integer> nums) {
        List<Integer> numsResult = new ArrayList<>(nums);
        Iterator<Integer> iterator = numsResult.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        return numsResult;
    }

    //Удаление нечетных чисел из списка, возвращается новый список с четными числами
    private static List deleteOddNumbers(List<Integer> nums) {
        List<Integer> numsResult = new ArrayList<>(nums);
        Iterator<Integer> iterator = numsResult.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 1) {
                iterator.remove();
            }
        }
        return numsResult;
    }

    //Создание списка, в котором только четные числа без повторений в порядке возрастания
    private static List removeOddAndDuplicateNumbersAndSorting(List<Integer> nums) {
        List<Integer> numsResult = deleteOddNumbers(nums); //Удаляем нечетные числа
        numsResult.sort(Comparator.naturalOrder());        //Сортируем по возростанию
        Iterator<Integer> iterator = numsResult.iterator();
        //Организуем цикл для удаления повторяющихся чисел
        int n1 = 0; int n2 = 0;       //Вспомогательные переменные
        for (int i = 0; iterator.hasNext() ; i++) {
            if (i == 0) {
                n1 = iterator.next();
            } else {
                n2 = iterator.next();
                if (n1 == n2) {
                    iterator.remove();
                } else n1 = n2;
            }
        }
        return numsResult;
    }

    //Удаление дублей слов из списка, возвращается новый список без дублей
    private static List<String> removeDuplicateWords(List<String> words) {
        List<String> wordsResult = new ArrayList<>(words);
        wordsResult.sort(Comparator.naturalOrder());    //Сортируем по возростанию
        Iterator<String> iterator = wordsResult.iterator();
        //Организуем цикл для удаления повторяющихся слов
        String s1 = "";  String s2 = "";       //Вспомогательные переменные
        for (int i = 0; iterator.hasNext(); i++) {
            if (i == 0) {
               s1 = iterator.next();
            } else {
                s2 = iterator.next();
                if (s1.equals(s2)) {
                    iterator.remove();
                } else s1 = s2;
            }
        }
        return wordsResult;
    }

    //Вычисление количества дублей слов в списке
    private static int calculationOfNumberDuplicateWords(List<String> words) {
        List<String> wordsResult = new ArrayList<>(words);
        wordsResult.sort(Comparator.naturalOrder());    //Сортируем по возростанию
        Iterator<String> iterator = wordsResult.iterator();
        //Организуем цикл для вычисления количества повторяющихся слов
        int numberDuplicate = 0;
        String s1 = "";  String s2 = "";       //Вспомогательные переменные
        for (int i = 0; iterator.hasNext(); i++) {
            if (i == 0) {
                s1 = iterator.next();
            } else {
                s2 = iterator.next();
                if (s1.equals(s2)) {
                    numberDuplicate++;
                    iterator.remove();
                } else s1 = s2;
            }
        }
        return numberDuplicate;
    }
}
