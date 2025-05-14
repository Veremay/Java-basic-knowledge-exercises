import java.net.InetAddress;
import java.net.UnknownHostException;

public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //获取域名和IP地址
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        //通过域名获取域名和IP地址
        InetAddress byName = InetAddress.getByName("myhuuu");
        System.out.println(byName);
        //根据域名返回 InetAddress对象，比如www.baidu.com对应
        InetAddress host = InetAddress.getByName("www.baidu.com" );
        System.out.println(host);
        //获得ip地址
        String hostAddress = localHost.getHostAddress();
        System.out.println(hostAddress);
        //通过InetAddress对象，获取对应的主机名/或者的域名
        String hostName = host.getHostName();
        System.out.println(hostName);
    }
}
