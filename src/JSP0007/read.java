/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSP0007;

import JSP0007.Model.Account;
import JSP0007.Model.Message;
import java.util.ArrayList;

/**
 *
 * @author LONG
 */
public class read {
    public static void main(String[] args){
        ArrayList<Account> m = new ArrayList<>();
        m=file.read();
        for(int i=0;i<m.size();i++){
            System.out.println(m.get(i).getLogin());
        }
        
        
    }
}
