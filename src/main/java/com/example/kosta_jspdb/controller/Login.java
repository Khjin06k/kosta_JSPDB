package com.example.kosta_jspdb.controller;

import com.example.kosta_jspdb.dto.Member;
import com.example.kosta_jspdb.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/bank/login.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id"); // login.jsp의 name과 동일해야 함
        String password = req.getParameter("password");

        MemberService memberService = new MemberService();
        try{
            Member member = memberService.login(id, password);
            HttpSession session = req.getSession();
            session.setAttribute("user", member);
            req.getRequestDispatcher("/bank/makeAccount.jsp").forward(req, res);
        }catch (Exception e){
            req.setAttribute("err", e.getMessage());
            req.getRequestDispatcher("/bank/error.jsp").forward(req, res);
        }
    }
}