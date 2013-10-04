import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

public class Evaluate extends ActionSupport {
   public String execute()  {
	   
	   
     Map session = ActionContext.getContext().getSession();
     if(!session.get("token").equals(getToken())){
    	 return "INVALID_TOKEN";
     }
     int guesses = (Integer)session.get("guesses")+1;
     session.put("guesses",guesses);
     int secret = (Integer)session.get("secret");
     int number = Integer.parseInt(getNumber());
     if (number > secret) {
        setMessage("Your guess is too large, guess again");
        return "WRONG";
     }
     if (number < secret) {
        setMessage("Your guess is too small, guess again");
        return "WRONG";
     }
     Map application = ActionContext.getContext().getApplication();
     if (application.containsKey("hiscore")) {
       int hiscore = (Integer)application.get("hiscore");
       if (guesses < hiscore) return "HISCORE";
     } else return "HISCORE";
     return "GUESSED";
  }

  public void validate() {
    int n = 0;
    try {
      n = Integer.parseInt(getNumber());
    } catch (NumberFormatException e) {
      addFieldError("number","You must write a number");
      return;
    }
    if (n<1 || n>100) {
      addFieldError("number","Your number must be between 1 and 100");
    }
  }

  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  private String number;
  private String token;
 
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }
  
  public void setToken(String token){
	  this.token = token;
  }
  
  public String getToken(){
	  return token;
  }
}
