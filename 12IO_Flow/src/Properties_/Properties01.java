package Properties_;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Properties01 {
    public static void main(String[] args) throws IOException {
        //1.实体化类对象
        Properties properties = new Properties();
        //2.将内容载入对象中
        properties.load(new FileReader("12IO_Flow/src/Properties_/mysql.properties"));
        //3.选择将内容输出到控制台上
        properties.list(System.out);
        //
        String user = properties.getProperty("users");
        System.out.println("users: " + user);
        // 修改配置文件
        properties.setProperty("add","may");
        properties.setProperty("phone","11234");
        properties.store(new FileWriter("12IO_Flow/src/Properties_/mysql02.properties"),null);
    }
}
