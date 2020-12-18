import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StringStreamTest {
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream,charset);
        int read=reader.read();
        StringBuilder sb = new StringBuilder();
        while(read>=0){
            sb.append((char) read);
            read=reader.read();
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        byte[] b = {48,49,50,51};
        try  (InputStream is = new ByteArrayInputStream(b)){
            System.out.println(readAsString(is, StandardCharsets.US_ASCII));
        }catch (IOException e)
        {

        }

    }
}
