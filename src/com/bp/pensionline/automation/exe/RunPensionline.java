

/*
 * Copyright (c) CMG Ltd All rights reserved.

 *
 * This software is the confidential and proprietary information of CMG
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with CMG.
 */
 package com.bp.pensionline.automation.exe; 

import javax.mail.MessagingException;

import com.bp.pensionline.automation.PensionlineProd;

/** 
 * DOCME * 
 * 
 * @author Long Nguyen *
 * @version .Revision: # .Date:Sep 5, 2012*
 */
public class RunPensionline {
    public static void main(String[] args) throws MessagingException, com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException, InterruptedException {
	    PensionlineProd prod = new PensionlineProd();
	    prod.PensionlineTest();
	}
}

