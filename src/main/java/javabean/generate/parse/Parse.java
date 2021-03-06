package javabean.generate.parse;

import javabean.generate.Constants;
import javabean.generate.bean.Column;
import javabean.generate.bean.ConnectionBean;
import javabean.generate.bean.Table;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Parse {

    private ConnectionBean connection;

    public Parse(ConnectionBean connection) {
        this.connection = connection;
    }

    /**
     *
     * @param db 数据库类型，只支持Oralce .MySql
     * @return
     */
    public List<Table> getParseTables(String db) {
        List<Table> tables = new ArrayList<>();
        java.sql.Connection conn = null;
        if("Oracle".equalsIgnoreCase(db)){
            conn= getConnectionOracle();
        } else if ("Mysql".equalsIgnoreCase(db)){
            conn= getConnectionMysql();
        }
        ResultSet rs = null;
        try {
            DatabaseMetaData dbmd = conn.getMetaData();
            rs = dbmd.getTables(conn.getCatalog(),connection.getUser(),null,new String[]{"TABLE","VIEW"});
            ResultSet colRs;
            List<Column> columns;
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                colRs = dbmd.getColumns(null, "%", tableName, "%");
                columns = new ArrayList<>();
                while (colRs.next()) {
                    String colName = colRs.getString("COLUMN_NAME");
                    int sqlType = colRs.getInt("DATA_TYPE");
                    String javaType = TypeMapper.getMapperClass(sqlType).getName();
                    String pkg = StringUtils.substringBeforeLast(javaType, Constants.PACKAGE_SEPARATOR);
                    if (StringUtils.equals(pkg, Constants.DEFAULT_PACKAGE)) {
                        javaType = StringUtils.substringAfterLast(javaType, Constants.PACKAGE_SEPARATOR);
                    }
                    columns.add(new Column(colName, sqlType, javaType));
                }
                tables.add(new Table(tableName, columns));
                close(colRs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(rs);
        close(conn);
        return tables;
    }
    private java.sql.Connection getConnectionOracle() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        java.sql.Connection conn = null;
        String url = "jdbc:oracle:thin:@%s:%s:%s";
        url = String.format(url, connection.getHost(), connection.getPort(), connection.getDb());
        try {
            //用户名转了大写
            conn = DriverManager.getConnection(url, connection.getUser().toUpperCase(), connection.getPasswd());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    private java.sql.Connection getConnectionMysql() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        java.sql.Connection conn = null;
        String url = "jdbc:mysql://%s:%s/%s?characterEncoding=utf-8&useSSL=false";
        url = String.format(url, connection.getHost(), connection.getPort(), connection.getDb());
        try {
            conn = DriverManager.getConnection(url, connection.getUser(), connection.getPasswd());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    private void close(java.sql.Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
