/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSP0007;


import JSP0007.Model.Message;
import JSP0007.Model.Account;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author LONG
 */
public class createFile {
    public static void main(String args[]){
        try {

            FileOutputStream fos = new FileOutputStream("account.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Account s[] = new Account[1];
            s[0]= new Account("long", "long", "long");
            oos.writeObject(s);

            fos.close();
            oos.close();
            
            fos = new FileOutputStream("message.bin");
            oos = new ObjectOutputStream(fos);
            Message m[] = new Message[1];
            m[0]=new Message("Sender", "Receiver", "Message");
            oos.writeObject(m);

            fos.close();
            oos.close();
        } catch (IOException ex) {
            System.out.println("Loi ghi file: " + ex);
        }
}
}
