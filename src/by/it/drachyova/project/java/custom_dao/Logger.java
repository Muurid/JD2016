package by.it.drachyova.project.java.custom_dao;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class Logger {
    private static Logger loggerInstance;

    private Logger() {

    }

    public static Logger getLoggerInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Logger();
        }
        return loggerInstance;
    }

    public void WriteToLog(String message) {

        String src = System.getProperty("user.dir") + "/src/by/it/";
        String filename = src + "drachyova/project/log.txt";
        DateFormat dateFormat;
        Date date = new Date();
        dateFormat = DateFormat.getDateTimeInstance();
        File logFile = new File(filename);
        try (FileWriter writeFile = new FileWriter(logFile, true)) {
            String mistake = dateFormat.format(date) + " " + message + "\n";
            writeFile.append(mistake);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
