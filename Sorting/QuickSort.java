import java.util.*;

class QuickSort{
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
        int pi = partition(arr, lo,hi);
        quickSort(arr, lo, pi-1);
        quickSort(arr, pi+1, hi);
    }

    static int partition(int []arr, int lo, int hi){
        random(arr,lo,hi);
        int pivotIndex = lo;
        int pivot = arr[pivotIndex];
        int or = lo; int gr = lo+1;
        while(gr<=hi){
            if(arr[gr]<pivot){
                or++;
                if(or!=gr)swap(arr,or,gr);
            }
            gr++;
        }
        swap(arr, or, pivotIndex);
        return or;
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