package pl.evanec;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id

    private String ip;
    private String browser;

    public User() {
    }

    public User(String ip, String browser) {
        this.ip = ip;
        this.browser = browser;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }
}
