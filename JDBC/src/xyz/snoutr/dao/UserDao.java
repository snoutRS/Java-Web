package xyz.snoutr.dao;

import xyz.snoutr.domain.User;
import xyz.snoutr.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

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
}
