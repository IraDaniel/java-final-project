package testA;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

/**
 * Created by Ira on 02.02.2016.
 */
public class TestLogger {
    public static final Logger LOG = LogManager.getLogger(TestLogger.class);
    @Test

    public void testLogger(){

       // LOG.warn("Hello World!");
       // LOG.info("Info");
        ResourceBundle bundle = ResourceBundle.getBundle("admin");

        String pLogin = bundle.getString("admin.login");
        String pPassword = bundle.getString("admin.password");
      //  System.out.println(pLogin);
      //  System.out.println(pPassword);
    }

    @Test

    public void testDate(){
        java.util.Date data2 = new java.util.Date();

        Date date = new Date(data2.getTime());

        System.out.println(date.toString());
        System.out.println(data2.toString());
    }
}
