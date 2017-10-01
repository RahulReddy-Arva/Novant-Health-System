

package com.chandu.phrmesctics;

import com.chandu.utilities.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;

public class pdaos {

    public void create(pbean bean)
       {
   ConnectionPool c=ConnectionPool.getInstance();
       c.initialize();
       Connection con=c.getConnection();
       try{
           String sql="insert into phar(username,password,name,address,mobile,email,did)values(?,?,?,?,?,?,?)";

           PreparedStatement pstmt=con.prepareStatement(sql);
           pstmt.setString(1,bean.getUsername());
           pstmt.setString(2,bean.getPassword());
           pstmt.setString(3,bean.getName());
           pstmt.setString(4,bean.getAddress());
           pstmt.setString(5, bean.getMobile());
           pstmt.setString(6,bean.getEmail());
           pstmt.setInt(7,bean.getDid());

           pstmt.executeUpdate();
            }
       catch(Exception e){
          System.out.println("i am in Create");
       }
       finally{
           c.putConnection(con);
       }
    }

   public void edit(pbean bean){
        ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="update phar set username=?,password=?,name=?,address=?,mobile=?,email=?,did=? where id=?";
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setString(1,bean.getUsername());
            pstmt.setString(2, bean.getPassword());
            pstmt.setString(3,bean.getName());
            pstmt.setString(4,bean.getAddress());
            pstmt.setString(5, bean.getMobile());
            pstmt.setString(6, bean.getEmail());
            pstmt.setInt(7, bean.getDid());
            pstmt.setInt(8, bean.getId());
            pstmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Exception in Edit coomand"+e);
        }
        finally{
            c.putConnection(con);
        }

    }


    public void remove(int id){
        ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="delete from phar where id=?";
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Exception in Edit coomand"+e);
        }
        finally{
            c.putConnection(con);
        }

    }

    public pbean find(int id){
         pbean ub=new pbean();
        ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="select * from phar where id=?";
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){

               ub.setUsername(rs.getString("username"));
               ub.setPassword(rs.getString("password"));
               ub.setName(rs.getString("name"));
               ub.setAddress(rs.getString("address"));
               ub.setMobile(rs.getString("mobile"));
               ub.setEmail(rs.getString("email"));
               ub.setDid(rs.getInt("did"));
               ub.setId(rs.getInt("id"));

   }


        }
        catch(Exception e){
            System.out.println("Exception in Edit coomand"+e);
        }
        finally{
            c.putConnection(con);
    }
        return ub;
    }


    public ArrayList<pbean> findAll(){
        ArrayList<pbean> al=new ArrayList<pbean>();
          ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="select * from phar";
            PreparedStatement pstmt=con.prepareStatement(sql);

            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                pbean ub=new pbean();
               ub.setUsername(rs.getString("username"));
               ub.setPassword(rs.getString("password"));
               ub.setName(rs.getString("name"));
               ub.setAddress(rs.getString("address"));
               ub.setMobile(rs.getString("mobile"));
               ub.setEmail(rs.getString("email"));
               ub.setDid(rs.getInt("did"));
               ub.setId(rs.getInt("id"));

 al.add(ub);
            }


        }
        catch(Exception e){
            System.out.println("Exception in Edit coomand"+e);
        }
        finally{
            c.putConnection(con);
        }
        return al;
    }


     public pbean authenticate(String username,String password){
         pbean ub=new pbean();
         ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{

            String sql="select * from phar where username=? && password=?";
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){

               ub.setUsername(rs.getString("username"));
               ub.setPassword(rs.getString("password"));
               ub.setName(rs.getString("name"));
               ub.setAddress(rs.getString("address"));
               ub.setMobile(rs.getString("mobile"));
               ub.setEmail(rs.getString("email"));
               ub.setDid(rs.getInt("did"));
               ub.setId(rs.getInt("id"));

   }


        }
        catch(Exception e){
            System.out.println("Exception in Edit coomand"+e);
        }
        finally{
            c.putConnection(con);
        }
  return ub;
     }

    public static void main(String[] args) {
        pdaos ud=new pdaos();

    
  
    }

                        }
