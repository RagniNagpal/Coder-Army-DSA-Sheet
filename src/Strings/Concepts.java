package Strings;

public class Concepts {
    public static void main(String[] args) {
        String s1="hello";   //literal
        String s2=new String("hello"); //constructor
        System.out.println(s1 + s2);

//        s1 stored in string pool, s2 in heap
//        Use .equals() to compare content, == checks reference

        int n=s1.length();
        System.out.println(n);
        System.out.println(s1.charAt(4));

        //String Immutability
//        Strings in Java are immutable
//        Any change creates a new string
//        For mutable operations, use StringBuilder / StringBuffer

//        StringBuilder sb = new StringBuilder("hello");
//        StringBuffer sbf = new StringBuffer("hello");

//        3.2 Comparison
//          .equals() → content equality
//          .equalsIgnoreCase() → ignore case
//          .compareTo() → lexicographical order

        System.out.println(s1.substring(1,3));
        System.out.println(s1.concat(s2));
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.indexOf(3));
        System.out.println("hello".indexOf("ll"));
        System.out.println("hello".lastIndexOf('l'));
        System.out.println("hello".lastIndexOf("l"));
        System.out.println("hello".toUpperCase());
        System.out.println(" hi ".trim());
        System.out.println("hh".replace("hh","kk"));
        System.out.println("abc123".replaceAll("\\d","x"));
        System.out.println("a,b,c".split(","));
        System.out.println("hello".contains("ll"));
        System.out.println("hello".startsWith("he"));
        System.out.println("hello".toCharArray());
        System.out.println("".isEmpty());
        System.out.println(String.valueOf(123));
        System.out.println(String.join("-", "a","b","c"));

        //StringBuilder / StringBuffer Methods (Mutable Strings)

        // 1️⃣ Create StringBuilder / StringBuffer
        StringBuilder sb = new StringBuilder("Hello");
        StringBuffer sbf = new StringBuffer("World");

        // 2️⃣ append() - add at end
        sb.append(" Java"); // "Hello Java"
        sbf.append(" Buffer"); // "World Buffer"
        System.out.println("append: " + sb);
        System.out.println("append: " + sbf);

        // 3️⃣ insert(index, String) - insert at index
        sb.insert(6, "Beautiful "); // "Hello Beautiful Java"
        System.out.println("insert: " + sb);

        // 4️⃣ delete(start, end) - remove substring (start to end-1)
        sb.delete(6, 16); // remove "Beautiful "
        System.out.println("delete: " + sb); // "Hello Java"

        // 5️⃣ deleteCharAt(index) - remove character at index
        sb.deleteCharAt(5); // remove space
        System.out.println("deleteCharAt: " + sb); // "HelloJava"

        // 6️⃣ replace(start, end, String) - replace substring
        sb.replace(5, 9, " World"); // "Hello World"
        System.out.println("replace: " + sb);

        // 7️⃣ reverse() - reverse string
        sb.reverse();
        System.out.println("reverse: " + sb); // "dlroW olleH"

        // 8️⃣ charAt(index) - get character
        char ch = sb.charAt(2);
        System.out.println("charAt: " + ch); // 'r'

        // 9️⃣ setCharAt(index, char) - modify character
        sb.setCharAt(0, 'D');
        System.out.println("setCharAt: " + sb); // "DlroW olleH"

        // 🔟 length() - length of StringBuilder/StringBuffer
        int len = sb.length();
        System.out.println("length: " + len);

        // 1️⃣1️⃣ capacity() - current capacity
        int cap = sb.capacity();
        System.out.println("capacity: " + cap);

        // 1️⃣2️⃣ ensureCapacity(minCapacity) - ensure minimum capacity
        sb.ensureCapacity(50);
        System.out.println("ensureCapacity: " + sb.capacity());

        // 1️⃣3️⃣ substring(start) - substring from start to end
        String sub1 = sb.substring(2);
        System.out.println("substring(start): " + sub1);

        // 1️⃣4️⃣ substring(start, end) - substring from start to end-1
        String sub2 = sb.substring(2, 7);
        System.out.println("substring(start,end): " + sub2);

        // 1️⃣5️⃣ toString() - convert to String
        String finalStr = sb.toString();
        System.out.println("toString: " + finalStr);
        System.out.println(String.join(" ", "Hello", "World"));
        System.out.println("Hi".repeat(3));
//        System.out.println("abc".chars().forEach(System.out::println));
    }
}
