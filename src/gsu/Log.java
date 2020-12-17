package gsu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Log {

    private final List<String> subscribers = new ArrayList<>();

    public void addSubscriber(String path){
        this.subscribers.add(path);
    }

    public void deleteSubscriber(String path){
        this.subscribers.remove(path);
    }

    public void writeAction(String data){

        int countOfSubscribers = subscribers.toArray().length;

        if (countOfSubscribers > 0){
            ThreadWriter[] threadWriters = new ThreadWriter[countOfSubscribers];

            for (int i = 0; i < countOfSubscribers; i++) {
                threadWriters[i] = new ThreadWriter(data, "src/gsu/logs/"+subscribers.get(i) + getTime() + ".txt");
            }

            for (ThreadWriter threadWriter : threadWriters) {
                threadWriter.start();
            }
        }
    }

    private String getTime(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(cal.getTime()) ;
    }

}
