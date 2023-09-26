package com.example.kosta_jspdb.controller;

import com.example.kosta_jspdb.dto.Account;
import com.example.kosta_jspdb.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/makeAccount")
public class MakeAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("user")==null){
            req.setAttribute("err", "로그인 하세요.");
            req.getRequestDispatcher("/bank/error.jsp").forward(req, res);
            return;
        }
        req.getRequestDispatcher("/bank/makeAccount.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String id = req.getParameter("id");
        String name=req.getParameter("name");
        Integer money = Integer.parseInt(req.getParameter("money"));
        String type = req.getParameter("type");
        String grade = req.getParameter("grade");

        Account acc = new Account(id, name, money, type, grade);
        AccountService accountService = new AccountService();
        try{
            accountService.makeAccount(acc);
            req.setAttribute("acc", acc);
            req.getRequestDispatcher("/bank/accountInfo.jsp").forward(req, res);
        }catch (Exception e){
            req.setAttribute("err", e.getMessage());
            req.getRequestDispatcher("/bank/error.jsp").forward(req, res);
        }

    }
}