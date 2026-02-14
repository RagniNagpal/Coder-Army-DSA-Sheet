package Queue;
import java.util.*;

//FIFO AUR LILO
// stacks              queue
//  push               add 0(1)
//  pop                 remove 0(1),poll
//  peek                peek 0(1)
//  peek                size

//back side se in front out , peek starting element
// add hota hai rear mei , peek remove hota hai front mei

//Traversing in queue eq [10,20,30] op 10 20 30
//agar ham while(q.size() >0 nhi karenge to print nhi ho payega aur hamara traverse hota rahega
        public class Basic {
    public static void main(String[] args) {
//        Queue<Integer> q=new LinkedList<>();
//        q.add(10);
//        q.add(20);
//        q.add(30);
//        System.out.println(q.peek());
//        System.out.println(q.remove());
//        System.out.println(q.size());
//        System.out.println(q);
//        System.out.println(q.poll());

//        while(!q.isEmpty()){
//            System.out.println(q.peek());
//            q.remove();  // q mei add kardo q se nikla hua element
//        }

//        int n = q.size();
//        while(n-- > 0){
//            System.out.println(q.peek());
//            q.add(q.remove());
//        }

//        int n=q.size();
//        for(int i=1;i<=n;i++){
//            System.out.println(q.peek());
//            q.add(q.remove());
//        }

        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        System.out.println("Original Queue:");
        display(q);

        System.out.println("\nAdd 60 at index 2:");
        addAtIndex(2, 60, q);
        display(q);

        System.out.println("\nRemoved element at index 3:");
        int removed = removeAtIndex(3, q);
        System.out.println("Removed = " + removed);

        System.out.println("\nFinal Queue:");
        display(q);


    }
    public static void addAtIndex(int idx,int val,Queue<Integer> q){
        int n=q.size();
        //index validation
        if(idx < 0 || idx > n){
            System.out.println("Invalid index");
            return;
        }
        //rotate till index
        for(int i=0;i<idx;i++){
            q.add(q.remove());
        }
        // add value
        q.add(val);
        //restore order
        for(int i=1;i<=n-idx;i++){
            q.add(q.remove());
        }
    }
    public static int peek(int idx,Queue<Integer> q){
        int n=q.size();
        if(idx<0 || idx>=n) return -1;
        int ans=-1;
        for(int i=0;i<n;i++){
            int x=q.remove();
            if(i==idx) ans=x;
            q.add(x);
        }
        return ans;
    }
    public static int removeAtIndex(int idx, Queue<Integer> q) {
        int n = q.size();
        if (idx < 0 || idx >= n) return -1;

        int ans = -1;

        for (int i = 0; i < n; i++) {
            int x = q.remove();

            if (i == idx) {
                ans = x;          // removed element
            } else {
                q.add(x);         // baaki elements wapas
            }
        }
        return ans;
    }

    private static void display(Queue<Integer> q){
        int n=q.size();
        for(int i=1;i<=n;i++){
            System.out.println(q.peek());
            q.add(q.remove());
        }
    }
        }



//        | Operation       | TC   | SC   |
//        | --------------- | ---- | ---- |
//        | Add at index    | O(n) | O(1) |
//        | Remove at index | O(n) | O(1) |
//        | Peek at index   | O(n) | O(1) |
//        | Display         | O(n) | O(1) |
