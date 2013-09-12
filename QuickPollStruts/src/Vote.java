import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Vote extends ActionSupport{
	private ArrayList<String> yesNo;
	private String vote;
	public ArrayList<String> getYesNo() {
		return yesNo;
	}

	public void setYesNo(ArrayList<String> yesNo) {
		this.yesNo = yesNo;
	}
	
	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}

	public String execute() {
		Map application = ActionContext.getContext().getApplication();
		if(application.get("question")==null)
			return "FATAL";
		if("yes".equals(getVote())) {
			application.put("yes",new Integer((Integer) application.get("yes") + 1));
			return "SUCCESS";
		} else if ("no".equals(getVote())) {
			application.put("no",new Integer((Integer) application.get("no") + 1));
			return "SUCCESS";
		}
		yesNo = new ArrayList<String>();
		yesNo.add("yes");
		yesNo.add("no");
		return "ERROR";
	}
}
