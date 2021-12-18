package pro.sky.java.course2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));

        System.out.println(nums); //Выводим исходный список

        printOddNumbers(nums); //Выводим только нечетные числа из исходного списка

    }

    private static void printOddNumbers(List<Integer> nums) {
        List<Integer> nums1 = new ArrayList<>(nums);
        Iterator<Integer> iterator = nums1.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(nums1);
    }
}
