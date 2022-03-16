package com.example.demo;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private int i;
    String paramName;
    String paramValue;
    public void init()
    {
        paramName = "myparam";
        paramValue = getServletConfig().getInitParameter(paramName);
        i=0;
        message = "Meh World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
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
//        i+=1;
//        out.println("<p> Licznik: "+ i + "</p>");
//        out.println("<p> Server init param: " + paramValue + "</p>");


        //// ciasteczka
        HttpSession session = request.getSession(true);
        Boolean loggedIn = (Boolean)session.getAttribute("zalogowany");
        String action =request.getParameter("akcja");
        if(action!=null){
            if(action.equals("wyloguj")){
                Boolean wartosc = false;
                session.setAttribute("zalogowany", wartosc);
            }
        }
        if(loggedIn == null){
            loggedIn=false;
        }
        if(loggedIn==true){
            /// zalogowany
            out.println("<h1>ZALOGOWANY</h1>");
            out.println("<form method = \"get\">");
            out.println("<input type =\"hidden\" name = \"akcja\" value=\"wyloguj\" />");
            out.println("<input type = \"submit\" value = \"Wyloguj\" />");
            out.println("</form>");
        }
        else{
            ///niezalogowany
            out.println("<form method=\"get\">");
            out.println("<input type =\"text\" name = \"user\"/>");
            out.println("<input type =\"password\" name = \"pass\"/>");
            out.println("<input type =\"submit\" value = \"zaloguj\"/>");
            out.println("</form>");
            String user;
            String pass;
            user = request.getParameter("user");
            pass =request.getParameter("pass");
            if(user!=null && pass!=null){
                if(user.equals("mioszek") && pass.equals("paproszek")){
                    loggedIn=true;
                    session.setAttribute("zalogowany", loggedIn);
                }
            }
        }
        Cookie[] cookies = request.getCookies();
        Cookie licznik = null;
        if(cookies!=null){
            for(int i=0; i<cookies.length; i++){
                if(cookies[i].getName().equals("licznik")) {
                    licznik = cookies[i];
                    break;
                }
            }
        }
        if(licznik==null){
            licznik=new Cookie("licznik", "0");
        }else{
            Integer v = Integer.parseInt(licznik.getValue());
            v++;
            licznik.setValue(v+"");
        }
        licznik.setMaxAge(24*60*60);
        response.addCookie(licznik);

        out.println(licznik.getValue());
    }

    public void destroy() {
    }
}