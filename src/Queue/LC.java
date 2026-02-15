//package Queue;
//
//public class LC {
//    class MyStack {
//        private Queue<Integer> q;
//
//        public MyStack() {
//            q=new LinkedList<>();
//        }
//
//        public void push(int x) {
//            q.add(x);
//            int n=q.size()-1;
//            for(int i=0;i<n;i++){
//                q.add(q.remove());
//            }
//        }
//
//        public int pop() {
//            return q.remove();
//        }
//
//        public int top() {
//            return q.peek();
//        }
//
//        public boolean empty() {
//            return q.isEmpty();
//        }
//    }
//
///**
// * Your MyStack object will be instantiated and called as such:
// * MyStack obj = new MyStack();
// * obj.push(x);
// * int param_2 = obj.pop();
// * int param_3 = obj.top();
// * boolean param_4 = obj.empty();
// */
//}

//232. Implement Queue using Stacks
//class MyQueue {
//    Stack<Integer> input;
//    Stack<Integer> output;
//
//    public MyQueue() {
//        input = new Stack<>();
//        output = new Stack<>();
//    }
//
//    public void push(int x) {
//        input.push(x);
//    }
//
//    public int pop() {
//        peek();
//        return output.pop();
//    }
//
//    public int peek() {
//        if (output.isEmpty()) {
//            while (!input.isEmpty()) {
//                output.push(input.pop());
//            }
//        }
//        return output.peek();
//    }
//
//    public boolean empty() {
//        return input.isEmpty() && output.isEmpty();
//    }
//}
//
///**
// * Your MyQueue object will be instantiated and called as such:
// * MyQueue obj = new MyQueue();
// * obj.push(x);
// * int param_2 = obj.pop();
// * int param_3 = obj.peek();
// * boolean param_4 = obj.empty();
// */


//rearrange queue
import java.util.*;

//public class RearrangeQueue {
//    public static void main(String[] args) {
//        Queue<Integer> q = new LinkedList<>();
//        q.add(10);
//        q.add(15);
//        q.add(20);
//        q.add(25);
//        q.add(30);
//
//        System.out.println("Original Queue: " + q);
//
//        Queue<Integer> odd = new LinkedList<>();
//        Queue<Integer> even = new LinkedList<>();
//
//        int n = q.size();
//        for (int i = 0; i < n; i++) {
//            int x = q.remove();
//            if (x % 2 == 0) even.add(x);
//            else odd.add(x);
//        }
//
//        // combine odd then even
//        while (!odd.isEmpty()) q.add(odd.remove());
//        while (!even.isEmpty()) q.add(even.remove());
//
//        System.out.println("Rearranged Queue: " + q);
//    }
//}



// first neg int
//static List<Integer> firstNegInt(int arr[],int k){
//    List<Integer> ans=new ArrayList<>();
//    int n=arr.length;
//    Queue<Integer> q=new LinkedList<>();
//    for(int i=0;i<n;i++){
//        if(arr[i]<0) q.add(i);
//    }
//    for(int i=0;i<n-k+1;i++){
//        while(q.size()>0 && q.peek()<i) q.remove();
//        if(q.size() && q.peek()<=i+k-1) ans.add(arr[q.peek()]);
//        else ans.add(0);
//    }
//    return ans;
//}