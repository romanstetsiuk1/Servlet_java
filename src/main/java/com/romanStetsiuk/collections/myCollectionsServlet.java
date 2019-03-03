package com.romanStetsiuk.collections;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/collection")
public class myCollectionsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String temp;
        Map<String, String> firstLastName = new HashMap<>();

        init(firstLastName);

        resp.getWriter().print("<table>" +
                "<tr>" +
                "<th>First Name</th>" +
                "<th>Last Name</th>" +
                "</tr>");

        for (String key : firstLastName.keySet()) {
            resp.getWriter().print("<tr>");
            resp.getWriter().println("<td>" + key + "</td>");
            temp = firstLastName.get(key);
            resp.getWriter().println("<td>" + temp + "</td>");
            resp.getWriter().print("</tr>");
        }
        resp.getWriter().print("</table>");


    }

    private void init(Map<String, String> firstLastName) {
        firstLastName.put("first name 1", "last name 1");
        firstLastName.put("first name 2", "last name 2");
        firstLastName.put("first name 3", "last name 3");
        firstLastName.put("first name 4", "last name 4");
        firstLastName.put("first name 5", "last name 5");
        firstLastName.put("first name 6", "last name 6");
        firstLastName.put("first name 7", "last name 7");
        firstLastName.put("first name 8", "last name 8");
        firstLastName.put("first name 9", "last name 9");
        firstLastName.put("first name 10", "last name 10");
    }
}
