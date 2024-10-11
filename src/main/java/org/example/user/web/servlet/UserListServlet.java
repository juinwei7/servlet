package org.example.user.web.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.user.domain.User;
import org.example.user.service.UserService;
import org.example.user.service.impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("admin") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        UserService service = new UserServiceImpl();

        int totoUserCount = service.totoUserCount();
        int limit = 10;
        int page = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
        int totoPage = totoUserCount / limit + (totoUserCount % limit == 0 ? 0 : 1);

        List<User> users = service.userByPage(page, limit);

        req.setAttribute("totoPage", totoPage);
        req.setAttribute("page", page);
        req.setAttribute("totoUserCount", totoUserCount);
        req.setAttribute("users", users);
        req.getRequestDispatcher("/Web-Jsp/UserList.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
