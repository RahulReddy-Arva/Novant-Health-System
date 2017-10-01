
package com.chandu.utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.sql.*;
import java.io.InputStream;

public class ConnectionPool{


    static ArrayList<Connection>connections;
    static ConnectionPool instance=null;
    public static synchronized void removeAllConnections(){
        try
        {
            if(connections==null)
            {
                return ;
            }
            int sz=connections.size();
            for(int i=0; i<sz; i++)
            {
               Connection c= connections.get(i);
               c.close();
            }
            connections.clear();
            connections=null;
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

public static synchronized ConnectionPool getInstance(){
    if(instance==null){
        instance=new ConnectionPool();
    }
    return instance;
}
 public synchronized void initialize() {
        if (connections == null) {
            try {
                Properties pro = new Properties();
                InputStream in = getClass().getResourceAsStream("Message.properties");
                pro.load(in);
                String userName = pro.getProperty("username");
                String password = pro.getProperty("password");
                String url = pro.getProperty("url");
                int ic = Integer.parseInt(pro.getProperty("maxconnections"));
                Class.forName(pro.getProperty("drivername")).newInstance();
                connections = new ArrayList<Connection>();
                int count = 0;
                while (count < ic) {
                    Connection c = DriverManager.getConnection(url, userName, password);
                    connections.add(c);
                    count++;
                }
            } catch (Exception e) {
                System.err.println("Cannot connect to the database server");
            }
        }
    }
public synchronized Connection getConnection(){
    Connection c=null;
    if(connections==null){
        return null;
    }
    while(true){
        if(connections.size()>0)
        {
            c=connections.get(0);
            connections.remove(0);
            break;
        }
 else{
            try{
                wait();
            }
            catch(Exception e){
                System.out.println("Problem with wait");

            }
 }
    }
    return c;
}

/*
public Connection getConnection() {
        try {

           Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://murachdb.cpitxysdf.us-west-2.rds.amazonaws.com:3306/murachdb?autoReconnect=true&user=rahul&password=12345678");
       return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }*/
public synchronized void putConnection(Connection c){
    connections.add(c);
    notifyAll();
}

 

                       
                      
 public static String getDriver(){
        FileInputStream in = null;
        String path = new String();
        try {

            Properties pro = new Properties();
            File f = new File(getAddressPro());
            in = new FileInputStream(f);
            pro.load(in);
            path = pro.getProperty("DRIVER");
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
           return path;
    }

  public static String getUrl(){
        FileInputStream in = null;
        String path = new String();
        try {

            Properties pro = new Properties();
            File f = new File(getAddressPro());
            in = new FileInputStream(f);
            pro.load(in);
            path = pro.getProperty("URL");
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
           return path;
    }
  
  

public static String getAddressPro(){
String prop="E:/study material/vadisoft/JavaModule2VedisoftUtilities/JavaModule2VedisoftUtilities/VedisoftUtil/src/java/emp/emp.properties";
    return prop;
}

   public  String getPath() {
         String path=new String();
        try {
            Properties pro = new Properties();
            InputStream in = getClass().getResourceAsStream("Message.properties");
            pro.load(in);
           path=pro.getProperty("Path");
            return path;
        } catch (IOException ex) {
        }
        return path;
    }
}
