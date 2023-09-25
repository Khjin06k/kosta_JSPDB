package com.example.kosta_jspdb.servlet;

import com.example.kosta_jspdb.dto.Member;
import com.example.kosta_jspdb.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/join")
public class Join extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/join.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        Member member = new Member(id, name, password, email, address);

        MemberService service = new MemberService();
        service.join(member);
        req.getRequestDispatcher("/login.jsp").forward(req, res);

    }
}