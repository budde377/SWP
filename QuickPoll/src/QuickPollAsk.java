import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ask")

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
              "<input type=submit name=submit value=Vosete>"+
              "</form>"+
              "</body></html>");
  }
}
