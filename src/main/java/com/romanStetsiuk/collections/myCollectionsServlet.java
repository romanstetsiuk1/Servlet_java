package com.romanStetsiuk.collections;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet("/collection")
public class myCollectionsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestParametr = req.getParameter("sort");
        PrintWriter out = resp.getWriter();
        Map<String, String> firstLastName = new HashMap<>();
        Map<String, String> result = new LinkedHashMap<>(firstLastName);

        init(firstLastName);

        if (requestParametr != null) {
            if (requestParametr.equals("r")) {
                firstLastName.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey())
                        .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
            } else if (requestParametr.equals("m")) {
                firstLastName.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                        .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
            }
        } else {
            firstLastName.forEach((k, v) -> result.put(k, v));
        }

        resp.getWriter().print("<table>" +
                "<tr>" +
                "<th>First Name</th>" +
                "<th>Last Name</th>" +
                "</tr>");

        result.forEach((k, v) -> {
            out.println("<tr>");
            out.println("<td>" + k + "</td>");
            out.println("<td>" + v + "</td>");
            out.println("</tr>");
        });

//        if (requestParametr.equals("r")) {
//            SortedSet<String> sortUp = new TreeSet<>(firstLastName.keySet());
//            for (String keyVal : sortUp) {
//                writeHtmlTable(resp, firstLastName, keyVal);
//            }
//        }

//        if (requestParametr.equals("m")) {
//            Map<String, String> sortDown = new LinkedHashMap<>();
//            firstLastName.entrySet().stream()
//                    .sorted(Map.Entry.<String, String>comparingByKey().reversed())
//                    .forEachOrdered(x -> sortDown.put(x.getKey(), x.getValue()));
//            for (String key : sortDown.keySet()) {
//                writeHtmlTable(resp, sortDown, key);
//            }
//        }

        resp.getWriter().print("</table>");

    }

//    private void writeHtmlTable(HttpServletResponse resp, Map<String, String> firstLastName, String keyVal) throws IOException {
//        String temp;
//        resp.getWriter().print("<tr>");
//        resp.getWriter().println("<td>" + keyVal + "</td>");
//        temp = firstLastName.get(keyVal);
//        resp.getWriter().println("<td>" + temp + "</td>");
//        resp.getWriter().print("</tr>");
//    }

    private void init(Map<String, String> firstLastName) {
        firstLastName.put("first name q", "last name 1");
        firstLastName.put("first name w", "last name 2");
        firstLastName.put("first name e", "last name 3");
        firstLastName.put("first name r", "last name 4");
        firstLastName.put("first name t", "last name 5");
        firstLastName.put("first name y", "last name 6");
        firstLastName.put("first name u", "last name 7");
        firstLastName.put("first name i", "last name 8");
        firstLastName.put("first name o", "last name 9");
        firstLastName.put("first name p", "last name 10");
        firstLastName.put("first name ap", "last name 11");
        firstLastName.put("first name sp", "last name 12");
        firstLastName.put("first name dp", "last name 13");
        firstLastName.put("first name fp", "last name 14");
        firstLastName.put("first name gp", "last name 15");
        firstLastName.put("first name hp", "last name 16");
        firstLastName.put("first name jp", "last name 17");
        firstLastName.put("first name kp", "last name 18");
        firstLastName.put("first name lp", "last name 19");
        firstLastName.put("first name zp", "last name 20");
    }
}
