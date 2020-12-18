/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSP0007.Model;

import java.io.Serializable;

/**
 *
 * @author LONG
 */
public class Account implements Serializable{
    private String name;
    private String login;
    private String pass;

    public Account() {
    }

    public Account(String login, String pass, String name) {
        this.login = login;
        this.pass = pass;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
