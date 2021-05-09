package xyz.snoutr.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtils {
    public static Connection getConnection()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
    public static void release(Statement stmt,Connection conn) throws Exception{
        if(stmt !=null){
            stmt.close();
            stmt=null;
        }
        if(conn !=null){
            conn.close();
            conn=null;
        }
    }
    public static void release(ResultSet rs,Statement stmt, Connection conn) throws Exception{
        if(rs !=null){
            rs.close();
            rs=null;
        }
        release(stmt, conn);
    }
}
