import java.util.*;
import java.util.stream.Collectors;

class HeapSort{
    public static void main(String[] args) {
        int arr[] = { 11, 11, 13, 9, 6, 15, 1, 11 };
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        System.out.println("Sorting in ascending order");
        for(int i=0;i<arr.length;i++){
            System.out.println(pQueue.poll());
        }
        
        PriorityQueue<Integer> pQueue2 = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            pQueue2.add(arr[i]);
        }
        System.out.println("Sorting in descending order");
        for(int i=0;i<arr.length;i++){
            System.out.println(pQueue2.poll());
        }
    }

    
}