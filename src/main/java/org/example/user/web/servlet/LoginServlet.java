package org.example.user.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.user.domain.Admin;
import org.example.user.service.AdminService;
import org.example.user.service.impl.AdminServiceImpl;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String account = req.getParameter("account");
        String password = req.getParameter("password");

        if (account == null || password == null || account.isEmpty() || password.isEmpty()) {
            req.getRequestDispatcher("/Web-Jsp/login.jsp").forward(req, resp);
            return;
        }

        // 創建 AdminServiceImpl 的實例
        AdminService adminService = new AdminServiceImpl();

        Admin admin = adminService.getAdmin(account, password);

        if (admin == null) {
            req.setAttribute("login_msg", "帳號或密碼錯誤");
            req.getRequestDispatcher("/Web-Jsp/login.jsp").forward(req, resp);
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("admin", admin);
        resp.sendRedirect(req.getContextPath()+"/Web-Jsp/serachUser.jsp");




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}