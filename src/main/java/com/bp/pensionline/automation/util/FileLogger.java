

/*
 * Copyright (c) CMG Ltd All rights reserved.

 *
 * This software is the confidential and proprietary information of CMG
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with CMG.
 */
 package com.bp.pensionline.automation.util; 

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/** 
 * DOCME * 
 * 
 * @author Long Nguyen *
 * @version .Revision: # .Date:Sep 5, 2012*
 */
public class FileLogger {
    public static Logger logger;
    public static final String LOG_NAME = "PLAutomation.log";
    static {
	    try {
	     File logFolder = new File(Element.BASE_PATH + "\\log");
	     if (!logFolder.exists() || !logFolder.isDirectory()) {
	    	 logFolder.mkdirs();
	     }
	     
	      boolean append = true;
	      FileHandler fh = new FileHandler(Element.BASE_PATH + "\\log\\" + LOG_NAME,append);
	      fh.setFormatter(new Formatter() {
	         public String format(LogRecord rec) {
	            StringBuffer buf = new StringBuffer(1000);
	            buf.append(new java.util.Date());
	            buf.append(' ');
	            buf.append(rec.getLevel());
	            buf.append(' ');
	            buf.append(formatMessage(rec));
	            buf.append('\n');
	            buf.append('\n');
	            return buf.toString();
	            }
	          });
	      logger = Logger.getLogger("TestLog");
	      logger.addHandler(fh);
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	}
}

