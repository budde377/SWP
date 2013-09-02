import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if("/QuickPollJSPEdition/results".equals(req.getRequestURI())) {
			RequestDispatcher resultsView = req.getRequestDispatcher("QuickPollResults.jsp");
			req.setAttribute("question", getServletContext().getAttribute("question"));
			req.setAttribute("yes", getServletContext().getAttribute("yes"));
			req.setAttribute("no", getServletContext().getAttribute("no"));
		    resultsView.forward(req, resp);
		} else if ("/QuickPollJSPEdition/ask".equals(req.getRequestURI())) {
			RequestDispatcher askView = req.getRequestDispatcher("QuickPollAsk.jsp");
			req.setAttribute("question", getServletContext().getAttribute("question"));
		    askView.forward(req, resp);
		} else {
		    resp.setContentType("text/html");
		    PrintWriter out = resp.getWriter();
		    out.print("<html><head><title>QuickPoll</title></head><body>"+
		              "<h1>QuickPoll</h1>"+
		              "Your question has been registered. "+
		              "Let the vote begin!nkdsknfdsnanfdanflkanflakw"+
		              "</body></html>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if ("/QuickPollJSPEdition/setup".equals(req.getRequestURI())) {
		    String q = req.getParameter("question");
		    ServletContext c = getServletContext();
		    c.setAttribute("question", q);
		    c.setAttribute("yes", new Integer(0));
		    c.setAttribute("no", new Integer(0));
		    RequestDispatcher setupView = req.getRequestDispatcher("QuickPollSetup.jsp");
		    setupView.forward(req, resp);
		} else if("/QuickPollJSPEdition/vote".equals(req.getRequestURI())) {
			String vote = req.getParameter("vote");
		    ServletContext c = getServletContext();
		    if (vote.equals("yes")) {
		      int yes = ((Integer)c.getAttribute("yes")).intValue();
		      yes++;
		      c.setAttribute("yes", new Integer(yes));
		    } else if (vote.equals("no")) {
		      int no = ((Integer)c.getAttribute("no")).intValue();
		      no++;
		      c.setAttribute("no", new Integer(no));
		    }
		    RequestDispatcher voteView = req.getRequestDispatcher("QuickPollVote.jsp");
		    voteView.forward(req, resp);
		} else {
			//404
		}
		
	}
}
