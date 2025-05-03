import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {
        String filePath = "12IO_Flow/test.txt";
        FileReader fileReader = null;
        int data = 0;

        //1.创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            //循环读取
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
