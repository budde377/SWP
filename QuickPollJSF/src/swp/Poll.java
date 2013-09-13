package swp;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.bean.ApplicationScoped;
import java.io.Serializable;
import java.io.IOException;

@ManagedBean
@ApplicationScoped
public class Poll implements Serializable {
	private String question;
	private int yes;
	private int no;
	private String vote;
	
	public void checkQuestion() throws IOException{
		if(question == null) {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	        ec.redirect(ec.getRequestContextPath());
		}
	}
	public String getVote() {
		return vote;
	}
	public void setVote(String vote) {
		this.vote = vote;
	}
	public int getYes() {
		return yes;
	}
	public synchronized String decideVote() {
		if("yes".equals(vote)) {
			yes++;
			return "VOTE";
		} else if ("no".equals(vote)) {
			no++;
			return "VOTE";
		}
		return "NOVOTE";
	}
	public String setup() {
		no = 0;
		yes = 0;
		return "DONE";
	}
	public void setYes(int yes) {
		this.yes = yes;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getQuestion() { 
		return question; 
	}
	public void setQuestion(String question) { 
		this.question = question; 
	}
}