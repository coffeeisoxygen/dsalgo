package com.coffecode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Hello World");
        logger.debug("Debug message");
        logger.error("Error message");
    }
}
