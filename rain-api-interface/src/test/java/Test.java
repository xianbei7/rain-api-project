public class Test {
    public static void main(String[] args) {
        String s1 = "hello world";
        System.out.println(s1.hashCode());
        String s2 = "hello world hello world hello world";
        System.out.println(s2.hashCode());
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    }
}
