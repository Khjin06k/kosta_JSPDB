package com.example.kosta_jspdb.service;

import com.example.kosta_jspdb.dao.MemberDAO;
import com.example.kosta_jspdb.dto.Member;

import java.sql.Connection;

public class MemberService {
    public void join(Member member){
        MemberDAO dao = new MemberDAO();
        dao.insertMember(member);
    }
}
