import java.util.Timer;
import java.util.TimerTask;
public class TimerTest {

    public static void main(String[] args) {
        long checkTime = 1000;
        ItemCheckQuery query = new ItemCheckQuery();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

                @Override
                public void run() {
                    query.getChecks(new ItemList());
                }
            }, 0, checkTime);
    }

}