package xyz.snoutr;

import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDao {
    public static Object query(String sql, ResultSetHandler<?> rsh, Object... params) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        conn = JDBCUtils.getConnection();
        pstm = conn.prepareStatement(sql);
        for (int i = 0;params!=null && i<params.length;i++){
            pstm.setObject(i+1,params[i]);
        }
        rs = pstm.executeQuery();
        Object obj = rsh.handle(rs);
        return obj;
    }
}
