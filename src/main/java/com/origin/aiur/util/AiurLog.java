/**
 * Copyright(c) 2011 TeleNav, Inc.
 *
 * @Title: TripLog.java
 * @Package com.skk.trip.util
 * @author jwdong 
 * @date 2013-7-10
 * @version V1.0  
 */
package com.origin.aiur.util;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class AiurLog {
    private static Logger logger = null;
    static{
        DOMConfigurator.configure(AiurLog.class.getClassLoader().getResource("log4j.xml"));
        if(logger == null){
            synchronized (AiurLog.class) {
                logger = Logger.getLogger("ActionLogger");
            }
        }
    }
    public static Logger logger(){
        return logger;
    }
}
