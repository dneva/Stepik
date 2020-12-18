public class stringtest {
    public static boolean isPalindrome(String text) {
        text = text.replaceAll("[^A-Za-z0-9]","");
        System.out.println(text);
        String rtext= new StringBuilder(text).reverse().toString();
        return text.equalsIgnoreCase(rtext);
    }
    public static void main(String[] args) {
        System.out.println('A' + '1' + "2");
        System.out.println("A" + ('\t' + '\u0003'));
        System.out.println("A" + 12);
        System.out.println('A' + "12");

        int[] t = new int[0];
        System.out.println(isPalindrome("Madam, I'm Adam!"));

        }
}
