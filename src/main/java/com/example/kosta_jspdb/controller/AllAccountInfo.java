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
import java.util.List;

@WebServlet("/allAccountInfo")
public class AllAccountInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("user")==null){
            req.setAttribute("err", "로그인 하세요.");
            req.getRequestDispatcher("/bank/error.jsp").forward(req, res);
            return;
        }

        AccountService accountService = new AccountService();

        try{
            // 전체 계좌 가져오기 >> 전체 계좌가 3번이나 반복되서 출력되는 부분 수정 필요
            List<Account> accountList = accountService.accountList();
            req.setAttribute("accs", accountList);
            req.getRequestDispatcher("/bank/allAccountInfo.jsp").forward(req, res);
        }catch (Exception e){
            req.setAttribute("err", e.getMessage());
            req.getRequestDispatcher("/bank/error.jsp").forward(req, res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}