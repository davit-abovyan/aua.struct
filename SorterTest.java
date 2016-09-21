
public class SorterTest {

	public static void main(String[] args) {
		Sorter testInstance = new Sorter();
		int[] a = {25,12,16,45,15};
//		testInstance.selectionSort(a,false);
//		testInstance.bubbleSort(a,true);
//		testInstance.insertionSort(a,false);
		testInstance.mergeSort(a,false);
		testInstance.print_array(a);
	}

}
