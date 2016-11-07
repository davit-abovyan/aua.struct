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
			print_array(arr);
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
					arr[loc] = arr[loc-1]; // Shift to right
					loc--;				
				} // end while
			} // end if
			arr[loc] = nextItem;  // Insert nextItem into sorted region
			print_array(arr);
		} // end for
	}
	
	/**
	 * Method for Merge sort
	 * @param arr the array of integers to be sorted
	 * @param order a flag for ordering in ascending (true) or descending (false) order
	 */
	public int[] mergeSort(int[] arr, boolean order){
		int n = arr.length;
		if(n!=1){
			// divides array into two parts
			int[] arr1 = Arrays.copyOfRange(arr, 0, n/2);
			int[] arr2 = Arrays.copyOfRange(arr, n/2, n);
			// go on dividing untill each element has only one element
			arr1 = mergeSort(arr1, order);
			arr2 = mergeSort(arr2, order);
			// merge the two sorted parts together
			return merge(arr1, arr2, order);
		} else {
			return arr;
		}// end if
	} 
	
	public void quickSort(int[] arr, int left, int right){
	
		if(left>right){
			return;
		} else {
			int pivot = arr[right];
			int part = partition(arr, left, right, pivot);
			quickSort(arr, left, part-1);
			quickSort(arr, part+1, right);
		}
	}
	
	public int partition(int[] arr, int left, int right, int pivot){
		int leftIndex = left-1;
		int rightIndex=right;
		
		while(true){
			while(arr[++leftIndex]<pivot){
				System.out.print("left");
				System.out.println(arr[leftIndex]);
			}
			while(rightIndex>0 && arr[--rightIndex]>pivot){
				System.out.print("right");
				System.out.println(arr[rightIndex]);
			}
			
			if(rightIndex>=leftIndex){
				break;
			} else {
				swap(arr,leftIndex,rightIndex);
			}
		}
		swap(arr,leftIndex,right);
		return leftIndex;
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
	 * Helper Method for MergeSort method
	 * @param arr1 the first array of integers to be merged
	 * @param arr2 the second array of integers to be merged
	 * @param order a flag for ordering in ascending (true) or descending (false) order	 
	 * @return the merged array 
	 */	
	public int[] merge(int[] arr1, int[] arr2, boolean order){
		int[] temp = new int[arr1.length+arr2.length]; // temporary array for holding sorted elements
		int currentPosition = 0;
		if(order){
			while(arr1.length>0 && arr2.length>0){
				if(arr1[0]<arr2[0]){
					temp[currentPosition] = arr1[0];
					arr1 = shift(arr1);
				} else {
					temp[currentPosition] = arr2[0];
					arr2 = shift(arr2);
				} // end if
				currentPosition++;
			} // end while
		} else {
			while(arr1.length>0 && arr2.length>0){
				if(arr1[0]>arr2[0]){
					temp[currentPosition] = arr1[0];
					arr1 = shift(arr1);
				} else {
					temp[currentPosition] = arr2[0];
					arr2 = shift(arr2);
				} // end if
				currentPosition++;
			} // end while			
		} // end if
		while(arr1.length > 0){
			temp[currentPosition] = arr1[0];
			arr1 = shift(arr1);
			currentPosition++;
		} // end while
		while(arr2.length > 0){
			temp[currentPosition] = arr2[0];
			arr2 = shift(arr2);
			currentPosition++;
		} // end while	
		return temp;
	} // end merge
	
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
	
	/**
	 * Helper Method to remove first element from array
	 * @param arr the array whose first element is being removed 
	 * @return the removed element 
	 */	
	private int[] shift(int[] arr){
		int[] temp = new int[arr.length-1];
		for(int i=0;i<arr.length-1;i++)
			temp[i]=arr[i+1];
		return temp;
	} // end shift
}
