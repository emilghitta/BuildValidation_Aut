import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.sheets.v4.Sheets;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildUp extends GSheet{
    final static String spreadsheetId = "10byN6HAPyI5mc1gqp8vXQn0qtLG2aJwVlhWAY36UMdg";
    static NetHttpTransport HTTP_TRANSPORT;
    static Sheets service;
    final static String[] colleagues = { "Cornel Ionce", "Alexandru Trif", "Bogdan Maris", "Mihai Boldan",
            "Camelia Badau", "Cristian Comorasu", "Maria Berlinger", "Ciprian Georgiu", "Timea Zsoldos", "Emil Ghitta",
            "Gabi Cheta", "Oana Botisan", "Anca Soncutean"," Catalin Sasca"," Cristian Baica", "Cristian Fogel",
            "Vlad Lucaci", "Cicas Daniel"};


    protected static void buildup() throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        service = new Sheets.Builder(HTTP_TRANSPORT, GSheet.getJsonFactory(), getCredentials(HTTP_TRANSPORT))
                .setApplicationName(GSheet.getApplicationName())
                .build();
    }
}
