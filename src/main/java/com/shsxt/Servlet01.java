package com.shsxt;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Servlet01 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String uname = req.getParameter("uname");
        String pwd = req.getParameter("password");
        System.out.println(uname);

        //请求转发,跳转页面
        if (uname.equals("admin")&&pwd.equals("123456")){
            req.setAttribute("uname",uname);
            //req.getAttribute("uname");
            req.getRequestDispatcher("login_success.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("login_error.jsp").forward(req,resp);

            //resp.sendRedirect("login_error.jsp");
        }
    }
}
