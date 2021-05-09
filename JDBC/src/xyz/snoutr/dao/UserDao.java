package xyz.snoutr.dao;

import xyz.snoutr.domain.User;
import xyz.snoutr.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserDao {
    public boolean insert(User user) throws Exception{
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        conn = JDBCUtils.getConnection();
        stmt = conn.createStatement();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = sdf.format(user.getBirthday());

        String sql = "INSERT INTO users (id,name,password,email,birthday) VALUES ("
                +user.getId()+",'"
                +user.getUsername()+"','"
                +user.getPassword()+"','"
                +user.getEmail()+"','"
                +birthday+"')";
        int num = stmt.executeUpdate(sql);
        if(num>0){
            return true;
        }else {
            return false;
        }
    }
    public ArrayList<User> findAll() throws Exception {
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        ArrayList<User> list = new ArrayList<User>();
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM users";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setBirthday(rs.getDate("birthday"));
                list.add(user);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            JDBCUtils.release(rs,stmt,conn);
        }
        return null;
    }
    public User find(int id) throws Exception {
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE id="+id;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setBirthday(rs.getDate("birthday"));
                return user;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs,stmt,conn);
        }
        return null;
    }

    public boolean delete(int id) throws Exception {
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "DELETE FROM users WHERE id="+id;
            int num = stmt.executeUpdate(sql);
            if(num>0){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs,stmt,conn);
        }
        return false;
    }
    public boolean update(User user) throws Exception {
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(user.getBirthday());
            String sql ="UPDATE users set name='"+user.getUsername()+"',password='"+user.getPassword()+"',email='"+user.getEmail()+"',birthday='"+birthday+"'WHERE id="+user.getId();
            int num = stmt.executeUpdate(sql);
            if(num>0){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs,stmt,conn);
        }
        return false;
    }
}
