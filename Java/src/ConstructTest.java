import java.math.BigInteger;
import java.util.Arrays;

public class ConstructTest {
    public static BigInteger factorial(int value) {
        BigInteger f = new BigInteger("1");
        for (int i = 2; i <= value; i++) {
            f=f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] mergea=new int[a1.length+a2.length];
        int len = Math.min(a1.length, a2.length);
        int i = 0;
        int j = 0;
        int k = 0;
        if (a1.length==0) return a2;
        if (a2.length==0) return a1;
        while (i<mergea.length) {
            while (j<a1.length && k<a2.length){
                if (a1[j]<a2[k]){
                    mergea[i]=a1[j];
                    j+=1;
                } else {
                    mergea[i]=a2[k];
                    k+=1;
                }
                i+=1;
            }
            while (j<a1.length)
            {
                mergea[i]=a1[j];
                i+=1;
                j+=1;
            }
            while (k<a2.length)
            {
                mergea[i]=a2[k];
                i+=1;
                k+=1;
            }
        }
        return mergea;
    }
    public static void main(String[] args) {
        System.out.println(factorial(2));
        int[] a1={0,2,2};
        int[] a2={1,3,4,7,8};
        System.out.println(Arrays.toString(mergeArrays(a1,a2)));
    }
}
