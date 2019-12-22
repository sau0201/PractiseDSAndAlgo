import java.util.*;

class QuickSortThreeWay {
    
    public static void main(String[] args) {
        int arr[] = { 11, 11, 13, 9, 6, 15, 1, 11 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Printing Quick sort recurively");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void quickSort(int []arr, int lo, int hi){
        if(lo>=hi)return;
        random(arr,lo,hi);
        int pivotIndex = lo;
        int pivot = arr[pivotIndex];

        int lt = lo; int gt=hi;int i=lo+1;

        while(i<=gt){
            while(i<=gt && arr[i]<pivot){
                swap(arr, i, lt);
                i++;lt++;
            }
            while(i<= gt&& arr[i]>pivot){
                swap(arr,i,gt);
                gt--;
            }
            while(i<= gt && arr[i]==pivot){
                i++;
            }
        }
        
        quickSort(arr, lo, lt-1);
        quickSort(arr, gt+1, hi);
    }

    static void random(int []arr,int low,int high) { 
	
		Random rand= new Random(); 
		int pivot = rand.nextInt(high-low) + low; 
		
		int temp1=arr[pivot]; 
		arr[pivot]=arr[low]; 
		arr[low]=temp1; 
	} 

    static void swap(int []arr, int firstIndex, int secondIndex){
        if(firstIndex!=secondIndex){
            int temp = arr[secondIndex];
            arr[secondIndex] = arr[firstIndex];
            arr[firstIndex] = temp;
        }
    }
}
