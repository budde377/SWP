import dk.brics.jwig.WebSite;
import guessinggame3.GuessingGame ;

/**
 * A minimal WebSite implementation that sets up a single web application
 */
public class Main extends WebSite {

    @Override
    public void init() {
        add(new GuessingGame());
    }
}
