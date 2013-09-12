import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Results extends ActionSupport{
	
	private int total;
	private int yesLength;
	private int noLength;
	
	public String execute() {
		Map application = ActionContext.getContext().getApplication();
		if(application.get("question")==null)
			return "FATAL";
		int yes = (Integer)application.get("yes");
		int no = (Integer)application.get("no");
		total = yes + no;
		if(total == 0) 
			return "ERROR";
		if(total!=0) {
			yesLength=yes*300/total;
			noLength=no*300/total;
		}
		return "SUCCESS";
		
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getYesLength() {
		return yesLength;
	}

	public void setYesLength(int yesLength) {
		this.yesLength = yesLength;
	}

	public int getNoLength() {
		return noLength;
	}

	public void setNoLength(int noLength) {
		this.noLength = noLength;
	}


}
