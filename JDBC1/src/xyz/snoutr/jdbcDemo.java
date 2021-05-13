package xyz.snoutr;

import java.sql.*;

public class jdbcDemo {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
        //2.Statement接口准备
        //3.resultset
        //4.释放资源
        PreparedStatement statement = null;
        ResultSet rs = null;
        Connection conn = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String password = "root";

            //拿到数据库连接
            conn = DriverManager.getConnection(url, username, password);

            //执行sql(无需传参)
            String sql = "INSERT INTO users(name,password,email,birthday) VALUE (?,?,?,?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1,"wtf");
            statement.setString(2,"wtf");
            statement.setString(3,"wtf@163.com");
            statement.setString(4,"1001-10-11");
            int i = statement.executeUpdate();
            System.out.println(i);

//            while (rs.next()){
////                int id = rs.getInt("id");
////                String name = rs.getString("name");
////                String psw = rs.getString("password");
////                String email = rs.getString("email");
////                Date birthday = rs.getDate("birthday");
//
//
////                System.out.println(id +"|" +name+"|"+psw+"|"+email+"|"+birthday);
//            }

        }catch (Exception e){
            e.printStackTrace();
        } finally {
//            if (statement !=null){
//                rs.close();
//            }
            if (statement != null){
                statement.close();
            }
            if (statement != null){
                conn.close();
            }
        }

    }
}
