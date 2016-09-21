import java.util.*;

/**
 * Class for different type of sorting for an array of integers
 * @author Davit Abovyan
 * @version 1.0
 */
public class Sorter {
	/**
	 * Method for Selection sort
	 * @param arr the array of integers to be sorted
	 * @param order a flag for ordering in ascending (true) or descending (false) order
	 */
	public void selectionSort(int[] arr, boolean order){
		int size = arr.length;
		int activeIndex;
		for(int last=size-1;last>0;last--){
			// Select the largest item in Array[0..last]
			activeIndex = findIndex(arr, last, order);
			swap(arr, activeIndex, last);
			print_array(arr);
		} // end for
	} 
	
	/**
	 * Method for Bubble sort
	 * @param arr the array of integers to be sorted
	 * @param order a flag for ordering in ascending (true) or descending (false) order
	 */
	public void bubbleSort(int[] arr, boolean order){
		boolean sorted=false; // False when swaps occur
		int pass = 1;
		int nextIndex;
		while(!sorted && pass<arr.length){
			sorted = true;
			if(order){
				for(int index = 0; index < arr.length-pass; index++){
					nextIndex = index + 1;
					if(arr[index] > arr[nextIndex]){
						swap(arr, index, nextIndex);
						sorted = false; // Signal exchange
					} //end if
				} // end for
			} else {
				for(int index = 0; index < arr.length-pass; index++){
					nextIndex = index + 1;
					if(arr[index] < arr[nextIndex]){
						swap(arr, index, nextIndex);
						sorted = false; // Signal exchange
					} //end if
				} // end for				
			} // end if
		} // end while
		pass++;
	} 	
	/**
	 * Method for Insertion sort
	 * @param arr the array of integers to be sorted
	 * @param order a flag for ordering in ascending (true) or descending (false) order
	 */
	public void insertionSort(int[] arr, boolean order){
		int nextItem, loc; 
		for(int i=1; i<arr.length; i++){ // i = first index of the unsorted region,
		    // Find the right position for the nextItem in Array[0..i]
		    // At the same time shifting to make a room
			nextItem = arr[i];
			loc = i;
			if(order){
				while(loc>0 && arr[loc-1]>nextItem){
					arr[loc] = arr[loc-1]; // Shift Array[loc - 1] to the right
					loc--;				
				} // end while
			}else{
				while(loc>0 && arr[loc-1]<nextItem){
					arr[loc] = arr[loc-1]; // Shift Array[loc - 1] to the right
					loc--;				
				} // end while
			} // end if
			arr[loc] = nextItem;  // Insert nextItem into sorted region
//			print_array(arr);
		} // end for
	} 
	/**
	 * Method for Mergen sort
	 * @param arr the array of integers to be sorted
	 * @param order a flag for ordering in ascending (true) or descending (false) order
	 */
	public void mergeSort(int[] arr, boolean order){
		int n = arr.length;
		if(n!=1){ 
			int[] arr1 = Arrays.copyOfRange(arr, 0, n/2);
			int[] arr2 = Arrays.copyOfRange(arr, n/2, n);
			mergeSort(arr1, order);
			mergeSort(arr2, order);
			return merge(arr1, arr2, order);
		} // end if
	} 		
	/**
	 * Method to display array elements
	 * @param arr the array of integers to display
	 */
	public void print_array(int[] arr){
		System.out.print("[ ");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);			
			System.out.print(" ");	
		} // end for
		System.out.println("]");
	}
	/**
	 * Helper Method to for MergeSort method
	 */	
	private int[] merge(int[] arr1, int[] arr2, boolean order){
		ArrayList<Integer> arrL1 = new ArrayList<>(Arrays.asList(arr1)));
		
	}
	/**
	 * Helper Method to fine the index of the largest element in the array
	 * @param arr the array to be looked in
	 * @param last the index of the element up to which the search should be performed
	 * @param order the order of sorting: ascending (true) or descending (false)
	 * @return the index of the largest element in the given range of array 
	 */	
	private int findIndex(int arr[], int last, boolean order){
		int index = last;
		if(order){
			for(int i=0;i<last;i++)
				if(arr[i]>arr[index])
					index = i;
		}else{
			for(int i=0;i<last;i++)
				if(arr[i]<arr[index])
					index = i;			
		} //end if
		return index;
	}
	/**
	 * Helper Method to swap elements in the array
	 */	
	private void swap(int[] arr, int index, int last){
		int temp = arr[last];
		arr[last] = arr[index];
		arr[index] = temp;
	}	
}
