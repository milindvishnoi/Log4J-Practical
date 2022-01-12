import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class VulnerableApp {
    public static void main(String[] args){
//        System.out.println("Hello");
        Logger logger = LogManager.getLogger(VulnerableApp.class);
        Scanner scanner = new Scanner(System.in);
        while(true){
        System.out.println("Feedback?");
        String feedbackText = scanner.nextLine();
        System.out.println(feedbackText);
        try {
            logger.error("Someone had this to say: " + feedbackText);
        } catch (Exception e){
            e.printStackTrace();
        }
        }
    }
}


