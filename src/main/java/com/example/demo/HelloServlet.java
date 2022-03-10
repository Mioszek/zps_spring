package com.example.demo;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private int i;
    public void init()
    {
        i=0;
        message = "Meh World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
//        String methodName = request.getMethod();
//        String remoteAddr = request.getRemoteAddr();
//        String serverName = request.getServerName();
//        String headerAccept= request.getHeader("Accept");
//        String headerAcceptLanguage = request.getHeader("Accept-Language");
//        String headerAcceptEncoding = request.getHeader("Accept-Encoding");
//        String headerUserAgent = request.getHeader("User-Agent");
//        out.println("<p>" + methodName + "</p>");
//        out.println("<p>" + remoteAddr + "</p>");
//        out.println("<p>" + serverName + "</p>");
//        out.println("<p>" + headerAccept + "</p>");
//        out.println("<p>" + headerAcceptLanguage + "</p>");
//        out.println("<p>" + headerAcceptEncoding + "</p>");
//        out.println("<p>" + headerUserAgent + "</p>");
//
////        String name = request.getParameter("imie");
////        String age = request.getParameter("wiek");
////        out.println("<p>" + name + "</p>");
////        out.println("<p>" + age + "</p>");
////        out.println("</body></html>");
//        String firstNumber = request.getParameter("x");
//        String secondNumber = request.getParameter("y");
//        int x = Integer.parseInt(firstNumber);
//        int y = Integer.parseInt(secondNumber);
//        out.println("<p> wynik dodawania = " + x + "+" + y +"=" + (x+y) + "</p>");
//
        i+=1;
        out.println("<p> Licznik: "+ i + "</p>");
    }

    public void destroy() {
    }
}