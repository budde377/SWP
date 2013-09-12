import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Setup extends ActionSupport{
	
	private String question;
	
	public String execute() {
		Map application = ActionContext.getContext().getApplication();
		application.put("question", getQuestion());
		application.put("yes",new Integer(0));
		application.put("no", new Integer(0));
		return "SUCCESS";
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
