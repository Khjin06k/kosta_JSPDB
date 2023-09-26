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

@WebServlet("/deposit")
public class Deposit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("user")==null){
            req.setAttribute("err", "로그인 하세요.");
            req.getRequestDispatcher("/bank/error.jsp").forward(req, res);
            return;
        }
        req.getRequestDispatcher("/bank/deposit.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        // 입력받은 값 가져오기
        String id = req.getParameter("id");
        Integer money = Integer.parseInt(req.getParameter("money"));

        // 세션에 저장된 회원 정보 가져오기
        HttpSession session = req.getSession();
        Member member = (Member)session.getAttribute("user");

        // 로직을 처리할 서비스 사용
        AccountService accountService = new AccountService();

        try{
            // 값을 넘겨 계좌번호 및 회원관련 조회 진행
            Account acc = accountService.accountDeposit(id, money, member);
            // 수정된 계좌 정보 업데이트
            req.setAttribute("acc", acc);
            req.getRequestDispatcher("/bank/accountInfo.jsp").forward(req, res);
        }catch (Exception e){
            req.setAttribute("err", e.getMessage());
            req.getRequestDispatcher("/bank/error.jsp").forward(req, res);
        }
    }
}