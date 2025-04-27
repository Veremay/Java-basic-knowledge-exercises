import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_ {
    // 演示FileInputStream的使用(字节输入流文件-->程序)
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() {
        String filePath = "./test.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节的数据。如果没有输入可用，此方法将阻止。
            // 如果返回-1，表示读取完毕
            while ((readData = fileInputStream.read()) != -1){
                System.out.println((char)readData);//转成char显示
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 一定要记得关闭流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 使用 read(byte[]b)读取文件，提高效率
    @Test
    public void readFile02() {
        String filePath = "./test.txt";
        // 字节数组
        byte[] buffer = new byte[8]; //一次读取8个字节
        int readLen = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取最多b.length字节的数据到字节数组。 此方法将阻塞，直到某些输入可用
            // 如果返回-1，表示读取完毕
            //如果读取正常，返回实际读取的字节数
            while ((readLen = fileInputStream.read(buffer)) != -1){
                System.out.print(new String(buffer,0,readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 一定要记得关闭流，释放资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
