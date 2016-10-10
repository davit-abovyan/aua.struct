
public class TestStack_Queue {

	   public static void main(String[] args) {
		      MyStack test = new MyStack(); 
		      test.push(1);
		      test.push(2);
		      test.push(3);
		      test.print();
		      test.pop();
		      test.print();
		      
		      MyQueue<Integer> testQueue = new MyQueue<>(); 

		      testQueue.enqueue(1);
		      testQueue.enqueue(2);
		      testQueue.enqueue(3);
		      testQueue.enqueue(4);

		      testQueue.print();
		      
		      testQueue.dequeue(); 
		      testQueue.dequeue(); 
		      testQueue.print();

		      testQueue.enqueue(5);
		      testQueue.enqueue(6);
		      testQueue.print();
	   }

}
