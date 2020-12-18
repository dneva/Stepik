public class test1 {
    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        return ((a^c)&(b^d))|((a^b)&(c^d));
    }
    public static int leapYearCount(int year) {
        return year;
    }
    public static int flipBit(int value, int bitIndex) {
        int bit = 1;;
        bit<<=bitIndex-1;
        return value^bit;
    }
    public static void main(String[] args) {
        System.out.println(flipBit(13,1));
        int bit = 2;
        int a =3;
        System.out.println(Integer.toBinaryString(a>>1));
        System.out.println(Integer.toBinaryString(bit));
        System.out.println(Integer.toBinaryString(Integer.reverse(bit)));
        System.out.println(Integer.toBinaryString(Integer.reverse(Integer.reverse(bit))));
        System.out.println(Integer.toBinaryString(-1));
    }

}
