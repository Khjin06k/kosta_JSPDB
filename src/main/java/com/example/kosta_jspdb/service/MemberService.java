package com.example.kosta_jspdb.service;

import com.example.kosta_jspdb.dao.MemberDAO;
import com.example.kosta_jspdb.dto.Member;

import java.sql.Connection;

public class MemberService {
    MemberDAO dao = new MemberDAO();

    public void join(Member member){
        dao.insertMember(member);
    }

    public Member login(String id, String password) throws Exception{
        Member member = dao.selectMember(id);
        if(member == null) throw new Exception("아이디가 틀립니다.");
        if(!member.getPassword().equals(password)) throw new Exception("비밀번호가 틀립니다.");

        member.setPassword(null); // password를 세션에 넣는 것은 아닌 것 같기에 password에 null을 넣어줌
        return member;
    }

}
