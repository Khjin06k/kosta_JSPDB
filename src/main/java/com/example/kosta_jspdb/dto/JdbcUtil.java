package com.example.kosta_jspdb.dto;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class JdbcUtil {
    public static Connection getConnection(){
        Connection conn = null;
        try{
            Context initCtx = new InitialContext();
            Context envCtx = (Context)initCtx.lookup("java:comp/env"); // context.xml에 있는 ~
            DataSource ds = (DataSource) envCtx.lookup("jdbc/kosta"); // context.xml에 있는 name과 동일해야 함
            conn = ds.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }

        return conn;
    }

    public static void close(Connection conn){
        try{
            if(conn != null) conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
