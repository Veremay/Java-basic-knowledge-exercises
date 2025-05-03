import java.io.*;

public class BufferedCopy {
    public static void main(String[] args) {
        String srcFilePath = "12IO_Flow/test.txt";
        String destFilePath = "12IO_Flow/test_copy.txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;

        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));
            //说明:readLine 读取一行内容，但是不读取换行
            while ((line = br.readLine()) != null) {
                //每读取一行，就写入
                bw.write(line);
                //插入一个换行
                bw.newLine();
                System.out.println("拷贝完毕...");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

