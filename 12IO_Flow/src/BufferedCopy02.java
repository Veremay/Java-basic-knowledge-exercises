import java.io.*;

public class BufferedCopy02 {
    public static void main(String[] args) throws IOException {
        String srcpath = "12IO_Flow/screenshot.png";
        String despath = "12IO_Flow/screenshot_copy.png";
        //利用字节数组进行存储
        byte[] data = new byte[1024];
        int len = 0;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(srcpath));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(despath));

        while ((len = bufferedInputStream.read(data)) != -1) {
            bufferedOutputStream.write(data, 0, len);
        }

        System.out.println("文件拷贝完毕！");

        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
