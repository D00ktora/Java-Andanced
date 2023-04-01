/**
 * Created by IntelliJ IDEA
 * User: Stilyan Petrov
 * Date: 29.3.2023 г.
 * Time: 18:37
 */
package P17_05MergeSort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arr = mergeSort(arr);
        String[] forPrint = new String[arr.length];

        for (int i = 0; i < forPrint.length; i++) {
            forPrint[i] = String.valueOf(arr[i]);
        }

        System.out.println(String.join(" ", forPrint));
    }

    private static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }


        int halfIndex = array.length / 2;

        int firstArrayLength = halfIndex;
        int secondArrayLength = array.length - halfIndex;

        int[] firstPartition = new int[firstArrayLength];
        int[] secondPartition = new int[secondArrayLength];

        for (int i = 0; i < firstArrayLength; i++) {
            firstPartition[i] = array[i];
        }
        for (int i = firstArrayLength; i < firstArrayLength + secondArrayLength; i++) {
            secondPartition[i - firstArrayLength] = array[i];
        }

        firstPartition = mergeSort(firstPartition);
        secondPartition = mergeSort(secondPartition);


        int mainIndex = 0;
        int firstPartitionIndex = 0;
        int secondPartitionIndex = 0;


        while (firstPartitionIndex < firstArrayLength && secondPartitionIndex < secondArrayLength) {
            if (firstPartition[firstPartitionIndex] < secondPartition[secondPartitionIndex]) {
                array[mainIndex] = firstPartition[firstPartitionIndex];

                mainIndex++;
                firstPartitionIndex++;
            } else {
                array[mainIndex] = secondPartition[secondPartitionIndex];

                mainIndex++;
                secondPartitionIndex++;
            }
        }

        while (firstPartitionIndex < firstArrayLength) {
            array[mainIndex] = firstPartition[firstPartitionIndex];

            mainIndex++;
            firstPartitionIndex++;
        }

        while (secondPartitionIndex < secondArrayLength) {
            array[mainIndex] = secondPartition[secondPartitionIndex];

            mainIndex++;
            secondPartitionIndex++;
        }

        return array;
    }
}
