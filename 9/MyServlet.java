import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();

    // Get form data
    String name = req.getParameter("name");
    String email = req.getParameter("email");

    // Display a response
    out.println("<h2>Form Submitted Successfully!</h2>");
    out.println("<p>Name: " + name + "</p>");
    out.println("<p>Email: " + email + "</p>");
    out.close();
  }
}
