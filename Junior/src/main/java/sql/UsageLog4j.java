package sql;

import org.apache.log4j.Logger;

public class UsageLog4j {

    final static Logger logger = Logger.getLogger(UsageLog4j.class);

    public static void main(String[] args) {
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
    }
}
