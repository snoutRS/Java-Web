package xyz.snoutr;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class Ex1 {
    public static DataSource ds = null;
    static {
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl("jdbc:mysql://localhost:3306/jdbc");
        bds.setUsername("root");
        bds.setPassword("root");

        bds.setInitialSize(5);
        bds.setMaxActive(5);
        ds = bds;

    }

    public static void main(String[] args) throws Exception {
        Connection conn = ds.getConnection();
        DatabaseMetaData metaData=conn.getMetaData();
        System.out.println(metaData.getUserName());
    }
}
