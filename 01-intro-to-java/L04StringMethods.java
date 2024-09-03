public class L04StringMethods {
    public static void main(String[] args) {
        String word = "The quick brown fox jumps over the lazy dog";

        System.out.println(word.toUpperCase());

        System.out.println(word.contains("fox"));

        System.out.println(word.substring(4,9));
    }
}
