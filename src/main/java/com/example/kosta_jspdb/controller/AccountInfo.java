package com.example.kosta_jspdb.controller;

import com.example.kosta_jspdb.dto.Account;
import com.example.kosta_jspdb.dto.Member;
import com.example.kosta_jspdb.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/accountInfo")
public class AccountInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("user")==null){
            req.setAttribute("err", "로그인 하세요.");
            req.getRequestDispatcher("/bank/error.jsp").forward(req, res);
            return;
        }
        req.getRequestDispatcher("/bank/accountInfoForm.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String id = req.getParameter("id");
        AccountService accountService = new AccountService();

        HttpSession session = req.getSession();
        Member member = (Member)session.getAttribute("user");

        try{
            // 계좌를 조회해서 존재한다면 조회
            Account acc = accountService.accountInfo(id, member);
            req.setAttribute("acc", acc);
            req.getRequestDispatcher("/bank/accountInfo.jsp").forward(req, res);
        }catch (Exception e){
            // 계좌가 존재하지 않아 예외를 받은 경우
            req.setAttribute("err", e.getMessage());
            req.getRequestDispatcher("/bank/error.jsp").forward(req, res);
        }
    }
}