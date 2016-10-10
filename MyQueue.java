
public class MyQueue<T> {
	
	   private static class Node<T> {
	        public T data; // the data hold in the node
	        public Node<T> next; // reference to the next node
	    }

	    private Node<T> first = null;
	    private Node<T> last = null;

	    public boolean isEmpty() {
	        return first == null;
	    }

	    public void enqueue(T data) {
	        Node<T> n = new Node<T>();
	        n.data = data;
	        if (isEmpty()) {
	            n.next = null;
	            first = n;
	            last = n;
	        } else {
	            last.next = n;
	            last = n;
	            last.next = null;
	        }
	    }

	    public Node<T> dequeue() {
	            Node<T> temp = first;
	            if (first.next == null)
	                last = null;
	            first = first.next;
	            return temp;
	        }
	    
	    public Node<T> getFront(){
	    	return first;
	    }

	    public void print() {
	        Node<T> current = first;
	        while (current != null) {
	            System.out.print(current.data);
	            System.out.print(" ");
	            current = current.next;
	        }
	        System.out.println();
	    }	
}
