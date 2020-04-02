import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

public class ShuffleTables extends GSheet {
    //GSheet ID
    final static String spreadsheetId = "10byN6HAPyI5mc1gqp8vXQn0qtLG2aJwVlhWAY36UMdg";
    final static String rangeAO1 = "Beta!K2:K20";
    final static String rangeAO2 = "Beta!K23:K41";
    static NetHttpTransport HTTP_TRANSPORT;
    static Sheets service;
    static List<List<Object>> ValuesAO1;
    static List<List<Object>> ValuesAO2;

    protected static void buildup() throws IOException, GeneralSecurityException{
        // Build a new authorized API client service.
        HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        service = new Sheets.Builder(HTTP_TRANSPORT, GSheet.getJsonFactory(), getCredentials(HTTP_TRANSPORT))
                .setApplicationName(GSheet.getApplicationName())
                .build();
    }

    protected static void readAO1Table() throws IOException, GeneralSecurityException{
         buildup();

        //Build up for AO1 Table
        ValueRange responseAO1 = service.spreadsheets().values()
                .get(spreadsheetId, rangeAO1)
                .execute();

        //Save Values as List
        List<List<Object>> valuesAO1 = responseAO1.getValues();
        ValuesAO1= valuesAO1;
        System.out.println("Before Shuffle AO1" + ValuesAO1);

    }

    protected static void readAO2Table() throws  IOException,GeneralSecurityException{
        buildup();

        //Build up for AO2 Table
        ValueRange responseAO2 = service.spreadsheets().values()
                .get(spreadsheetId, rangeAO2)
                .execute();

        List<List<Object>> valuesAO2 = responseAO2.getValues();
        ValuesAO2 = valuesAO2;
        System.out.println("Before Shuffle AO2" + ValuesAO2);
    }

    protected static void shuffleAO1andAO2Tables()throws IOException, GeneralSecurityException{
            /*
            If interogated values are empty, return print message else shuffle the values
             */
            readAO1Table();
            if(ValuesAO1 == null || ValuesAO1.isEmpty()){
                System.out.println("AO1 Table contains empty data!");
            }else{
                Collections.shuffle(ValuesAO1);
                System.out.println("After shuffle AO1" + ValuesAO1);
            }

            readAO2Table();

            if(ValuesAO2 == null || ValuesAO2.isEmpty()){
                System.out.println("AO2 Table contains empty data!");
            }else{
                Collections.shuffle(ValuesAO2);
                System.out.println("After shuffle AO2" + ValuesAO2);
            }

    }
}
