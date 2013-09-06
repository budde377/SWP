import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns={"/vote","/setup"})

public class Controller extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ServletContext c = getServletContext();
		CurrentQuestion q;
		if((q = (CurrentQuestion) c.getAttribute("currentQuestion")) == null){
			c.setAttribute("currentQuestion", q = new CurrentQuestion());
		}
		if(request.getRequestURI().endsWith("vote")){
			String v = request.getParameter("vote");
			if(v.equals("yes")){
				q.voteYes();
			} else if (v.equals("no")){
				q.voteNo();
			}
			request.getRequestDispatcher("/QuickPollVote.jsp").forward(request, response);
		} else if(request.getRequestURI().endsWith("setup")){
			q.setQuestion(request.getParameter("question"));
			request.getRequestDispatcher("/QuickPollSetup.jsp").forward(request, response);
		}
		
	}
	

}
