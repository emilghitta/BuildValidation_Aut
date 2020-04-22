import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public class UpdateTable extends BuildUp{
    static String startingRangeWeeksTables = "Beta!B";
    static String rangeAO1 = "'POC Beta'!H";
    static String rangeAO2 = "'POC Beta'!H";
    static String rangePTOwk1M = "'POC Beta'!J";
    //Applies for Sprint1
    static String rangeTaskPrep;

    protected static void UpdateTableElementsAO1andAO2() throws IOException, GeneralSecurityException {
        System.out.println("Shuffling for table AO1");
        ShuffleTables.shuffleAO1andAO2Tables();

        //Inputting in AO1 cells
        int numberadd = 7;

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
            if(numberadd > 24){
                break;
            }else{
                numberadd++;
                rangeAO1 = "'POC Beta'!H";
            }
        }
        System.out.println("Shuffling again for table AO2");
        ShuffleTables.shuffleAO1andAO2Tables();

        int numberadd2 = 32;
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
            if(numberadd2 > 49){
                break;
            }else{
                numberadd2++;
                rangeAO2 = "'POC Beta'!H";
            }
        }
    }

  protected static void updatePTOTable(String[] pto, String range, String week) throws IOException,GeneralSecurityException{
      buildup();
      //Add if for pto week2
      int numberadd = 0;
      if(week == "w1"){
           numberadd = 7;
      }else if(week == "w2"){
           numberadd = 32;
      }

      for(int y = 0; y <18; y++){
          range += numberadd;
          System.out.println(range);
          ValueRange update = new ValueRange().setValues(Arrays.asList(Arrays.asList(pto[y])));
          UpdateValuesResponse result = service.spreadsheets().values()
                  .update(spreadsheetId,range, update)
                  .setValueInputOption("RAW")
                  .execute();
          System.out.println("Updating row: " + range);
          if(week.contains("w1")){
              if(numberadd > 24){
                  break;
              }else if(range.contains("'POC Beta'!J")){
                  numberadd++;
                  System.out.println("We are here");
                  range = "'POC Beta'!J";
              }else if(range.contains("'POC Beta'!K")){
                  numberadd++;
                  range = "'POC Beta'!K";
              }else if(range.contains("'POC Beta'!L")){
                  numberadd++;
                  range = "'POC Beta'!L";
              }else{
                  System.out.println("we are here. Error has occurred" );
              }
          }else if(week.contains("w2")){
              if(numberadd > 50){
                  break;
              }else if(range.contains("'POC Beta'!J")){
                  numberadd++;
                  range ="'POC Beta'!J";
              }else if(range.contains("'POC Beta'!K")){
                  numberadd++;
                  range="'POC Beta'!K";
              }else if(range.contains("'POC Beta'!L")){
                  numberadd++;
                  range = "'POC Beta'!L";
              }else if(range.contains("'POC Beta'!M")){
                  numberadd++;
                  range = "'POC Beta'!M";
              }else{
                  System.out.println("We are here. Error has occurred");
              }
          }

      }
  }
  protected static void updateWeek1Table() throws IOException,GeneralSecurityException{

      //  int numberadd2 = 6;
       //TO DO: Replace it with a foreach loop//
//      for(int x =0; x <colleagues.length; x++){
//               rangeAO2 += numberadd2;
//           System.out.println(rangeAO2);
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

 /*     protected static void updateTableWithTaskPrepSprint1() throws IOException,GeneralSecurityException{
          for(int x =0; x < 7; x++) {
              int count = x;
              switch (count){
                  case 0: rangeTaskPrep = "Beta!B12";
                      break;
                  case 1: rangeTaskPrep = "Beta!D12";
                      break;
                  case 2: rangeTaskPrep = "Beta!F12";
                      break;
                  case 3: rangeTaskPrep = "Beta!B33";
                      break;
                  case 4: rangeTaskPrep = "Beta!D33";
                      break;
                  case 5: rangeTaskPrep = "Beta!F33";
                      break;
                  case 6: rangeTaskPrep = "Beta!H33";
              }
              ValueRange update = new ValueRange().setValues(Arrays.asList(Arrays.asList(ReadTable.array)));
              UpdateValuesResponse result = service.spreadsheets().values()
                      .update(spreadsheetId, rangeTaskPrep,update)
                      .setValueInputOption("RAW")
                      .execute();
          }
      }*/
}
