
package com.chandu.doctor;

import com.chandu.utilities.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Shara
 */
public class doctordaos {

   public void create(doctorbean  bean){
   ConnectionPool c=ConnectionPool.getInstance();
       c.initialize();
       Connection con=c.getConnection();
       try{
           String sql="insert into doctor(username,password,name,address,mobile,email,specilization)values(?,?,?,?,?,?,?)";

           PreparedStatement pstmt=con.prepareStatement(sql);
           pstmt.setString(1,bean.getUsername());
           pstmt.setString(2,bean.getPassword());
           pstmt.setString(3,bean.getName());
           pstmt.setString(4,bean.getAddress());
           pstmt.setString(5, bean.getMobile());
           pstmt.setString(6,bean.getEmail());
           pstmt.setString(7,bean.getSpecilization());

           pstmt.executeUpdate();
            }
       catch(Exception e){
          System.out.println("i am here");
       }
       finally{
           c.putConnection(con);
       }
}
 
    public void edit(doctorbean bean){
        ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="update doctor set username=?,password=?,name=?,address=?,mobile=?,email=?,specilization=? where id=?";
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setString(1,bean.getUsername());
            pstmt.setString(2, bean.getPassword());
            pstmt.setString(3,bean.getName());
            pstmt.setString(4,bean.getAddress());
            pstmt.setString(5, bean.getMobile());
            pstmt.setString(6, bean.getEmail());
            pstmt.setString(6, bean.getSpecilization());
            pstmt.setInt(7, bean.getId());
            pstmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Exception in Edit "+e);
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
            String sql="delete from doctor where id=?";
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Exception in Edit "+e);
        }
        finally{
            c.putConnection(con);
        }

    }

    public doctorbean find(int id){
         doctorbean ub=new doctorbean();
        ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="select * from doctor where id=?";
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
               ub.setEmail(rs.getString("specilization"));
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


    public ArrayList<doctorbean> findAll(){
        ArrayList<doctorbean> al=new ArrayList<doctorbean>();
          ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="select * from doctor";
            PreparedStatement pstmt=con.prepareStatement(sql);

            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                doctorbean ub=new doctorbean();
               ub.setUsername(rs.getString("username"));
               ub.setPassword(rs.getString("password"));
               ub.setName(rs.getString("name"));
               ub.setAddress(rs.getString("address"));
               ub.setMobile(rs.getString("mobile"));
               ub.setEmail(rs.getString("email"));
               ub.setSpecilization(rs.getString("specilization"));
               ub.setId(rs.getInt("id"));

 al.add(ub);
            }


        }
        catch(Exception e){
            System.out.println("Exception in Edit"+e);
        }
        finally{
            c.putConnection(con);
        }
        return al;
    }


     public doctorbean authenticate(String username,String password){
         doctorbean ub=new doctorbean();
         ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{

            String sql="select * from doctor where username=? && password=?";
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
               ub.setEmail(rs.getString("specilization"));
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
        doctordaos ud=new doctordaos();

     

       ArrayList<doctorbean> ub=ud.findAll();
        for(doctorbean c: ub)
            System.out.println("Username="+c.getUsername()+"\npassword="+c.getPassword()+"\nname="+c.getName()+"\naddress="+c.getAddress()+"\n mobile="+c.getMobile()+"\n Email="+c.getEmail()+"\nuid="+c.getId());


   }

}

