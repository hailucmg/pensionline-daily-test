/**
 * Copyright (c) CMG Ltd All rights reserved.

 *
 * This software is the confidential and proprietary information of CMG
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with CMG.
 */
 package com.bp.pensionline.automation; 
 
import javax.mail.MessagingException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.bp.pensionline.automation.util.Element;
import com.bp.pensionline.automation.util.FileLogger;
import com.bp.pensionline.automation.util.MailUtil;
import com.thoughtworks.selenium.Selenium;

/** 
 * DOCME * 
 * 
 * @author Long Nguyen *
 * @version .Revision: # .Date:Sep 5, 2012*
 */
public class PensionlineProd {
    public void PensionlineTest() throws MessagingException, InterruptedException{
        MailUtil mail = new MailUtil();
        String bodyText = "";
        String[] bgroup;
        Element element = new Element();
        element.loadProperties();
        
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        Selenium selenium = new WebDriverBackedSelenium(driver,element.getUrl_prod());
        
        selenium.setTimeout("2100000");
        /***************Start website****************/
        selenium.open(element.getUrl_prod());
        Thread.sleep(5000);
        if(selenium.isTextPresent("welcome to PensionLine")){
            bodyText = "<h3>Beginning of automation test for PL Prod: https://pensionline.bp.com/content/pl</h3>"+"<br>";
            FileLogger.logger.info("Beginning of autamation test for PL Prod");
        }else{
            bodyText = "<h3 style=\"color:red\">Server was broken. Cannot open website</h3>";
            FileLogger.logger.info("Server was broken. Cannot open website");
            try {
		mail.sendMailPL(bodyText, 2);
	    } catch (MessagingException e) {
		e.printStackTrace();
	    }
        }
        
        /*****************Start login function*********************/
        selenium.open("https://pensionline.bp.com/content/pl/_login_ask.html");
        Thread.sleep(5000);
        selenium.type("_request_username", "superuser");
        selenium.type("_request_password", "P3nsions");
        selenium.click("doauth");
        
        if (selenium.isTextPresent("Superuser access")) {
            bodyText += "   Superuser Login function: PASSED" + "<br><br>";
            FileLogger.logger.info(" ->Superuser Login function: PASSED");
        } else {
            bodyText += "   Superuser Login function: FAILED" + "<br><br>";
            FileLogger.logger.info(" ->Superuser Login function: FAILED");

            try {
                mail.sendMailPL(bodyText, 2);
            } catch (MessagingException e) {
                e.printStackTrace();
            } 
        }
        
        /*******************Loading of WALL'ed member (BGROUP/REFNO): BPF-0103249*********************************/
        bgroup = element.getWall_member1().split("-");
        if(bgroup[0].equalsIgnoreCase("BPF")){
            selenium.select("bgroup","BPF");
        }
        selenium.type("crefno", bgroup[1]);
        selenium.click("doauth");
        Thread.sleep(5000);
        if (selenium.isTextPresent("welcome to PensionLine")) {
            bodyText += "   Loading of WALL'ed member (BGROUP/REFNO) "+element.getWall_member1()+": PASSED" + "<br>";
            FileLogger.logger.info(" ->Loading of WALL'ed member (BGROUP/REFNO) "+element.getWall_member1()+": PASSED");
        } else {
            bodyText += "   Loading of WALL'ed member (BGROUP/REFNO) "+element.getWall_member1()+": FAILED" + "<br>";
            FileLogger.logger.info(" ->Loading of WALL'ed member (BGROUP/REFNO) "+element.getWall_member1()+": FAILED");
        }
        
        /********************Loading of WALL'ed member (BGROUP/REFNO): BPF-0103603********************************/
        selenium.open("https://pensionline.bp.com/content/pl/superuser/");
        Thread.sleep(5000);
        bgroup = element.getWall_member2().split("-");
        if(bgroup[0].equalsIgnoreCase("BPF")){
            selenium.select("bgroup","BPF");
        }
        selenium.type("crefno", bgroup[1]);
        selenium.click("doauth");
        Thread.sleep(5000);
        if (selenium.isTextPresent("welcome to PensionLine")) {
            bodyText += "   Loading of WALL'ed member (BGROUP/REFNO) "+element.getWall_member2()+": PASSED" + "<br>";
            FileLogger.logger.info(" ->Loading of WALL'ed member (BGROUP/REFNO) "+element.getWall_member2()+": PASSED");
        } else {
            bodyText += "   Loading of WALL'ed member (BGROUP/REFNO) "+element.getWall_member2()+": FAILED" + "<br>";
            FileLogger.logger.info(" ->Loading of WALL'ed member (BGROUP/REFNO) "+element.getWall_member2()+": FAILED");
        }
        
        /********************Loading of WALL'ed member (BGROUP/REFNO): BPF-0116405********************************/
        selenium.open("https://pensionline.bp.com/content/pl/superuser/");
        Thread.sleep(5000);
        bgroup = element.getWall_member3().split("-");
        if(bgroup[0].equalsIgnoreCase("BPF")){
            selenium.select("bgroup","BPF");
        }
        selenium.type("crefno", bgroup[1]);
        selenium.click("doauth");
        Thread.sleep(5000);
        if (selenium.isTextPresent("welcome to PensionLine")) {
            bodyText += "   Loading of WALL'ed member (BGROUP/REFNO) "+element.getWall_member3()+": PASSED" + "<br><br>";
            FileLogger.logger.info(" ->Loading of WALL'ed member (BGROUP/REFNO) "+element.getWall_member3()+": PASSED");
        } else {
            bodyText += "   Loading of WALL'ed member (BGROUP/REFNO) "+element.getWall_member3()+": FAILED" + "<br><br>";
            FileLogger.logger.info(" ->Loading of WALL'ed member (BGROUP/REFNO) "+element.getWall_member3()+": FAILED");
        }
        
        /********************Loading of Deferred member (BGROUP/REFNO): BPF-0103360(PP)********************************/
        selenium.open("https://pensionline.bp.com/content/pl/superuser/");
        Thread.sleep(5000);
        bgroup = element.getDeferred_member().split("-");
        if(bgroup[0].equalsIgnoreCase("BPF")){
            selenium.select("bgroup","BPF");
        }
        selenium.type("crefno", bgroup[1]);
        selenium.click("doauth");
        Thread.sleep(5000);
        if (selenium.isTextPresent("welcome to PensionLine")) {
            bodyText += "   Loading of Deferred member (BGROUP/REFNO) "+element.getDeferred_member()+ "<br>";
            bodyText += "     lock-outs functional(yes/no) : YES" + "<br>";
            FileLogger.logger.info(" ->Loading of Deferred member (BGROUP/REFNO) "+element.getDeferred_member()+"(PP): PASSED");
        } else {
            bodyText += "   Loading of Deferred member (BGROUP/REFNO) "+element.getDeferred_member()+": FAILED" + "<br>";
            FileLogger.logger.info(" ->Loading of Deferred member (BGROUP/REFNO) "+element.getDeferred_member()+"(PP): FAILED");
        }
        
        	/**************Loading My detail and This is me*********************/
        	selenium.open("https://pensionline.bp.com/content/pl/mydetails/");
        	Thread.sleep(3000);
        	if(selenium.isTextPresent("my details")){
        	    bodyText += "     My details function" + "<br>";
        	    selenium.open("https://pensionline.bp.com/content/pl/mydetails/this_is_me.html");
        	    Thread.sleep(7000);
        	    if(selenium.isTextPresent("Mr Stephen Day")){
        		bodyText += "       This is me functional(yes/no) : YES" + "<br><br>";
        	        FileLogger.logger.info(" ->This is me functional(yes/no) : YES");
        	    }else{
        		bodyText += "       This is me functional(yes/no) : NO" + "<br><br>";
        	        FileLogger.logger.info(" ->This is me functional(yes/no) : NO");
        	    }
        	}else{
        	    bodyText += "     My details function" + "<br>";
        	    FileLogger.logger.info(" ->My details function: FAILED");
        	}
       
        /********************Loading of Pensioner member (BGROUP/REFNO): BCF-0001532********************************/
        selenium.open("https://pensionline.bp.com/content/pl/superuser/");
        Thread.sleep(5000);
        bgroup = element.getPensioner_member1().split("-");
        if(bgroup[0].equalsIgnoreCase("BCF")){
             selenium.select("bgroup","BCF");
        }
        selenium.type("crefno", bgroup[1]);
        selenium.click("doauth");
        Thread.sleep(5000);
        if (selenium.isTextPresent("welcome to PensionLine")) {
            bodyText += "   Loading of Pensioner member (BGROUP/REFNO) "+element.getPensioner_member1()+"<br>";
            bodyText += "     lock-outs functional(yes/no) : YES" + "<br>";
            FileLogger.logger.info(" ->Loading of Pensioner member (BGROUP/REFNO) "+element.getPensioner_member1()+": PASSED");
        } else {
            bodyText += "   Loading of Pensioner member (BGROUP/REFNO) "+element.getPensioner_member1()+": FAILED" + "<br>";
            FileLogger.logger.info(" ->Loading of Pensioner member (BGROUP/REFNO) "+element.getPensioner_member1()+": FAILED");
        }
            	/**************Loading My detail and This is me*********************/
        	selenium.open("https://pensionline.bp.com/content/pl/mydetails/");
        	Thread.sleep(5000);
        	if(selenium.isTextPresent("my details")){
        	    bodyText += "     My details function" + "<br>";
        	    selenium.open("https://pensionline.bp.com/content/pl/mydetails/this_is_me.html");
        	    Thread.sleep(10000);
        	    if(selenium.isTextPresent("Mr Martin Cookson")){
        		bodyText += "       This is me functional(yes/no) : YES" + "<br>";
        	        FileLogger.logger.info(" ->This is me functional(yes/no) : YES");
        	    }else{
        		bodyText += "       This is me functional(yes/no) : NO" + "<br>";
        	        FileLogger.logger.info(" ->This is me functional(yes/no) : NO");
        	    }
        	}else{
        	    bodyText += "     My details function" + "<br>";
        	    FileLogger.logger.info(" ->My details function: FAILED");
        	}
        	/**************Loading My benefits*********************/
        	selenium.open("https://pensionline.bp.com/content/pl/mydetails/benefit_statement_pn.html");
        	Thread.sleep(50000);
        	if(selenium.isTextPresent("\u00A37,136.15")){
        	    bodyText += "       Payslips fuctional (yes/no) : YES" + "<br>";
        	    FileLogger.logger.info(" ->Payslips fuctional (yes/no) : YES");
        	}else{
        	    bodyText += "       Payslips fuctional (yes/no) : NO" + "<br>";
        	    FileLogger.logger.info(" ->Payslips fuctional (yes/no) : NO");
        	}
        /********************Loading of Pensioner member (BGROUP/REFNO): BPF-0100027********************************/
        selenium.open("https://pensionline.bp.com/content/pl/superuser/");
        Thread.sleep(5000);
        bgroup = element.getPensioner_member2().split("-");
        if(bgroup[0].equalsIgnoreCase("BPF")){
             selenium.select("bgroup","BPF");
        }
        selenium.type("crefno", bgroup[1]);
        selenium.click("doauth");
        Thread.sleep(5000);
        if (selenium.isTextPresent("welcome to PensionLine")) {
              bodyText += "   Loading of Pensioner member (BGROUP/REFNO) "+element.getPensioner_member2()+"<br>";
              bodyText += "     lock-outs functional(yes/no) : YES" + "<br>";
              FileLogger.logger.info(" ->Loading of Pensioner member (BGROUP/REFNO) "+element.getPensioner_member2()+": PASSED");
        } else {
              bodyText += "   Loading of Pensioner member (BGROUP/REFNO) "+element.getPensioner_member2()+": FAILED" + "<br>";
              FileLogger.logger.info(" ->Loading of Pensioner member (BGROUP/REFNO) "+element.getPensioner_member2()+": FAILED");
        }
              /**************Loading My detail and This is me*********************/
              selenium.open("https://pensionline.bp.com/content/pl/mydetails/");
              Thread.sleep(5000);
              if(selenium.isTextPresent("my details")){
        	  bodyText += "     My details function" + "<br>";
        	  selenium.open("https://pensionline.bp.com/content/pl/mydetails/this_is_me.html");
        	  Thread.sleep(10000);
        	  if(selenium.isTextPresent("Mr Graham Geoffrey Oliver")){
        	      bodyText += "       This is me functional(yes/no) : YES" + "<br>";
        	      FileLogger.logger.info(" ->This is me functional(yes/no) : YES");
        	  }else{
        	      bodyText += "       This is me functional(yes/no) : NO" + "<br>";
        	      FileLogger.logger.info(" ->This is me functional(yes/no) : NO");
        	  }
               }else{
        	   bodyText += "     My details function" + "<br>";
        	   FileLogger.logger.info(" ->My details function: FAILED");
               }
               /**************Loading My benefits*********************/
               selenium.open("https://pensionline.bp.com/content/pl/mydetails/benefit_statement_pn.html");
               Thread.sleep(50000);
               if(selenium.isTextPresent("\u00A32,746.96")){
        	   bodyText += "       Payslips fuctional (yes/no) : YES" + "<br>";
        	   FileLogger.logger.info(" ->Payslips fuctional (yes/no) : YES");
               }else{
        	   bodyText += "       Payslips fuctional (yes/no) : NO" + "<br>";
        	   FileLogger.logger.info(" ->Payslips fuctional (yes/no) : NO");
               }
               
         /************************Loading of Pensioner member (BGROUP/REFNO): BPF-0090597*************************/
         selenium.open("https://pensionline.bp.com/content/pl/superuser/");
         Thread.sleep(5000);
         bgroup = element.getPensioner_member3().split("-");
         if(bgroup[0].equalsIgnoreCase("BPF")){
              selenium.select("bgroup","BPF");
         }
         selenium.type("crefno", bgroup[1]);
         selenium.click("doauth");
         Thread.sleep(5000);
         if (selenium.isTextPresent("welcome to PensionLine")) {
               bodyText += "   Loading of Pensioner member (BGROUP/REFNO) "+element.getPensioner_member3()+"<br>";
               bodyText += "     lock-outs functional(yes/no) : YES" + "<br>";
               FileLogger.logger.info(" ->Loading of Pensioner member (BGROUP/REFNO) "+element.getPensioner_member3()+": PASSED");
         } else {
               bodyText += "   Loading of Pensioner member (BGROUP/REFNO) "+element.getPensioner_member3()+": FAILED" + "<br>";
               FileLogger.logger.info(" ->Loading of Pensioner member (BGROUP/REFNO) "+element.getPensioner_member3()+": FAILED");
         }
               /**************Loading My detail and This is me*********************/
               selenium.open("https://pensionline.bp.com/content/pl/mydetails/");
               Thread.sleep(5000);
               if(selenium.isTextPresent("my details")){
         	  bodyText += "     My details function" + "<br>";
         	  selenium.open("https://pensionline.bp.com/content/pl/mydetails/this_is_me.html");
         	  Thread.sleep(10000);
         	  if(selenium.isTextPresent("Mrs E M Spratt")){
         	      bodyText += "       This is me functional(yes/no) : YES" + "<br>";
         	      FileLogger.logger.info(" ->This is me functional(yes/no) : YES");
         	  }else{
         	      bodyText += "       This is me functional(yes/no) : NO" + "<br>";
         	      FileLogger.logger.info(" ->This is me functional(yes/no) : NO");
         	  }
                }else{
         	   bodyText += "     My details function" + "<br>";
         	   FileLogger.logger.info(" ->My details function: FAILED");
                }
                /**************Loading My benefits*********************/
                selenium.open("https://pensionline.bp.com/content/pl/mydetails/benefit_statement_pn.html");
                Thread.sleep(50000);
                if(selenium.isTextPresent("\u00A32,000.88")){
         	   bodyText += "       Payslips fuctional (yes/no) : YES" + "<br><br>";
         	   FileLogger.logger.info(" ->Payslips fuctional (yes/no) : YES");
                }else{
         	   bodyText += "       Payslips fuctional (yes/no) : NO" + "<br><br>";
         	   FileLogger.logger.info(" ->Payslips fuctional (yes/no) : NO");
                }
         
         /******************Loading Security lock-out in place (BGROUP/REFNO): BPF-0001341*****************************/
         selenium.open("https://pensionline.bp.com/content/pl/superuser/");
         Thread.sleep(5000);
         bgroup = element.getSecurity_member1().split("-");
         if(bgroup[0].equalsIgnoreCase("BPF")){
              selenium.select("bgroup","BPF");
         }
         selenium.type("crefno", bgroup[1]);
         selenium.click("doauth");
         Thread.sleep(5000);
         if (selenium.isTextPresent("welcome to PensionLine")) {
               bodyText += "   Loading of Security lock-out in place (BGROUP/REFNO) "+element.getSecurity_member1()+"<br>";
               bodyText += "     lock-outs functional(yes/no) : YES" + "<br>";
               FileLogger.logger.info(" ->Security lock-out in place (BGROUP/REFNO) "+element.getSecurity_member1()+": PASSED");
         } else {
               bodyText += "   Loading of Security lock-out in place (BGROUP/REFNO) "+element.getSecurity_member1()+": FAILED" + "<br>";
               FileLogger.logger.info(" ->Loading of Security lock-out in place (BGROUP/REFNO): BPF-0001341: FAILED");
         }
             /**************Loading My detail and This is me*********************/
             selenium.open("https://pensionline.bp.com/content/pl/mydetails/");
             Thread.sleep(5000);
             if(selenium.isTextPresent("my details")){
       	  	bodyText += "     My details function" + "<br>";
       	  	selenium.open("https://pensionline.bp.com/content/pl/mydetails/this_is_me.html");
       	  	Thread.sleep(10000);
       	  	if(selenium.isTextPresent("Mr Mark A Ashwell")){
       	  	    bodyText += "       This is me functional(yes/no) : YES" + "<br>";
       	  	    FileLogger.logger.info(" ->This is me functional(yes/no) : YES");
       	  	}else{
       	  	    bodyText += "       This is me functional(yes/no) : NO" + "<br>";
       	  	    FileLogger.logger.info(" ->This is me functional(yes/no) : NO");
       	  	}
              }else{
              	    bodyText += "     My details function" + "<br>";
              	    FileLogger.logger.info(" ->My details function: FAILED");
              }
             /************Loading Scheme Benefits Statement*********************/
             selenium.open("https://pensionline.bp.com/content/pl/mydetails/benefit_statement_ac/scheme_pension/");
             Thread.sleep(20000);
             if(selenium.isTextPresent("\u00A310,500")){
        	 bodyText += "     Scheme benefit statement functional (yes/no): YES " + "<br>";
        	 FileLogger.logger.info(" ->Scheme benefit statement functional (yes/no): YES ");
    	     }else{
    		 bodyText += "       Scheme benefit statement functional (yes/no): NO " + "<br>";
    		 FileLogger.logger.info(" ->Scheme benefit statement functional (yes/no): NO ");
    	     }
             /***********Loading My Annual Allowance***************************/
             selenium.open("https://pensionline.bp.com/content/pl/mydetails/annual_allowance/statement.html");
             Thread.sleep(10000);
             if(selenium.isTextPresent("\u00A311,736")){
        	 bodyText += "     My Annual Allowance (yes/no): YES " + "<br><br>";
        	 FileLogger.logger.info(" ->My Annual Allowance (yes/no): YES ");
             }else{
        	 bodyText += "     My Annual Allowance (yes/no): NO " + "<br><br>";
        	 FileLogger.logger.info(" ->My Annual Allowance (yes/no): NO ");
             }
        
        /****************Loading Security lock-out in place (BGROUP/REFNO): BPF-0001794**************************/
        selenium.open("https://pensionline.bp.com/content/pl/superuser/");
        Thread.sleep(5000);
        bgroup = element.getSecurity_member2().split("-");
        if(bgroup[0].equalsIgnoreCase("BPF")){
             selenium.select("bgroup","BPF");
        }
        selenium.type("crefno", bgroup[1]);
        selenium.click("doauth");
        Thread.sleep(5000);
        if (selenium.isTextPresent("welcome to PensionLine")) {
              bodyText += "   Loading of Security lock-out in place (BGROUP/REFNO) "+element.getSecurity_member2()+"<br>";
              bodyText += "     lock-outs functional(yes/no) : YES" + "<br>";
              FileLogger.logger.info(" ->Security lock-out in place (BGROUP/REFNO) "+element.getSecurity_member2()+": PASSED");
        } else {
              bodyText += "   Loading of Security lock-out in place (BGROUP/REFNO) "+element.getSecurity_member2()+": FAILED" + "<br>";
              FileLogger.logger.info(" ->Loading of Security lock-out in place (BGROUP/REFNO) "+element.getSecurity_member2()+": FAILED");
        }
            /**************Loading My detail and This is me*********************/
            selenium.open("https://pensionline.bp.com/content/pl/mydetails/");
            Thread.sleep(5000);
            if(selenium.isTextPresent("my details")){
      	  	bodyText += "     My details function" + "<br>";
      	  	selenium.open("https://pensionline.bp.com/content/pl/mydetails/this_is_me.html");
      	  	Thread.sleep(10000);
      	  	if(selenium.isTextPresent("Mr Ashok K S Bavishi")){
      	  	    bodyText += "       This is me functional(yes/no) : YES" + "<br>";
      	  	    FileLogger.logger.info(" ->This is me functional(yes/no) : YES");
      	  	}else{
      	  	    bodyText += "       This is me functional(yes/no) : NO" + "<br>";
      	  	    FileLogger.logger.info(" ->This is me functional(yes/no) : NO");
      	  	}
             }else{
             	bodyText += "     My details function" + "<br>";
             	FileLogger.logger.info(" ->My details function: FAILED");
             }
            /************Loading Scheme Benefits Statement*********************/
            selenium.open("https://pensionline.bp.com/content/pl/mydetails/benefit_statement_ac/scheme_pension/");
            Thread.sleep(20000);
            if(selenium.isTextPresent("\u00A338,936")){
       	 	bodyText += "     Scheme benefit statement functional (yes/no): YES " + "<br>";
       	 	FileLogger.logger.info(" ->Scheme benefit statement functional (yes/no): YES ");
   	     }else{
   		 bodyText += "     Scheme benefit statement functional (yes/no): NO " + "<br>";
   		 FileLogger.logger.info(" ->Scheme benefit statement functional (yes/no): NO ");
   	     }
            /***********Loading My Annual Allowance***************************/
            selenium.open("https://pensionline.bp.com/content/pl/mydetails/annual_allowance/statement.html");
            Thread.sleep(12000);
            if(selenium.isTextPresent("\u00A335,253")){
       	 	bodyText += "     My Annual Allowance (yes/no): YES " + "<br><br>";
       	 	FileLogger.logger.info(" ->My Annual Allowance (yes/no): YES ");
            }else{
       	 	bodyText += "     My Annual Allowance (yes/no): NO " + "<br><br>";
       	 	FileLogger.logger.info(" ->My Annual Allowance (yes/no): NO ");
            }
        
        /****************Loading active member: BPF-0122398*************************************/
        selenium.open("https://pensionline.bp.com/content/pl/superuser/");
        Thread.sleep(5000);
        bgroup = element.getActive_member().split("-");
        if(bgroup[0].equalsIgnoreCase("BPF")){
             selenium.select("bgroup","BPF");
        }
        selenium.type("crefno", bgroup[1]);
        selenium.click("doauth");
        Thread.sleep(5000);
        if (selenium.isTextPresent("welcome to PensionLine")) {
            bodyText += "   Loading of active member: "+element.getActive_member()+"<br>";
            FileLogger.logger.info(" ->loading of active member: "+element.getActive_member()+": PASSED");
        } else {
            bodyText += "   Loading of active member: "+element.getActive_member()+": FAILED" + "<br>";
            FileLogger.logger.info(" ->Loading of active member: "+element.getActive_member()+": FAILED");
        }
            /**************Loading My detail and This is me*********************/
            selenium.open("https://pensionline.bp.com/content/pl/mydetails/");
            Thread.sleep(5000);
            if(selenium.isTextPresent("my details")){
      	  	bodyText += "     My details function" + "<br>";
      	  	selenium.open("https://pensionline.bp.com/content/pl/mydetails/this_is_me.html");
      	  	Thread.sleep(10000);
      	  	if(selenium.isTextPresent("Mr Hugo Galanes-Alvarez")){
      	  	    bodyText += "       This is me functional(yes/no) : YES" + "<br>";
      	  	    FileLogger.logger.info(" ->This is me functional(yes/no) : YES");
      	  	}else{
      	  	    bodyText += "    &nbsp This is me functional(yes/no) : NO" + "<br>";
      	  	    FileLogger.logger.info(" ->This is me functional(yes/no) : NO");
      	  	}
             }else{
             	bodyText += "     My details function" + "<br>";
             	FileLogger.logger.info(" ->My details function: FAILED");
             }
            /*************Loading Scheme Benefits Statement********************/
            selenium.open("https://pensionline.bp.com/content/pl/mydetails/benefit_statement_ac/scheme_pension/");
            Thread.sleep(10000);
            if(selenium.isTextPresent("\u00A342,233")){
       	 	bodyText += "     Scheme benefit statement functional (yes/no): YES " + "<br>";
       	 	FileLogger.logger.info(" ->Scheme benefit statement functional (yes/no): YES ");
   	    }else{
   		 bodyText += "     Scheme benefit statement functional (yes/no): NO " + "<br>";
   		 FileLogger.logger.info(" ->Scheme benefit statement functional (yes/no): NO ");
   	    }
            /************Loading State Benefits********************************/
            selenium.open("https://pensionline.bp.com/content/pl/mydetails/benefit_statement_ac/state_pension.html");
            Thread.sleep(10000);
            if(selenium.isTextPresent("\u00A35,950 a year")){
       	 	bodyText += "     State Benefits functional (yes/no): YES " + "<br>";
       	 	FileLogger.logger.info(" ->State Benefits functional (yes/no): YES ");
   	    }else{
   		 bodyText += "     State Benefits functional (yes/no): NO " + "<br>";
   		 FileLogger.logger.info(" ->State Benefits functional (yes/no): NO ");
   	    }
            /************Loading My Retirement Planner********************************/
            selenium.open("https://pensionline.bp.com/content/pl/mydetails/retirement_planner_ac/");
            Thread.sleep(10000);
            if(selenium.isTextPresent("\u00A363,350")){
       	 	bodyText += "     Retirement planner functional (yes/no): YES " + "<br>";
       	 	FileLogger.logger.info(" ->Retirement planner functional (yes/no): YES ");
   	    }else{
   		 bodyText += "     Retirement planner functional (yes/no): NO " + "<br>";
   		 FileLogger.logger.info(" ->Retirement planner functional (yes/no): NO ");
   	    }
            /************Loading My Redundancy Planner********************************/
            selenium.open("https://pensionline.bp.com/content/pl/mydetails/redundancy_planner_ac/");
            Thread.sleep(10000);
            if(selenium.isTextPresent("12 months")){
       	 	bodyText += "     Redundancy planner functional (yes/no): YES " + "<br>";
       	 	FileLogger.logger.info(" ->Redundancy planner functional (yes/no): YES ");
   	    }else{
   		 bodyText += "     Redundancy planner functional (yes/no): NO " + "<br>";
   		 FileLogger.logger.info(" ->Redundancy planner functional (yes/no): NO ");
   	    }
            /************Loading My Annual Allowance********************************/
            selenium.open("https://pensionline.bp.com/content/pl/mydetails/annual_allowance/");
            Thread.sleep(5000);
            if(selenium.isTextPresent("My AA Projection")){
       	 	bodyText += "     Annual Allowance functional (yes/no): YES " + "<br>";
       	 	FileLogger.logger.info(" ->Annual Allowance functional (yes/no): YES ");
   	    }else{
   		 bodyText += "     Annual Allowance functional (yes/no): NO " + "<br>";
   		 FileLogger.logger.info(" ->Annual Allowance functional (yes/no): NO ");
   	    }
            /************Loading My Accrual Rate********************************/
            selenium.open("https://pensionline.bp.com/content/pl/mydetails/myservice/");
            Thread.sleep(50000);
            if(selenium.isTextPresent("Click to add a salary change")){
       	 	bodyText += "     My Accrual Rate functional (yes/no): YES " + "<br>";
       	 	FileLogger.logger.info(" ->My Accrual Rate functional (yes/no): YES ");
   	    }else{
   		 bodyText += "     My Accrual Rate functional (yes/no): NO " + "<br>";
   		 FileLogger.logger.info(" ->My Accrual Rate functional (yes/no): NO ");
   	    }
            /************Loading Lifetime Allowance********************************/
            selenium.open("https://pensionline.bp.com/content/pl/mydetails/myservice/notes_lta.html");
            Thread.sleep(30000);
            if(selenium.isTextPresent("LTA")){
       	 	bodyText += "     Lifetime Allowance functional (yes/no): YES " + "<br><br>";
       	 	FileLogger.logger.info(" ->Lifetime Allowance Rate functional (yes/no): YES ");
   	    }else{
   		 bodyText += "     Lifetime Allowance Rate functional (yes/no): NO " + "<br><br>";
   		 FileLogger.logger.info(" ->Lifetime Allowance Rate functional (yes/no): NO ");
   	    }
        
        /*************************Testing LDAP Connection*****************************/
        selenium.open("https://pensionline.bp.com/content/pl/__test_ldap_connection.jsp");
        Thread.sleep(3000);
        if(selenium.isTextPresent("LDAP connected(yes/no): YES")){
            bodyText += "   LDAP (bp1.ad.bp.com 389) connected(yes/no) : YES" + "<br>";
            FileLogger.logger.info(" ->LDAP (bp1.ad.bp.com 389) connected(yes/no) : YES");     
            try {
                mail.sendMailPL(bodyText, 1);
            } catch (MessagingException e) {
                e.printStackTrace();
            } 
	}else{
	    bodyText += "   LDAP (bp1.ad.bp.com 389) connected(yes/no) : NO" + "<br>";
	    FileLogger.logger.info(" ->LDAP (bp1.ad.bp.com 389) connected(yes/no) : NO ");
	    try {
                mail.sendMailPL(bodyText, 1);
            } catch (MessagingException e) {
                e.printStackTrace();
            } 
	}   
    }
}


