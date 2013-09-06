
public class CurrentQuestion implements java.io.Serializable{
	private int yes = 0, no = 0 ;
	private String question;
	
	public int getNo(){
		return no;
	}
	
	public int getYes(){
		return yes;
	}
	
	public int getTotal(){
		return yes+no;
	}
	
	public String getQuestion(){
		return question;
	}
	
	public void setQuestion(String question){
		this.question = question;
	}
	
	public void voteYes(){
		yes++;
	}
	
	public void voteNo(){
		no++;
	}

}
