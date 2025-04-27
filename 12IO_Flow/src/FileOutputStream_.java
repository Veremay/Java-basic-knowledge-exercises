import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    /**
     * 演示使用FileOutputStream 将数据写到文件中
     * 如果该文件不存在，则创建该文件
     */
    @Test
    public void writeFile(){
        // 创建FileOutputStream对象
        String filePath = "./test.txt";
        FileOutputStream fileOutputStream = null;

        try {

            // 得到fileoutputstream对象
            //1.new FileOutputStream(filePath)创建方式，当写入内容时，会覆盖原来的内容
            //2.new FileOutputStream(filePath，true)创建方式，当写入内容时，是追加内容
            fileOutputStream = new FileOutputStream(filePath, true);

            //写入一个字节
            fileOutputStream.write('H');

            // 写入字符串
            String str = "hahahahaha";
            //str.getBytes()可以把字符串->字节数组
            fileOutputStream.write(str.getBytes());

            // 指定位置
            fileOutputStream.write(str.getBytes(),0, str.length());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 一定要记得关闭流，释放资源
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
