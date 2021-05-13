package xyz.snoutr;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class Ex4 {
    public static DataSource ds = null;
    static {
        ComboPooledDataSource cpds = new ComboPooledDataSource("itcast");
        ds = cpds;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(ds.getConnection());
    }
}
