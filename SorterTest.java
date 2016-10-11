
import java.util.*;

public class SorterTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("[1: Selection sort]");
		System.out.println("[2: Bubble sort]");
		System.out.println("[3: Insertion sort]");
		System.out.println("[4: Merge sort]");
        System.out.print("Choose sorting type: ");
        
        int type = input.nextInt();

		System.out.println("[true: Ascending]");
		System.out.println("[false: Descending]");
        System.out.print("Choose sorting Direction: ");
        
        boolean direction =  input.nextBoolean();
		int[] arr = new int[8];
        
		System.out.print("Array to be sorted: ");
		for(int i=0;i<arr.length;i++){
			arr[i]=(int) (Math.random()*100);
			System.out.print(arr[i]);
			System.out.print(" ");
		}
		System.out.println();
		
		Sorter testInstance = new Sorter();
		switch(type){
		case 1:
			testInstance.selectionSort(arr,direction);
			break;
		case 2:
			testInstance.bubbleSort(arr,direction);
			break;
		case 3:
			testInstance.insertionSort(arr,direction);
			break;
		case 4:
			arr = testInstance.mergeSort(arr,direction);
			testInstance.print_array(arr);
		}


		
//		
//		

	}

}
