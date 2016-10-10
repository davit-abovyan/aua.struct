
public class MyStack<T> {
   private int maxSize; // size of array
   private T[] stackArray; // array to hold elements in stack
   private int top; // the index of top element
   /**
    * Default constructor
    */
   @SuppressWarnings("unchecked")
   public MyStack() {
      maxSize = 1;
      stackArray = (T[]) new Object[maxSize];
      top = -1;
   }
   /**
    * Adds element to the top of stack
    * @param i the element to be added
    */
   public void push(T i) {
	  if(maxSize <= stackArray.length)
		   resize();
      stackArray[++top] = i;
   }
   /**
    * Remove the last added item
    * @return the removed item
    */
   public T pop() {
      return top > -1 ? stackArray[top--] : null;
   }
   /**
    * Get the last element in the Stack
    * @return the last element
    */
   public T getTop() {
      return stackArray[top];
   }
   /**
    * Check whether the stack is empty
    * @return true if it is empty
    */
   public boolean isEmpty() {
      return top == -1;
   }
   /**
    * Prints all the elements of the array
    */
   public void print(){
	   System.out.print("[ ");
	   for(int i=0;i<=top;i++){
		   System.out.print(stackArray[i]);
		   System.out.print(" ");
	   }
	   System.out.println("]");
   }
   /**
    * Helper function to double the size of array
    */
   @SuppressWarnings("unchecked")
   private void resize(){
	   maxSize*=2;
	   T[] temp = (T[]) new Object[maxSize];
	   for(int i=0; i<stackArray.length; i++)
		   temp[i]=stackArray[i];
	   stackArray = temp;
	   temp = null;
   }
}
