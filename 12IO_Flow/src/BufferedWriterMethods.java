import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterMethods {
    public static void main(String[] args) throws IOException {
        String path="12IO_Flow/test.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path,true));
        bufferedWriter.newLine();
        bufferedWriter.write("你好");
        bufferedWriter.newLine();
        bufferedWriter.write("may");
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}
