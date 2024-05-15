package dependency.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DependencyB {

    private static final Logger logger = LogManager.getLogger(DependencyB.class);

    public void Logger() {
        logger.error("Logging an error message");
        logger.fatal("Logging a fatal error message");
    }
}
