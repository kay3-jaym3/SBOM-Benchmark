package sbom.benchmark;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        logger.error("This logs an error message.");
        logger.fatal("This logs a fatal error message.");
    }
}