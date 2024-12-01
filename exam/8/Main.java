import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class Main extends HttpServlet {
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String name = req.getParameter("name");
    resp.setContentType("text/html");
    resp.getWriter().println("<h1>Hello, " + name + "!</h1>");
  }
}
