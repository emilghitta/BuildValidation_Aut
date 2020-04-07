import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class ReadTable extends BuildUp{
    static String readAO1 = "Beta!K2:K20";
    static String readAO2 = "Beta!K23:K41";
    static String readLeaveW1 = "Beta!L2:O20";
    static String readLeaveW2 = "Beta!L23:O41";
    static List<List<Object>> ValuesAO1;
    static List<List<Object>> ValuesAO2;
    static List<List<Object>> ValuesLeaveW1;
    static List<List<Object>> ValuesLeaveW2;

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
                .get(spreadsheetId,readLeaveW1)
                .execute();
        List<List<Object>> valuesLeaveW1 = respondeLeaveW1.getValues();
        ValuesLeaveW1 = valuesLeaveW1;
        System.out.println(ValuesLeaveW1);
    }

    protected static void readLeaveW2Table() throws IOException,GeneralSecurityException{
        buildup();
        ValueRange respondeLeaveW2 = service.spreadsheets().values()
                .get(spreadsheetId,readLeaveW2)
                .execute();
        List<List<Object>> valuesLeaveW2 = respondeLeaveW2.getValues();
        ValuesLeaveW2 = valuesLeaveW2;
        System.out.println(ValuesLeaveW2);

    }



}
