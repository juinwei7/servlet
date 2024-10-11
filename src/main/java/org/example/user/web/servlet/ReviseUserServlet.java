package org.example.user.web.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.user.domain.Address;
import org.example.user.domain.User;
import org.example.user.service.UserService;
import org.example.user.service.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet("/reviseUserServlet")
public class ReviseUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("admin") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }


        //用戶修改
        req.setCharacterEncoding("UTF-8");

        UserService userService = new UserServiceImpl();

        boolean goRg = req.getParameter("inputId") == null || req.getParameter("inputId").equals("");

        if (goRg) {
            int id = 0;
            id = Integer.parseInt(req.getParameter("id"));
            User user = userService.getUserById(id);

            req.setAttribute("address", Address.getAddressLines());
            req.setAttribute("user", user);
            req.getRequestDispatcher("/Web-Jsp/revise.jsp").forward(req, resp);
            return;
        }


        int id = Integer.parseInt(req.getParameter("inputId"));
        User user = userService.getUserById(id);
        if (userService.reviseUser(id, req.getParameterMap())){
            resp.sendRedirect(req.getContextPath() + "/UserListServlet");
        }else {
            req.setAttribute("address", Address.getAddressLines());
            req.setAttribute("user", user);
            req.setAttribute("error_msg", "資料更新失敗");
            req.getRequestDispatcher("/Web-Jsp/revise.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
