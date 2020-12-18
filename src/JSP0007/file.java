/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSP0007;


import JSP0007.Model.Message;
import JSP0007.Model.Account;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author LONG
 */
public class file {

    public static void write(ArrayList<Account> a) {
        try {

            FileOutputStream fos = new FileOutputStream("account.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Account s[] = new Account[a.size()];
            for(int i = 0;i<a.size();i++){
                s[i] = a.get(i);
            }
            oos.writeObject(s);

            fos.close();
            oos.close();
        } catch (IOException ex) {
            System.out.println("Loi ghi file: " + ex);
        }

    }

    public static ArrayList<Account> read() {

        try {
            ArrayList<Account> a = new ArrayList<>();
            FileInputStream fis = new FileInputStream("account.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Account sArr[] = (Account[]) ois.readObject();
            for (Account s : sArr) {
                a.add(s);
            }
            fis.close();
            ois.close();
            return a;
        } catch (Exception ex) {
            System.out.println("Loi doc file: " + ex);
        }
        return null;
    }
    
    public static void writeMess(ArrayList<Message> a) {
        try {

            FileOutputStream fos = new FileOutputStream("message.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Message s[] = new Message[a.size()];
            for(int i = 0;i<a.size();i++){
                s[i] = a.get(i);
            }
            oos.writeObject(s);

            fos.close();
            oos.close();
        } catch (IOException ex) {
            System.out.println("Loi ghi file: " + ex);
        }

    }

    public static ArrayList<Message> readMess() {

        try {
            ArrayList<Message> a = new ArrayList<>();
            FileInputStream fis = new FileInputStream("message.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Message sArr[] = (Message[]) ois.readObject();
            for (Message s : sArr) {
                a.add(s);
            }
            fis.close();
            ois.close();
            return a;
        } catch (Exception ex) {
            System.out.println("Loi doc file: " + ex);
        }
        return null;
    }
}
