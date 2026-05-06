import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filePath = "C:\\Users\\smart\\Desktop\\I.A.F.F\\code music\\music wav\\semantics-by-tubebackr.wav";

        while(alarmTime == null){
            try{
                System.out.print("Enter an alarm time(HH:mm:ss): ");
                String inputTime = scanner.nextLine();

                //parsing inputTime
                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarm set for " + alarmTime);

            }
            catch(DateTimeParseException e){
                System.out.println("Invalid format");
                System.out.println("Please use HH:mm:ss");
            }
        }

        AlarmClock alarmClock = new AlarmClock(alarmTime, filePath, scanner);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();


    }
}