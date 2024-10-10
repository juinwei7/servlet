package org.example.user.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.user.domain.User;
import org.example.user.service.UserService;
import org.example.user.service.impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService service = new UserServiceImpl();
        List<User> users = service.findAll();

        req.setAttribute("users", users);
        req.getRequestDispatcher("/Web-Jsp/UserList.jsp").forward(req, resp);

//        for (User user : users) {
//            System.out.println(user.toString());
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
