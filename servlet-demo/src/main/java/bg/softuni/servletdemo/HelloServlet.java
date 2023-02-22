package bg.softuni.servletdemo;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

  public void doGet(HttpServletRequest request,
      HttpServletResponse response) throws IOException {

    var name = request.getSession().getAttribute("name");

    response.setContentType("text/html");


    // Hello
    PrintWriter out = response.getWriter();

    out.println("<html><body>");
    out.println("<h1>Hello, " + (name != null ? name : "Anonymous")  + "!</h1>");
    out.println("</body></html>");
  }

  public void destroy() {
  }
}