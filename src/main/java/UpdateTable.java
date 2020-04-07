import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public class UpdateTable extends BuildUp{
    static String startingRangeWeeksTables = "Beta!B";
    static String rangeAO1 = "Beta!K";
    static String rangeAO2 = "Beta!K";


    protected static void UpdateTableElementsAO1andAO2() throws IOException, GeneralSecurityException {
        System.out.println("Shuffling for table AO1");
        ShuffleTables.shuffleAO1andAO2Tables();

        //Inputting in AO1 cells
        int numberadd = 2;

        //TO DO: Replace it with a foreach loop//
        for(int y = 0; y <colleagues.length; y++){

            rangeAO1 += numberadd;
            System.out.println(rangeAO1);
            ValueRange update = new ValueRange().setValues(Arrays.asList(Arrays.asList(colleagues[y])));
            UpdateValuesResponse result = service.spreadsheets().values()
                    .update(spreadsheetId,rangeAO1, update)
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
        ShuffleTables.shuffleAO1andAO2Tables();
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

  protected static void updateWeek1Table() throws IOException,GeneralSecurityException{
//        int numberadd2 = 6;
//        //TO DO: Replace it with a foreach loop//
//        for(int x =0; x <colleagues.length; x++){
//            rangeAO2 += numberadd2;
//            System.out.println(rangeAO2);
//            ValueRange update = new ValueRange().setValues(Arrays.asList(Arrays.asList(colleagues[x])));
//            UpdateValuesResponse result = service.spreadsheets().values()
//                    .update(spreadsheetId,rangeAO2,update)
//                    .setValueInputOption("RAW")
//                    .execute();
//            System.out.println("Updating row " + rangeAO2);
//            if(numberadd2 > 41){
//                break;
//            }else{
//                numberadd2++;
//                rangeAO2 = "Beta!K";
//       }
//        }
    }

//    protected static void updateWeek2Table(){
//
//    }


}
