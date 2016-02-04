package testA;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by Ira on 02.02.2016.
 */
public class TestLogger {
    public static final Logger LOG = LogManager.getLogger(TestLogger.class);
    @Test
    public void testLogger(){

        LOG.warn("Hello World!");
        LOG.info("Info");
    }
}
