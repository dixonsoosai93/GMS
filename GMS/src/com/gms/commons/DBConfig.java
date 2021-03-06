package com.gms.commons;

public interface DBConfig {
   /* 
	// New oracle Database with all the connection details
	
	String USERNAME = "HigherUser as default";
    String PASSWORD = "kuchbhi1234";
    String DRIVER = "oracle.jdbc.driver.OracleDriver";
    String CONNECTION_URL = "jdbc:oracle:thin:@181.215.242.88:20480:xe";
	
    // sql server details
    
    String SQL_USERNAME = "Akash";
    String SQL_PASSWORD = "Akash@123#";
    String SQL_HOST = "13.235.150.162";
    String SQL_DATABASE_NAME = "GMS";
    String SQL_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String SQL_CONNECTION_URL = "jdbc:sqlserver://"+SQL_HOST+";databaseName="+SQL_DATABASE_NAME;
    */
    
    // Production Details for 
    String SQL_USERNAME = "temp";
    String SQL_PASSWORD = "temp";
    String SQL_HOST = "10.32.152.176:21433";
    String SQL_DATABASE_NAME = "DB_MAILS";
    String SQL_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String SQL_CONNECTION_URL = "jdbc:sqlserver://"+SQL_HOST+";databaseName="+SQL_DATABASE_NAME;
    
   	//DB Connection UAT as on 30-10
    String USERNAME = "HALERTS";
    String PASSWORD = "HALERTS";
    String DRIVER = "oracle.jdbc.driver.OracleDriver";
    String CONNECTION_URL = "jdbc:oracle:thin:@10.32.151.35:1521:HRCOMP";
	
    /*
    //DB Connection UAT prior to 30-10
    String USERNAME = "HALERTS";
    String PASSWORD = "HALERTS";
    String DRIVER = "oracle.jdbc.driver.OracleDriver";
    String CONNECTION_URL = "jdbc:oracle:thin:@10.32.151.34:1521:HRCOMP";
    */
    
    //DB Connection Prod
    /* String USERNAME = "italicdata";
    String PASSWORD = "italicdata";
    String DRIVER = "oracle.jdbc.driver.OracleDriver";
    String CONNECTION_URL = "jdbc:oracle:thin:@10.32.151.205:1521:PII1";
   */  
    
    /*
    String USERNAME = "sys as sysdba";
    String PASSWORD = "sys";
    String DRIVER = "oracle.jdbc.driver.OracleDriver";
    String CONNECTION_URL = "jdbc:oracle:thin:@36.255.0.246:1521:WhatsappInt";
	*/
    
    //LDAP URL for UAT
    String ENVIRONMENT = "UAT";
    String LDAPURL = "ldap://10.32.128.40:389";
    String FACTINIT = "com.sun.jndi.ldap.LdapCtxFactory";
    String LDAPPRINCIPAL = ",OU=Employees,OU=Users,OU=OTL,OU=India,OU=Life,OU=Q5,DC=q5-core,DC=q5,DC=aig,DC=net";
   
    
    //LDAP URL for PROD
   /* String ENVIRONMENT = "PROD";
    String LDAPURL = "ldap://advip:389";
    String FACTINIT = "com.sun.jndi.ldap.LdapCtxFactory";
    String LDAPPRINCIPAL = ",OU=General Users,OU=Employees,OU=Users,OU=OTL,OU=India,OU=Life,OU=R5,DC=r5-core,DC=r5,DC=aig,DC=net";
*/

}
