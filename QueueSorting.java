package wiprotraining;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class QueueSorting {
 public static void sortQueueWithStack(Queue<Integer> queue) {
 Stack<Integer> stack = new Stack<>();
 int n = queue.size();
 for (int i = 0; i < n; i++) {
 int min = Integer.MAX_VALUE;
 int minCount = 0;
 int currentSize = queue.size();
 for (int j = 0; j < currentSize; j++) {
 int element = queue.poll();
 if (element < min) {
 min = element;
 minCount = 1;
 } else if (element == min) {
 minCount++;
 }
 stack.push(element);
 }
 while (!stack.isEmpty()) {
int element = stack.pop();
 if (element != min) {
 queue.add(element);
 } else {
 minCount--;
 if (minCount > 0) {
 queue.add(element);
 }}
 }
 queue.add(min);
 }
 }
 public static void main(String[] args) {
 Queue<Integer> queue = new LinkedList<>();
 queue.add(5);
 queue.add(8);
 queue.add(12);
 queue.add(16);
 queue.add(21);
 queue.add(25);
 queue.add(24);
 System.out.println("Original Queue: " + queue);
 sortQueueWithStack(queue);
  System.out.println("Sorted Queue: " + queue);
}
}
