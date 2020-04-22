import java.io.IOException;
import java.security.GeneralSecurityException;

public class run extends SystemIO {


    public static void main(String[] args) throws IOException, GeneralSecurityException {
        firstInteraction();
        System.out.println("Randomizing availability for w1 & w2");
        UpdateTable.UpdateTableElementsAO1andAO2();

    }
    }








