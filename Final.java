import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Final {

	public static void main(String[] args) {
		Stack s = new Stack<Integer>();
		s.push(1);
		s.push(-2);
		s.push(3);
		s.push(-4);
		s.push(5);
		s.push(-6);
		s.push(7);
		System.out.println("Initial Stack");
		System.out.println(s);
		System.out.println("Copy of Initial Stack");
		System.out.println(copyStack(s));
	}
	
	public static Stack<Integer> copyStack(Stack<Integer> s) {
		Queue<Integer> q = new LinkedList<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		while (!s.isEmpty()) {
			s2.push(s.pop());
		}
		while (!s2.isEmpty()) {
			q.add(s2.pop());
		}
		while (!q.isEmpty()) {
			s.push(q.peek());
			s2.push(q.remove());
		}
		return s2;
	}
}
