package TopTrumpsApp;

/**
 * Abstract class used solely for launching the app.
 * @author Liam Hurley
 */

public abstract class TopTrumpsDriver {
    public TopTrumpsDriver(){
    }

    public static void main(String[] args) {
        new TopTrumpsMenu();
    }
}
