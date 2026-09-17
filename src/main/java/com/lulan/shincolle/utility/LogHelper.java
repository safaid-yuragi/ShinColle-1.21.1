package com.lulan.shincolle.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lulan.shincolle.config.ShinColleConfig;
import com.lulan.shincolle.reference.Reference;

public class LogHelper
{

    private static final Logger LOGGER = LoggerFactory.getLogger(Reference.MOD_NAME);


    public static Logger getLogger()
    {
        return LOGGER;
    }

    //off: lowest priority, effectively never shown
    public static void off(Object object) { LOGGER.trace(String.valueOf(object)); }

    //fatal: severe problem that prevents the mod from working
    public static void fatal(Object object) { LOGGER.error(String.valueOf(object)); }

    //error: problem that may stop part of the mod working
    public static void error(Object object) { LOGGER.error(String.valueOf(object)); }

    //warn: problem that may lead to error
    public static void warn(Object object) { LOGGER.warn(String.valueOf(object)); }

    //info: normal message, no debug mode required
    public static void info(Object object) { LOGGER.info(String.valueOf(object)); }

    //log: debug message, requires debug mode
    public static void debug(Object object)
    {
        if (ShinColleConfig.debugMode) LOGGER.info(String.valueOf(object));
    }

    //debug: debug message, requires debug mode, logged at debug level
    public static void debugHighLevel(Object object)
    {
        if (ShinColleConfig.debugMode) LOGGER.debug(String.valueOf(object));
    }

    //trace: program flow trace
    public static void trace(Object object) { LOGGER.trace(String.valueOf(object)); }

    //all: log everything
    public static void all(Object object) { LOGGER.trace(String.valueOf(object)); }


}
