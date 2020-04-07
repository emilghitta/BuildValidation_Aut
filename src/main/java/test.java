import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.security.GeneralSecurityException;


public class test extends UpdateTable{
    final static Logger logger = LogManager.getLogger(BuildUp.class.getName());
    public static void main(String... args) throws IOException, GeneralSecurityException {
        logger.info("Test");

        //Update AO1 & AO2 Tables
       UpdateTableElementsAO1andAO2();
      // ReadTable.readLeaveW1Table();
      // ReadTable.readLeaveW2Table();


    }
}




