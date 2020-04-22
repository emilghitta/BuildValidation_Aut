import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReadTable extends BuildUp{
    static String readAO1 = "Beta!K2:K20";
    static String readAO2 = "Beta!K23:K41";
    static String readLeaveW1Monday = "Beta!L2:L20";
    static String readLeaveW1Wednesday ="Beta!M2:M20";
    static String readLeaveW1WednesdayThursday = "Beta!N2:N20";
    static String readLeaveW1WednesdayFriday ="Beta!O2:O20";
    static String readLeaveW2Monday = "Beta!L23:L41";
    static String readLeaveW2MWednesday = "Beta!M23:M41";
    static String readLeaveW2Thursday = "Beta!N23:N41";
    static String readLeaveW2Friday = "Beta!O23:O41";
    //Sprint1
    static String readTaskPrep = "Beta!I17:I23";

    static List<List<Object>> ValuesAO1;
    static List<List<Object>> ValuesAO2;
    static List<List<Object>> ValuesLeaveW1;
    static List<List<Object>> ValuesLeaveW2;
    static List<List<Object>> PTOMondayWK1;
    static String[] PTOWednesdayWK1;
    static String[] PTOThursdayWK1;
    static String[] PTOFridayWK1;
    static String[] PTOMondayWK2;
    static String[] PTOWednesdayWK2;
    static String[] PTOThursdayWK2;
    static String[] PTOFridayWK2;
    static List<List<Object>> TaskPrep;
    static Object[][] array;

    protected static void readAO1Table() throws IOException, GeneralSecurityException {
        buildup();

        //Build up for AO1 Table
          ValueRange responseAO1 = service.spreadsheets().values()
         .get(spreadsheetId, readAO1)
         .execute();

        //Save Values as List

        List<List<Object>> valuesAO1 = responseAO1.getValues();
         ValuesAO1= valuesAO1;
    }
    protected static void readAO2Table() throws  IOException,GeneralSecurityException{
       buildup();
        //Build up for AO2 Table
        ValueRange responseAO2 = service.spreadsheets().values()
        .get(spreadsheetId, readAO2)
        .execute();

        List<List<Object>> valuesAO2 = responseAO2.getValues();
        ValuesAO2 = valuesAO2;
    }

    protected static void readLeaveW1Table() throws IOException,GeneralSecurityException{
        buildup();
        ValueRange respondeLeaveW1 = service.spreadsheets().values()
                .get(spreadsheetId,readLeaveW1Monday)
                .execute();
        PTOMondayWK1 = respondeLeaveW1.getValues();
    }

//    protected static void readLeaveW2Table() throws IOException,GeneralSecurityException{
//        buildup();
//        ValueRange respondeLeaveW2 = service.spreadsheets().values()
//                .get(spreadsheetId,readLeaveW2Monday)
//                .execute();
//        List<List<Object>> valuesLeaveW2 = respondeLeaveW2.getValues();
//        ValuesLeaveW2 = valuesLeaveW2;
//        System.out.println(ValuesLeaveW2);
//
//    }

    protected static void readTaskPrepTable() throws IOException,GeneralSecurityException{
        buildup();

        ValueRange taskPrepTable = service.spreadsheets().values()
                .get(spreadsheetId, readTaskPrep)
                .execute();

        TaskPrep = taskPrepTable.getValues();

    //Converting List of Object to a multidimensional array
        for(int x = 0; x < 7; x++){
           array = new Object[TaskPrep.size()][];

            int i = 0;
            for (List<Object> event : TaskPrep) {//each list
                array[i++] = event.toArray(new Object[event.size()]);
            }
            String test = array[x][0].toString();
            String[] test2 = new String[6];
            test2[0] = test;
            System.out.println(test2);

            System.out.println("Creating an array with: " + array[x][0]);
        }

    }


}
