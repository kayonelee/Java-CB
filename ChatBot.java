package ChatB;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class ChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        int countTo = 0;
        LocalDate birthdate = null;

        greetUser();
        repeat();
        guessAge();
        birthdate = askForBirthdate(scanner);
        int age = calculateAge(birthdate);
        System.out.println("More than likely your age is " + age );
        countTo = countToNumber(scanner);
        days();
        scanner.close();
    }

//    STEP 1: GREETING THE USER & ASKING FOR THEIR NAME THE FIRST TIME
    public static void greetUser() {
        Scanner scanner  = new Scanner (System.in);
        System.out.println("Hello world! What's your name?");
        String name = scanner.nextLine();
    }
//    STEP 2: ASKING USER TO REPEAT THEIR NAME, THEN GREET THEM BY THEIR NAME
    public static void repeat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sorry, can you type your name again?");
        String name2 = scanner.nextLine();
        System.out.println("Thank You for repeating that " + name2 + " !! ");
    }

//STEP 3: QUESTIONS- ASK FOR WHAT YEAR USER IS BORN, PRINT STATEMENT WITH ESTIMATED AGE/GENERATION
    public static void guessAge() {
        System.out.println("Can I guess your age? I'll need some help, what year were you born?");

        Scanner scanner = new Scanner (System.in);
        int year = scanner.nextInt();

        if (year >= 2010) {
            System.out.println("Ok....you're probably a Gen Alpha, under 10 years of age");
        }
        else if (year >= 1997 && year < 2009) {
            System.out.println("Ok....you're probably a Gen Z, around 11-26 of age ");
        }
        else if (year >= 1981 && year < 1996){
            System.out.println("Ok....you're probably a Millennial, around 27-42 of age");
        }
        else if (year >= 1965 && year < 1980) {
            System.out.println("Ok....you're probably a Gen X, around 43-58 of age");
        }
        else {
            System.out.println("You're most likely a Baby Boomer or Silent Generation, 59+ of age");
        }
    }
//-ASKING FOR BIRTHDATE FROM USER THEN PARSING
        public static LocalDate askForBirthdate(Scanner scanner) {
        System.out.println("What is your birthdate? (YYYY-MM-DD)");
        String birthdateString = scanner.nextLine();
        LocalDate birthdate = LocalDate.parse(birthdateString);
        return birthdate;
    }
//- CALCULATING AGE USING BIRTHDATE AND THE CURRENT DATE
    public static int calculateAge(LocalDate birthdate) {
        LocalDate now = LocalDate.now();
        Period period = Period.between(birthdate, now);
        int age = period.getYears();
        return age;
    }

//STEP 4: ASK USER FOR A NUMBER, PRINT AND SHOW COUNT
    public static int countToNumber(Scanner scanner) {
        System.out.println("Want to see me count? Give me a random number:");
        int countTo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Here goes nothing, I'll count up to " + countTo );
        for (int i = 1; i <= countTo; i++) {
            System.out.println(i);
        }
        return countTo;
    }

//STEP 5: MULTIPLE CHOICE + LOOP + ACCEPTING CORRECT ANSW
    public static int testProgrammingKnowledge(Scanner scanner) {
        System.out.println("(POP QUIZ!!) Stiegler Ed Tech was named in honor of:");
        System.out.println("A. Hector Stiegler Gonzalez");
        System.out.println("B. Pasha Stiegler Maher");
        System.out.println("C. Rick Stiegler");
        System.out.println("D. Tariq Stiegler");
        while (true) {
            String answer = scanner.nextLine().toUpperCase();
            if (answer.equals("C")) {  //    THIS IS THE CORRECT ANSWER
                System.out.println("That's correct!!!!!!!");
                break;
            } else if (answer.equals("A") || answer.equals("B") || answer.equals("D")) {
                System.out.println("Sorry, Please try again!"); //PRINT THIS- IF "C" NOT PICKED
            } else {
                System.out.println("You must select (A, B, C, or D)!"); //PRINT THIS- IF RESPONSE NOT VALID
            }
        }
        return 0;
    }

//LEVEL 3-----Use a switch statement to output a phrase that the bot enjoys about each day of the week.
    public static void days() {

            Scanner scanner = new Scanner (System.in);

            System.out.println("Want to know my mood for the week? Select a number representing each day of the week (1-7)");
            int day = scanner.nextInt();

            switch (day) {
                case 1:
                    System.out.println("SO SAD Sunday");
                    break;
                case 2:
                    System.out.println("MISERABLE Monday ");
                    break;
                case 3:
                    System.out.println("TACO Tuesday!");
                    break;
                case 4:
                    System.out.println("WE ALMOST THERE Wednesday");
                    break;
                case 5:
                    System.out.println("THOUGHTFUL Thursday");
                    break;
                case 6:
                    System.out.println("FRI-YAY Friday");
                    break;
                case 7:
                    System.out.println("SLEEP IN Saturday");
                    break;
                default:
                    System.out.println("Don't worry, I have my days messed up too. We will end ChatBot early. Goodbye!");
            }
    }
}
