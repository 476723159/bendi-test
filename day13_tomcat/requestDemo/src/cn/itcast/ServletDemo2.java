package cn.itcast;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;


@WebServlet("/servletDemo2")
public class ServletDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("");
        String username = request.getParameter("username");
       /* System.out.println(username);*/
        Map<String, String[]> map = request.getParameterMap();
        Set<String> keySet = map.keySet();
        /*for(String name:keySet){
            String[] strings = map.get(name);
            for (String value:strings) {
                System.out.println(value);
            }
        }*/
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("name","");
        for (int i = 0;i<=keySet.size();i++){
            System.out.println(keySet.iterator());
            String[] strings = map.get( keySet.iterator());
            for (int j = 0;j<=strings.length;j++){
                System.out.println(strings[j]);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
