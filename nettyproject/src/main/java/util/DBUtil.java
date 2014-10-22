/*
/*
 * Created on 2006-11-3
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * @author Administrator.
 * @createDate 2006-11-3.
 * @version 1.0.0.
 */
public final class DBUtil {

    private static ComboPooledDataSource ComboPool = null;

    private static String Synchro = "Synchro";

    private DBUtil() {
    }

    static {
        loadDBResource();
    }

    /**
     * .
     * 
     * @author Paul Jiang.
     * @createDate 2007-1-11.
     * @version 1.0.0.
     */
    static void loadDBResource() {
        try {
            ComboPool = new ComboPooledDataSource();
            ComboPool.setDriverClass(ConfigUtil.get("DbDriver"));
            ComboPool.setJdbcUrl(ConfigUtil.get("ConnString"));
            ComboPool.setUser(ConfigUtil.get("DbUser"));
            ComboPool.setPassword(ConfigUtil.get("DbPassword"));

            ComboPool.setMinPoolSize(Integer.parseInt(ConfigUtil
                    .get("MinPool")));
            ComboPool.setMaxPoolSize(Integer.parseInt(ConfigUtil
                    .get("MaxPool")));
            ComboPool.setMaxStatements(300);
            ComboPool.setMaxIdleTime(60);
        } catch (Exception ex) {
            ex.printStackTrace();
//            System.out
//                    .println("|---System will database connection pool failure, please check it, system will exit.....");
            System.exit(0);
        }
    }
    
   
    /**
     * 
     * @param isTrans
     * @return
     * @throws SQLException.
     * @author Paul Jiang.
     * @createDate 2007-1-11.
     * @version 1.0.0.
     */
    public static Connection getConnection(boolean isTrans) throws SQLException {
//    	long t1 = System.currentTimeMillis();
        Connection resConn = null;

        if (!isTrans) {
            synchronized (Synchro) {
                if (ComboPool == null) {
                    loadDBResource();
                }
            }
//            System.out.println(ComboPool.getNumConnections());
            resConn = ComboPool.getConnection();
        } else {
            try {
                Properties props = new Properties();

                props.put("user", ConfigUtil.get("DbUser"));
                props.put("password", ConfigUtil.get("DbPassword"));

                Driver serviceDriver = (Driver) Class.forName(
                        ConfigUtil.get("dbDriver")).newInstance();

                resConn = serviceDriver.connect(ConfigUtil.get("ConnString"),
                        props);
                resConn.setAutoCommit(false);
            } catch (SQLException sex) {
                sex.printStackTrace();
                throw sex;
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new SQLException(
                        "create a database connnection failure, detial:"
                                + ex.toString());
            }
        }
        //long temp = System.currentTimeMillis()-t1;
        //System.out.println("conn time cost : " + temp);
//        System.out.println("获取连接成功！");
        return resConn;
    }
    
    

    /**
     * 
     * @param stmt.
     * @author Administrator.
     * @createDate 2006-11-3.
     * @version 1.0.0.
     */
    public static void close(Statement stmt) {
        if (stmt == null)
            return;
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 
     * @param rs.
     * @author Administrator.
     * @createDate 2006-11-3.
     * @version 1.0.0.
     */
    public static void close(ResultSet rs) {
        if (rs == null)
            return;
        try {
            rs.close();
//            System.out.println("关闭连接成功！");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 
     * @param conn.
     * @author Administrator.
     * @createDate 2006-11-3.
     * @version 1.0.0.
     */
    public static void close(Connection conn) {
        try {
            if (conn == null || conn.isClosed())
                return;
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static ComboPooledDataSource getPool(){
    	return ComboPool;
    }
}

