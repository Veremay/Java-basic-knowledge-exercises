package transformation;

import java.io.*;

public class InputStreamReader_ {
    //演示使用 InputStreamReader 转换流解决中文乱码问题
    //将字节流 FileInputStream 转成字符流 InputStreamReader，指定编码 gbk/utf-8
    public static void main(String[] args) throws IOException {
        String filePath = "12IO_Flow/test.txt";
        //解读
        //1.把FileInputstream 转成 InputStreamReader//2.指定编码 gbk
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        //3.把InputstreamReader 传入BufferedReader
        BufferedReader br = new BufferedReader(isr);
        //4.读取
        String s = br.readLine();
        System.out.println("读取内容=" + s);
        //5.关闭外层流
        br.close();
    }
}
