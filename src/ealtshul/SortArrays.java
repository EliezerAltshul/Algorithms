package ealtshul;

import java.util.Random; 

public class SortArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create an array of random unsorted integers
        Random rand = new Random(); 
		int[] arr = new int[10];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = rand.nextInt(100);
		}
		
		//display original unsorted array
		System.out.println("Original Array: ");
		for(int i : arr) System.out.print(i + ", ");
		
		int[] sorted;
		/*The selection sort algorithm sorts an array by repeatedly 
		 * finding the minimum element (considering ascending order) 
		 * from unsorted part and putting it at the beginning. The 
		 * algorithm maintains two subarrays in a given array.*/
		sorted = selectionSort(arr);
		
		
		//display sorted array;
		sorted = insertionSort(arr);
		
	}
	public static int[] selectionSort(int[] arr) {
		System.out.println("\nSelection Sort: ");
		for(int i = 0; i<arr.length; i++) {
			int minIndex = i;
			for(int j = 0; j<arr.length-i; j++) {
				if(arr[j+i] < arr[minIndex]) {
					minIndex = j+i;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
			System.out.print(arr[i] + ", ");
		}
		return arr;
	}
	/**Insertion sort is a simple sorting algorithm that 
	 * builds the final sorted array one item at a time.
	**/
	public static int[] insertionSort(int[] arr) {
		System.out.println("\nInsertion Sort: ");
		int key = 0;
		int i = 0;
	 	for(int j=1; j<arr.length; j++) {
			key = arr[j];
			i = j-1;
			while(i>=0 && arr[i]>key) {
				arr[i+1] = arr[i];
				i--;
			}
			arr[i+1] = key;
			System.out.print(arr[j-1] + ", ");
		}
	 	System.out.print(arr[arr.length-1] + ", ");
		return arr;
	}
	
	
}
