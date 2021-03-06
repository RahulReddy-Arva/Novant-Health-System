
package com.chandu.pappointment;

import com.chandu.utilities.ConnectionPool;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Shara
 */
public class Pappointmentdao {

public void create(Pappointment  bean){
   ConnectionPool c=ConnectionPool.getInstance();
       c.initialize();
       Connection con=c.getConnection();
       try{
           String sql="insert into pappointment(name,age,sex,address,mobile,email,doctor,symtoms,date,did,image)values(?,?,?,?,?,?,?,?,?,?,?)";

           PreparedStatement pstmt=con.prepareStatement(sql);
           pstmt.setString(1,bean.getName());
           pstmt.setString(2,bean.getAge());
           pstmt.setString(3,bean.getSex());
           pstmt.setString(4,bean.getAddress());
           pstmt.setString(5, bean.getMobile());
           pstmt.setString(6,bean.getEmail());
           pstmt.setString(7,bean.getDoctor());
           pstmt.setString(8,bean.getSymtoms());
           pstmt.setString(9,bean.getDate());
          pstmt.setInt(10,bean.getDid());
          pstmt.setString(11,bean.getImage());

           pstmt.executeUpdate();
           System.out.println("success");
            }
       catch(Exception e){
          System.out.println("i am in Create");
       }
       finally{
           c.putConnection(con);
       }
}

    public void edit(Pappointment bean){
        ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="update pappointment set name=?,age=?,sex=?,address=?,mobile=?,email=?,doctor=?,symtoms=?,date=?,did=?,image=? where id=?";
            PreparedStatement pstmt=con.prepareStatement(sql);
             pstmt.setString(1,bean.getName());
           pstmt.setString(2,bean.getAge());
           pstmt.setString(3,bean.getSex());
           pstmt.setString(4,bean.getAddress());
           pstmt.setString(5, bean.getMobile());
           pstmt.setString(6,bean.getEmail());
           pstmt.setString(7,bean.getDoctor());
           pstmt.setString(8,bean.getSymtoms());
           pstmt.setString(9,bean.getDate());
           pstmt.setString(10,bean.getImage());
          pstmt.setInt(11, bean.getId());


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
            String sql="delete from pappointment where id=?";
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

    public Pappointment find(int id){
         Pappointment ub=new Pappointment();
        ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="select * from pappointment where id=?";
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){

               ub.setName(rs.getString("name"));
               ub.setAge(rs.getString("age"));
               ub.setSex(rs.getString("sex"));
               ub.setAddress(rs.getString("address"));
               ub.setMobile(rs.getString("mobile"));
               ub.setEmail(rs.getString("email"));
               ub.setDoctor(rs.getString("doctor"));
               ub.setSymtoms(rs.getString("symtoms"));
               ub.setDate(rs.getString("date"));
               ub.setImage(rs.getString("image"));
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


    public ArrayList<Pappointment> findAll(){
        ArrayList<Pappointment> al=new ArrayList<Pappointment>();
          ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
            String sql="select * from pappointment";
            PreparedStatement pstmt=con.prepareStatement(sql);

            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                Pappointment ub=new Pappointment();
               ub.setName(rs.getString("name"));
               ub.setAge(rs.getString("age"));
               ub.setSex(rs.getString("sex"));
               ub.setAddress(rs.getString("address"));
               ub.setMobile(rs.getString("mobile"));
               ub.setEmail(rs.getString("email"));
               ub.setDoctor(rs.getString("doctor"));
               ub.setSymtoms(rs.getString("symtoms"));
               ub.setDate(rs.getString("date"));
               ub.setImage(rs.getString("image"));
               ub.setId(rs.getInt("id"));
               ub.setDid(rs.getInt("did"));

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



    public ArrayList<Pappointment> findAllPatient(int did){
        ArrayList<Pappointment> al=new ArrayList<Pappointment>();
          ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
             String sql="select * from pappointment where did="+did;
            PreparedStatement pstmt=con.prepareStatement(sql);

            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                Pappointment ub=new Pappointment();
               ub.setName(rs.getString("name"));
               ub.setAge(rs.getString("age"));
               ub.setSex(rs.getString("sex"));
               ub.setAddress(rs.getString("address"));
               ub.setMobile(rs.getString("mobile"));
               ub.setEmail(rs.getString("email"));
               ub.setDoctor(rs.getString("doctor"));
               ub.setSymtoms(rs.getString("symtoms"));
               ub.setDate(rs.getString("date"));
               ub.setImage(rs.getString("image"));
               ub.setId(rs.getInt("id"));
               ub.setDid(rs.getInt("did"));

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



    public ArrayList<Pappointment> findAllPatientDetail(String pid){
        ArrayList<Pappointment> al=new ArrayList<Pappointment>();
          ConnectionPool c=ConnectionPool.getInstance();
        c.initialize();
        Connection con=c.getConnection();
        try{
             String sql="select * from pappointment where did="+pid;
            PreparedStatement pstmt=con.prepareStatement(sql);

            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                Pappointment ub=new Pappointment();
               ub.setName(rs.getString("name"));
               ub.setAge(rs.getString("age"));
               ub.setSex(rs.getString("sex"));
               ub.setAddress(rs.getString("address"));
               ub.setMobile(rs.getString("mobile"));
               ub.setEmail(rs.getString("email"));
               ub.setDoctor(rs.getString("doctor"));
               ub.setSymtoms(rs.getString("symtoms"));
               ub.setDate(rs.getString("date"));
               ub.setImage(rs.getString("image"));
               ub.setId(rs.getInt("id"));
               ub.setDid(rs.getInt("did"));

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




       public static void main(String[] args) {
        Pappointmentdao ud=new Pappointmentdao();


     

      Pappointment c= ud.find(2);
      System.out.println("Username="+c.getEmail());




    }
}
