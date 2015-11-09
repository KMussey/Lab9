import java.util.*;

public class Lab09 {

   static int numSwapS = 0; //setting global swap variables
   static int numSwapB = 0;
   
    public static void printArray(int[] arr) {
	System.out.print("[ ");
	for (int j=0; j < (arr.length - 1); j++) {
	    System.out.print(arr[j] + ", ");
	}
	if (arr.length > 0) {
	    System.out.print(arr[arr.length - 1]);
	}
	System.out.println(" ]");
	    
    }

    public static void swap(int[] arr, int index1, int index2) {
	if (index1 == index2) {
	    // Do nothing!
	} else {
	    int tmp = arr[index1];
	    arr[index1] = arr[index2];
	    arr[index2] = tmp;
       numSwapS++; //count swap
	}
    }

    public static void selectionSort(int[] arr) { 
	
	if (arr.length < 2) {
	    return;
	}
	
	int minIndex = 0;
	int minVal = 0;

	for (int j = 0; j < (arr.length); j++) {
	    minIndex = j;
	    minVal = arr[j];
	    for(int k = j + 1; k < arr.length; k++) {

		if (arr[k] < minVal) {

		    minVal = arr[k];
		    minIndex = k;
		}
	    }
	    swap(arr, j, minIndex);
      
	}

    }
   public static void bubbleSort(int[] arr){
      for(int i = 0; i < arr.length - 1; i++){
         
         if(arr[i] > arr[i + 1]){ //swap
            int tmp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = tmp;
            numSwapB++; //count swap
         }
      }
      for(int i = 0; i < arr.length - 1; i++){         
         if(arr[i] > arr[i + 1]){
            bubbleSort(arr); //check if sorted
         }
         
      }
   }      

    public static void main(String[] args) {
	int[][] a1 = { {8, 9, 5, 6, 4, 3},
		       {9, 0, 14, 13, 10, 8, 2, 1, 17, 18, 19, 201, 220, 235, 2},
		       {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200 },
		       {22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 1},
		       {20, 18, 13, 12, 11, 9, 6, 5, 4, 3, 2, 1, -87, -900, -9, -909, -911, -80, -44, -32, -1000} };
	
      int[][] a2 = copy(a1);
         for( int i = 0; i < a1.length; i++){ //only pass 1D 
            selectionSort(a2[i]);
            printArray(a2[i]);
            System.out.println("Selection Sort Swaps: " + numSwapS);
            numSwapS = 0;
                    
            bubbleSort(a1[i]);
            printArray(a1[i]);
            System.out.println("Bubble Sort Swaps: " + numSwapB);
            numSwapB = 0;
         }
         
              
    }
    
    public static int[][] copy(int[][] a1)//deep copy method
   {
  
      int[][] a2 = new int[a1.length][];
      for(int count = 0; count < a1.length; count++)
      {
        
         a2[count] = new int[a1[count].length];// account for jagged array
         for(int index = 0; index < a1[count].length; index++)
         {
            
            a2[count][index] = a1[count][index];
         }
      }
      return a2;
   }
}