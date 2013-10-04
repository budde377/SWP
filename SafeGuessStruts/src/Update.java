import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

public class Update extends ActionSupport {
   public String execute()  {
     Map session = ActionContext.getContext().getSession();
     if(!session.get("token").equals(getToken())){
    	 
    	 return "INVALID_TOKEN";
     }
     int guesses = (Integer)session.get("guesses");
     Map application = ActionContext.getContext().getApplication();
     application.put("hiscore",guesses);
     application.put("hiname",name);
     return "SUCCESS";
  }

  private String name;
  private String token;
 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public void setToken(String token){
	  this.token = token;
  }
  
  public String getToken(){
	  return token;
  }
  
}
