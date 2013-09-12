package swp;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;


public class RequestListener implements PhaseListener{
	@ManagedProperty("#{poll}")
	private Poll poll;

	@Override
	public void afterPhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		if(poll.getQuestion()==null) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
													  "Illegal access to page.",
													  "The vote and results page can't be accessed before a question i posed."));
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.APPLY_REQUEST_VALUES;
	}

}
