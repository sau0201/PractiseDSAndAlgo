import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 9, 6, 15, 1, 8 };
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Printing Merge sort recurively");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void mergeSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) return;

        int mid = (endIndex + startIndex) / 2;
        mergeSort(arr, startIndex, mid);
        mergeSort(arr, mid + 1, endIndex);
        merge(arr, startIndex, mid, endIndex);
    }

    static void merge(int[] arr, int startIndex,int mid, int endIndex) {
        int n1 = mid - startIndex+1;
        int n2 = endIndex-mid;

        int [] newArray = new int [n1+n2];
        int i= startIndex;
        int j= mid+1;
        int index =0;

        while (i<= mid &&  j <= endIndex) {
            if (arr[i] <= arr[j]) newArray[index++] = arr[i++];
            else newArray[index++] = arr[j++];
        }

        while (i <=mid) {
            newArray[index++] = arr[i++];
        }
        while (j <= endIndex) {
            newArray[index++] = arr[j++];
        }

        index =0;
        int lo = startIndex;
        int hi = endIndex;
        while(lo<=hi){
            arr[lo++] =  newArray[index++];
        }
    }
}