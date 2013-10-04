import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

import java.util.Random;
import java.util.Map;
import java.util.UUID;

public class Start extends ActionSupport {
    public String execute()  {
      Map session = ActionContext.getContext().getSession();
      session.put("guesses",0);
      session.put("secret",new Random().nextInt(100)+1);
      session.put("token", UUID.randomUUID().toString());
      return "SUCCESS";
    }

    private String message = "Guess a number between 1 and 100";

    public String getMessage() {
      return message;
   }
}
