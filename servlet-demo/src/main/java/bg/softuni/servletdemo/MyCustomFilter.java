package bg.softuni.servletdemo;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "MyCustomFilter",
    servletNames = "helloServlet")
public class MyCustomFilter implements Filter {

  public void init(FilterConfig config) throws ServletException {
  }

  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws ServletException, IOException {

    ((HttpServletRequest)request).getSession().setAttribute("name", "Pesho");

    chain.doFilter(request, response);
  }
}
