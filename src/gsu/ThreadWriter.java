package gsu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ThreadWriter extends Thread {

    private String data;
    private String path;

    public ThreadWriter(String data, String path){
        System.out.println("Thread " + path + " created");
        this.data = data;
        this.path = path;
    }

    @Override
    public void run() {
        System.out.println("Thread " + path + " started!");
        try {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
                bufferedWriter.write(data);
            }
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }
}
