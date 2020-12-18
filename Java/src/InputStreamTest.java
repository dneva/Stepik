import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int check = 0;
        int read = inputStream.read();
        while (read>=0){
            check = Integer.rotateLeft(check,1) ^ read;
            read = inputStream.read();
        }
        return check;
    }

    public static void main(String[] args) {
        byte[] b = {0x33, 0x45, 0x01};
        try  (InputStream is = new ByteArrayInputStream(b)){
            System.out.println(checkSumOfStream(is));
        }catch (IOException e)
        {

        }

    }
}
