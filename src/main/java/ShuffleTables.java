import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;



import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;


public class ShuffleTables {

    //TO DO!: Add and read this from a properties file//


    protected static void shuffleAO1andAO2Tables()throws IOException, GeneralSecurityException{
        BuildUp.buildup();

        System.out.println("Before shuffle " + Arrays.toString(BuildUp.colleagues));
        List<String> intList = Arrays.asList(BuildUp.colleagues);
        Collections.shuffle(intList);
        intList.toArray(BuildUp.colleagues);
        System.out.println("After shuffle " + Arrays.toString(BuildUp.colleagues));

    }
        }

