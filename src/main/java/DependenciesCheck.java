/*
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;


public class DependenciesCheck extends ReadTable {
        public static List<String> excludeColleagues;

    public static void performCheck() throws IOException, GeneralSecurityException {
        buildup();
        readLeaveW1Table();

        System.out.println("Performing task Preparation Completeness check");
        checkTaskPreparationCompleteness();

        System.out.println("Performing Week 1 PTO verification");
        if(PTOMondayWK1 == null){
            System.out.println("No PTO's on monday.");

           // UpdateTable.updateWeek1Table();
        } else {
            System.out.println("Test");
        }

//        if(readLeaveW1Wednesday == null){
//            UpdateTable.updateWeek1Table();
//        } else if{
//
//        }
//
//        if(readLeaveW1WednesdayThursday == null){
//            UpdateTable.updateWeek1Table();
//        } else if{
//
//        }
//
//        if(readLeaveW1WednesdayFriday == null){
//            UpdateTable.updateWeek1Table();
//        } else if{
//
//        }

    }

    private static void checkTaskPreparationCompleteness() throws IOException,GeneralSecurityException{
        buildup();
        readTaskPrepTable();
        if(TaskPrep == null){
            System.out.println("Task prep table is not complete, quitting the application:");
            System.exit(0);
        }else{
            System.out.println("The following colleagues are assigned to task preparation: " + TaskPrep);
            System.out.println("Populating tables with Task Prep Colleagues");
            UpdateTable.updateTableWithTaskPrepSprint1();
        }
    }

}
*/
