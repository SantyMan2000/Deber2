package uce.edu.pa2.deber2;

import jakarta.inject.Singleton;

@Singleton
public class LoggerService {

    private int logs = 0;

    public void log(String mensaje) {
        logs++;
        System.out.println("LOG #" + logs + ": " + mensaje);
    }

    public int getTotalLogs() {
        return logs;
    }
}