import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SystemIO extends BuildUp{
    static Scanner scan = new Scanner(System.in);
    static boolean enter = false;
    static String[] pto1 = new String[18];
    static String[] pto2 = new String[18];
    static String[] pto3 = new String[18];
    static String[] pto4 = new String[18];
    static String[] pto5 = new String[18];
    static String[] pto6 = new String[18];
    static String[] pto7 = new String[18];
    static String accepted;
    static String Mondayw1 = "'POC Beta'!J";
    static String Wednesdayw1 = "'POC Beta'!K";
    static String Thursdayw2 = "'POC Beta'!L";
    static String Fridayw1 = "'POC Beta'!L";
    static String Fridayw2 = "'POC Beta'!M";

    static void firstInteraction(){
        while (!enter) {
            System.out.println("Do you want to start the build validation process? yes or no");
            try {
                accepted = scan.nextLine().toLowerCase();

                if (accepted.equals("yes")) {
                    System.out.println("Let's start by entering the PTO's for week 1");
                    enterPTOWeek1("w1");
                    System.out.println("Let's start by entering the PTO's for week 2");
                    enterPTOWeek1("w2");
                    enter = true;
                } else if (accepted.equals("no")) {
                    System.out.println("Quitting the application");
                    System.exit(0);
                    enter = true;
                } else {
                    System.out.println("You've entered something else. Try again");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter yes or no :)");
            }
        }
    }
    //Accepts w1 & w2
    static void enterPTOWeek1(String week) {
        boolean isTrue = false;
        boolean isTrue2;
        int i;
        String answer;

        //Monday//
        while (!isTrue) {
            i = 0;
            try {
                System.out.println("Is there someone in PTO on Monday? yes or no");
                answer = scan.nextLine();
                if (answer.equals("yes")) {
                    System.out.println("Please add the colleague");
                    if(week =="w1"){
                        pto1[i] = scan.nextLine();
                    }else if(week =="w2"){
                        pto4[i] = scan.nextLine();
                    }
                    i++;
                    isTrue2 = false;

                    while (!isTrue2) {
                        System.out.println("Is there someone else in PTO on Monday? yes or no");
                        answer = scan.nextLine().toLowerCase();
                        if (answer.equals("yes")) {
                            System.out.println("Please add the colleague");
                            if(week == "w1"){
                                pto1[i] = scan.nextLine();
                            }else if(week == "w2"){
                                pto4[i] = scan.nextLine();
                            }

                            i++;
                        } else if (answer.equals("no")) {
                            System.out.println("This are the colleague which are on PTO on Monday:");
                            for (int x = 0; x < i; x++) {
                                if(week =="w1"){
                                    System.out.println(pto1[x]);
                                }else if(week =="w2"){
                                    System.out.println(pto4[x]);
                                }
                            }
                            if(week == "w1"){
                                UpdateTable.updatePTOTable(pto1, Mondayw1, week);
                            }else if(week == "w2"){
                                UpdateTable.updatePTOTable(pto4, Mondayw1, week);
                            }
                            System.out.println("No other colleague is on PTO, skipping to Wednesday");
                            isTrue = true;
                            isTrue2 = true;
                        } else {
                            System.out.println("Wrong input");
                        }
                    }
                } else if (answer.equals("no")) {
                    isTrue = true;
                } else {
                    System.out.println("Wrong input. Please try again");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid input");
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        isTrue = false;
        i = 0;

        //Wednesday//
        while (!isTrue) {
            try {
                System.out.println("Is there someone in PTO on Wednesday? yes or no");
                answer = scan.nextLine();
                if (answer.equals("yes")) {
                    System.out.println("Please add the colleague");
                    if(week == "w1"){
                        pto2[i] = scan.nextLine();
                    }else if(week == "w2"){
                        pto5[i] = scan.nextLine();
                    }
                    isTrue2 = false;
                    i++;
                    while (!isTrue2) {
                        System.out.println("Is there someone else in PTO on Wednesday? yes or no");
                        answer = scan.nextLine().toLowerCase();
                        if (answer.equals("yes")) {
                            System.out.println("Please add the colleague");
                            if(week == "w1"){
                                pto2[i] = scan.nextLine();
                            }else if(week == "w2"){
                                pto5[i] = scan.nextLine();
                            }
                            i++;
                        } else if (answer.equals("no")) {
                            System.out.println("This are the colleagues on PTO on Wednesday: ");
                            for(int x = 0; x<i; x++){
                                if(week == "w1"){
                                    System.out.println(pto2[x]);
                                }else if(week == "w2"){
                                    pto5[i] = scan.nextLine();
                                }
                            }
                            if(week == "w1"){
                                UpdateTable.updatePTOTable(pto2, Wednesdayw1, week);
                            }else if(week == "w2"){
                                UpdateTable.updatePTOTable(pto5, Wednesdayw1, week);
                            }
                            System.out.println("No other colleague is on PTO, skipping to Friday");
                            isTrue = true;
                            isTrue2 = true;
                        } else {
                            System.out.println("Wrong input");
                        }
                    }
                } else if (answer.equals("no")) {
                    isTrue = true;
                } else {
                    System.out.println("Wrong input. Please try again");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid input");
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        isTrue = false;
        i = 0;

        if(week.contains("w2")){
            //Thursday
            while(!isTrue){
                try {
                    System.out.println("Is there someone in PTO on Thursday? yes or no");
                    answer = scan.nextLine();
                    if (answer.equals("yes")) {
                        System.out.println("Please add the colleague");
                        pto6[i] = scan.nextLine();
                        isTrue2 = false;
                        i++;
                        while (!isTrue2) {
                            System.out.println("Is there someone else in PTO on Thursday? yes or no");
                            answer = scan.nextLine().toLowerCase();
                            if (answer.equals("yes")) {
                                System.out.println("Please add the colleague");
                                pto6[i] = scan.nextLine();
                                i++;
                            } else if (answer.equals("no")) {
                                System.out.println("This are the colleagues on PTO on Thursday: ");
                                for(int x =0; x <i ; x++){
                                    System.out.println(pto6[x]);
                                }
                                UpdateTable.updatePTOTable(pto6,Thursdayw2,week);
                                System.out.println("No other colleague is on PTO. Skipping to Friday");
                                isTrue = true;
                                isTrue2 = true;
                            } else {
                                System.out.println("Wrong input");
                            }
                        }
                    } else if (answer.equals("no")) {
                        isTrue = true;
                    } else {
                        System.out.println("Wrong input. Please try again");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid input");
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            isTrue = false;
            i = 0;
        }
            //Friday//
            while(!isTrue){
                try {
                    System.out.println("Is there someone in PTO on Friday? yes or no");
                    answer = scan.nextLine();
                    if (answer.equals("yes")) {
                        //Emptying our array
                        System.out.println("Please add the colleague");
                        if(week == "w1"){
                            pto3[i] = scan.nextLine();
                        }else if(week == "w2"){
                            pto7[i] = scan.nextLine();
                        }
                        isTrue2 = false;
                        i++;
                        while (!isTrue2) {
                            System.out.println("Is there someone else in PTO on Friday? yes or no");
                            answer = scan.nextLine().toLowerCase();
                            if (answer.equals("yes")) {
                                System.out.println("Please add the colleague");
                                if(week == "w1"){
                                    pto3[i] = scan.nextLine();
                                }else if(week =="w2"){
                                    pto7[i] = scan.nextLine();
                                }
                                i++;
                            } else if (answer.equals("no")) {
                                System.out.println("This are the colleagues on PTO on Friday: ");
                                for(int x =0; x <i ; x++){
                                    if(week =="w1"){
                                        System.out.println(pto3[x]);
                                    }else if(week =="w2"){
                                        System.out.println(pto7);
                                    }
                                }
                                if(week =="w1"){
                                    UpdateTable.updatePTOTable(pto3,Fridayw1,week);
                                }else if(week == "w2"){
                                    UpdateTable.updatePTOTable(pto7,Fridayw2,week);
                                }

                                System.out.println("No other colleague is on PTO, Week 1 is done!");
                                isTrue = true;
                                isTrue2 = true;
                            } else {
                                System.out.println("Wrong input");
                            }
                        }
                    } else if (answer.equals("no")) {
                        isTrue = true;
                    } else {
                        System.out.println("Wrong input. Please try again");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid input");
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
    
}
