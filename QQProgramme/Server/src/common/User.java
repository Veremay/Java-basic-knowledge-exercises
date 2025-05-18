package common;

import java.io.Serializable;

/*
    表示一个用户信息
 */
public class User implements Serializable {
    //通过数据通道传输则需要实现serializable
    //提高兼容性
    private static final long serialVersionUID = 1L;
    private String userId;

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String passwd;

    public User(String userId, String passwd) {
        this.passwd = passwd;
        this.userId = userId;
    }
}
