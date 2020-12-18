import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        double sum=0.000000, read;

        Scanner scanner=new Scanner(System.in).useLocale(Locale.ENGLISH);
        while (scanner.hasNext()){
            try {
                read=scanner.nextDouble();
                sum+=read;
            }catch (InputMismatchException e){
                scanner.next();
            }
            System.out.printf("%.6f",sum);
        }
        System.out.printf("%.6f",sum);
        /**
        int read=System.in.read();
        int buf=0;
        while (read>=0){
            if (read!=66 && buf==65){
                System.out.write(65);
            }
            buf=read;
            if(read==65){
                read=System.in.read();
                continue;
            }
            System.out.write(read);
            read=System.in.read();
        }
        //if(buf==65) System.out.write(65);
        //System.out.flush();**/
    }
}