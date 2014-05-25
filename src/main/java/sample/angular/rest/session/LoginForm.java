package sample.angular.rest.session;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginForm {
    private String password;

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
