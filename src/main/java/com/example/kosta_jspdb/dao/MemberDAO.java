package com.example.kosta_jspdb.dao;

import com.example.kosta_jspdb.dto.JdbcUtil;
import com.example.kosta_jspdb.dto.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberDAO {

    public static int insertMember(Member member){
        Connection conn = JdbcUtil.getConnection(); // Connection 풀에서 커넥션 해오는 것
        int cnt = 0;
        PreparedStatement pstmt = null;
        String sql = "insert into member value(?,?,?,?,?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getPassword());
            pstmt.setString(4, member.getEmail());
            pstmt.setString(5, member.getAddress());
            cnt = pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstmt != null){
                    pstmt.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        JdbcUtil.close(conn);
        return cnt;
    }

    public static void close(Connection conn){
        try{
            if(conn != null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
