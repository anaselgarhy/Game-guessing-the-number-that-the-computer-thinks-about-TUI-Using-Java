package mainPackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final short levelLimit = 50;
        short score = 0, highestScore=0, estimatedNumber, attemptsNumber=0, missedTimes=0, level=1;
        short randomNumber, startNumber, endNumber;
        //Main loop
        do{
            startNumber = Functions.setNumber(level);
            endNumber = Functions.setNumber(level, startNumber);
            randomNumber = Functions.setRandomNumber(startNumber, endNumber); // Generate random number between startNumber and endNumber

            // لقد فكرت في رقم بين [startNumber ]  و [endNumber ]  هل تمتلك الذكاء الكافي لتخمينه في اقل عدد من المرات ؟
            System.out.printf("I thought about a number between %d and %d. Do you have the intelligence to guess the few times?\n", startNumber-2, endNumber+2);
            System.out.println("Type -1 to exit");
            // Child loop
            while(true)
            {
                // Read Estimated Number
                System.out.print("> ");
                try {
                    estimatedNumber = new Scanner(System.in).nextShort();
                } catch(InputMismatchException iex) {
                    System.out.println("The input value not a valid number!");
                    return;
                }
                if(estimatedNumber == -1) // Exit
                {
                    switch((short) Math.floor(Math.random() * 3))
                    {
                        case 0 -> System.out.println("I knew that I would never find someone to care about what I think )':\nGoodbye >_");
                        case 1 -> System.out.println("I wanted you to play with me just a little bit ＞﹏＜");
                        case 2 -> System.out.println("You no longer love me ~(>_<。)＼");
                    }
                    System.exit(0);
                }
                // Check Estimated Number
                attemptsNumber++;
                if(estimatedNumber == randomNumber) // True
                {
                    // Calc score
                    if(attemptsNumber <= 4)
                        score += 50;
                    else if(attemptsNumber <= 8)
                        score += 35;
                    else if(attemptsNumber <= 10)
                        score += 20;
                    else if(attemptsNumber <= 15)
                        score += 10;
                    else
                        score = 5;
                    // Check highest score
                    highestScore = (score > highestScore) ? score:highestScore;

                    // set level
                    level = (score >= levelLimit)? ++level: level;

                    // Print the results
                    System.out.println("Yes indeed the number you thought about it " + estimatedNumber + "\n"
                                        + "You have tried " + attemptsNumber + " times to find the correct number" + "\n"
                                        + "The number of times you missed: " + missedTimes + "\n"
                                        + "Your score: " + score + "\t\tHighest Score: " + highestScore + "\n"
                                        + ((score >= levelLimit)? "Level up, " : "") + "Your level now: " + level + "\n"
                                        + "------------------------------------------------");
                    // Rest attempts number counter
                    attemptsNumber = 0;
                    break;
                }
                else // False
                {
                    missedTimes++;
                        score = (score >= 5 && attemptsNumber > 15)? (short) (score - 5) : score;
                    System.out.printf("The number I thought about is %s than the number you entered.\n",
                            ((estimatedNumber < randomNumber) ? "greater":"less"));
                }
            }
        } while(true);
    }
}
// The code was written by me n_n
// Programming is very, very fun 🖤