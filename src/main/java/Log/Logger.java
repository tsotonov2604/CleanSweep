package log;

import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public final class Logger {
    private static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
    private static final String ROOT_PATH = "Log/";
    private static final String MAIN_LOG_NAME = "MainLog.txt";
    private static final Logger instance = new Logger();

    private Logger(){}

    public static Logger getInstance() {
        return instance;
    }

    private static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }

    public static void writeToBatteryLog(double battery)
    {
        try{
            String filesub = "BatteryLog.txt";
            String output = "Clean Sweep battery status is "+battery+".";
            writeToLogs(output, "Battery", filesub);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void writeToDirtCapacityLog(int currentDirt,int maxDirt)
    {
        try{
            String filesub = "DirtCapacityLog.txt";
            String output = "Clean Sweep is cleaning dirt("+currentDirt+"/"+maxDirt+").";
            writeToLogs(output, "Dirt", filesub);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void writeToNavigationSensorLog(int x, int y)
    {
        try{
            String filesub = "NavigationSensorLog.txt";

            String output = "Clean Sweep at tile ("+x+","+y+").";
            writeToLogs(output, "NAVIGATION", filesub);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void writeToLogs(String output, String eventType, String subLogPath)
    {
        try{
            FileWriter fwm = null;
            FileWriter fws = null;

            String time=now();
            output = time + " " + eventType + " : " + output;

            File filemain = new File(ROOT_PATH + MAIN_LOG_NAME);
            writeToFile(filemain, output);

            if(subLogPath != null) {
                File filesub = new File(ROOT_PATH + subLogPath);
                writeToFile(filesub, output);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void writeToFile(File file, String output)
    {
        FileWriter fileWriter = null;

        try
        {
            if (file.exists()) {
                fileWriter = new FileWriter(file, true);
            } else {
                file.getParentFile().mkdirs();
                file.createNewFile();
                fileWriter = new FileWriter(file);
            }
            fileWriter.append(System.lineSeparator());
            fileWriter.append(output);
            fileWriter.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

}