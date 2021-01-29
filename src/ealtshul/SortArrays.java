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
		
		//display sorted array;
		int[] sorted = insertionSort(arr);
		System.out.println("\nSorted Array: ");
		for(int i : sorted) System.out.print(i + ", ");
	}
	
	/**Insertion sort is a simple sorting algorithm that 
	 * builds the final sorted array one item at a time.
	**/
	public static int[] insertionSort(int[] arr) {
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
		}
		return arr;
	}
	
	
}
