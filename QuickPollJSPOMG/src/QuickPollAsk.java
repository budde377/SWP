import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ask")
<<<<<<< HEAD

=======
>>>>>>> 73ac21c6991dbbb6e957adf6e289e870378d9553
public class QuickPollAsk extends HttpServlet {
  public void doGet(HttpServletRequest request, 
                    HttpServletResponse response)
      throws IOException, ServletException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.print("<html><head><title>QuickPoll</title></head><body>"+
              "<h1>QuickPoll</h1>"+
              "<form method=post action=vote>");
    String question = 
      (String)getServletContext().getAttribute("question");
    out.print(question+"?<p>");
    out.print("<input name=vote type=radio value=yes> yes<br>"+
              "<input name=vote type=radio value=no> no<p>"+
              "<input type=submit name=submit value=Vote>"+
              "</form>"+
              "</body></html>");
  }
}
