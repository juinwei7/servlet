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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("admin") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        req.setCharacterEncoding("UTF-8");


        Map<String, String[]> userInfo = req.getParameterMap();
        if (userInfo.size() != 6) {
            seedToSer(req, resp);
            return;
        }

        String inputName = req.getParameter("inputName");
        String inputGender = req.getParameter("inputGender");
        String inputAge = req.getParameter("inputAge");
        String inputAdderss = req.getParameter("inputAdderss");
        String inputPhone = req.getParameter("inputPhone");
        String inputEmail = req.getParameter("inputEmail");

        User user = new User();
        user.setName(inputName);
        user.setGender(inputGender);
        user.setAge(Integer.parseInt(inputAge));
        user.setAddress(inputAdderss);
        user.setPhone(inputPhone);
        user.setEmail(inputEmail);

        UserService userService = new UserServiceImpl();
        if(userService.addUser(user)){
            resp.sendRedirect(req.getContextPath() + "/UserListServlet");
        }else {
            req.setAttribute("error_msg", "email已重複，請換一個");
            seedToSer(req, resp);
        }

    }

    public void seedToSer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("address", Address.getAddressLines());
        req.getRequestDispatcher("/Web-Jsp/register.jsp").forward(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
