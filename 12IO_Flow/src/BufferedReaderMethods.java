import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderMethods {
    public static void main(String[] args) {
        String filepath = "12IO_Flow/test.txt";
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filepath));
            String line = null;
            //readline,一次读一行，返回字符串，读结束返回Null
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭外层，即关闭BufferReader即可
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
