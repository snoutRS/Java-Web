package xyz.snoutr;

import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class Test1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        BaseDao bd = new BaseDao();
        String sql = "select * from user where id=?";
        User user = (User) bd.query(sql,new BeanHandler(User.class),1);
        System.out.println(user.getName());
    }
}
