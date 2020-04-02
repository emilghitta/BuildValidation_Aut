import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;


import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;


public class ShuffleTables extends GSheet {
    //GSheet ID
    final static String spreadsheetId = "10byN6HAPyI5mc1gqp8vXQn0qtLG2aJwVlhWAY36UMdg";
    static String rangeAO1 = "Beta!K";
    static String rangeAO2 = "Beta!K";
    static NetHttpTransport HTTP_TRANSPORT;
    static Sheets service;

    //TO DO!: Add and read this from a properties file//
    static String[] colleagues = new String[] {
                "Cornel Ionce", "Arnold Bodenlosz", "Alexandru Trif", "Bogdan Maris", "Mihai Boldan",
                "Camelia Badau", "Cristian Comorasu", "Maria Berlinger", "Ciprian Georgiu", "Timea Zsoldos", "Emil Ghitta",
                "Gabi Cheta", "Oana Botisan", "Anca Soncutean"," Catalin Sasca"," Cristian Baica", "Cristian Fogel",
                "Vlad Lucaci", "Cicas Daniel"};

    protected static void buildup() throws IOException, GeneralSecurityException{
        // Build a new authorized API client service.
        HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        service = new Sheets.Builder(HTTP_TRANSPORT, GSheet.getJsonFactory(), getCredentials(HTTP_TRANSPORT))
                .setApplicationName(GSheet.getApplicationName())
                .build();
    }

    protected static void shuffleAO1andAO2Tables()throws IOException, GeneralSecurityException{
        buildup();

        System.out.println("Before shuffle " + Arrays.toString(colleagues));
        List<String> intList = Arrays.asList(colleagues);
        Collections.shuffle(intList);
        intList.toArray(colleagues);
        System.out.println("After shuffle " + Arrays.toString(colleagues));

    }
    protected static void UpdateTableElementsAO1andAO2(String spreadsheetId) throws IOException,GeneralSecurityException{
        System.out.println("Shuffling for table AO1");
      shuffleAO1andAO2Tables();

        //Inputting in AO1 cells
        int numberadd = 2;

        //TO DO: Replace it with a foreach loop//
                for(int y = 0; y <colleagues.length; y++){

                    rangeAO1 += numberadd;
                    System.out.println(rangeAO1);
                    ValueRange update = new ValueRange().setValues(Arrays.asList(Arrays.asList(colleagues[y])));
                    UpdateValuesResponse result = service.spreadsheets().values()
                            .update(spreadsheetId, rangeAO1, update)
                            .setValueInputOption("RAW")
                            .execute();
                    System.out.println("Updating row: " + rangeAO1);
                    if(numberadd > 20){
                        break;
                    }else{
                        numberadd++;
                        rangeAO1 = "Beta!K";
                    }
                }


        System.out.println("Shuffling again for table AO2");
                shuffleAO1andAO2Tables();
                int numberadd2 = 23;
                //TO DO: Replace it with a foreach loop//
                    for(int x =0; x <colleagues.length; x++){
                        rangeAO2 += numberadd2;
                        System.out.println(rangeAO2);
                        ValueRange update = new ValueRange().setValues(Arrays.asList(Arrays.asList(colleagues[x])));
                        UpdateValuesResponse result = service.spreadsheets().values()
                                .update(spreadsheetId,rangeAO2,update)
                                .setValueInputOption("RAW")
                                .execute();
                        System.out.println("Updating row " + rangeAO2);
                        if(numberadd2 > 41){
                            break;
                        }else{
                            numberadd2++;
                            rangeAO2 = "Beta!K";
                        }
                    }

    }



        }

