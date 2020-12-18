import java.lang.reflect.Array;
import java.util.Arrays;

public class CharSequenceTest {
    public static class AsciiCharSequence implements CharSequence {
        private int len=0;
        private byte[] bytes;
        public AsciiCharSequence(byte[] bytes) {
            this.bytes=new byte[bytes.length];
            this.bytes=Arrays.copyOf(bytes,bytes.length);
            len=bytes.length;

        }
        public int length(){
            return len;
        }

        @Override
        public char charAt(int i) {
            return (char) (bytes[i]);
        }
        public CharSequence subSequence(int start, int end) {
            byte[] result=Arrays.copyOfRange(bytes,start,end);
            return new AsciiCharSequence(result);
        }
        public String toString(){
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < len; i++) {
                result.append((char)(bytes[i]));
            }
            return result.toString();
        }
    }

    public static void main(String[] args) {
        byte[] b = new byte[] {65,66,67,68};
        AsciiCharSequence a = new AsciiCharSequence(b);
        System.out.println(a.length());
        System.out.println(a.charAt(2));
        System.out.println(a.subSequence(1,3));
        System.out.println(a.toString());
    }
}

