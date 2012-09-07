

/*
 * Copyright (c) CMG Ltd All rights reserved.

 *
 * This software is the confidential and proprietary information of CMG
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with CMG.
 */
 package com.bp.pensionline.automation.util; 

import java.io.IOException;
import java.util.Properties;

/** 
 * DOCME * 
 * 
 * @author Long Nguyen *
 * @version .Revision: # .Date:Sep 5, 2012*
 */
public class Element {
    private String url_prod;
    private String username;
    private String password;
    private String administrator;
    private String adminpass;
    private String monitor_prod;
    private String wall_member1;
    private String wall_member2;
    private String wall_member3;
    private String deferred_member;
    private String pensioner_member1;
    private String pensioner_member2;
    private String pensioner_member3;
    private String security_member1;
    private String security_member2;
    private String active_member;
    private String ldap_connection;
    
    public Element(){
	
    }
    
    Properties props = new Properties();
    public String getUrl_prod() {
        return url_prod;
    }

    public void setUrl_prod(String url_prod) {
        this.url_prod = url_prod;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    public String getAdminpass() {
        return adminpass;
    }

    public void setAdminpass(String adminpass) {
        this.adminpass = adminpass;
    }

    public String getMonitor_prod() {
        return monitor_prod;
    }

    public void setMonitor_prod(String monitor_prod) {
        this.monitor_prod = monitor_prod;
    }

    public String getWall_member1() {
        return wall_member1;
    }

    public void setWall_member1(String wall_member1) {
        this.wall_member1 = wall_member1;
    }

    public String getWall_member2() {
        return wall_member2;
    }

    public void setWall_member2(String wall_member2) {
        this.wall_member2 = wall_member2;
    }

    public String getWall_member3() {
        return wall_member3;
    }

    public void setWall_member3(String wall_member3) {
        this.wall_member3 = wall_member3;
    }

    public String getDeferred_member() {
        return deferred_member;
    }

    public void setDeferred_member(String deferred_member) {
        this.deferred_member = deferred_member;
    }

    public String getPensioner_member1() {
        return pensioner_member1;
    }

    public void setPensioner_member1(String pensioner_member1) {
        this.pensioner_member1 = pensioner_member1;
    }

    public String getPensioner_member2() {
        return pensioner_member2;
    }

    public void setPensioner_member2(String pensioner_member2) {
        this.pensioner_member2 = pensioner_member2;
    }

    public String getPensioner_member3() {
        return pensioner_member3;
    }

    public void setPensioner_member3(String pensioner_member3) {
        this.pensioner_member3 = pensioner_member3;
    }

    public String getSecurity_member1() {
        return security_member1;
    }

    public void setSecurity_member1(String security_member1) {
        this.security_member1 = security_member1;
    }

    public String getSecurity_member2() {
        return security_member2;
    }

    public void setSecurity_member2(String security_member2) {
        this.security_member2 = security_member2;
    }

    public String getActive_member() {
        return active_member;
    }

    public void setActive_member(String active_member) {
        this.active_member = active_member;
    }

    public String getLdap_connection() {
        return ldap_connection;
    }

    public void setLdap_connection(String ldap_connection) {
        this.ldap_connection = ldap_connection;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }
    
    public void loadProperties(){
	try {
		props.load(this.getClass().getResourceAsStream("/com/bp/pensionline/automation/util/element.properties"));
		this.setUrl_prod(props.getProperty("url_prod"));
		this.setUsername(props.getProperty("username"));
		this.setPassword(props.getProperty("password"));
		this.setAdministrator(props.getProperty("administrator"));
		this.setAdminpass(props.getProperty("adminpass"));
		this.setMonitor_prod(props.getProperty("monitor_prod"));
		this.setWall_member1(props.getProperty("wall_member1"));
		this.setWall_member2(props.getProperty("wall_member2"));
		this.setWall_member3(props.getProperty("wall_member3"));
		this.setDeferred_member(props.getProperty("deferred_member"));
		this.setPensioner_member1(props.getProperty("pensioner_member1"));
		this.setPensioner_member2(props.getProperty("pensioner_member2"));
		this.setPensioner_member3(props.getProperty("pensioner_member3"));
		this.setSecurity_member1(props.getProperty("security_member1"));
		this.setSecurity_member2(props.getProperty("security_member2"));
		this.setActive_member(props.getProperty("active_member"));
		this.setLdap_connection(props.getProperty("ldap_connection"));
	} catch (IOException e) {
		e.printStackTrace();
	}
    }
}

