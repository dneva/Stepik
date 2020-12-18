import java.lang.reflect.Array;
import java.util.Arrays;

public class CallerClassAndMethodName {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        m1();    }

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] res = new Throwable().getStackTrace();
        for (StackTraceElement i : res){
            System.out.println(i);
        }
        if(res.length>2) {
            String s = res[2].getClassName() + "#" + res[2].getMethodName();
            return s;
        }
        return null;

    }
}
