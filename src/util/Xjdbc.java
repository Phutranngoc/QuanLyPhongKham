/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class Xjdbc {

    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String dburl = "jdbc:sqlserver://localhost:1433;database=QuanLyPhongKham;encrypt=false";
    static String user = "sa";
    static String pass = "12341234";

    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dburl, user, pass);
    }


    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection conn = DriverManager.getConnection(dburl, user, pass);
        PreparedStatement stmt=null;
        if (sql.trim().startsWith("{")) {
            stmt = conn.prepareCall(sql);
        } else {
            stmt = conn.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            stmt.setObject(i + 1, args[i]);
        }
        return stmt;
    }
 
    public static ResultSet query(String sql,Object...args)throws SQLException{
       PreparedStatement stmt =Xjdbc.getStmt(sql, args);
       return stmt.executeQuery();
    }
    
    public static Object value(String sql,Object...args){
        try{
            ResultSet rs = Xjdbc.query(sql, args);
            if(rs.next()){
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        }catch(Exception e){
            throw new RuntimeException(e);
        }   
    }
    
    public static int update(String sql,Object...args){
        try{
            PreparedStatement stmt=Xjdbc.getStmt(sql, args);
            try{
                return stmt.executeUpdate();
            }
            finally{
                stmt.getConnection().close();
            }
    }catch(Exception e){
        throw new RuntimeException(e);
    }
}
}