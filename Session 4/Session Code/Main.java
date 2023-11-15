import java.io.*;
import java.util.*;

public class Main {

    static PrintWriter pw = new PrintWriter(System.out);
    static Scanner sc = new Scanner(System.in);

    public static boolean isSetOne(int x, int i){
        return (x&(1<<i)) != 0;
    }

    public static int setBit1(int x, int i){
        return x|(1<<i);
    }

    public static int setBit0(int x, int i){
        return x & (~(1<<i));
    }


    public static int flipBit(int x, int i){
        return x^(1<<i);
    }

    public static void main(String[] args) throws Exception {

        /******************************************** BITWISE OPERATIONS *****************************************/

        // x&0 = 0
        // x|0 = x
        // x^0 = x , x^x = 0

        // 101 << 2 -> 10100  shift left 2
        // 10100 >> 3 -> 10   shift right 3
        System.out.println(5<<2);
        System.out.println(20>>3);

        // 10110 & 00100    check set bit
        System.out.println(isSetOne(22,2));

        // 10110 | 01000    set bit to 1
        System.out.println(setBit1(22,3));

        // 10110 & ~(00100) = 10110 & 11011    set bit to 0
        System.out.println(setBit0(22,2));

        // 10110 ^ 00100    flip bit
        System.out.println(flipBit(22,2));

        /********************************************** BITMASKS *************************************************/



        // get number of sub arrays with sum = x
        int n = 6;
        int x = 7;
        int[] arr = new int[]{1, 3, 4, 5, 1, 2};
        int num = 0;
        for (int mask =0; mask<(1<<n); mask++){
            int sum = 0;
            for (int i = 0; i<n; i++){
                if (isSetOne(mask,i)) sum += arr[i];
            }
            if (sum == x) num++;
        }
        System.out.println(num);

        /*
         *  valid sub arrays :
         *       1 3 1 2
         *       1 4 2
         *       1 5 1
         *       3 4
         *       4 1 2
         *       5 2
         *
         *  ans = 6
         */

        /********************************************** ArrayList *************************************************/

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(4); // O(1);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(1);

        System.out.println("ArrayList : " + arrayList);

        arrayList.add(2, 3); // O(n)
        System.out.println("ArrayList : " + arrayList);

        Collections.sort(arrayList); // O(nlog(n))
        System.out.println("ArrayList : " + arrayList);


        System.out.println(arrayList.get(1)); //O(1);

        arrayList.set(0, 8); // O(1);
        System.out.println("ArrayList : " + arrayList);

        System.out.println(arrayList.size()); //O(1);

        arrayList.remove(2); //O(n)
        System.out.println("ArrayList : " + arrayList);

        arrayList.remove((Integer) 8); //O(n)
        System.out.println("ArrayList : " + arrayList);

        System.out.println(arrayList.indexOf(4)); //O(n)

        /********************************************** LinkedList *************************************************/

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1); //O(1)
        linkedList.add(2);

        linkedList.addLast(3); //O(1)

        linkedList.addFirst(4); //O(1)

        linkedList.add(5);
        linkedList.add(6);
        linkedList.addLast(7);
        linkedList.addFirst(8);

        System.out.println("First Element : " + linkedList.getFirst()); // O(1)
        System.out.println("Last Element : " + linkedList.getLast()); // O(1)

        System.out.println(linkedList.size()); // O(1)

        System.out.println(linkedList.indexOf(2)); // O(n)

        linkedList.remove((Integer)3); // O(n)
        System.out.println(linkedList);

        linkedList.remove(1); // O(n)
        System.out.println(linkedList);

        linkedList.removeFirst(); // O(n)
        System.out.println(linkedList);

        linkedList.removeLast(); // O(n)
        System.out.println(linkedList);

        Queue<Integer> queue =new LinkedList<>(); //FIFO data structure first in first out!

        // To add an element in a queue we use .add(x)   O(1)
        //      |<-- beginning of our queue
        queue.add(1); // --> [1]
        //      |<-- beginning of our queue
        queue.add(2); // --> [1,2]
        //      |<-- beginning of our queue
        queue.add(3); // --> [1,2,3]
        //      |<-- beginning of our queue
        queue.add(7); // --> [1,2,3,7]

        // to get the size of the queue we use .size()  O(1)
        System.out.println("The size of the queue: "+queue.size()); // this will print 4

        //To check if the queue is empty or not we use .isEmpty() O(1)
        System.out.println(queue.isEmpty()); // this will print false as we added elements in the queue

        //To remove the element at the front of the queue we use .poll() or .remove()  O(1)
        queue.remove(); // --> [2,3,7]
        queue.poll(); // --> [3,7]

        // To see the value of the front element without removing it we use .peek() O(1)
        System.out.println("The element at the front of the queue now is: "+queue.peek()); // this will print 3

        // To remove an element from the queue we use .remove(x)   O(N)
        queue.remove(3); // --> [7]

        //To iterate over the queue:
        while(!queue.isEmpty()) {
            System.out.print(queue.poll()+" ");
        }

        //______________________________________________________ Stack _________________________________________________________________

        // Initializing a Stack
        Stack<Integer>stack= new Stack<>(); //LIFO data structure last in first out!
//
//
        stack.push(1); // --> [1]
        stack.add(2); // --> [1,2]
        stack.push(3); // --> [1,2,3]
        stack.push(7); // --> [1,2,3,7]
        stack.push(10); // -->[1,2,3,7,10]
        System.out.println("The size of the stack: "+stack.size());

        System.out.println(stack.isEmpty()); // this will print false as we added elements in the stack

        //To remove the element at the top of the stack we use .pop() O(1)
        stack.pop(); // --> [1,2,3,     ]

        // To see the value of the front element without removing it we use .peek() O(1)
        System.out.println("The element at the top of the stack now is: "+stack.peek()); // this will print 7

        // To remove an element at a certain in index from the stack we use .remove(i)  O(N)
        stack.remove(1); // -->[1,3,7]

        //To iterate over the stack:
        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }


    }






    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException {
            return br.ready();
        }

        long[] readArray(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        int[] nextIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

    }

}
