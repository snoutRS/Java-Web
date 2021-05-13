package xyz.snoutr;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class Ex2 {
    public static DataSource ds = null;
    static {
        InputStream in = new Ex2().getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
            ds = BasicDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Connection conn = ds.getConnection();
        DatabaseMetaData metaData=conn.getMetaData();
        System.out.println(metaData.getUserName());
    }
}
