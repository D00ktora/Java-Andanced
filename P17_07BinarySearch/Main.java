/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 29.3.2023 г.
 * Time: 19:06
 */
package P17_07BinarySearch;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arr[] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int key = Integer.parseInt(scanner.nextLine());
        int last=arr.length-1;
        BinarySearchExample.binarySearch(arr,0,last,key);

    }

    public static class BinarySearchExample {
        public static void binarySearch(int arr[], int first, int last, int key) {
            int mid = (first + last) / 2;
            while (first <= last) {
                if (arr[mid] < key) {
                    first = mid + 1;
                } else if (arr[mid] == key) {
                    System.out.println(mid);
                    break;
                } else {
                    last = mid - 1;
                }
                mid = (first + last) / 2;
            }
        }
    }
}
