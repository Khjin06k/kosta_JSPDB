package com.example.kosta_jspdb.dao;

import com.example.kosta_jspdb.dto.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    public void insertAccount(Account acc){
        Connection conn = JdbcUtil.getConnection();

        PreparedStatement pstmt = null;
        String sql = "insert into account values(?,?,?,?,?);";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, acc.getId());
            pstmt.setString(2, acc.getName());
            pstmt.setInt(3, acc.getBalance());
            pstmt.setString(4, acc.getType());
            pstmt.setString(5, acc.getGrade());
            pstmt.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstmt != null) pstmt.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        JdbcUtil.close(conn);
    }

    // 중복체크
    public Account selectAccount(String id){
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Account acc = null;
        String sql = "select * from account where id=?";
        try{
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs= pstmt.executeQuery();
            if(rs != null && rs.next()){
                acc = new Account();
                acc.setId(rs.getString("id"));
                acc.setName(rs.getString("name"));
                acc.setBalance(rs.getInt("balance"));
                acc.setType(rs.getString("type"));
                acc.setGrade((rs.getString("grade")));
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
        return acc;
    }

    // 입금, 출금액 반영
    public void changeMoney(Account acc){
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "update account set balance=? where id=?";
        try{
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, acc.getBalance());
            pstmt.setString(2, acc.getId());
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(pstmt != null) pstmt.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        JdbcUtil.close(conn);
    }

    // 전체 계좌 조회
    public List<Account> allAccount(){
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from account"; // 모든 계좌 조회 필요
        List<Account> accountList = new ArrayList<>();

        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            // 쿼리문에서 조회한 계좌가 존재한다면 가져와서 리스트에 저장
            while(rs.next()){
                Account acc = new Account();
                acc.setId(rs.getString("id"));
                acc.setName(rs.getString("name"));
                acc.setBalance(rs.getInt("balance"));
                acc.setType(rs.getString("type"));
                acc.setGrade((rs.getString("grade")));
                accountList.add(acc);
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
        return accountList;
    }
}
