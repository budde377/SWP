import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

public class Update extends ActionSupport {
   public String execute()  {
     Map session = ActionContext.getContext().getSession();
     int guesses = (Integer)session.get("guesses");
     Map application = ActionContext.getContext().getApplication();
     application.put("hiscore",guesses);
     application.put("hiname",name);
     return "SUCCESS";
  }

  private String name;
 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
