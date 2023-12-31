package com.example.kosta_jspdb.dao;

import com.example.kosta_jspdb.dto.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public Member selectMember(String id){
        Connection conn = JdbcUtil.getConnection();
        String sql = "select * from member where id=?";

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Member member = null;
        try{
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs != null && rs.next()){
                member = new Member();
                member.setId(rs.getString("id"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setAddress(rs.getString("address"));
                member.setEmail(rs.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        JdbcUtil.close(conn);
        return member;
    }
}
