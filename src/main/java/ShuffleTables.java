import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

