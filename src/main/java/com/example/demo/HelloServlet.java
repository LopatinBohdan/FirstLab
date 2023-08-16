package com.example.demo;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.naming.spi.DirStateFactory;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");

        try{
            String url="jdbc:mysql://localhost:3306/notesDB";
            String username="root";
            String password="";
            Class.forName("com.mysql.jdbc.Driver");
            try(Connection conn= DriverManager.getConnection(url,username,password)){
//                String sqlCommand="CREATE TABLE notes (id INT PRIMARY KEY AUTO_INCREMENT,\n" +
//                        "manufacturer VARCHAR(20),\n" +
//                        "title VARCHAR(20),\n" +
//                        "pages INT,\n" +
//                        "cover BOOLEAN,\n" +
//                        "country VARCHAR(20),\n" +
//                        "look VARCHAR(20)\n" +
//                        ")";


//                String sqlCommand="INSERT notes (manufacturer, title, pages, cover, country, look)\n" +
//                        "    VALUES ('manufacturer11', 'title11', 111,0,'country1','cells'),\n" +
//                        "    ('manufacturer11', 'title2', 222,1,'country5','lines'),\n" +
//                        "    ('manufacturer22', 'title3', 333,0,'country6','cells'),\n" +
//                        "    ('manufacturer11', 'title4', 444,1,'country7','lines');";


                //String sqlCommand="SELECT * FROM notes";
//                ResultSet set= statement.executeQuery(sqlCommand);
//
//                PrintWriter out=response.getWriter();
//                out.println("<html><body>");
//                while (set.next()){
//                    int id= set.getInt("id");
//                    String manufacturer= set.getString("manufacturer");
//                    String title= set.getString("title");
//                    int pages= set.getInt("pages");
//                    boolean cover= set.getBoolean("cover");
//                    String country= set.getString("country");
//                    String look= set.getString("look");
//
//                    message =id+" | "+ manufacturer+" | "+title+" | "+pages+ " | "+cover+ " | "+country+
//                            " | "+look;
//                    out.println("<p>"+message+"</p>");
//
//                }



                //String sqlCommand="SELECT country FROM notes";
//                String sqlCommand="SELECT country, COUNT(id) AS amount\n" +
//                        "FROM notes\n" +
//                        "GROUP BY country";


//                String sqlCommand="SELECT country, COUNT(id) AS amount\n" +
//                        "FROM notes\n" +
//                        "GROUP BY country\n" +
//                        "ORDER BY amount DESC LIMIT 1;";

//                String sqlCommand="SELECT country, COUNT(id) AS amount\n" +
//                        "FROM notes\n" +
//                        "GROUP BY country\n" +
//                        "ORDER BY amount ASC LIMIT 1;";

//                String sqlCommand="SELECT manufacturer, COUNT(id) AS amount\n" +
//                        "FROM notes\n" +
//                        "GROUP BY manufacturer\n" +
//                        "ORDER BY amount DESC LIMIT 1;";

//                String sqlCommand="SELECT manufacturer, COUNT(id) AS amount\n" +
//                        "FROM notes\n" +
//                        "GROUP BY manufacturer\n" +
//                        "ORDER BY amount ASC LIMIT 1;";


//                String sqlCommand="SELECT *\n" +
//                        "FROM notes\n" +
//                        "WHERE cover=0;";


//                String sqlCommand="SELECT *\n" +
//                        "FROM notes\n" +
//                        "WHERE cover=1;";


//                String sqlCommand="SELECT *\n" +
//                        "FROM notes\n" +
//                        "WHERE country=\"country1\";";


//                String sqlCommand="SELECT *\n" +
//                        "FROM notes\n" +
//                        "WHERE look=\"cells\";";

//                String sqlCommand="SELECT *\n" +
//                        "FROM notes\n" +
//                        "WHERE pages>300;";


//                String sqlCommand="UPDATE notes\n" +
//                        "SET country=\"New Country\"\n" +
//                        "WHERE id=4;";


                String sqlCommand="DELETE FROM notes\n" +
                        "WHERE id=5;";


                PrintWriter out=response.getWriter();
                Statement statement= conn.createStatement();
                //ResultSet set= statement.executeQuery(sqlCommand);
                statement.execute(sqlCommand);

                out.println("<html><body>");
//                while (set.next()){
//                    int id= set.getInt("id");
//                    String manufacturer= set.getString("manufacturer");
//                    String title= set.getString("title");
//                    int pages= set.getInt("pages");
//                    boolean cover= set.getBoolean("cover");
//                    String country= set.getString("country");
//                    String look= set.getString("look");
//
//                    message =id+" | "+ manufacturer+" | "+title+" | "+pages+ " | "+cover+ " | "+country+
//                            " | "+look;
//                    out.println("<p>"+message+"</p>");
//
//                }
                message="Delete completed";
                out.println("<p>"+message+"</p>");
                out.println("</body></html>");
            }
        }
        catch(Exception e){
            PrintWriter out=response.getWriter();
            out.println("<html><body>");
            out.println("<h1>"+e.getMessage()+"</h1>");
            out.println("</body></html>");
        }

    }

    public void destroy() {
    }
}