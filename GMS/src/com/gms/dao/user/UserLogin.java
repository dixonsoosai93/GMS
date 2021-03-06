package com.gms.dao.user;

import static com.gms.commons.DBConfig.FACTINIT;
import static com.gms.commons.DBConfig.LDAPPRINCIPAL;
import static com.gms.commons.DBConfig.LDAPURL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;

import com.gms.commons.DBConnection;
import com.gms.model.masters.ManpowerModel;
import com.gms.model.user.Admin;

import oracle.jdbc.OracleTypes;

public class UserLogin {
	static Logger logger = Logger.getLogger(UserLogin.class.getName());
	
	public static ManpowerModel isAuthenticated(Admin admin) throws SQLException {
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
//			boolean loginFlag = UserLogin.NTLogin(admin.getLOGIN_ID(),admin.getADMIN_PASSWORD());
//            if(loginFlag){
				con = DBConnection.getConnection();
				//cst = con.prepareCall("{call PCK_GMS_SEC_LOGIN_SCR.GMS_SEC_LOGIN_EMPLOYEE(?,?)}");
				cst = con.prepareCall("{call PCK_GMS_SEC_LOGIN_SCR.GMS_SEC_NT_LOGIN_EMPLOYEE(?,?)}");
				cst.setString(1, admin.getLOGIN_ID());
				cst.registerOutParameter(2, OracleTypes.CURSOR);
				cst.execute();
				rs=(ResultSet)cst.getObject(2);
				ManpowerModel Manpower =new ManpowerModel();
					while (rs.next()) {
						Manpower.setNAME(rs.getString("NAME"));
						Manpower.setEMPLOYEE_ID(rs.getString("EMPLOYEE_ID"));
					}
			        return Manpower;
 //           }
		} catch (Exception ex) {
			ex.printStackTrace();
			 Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(cst != null) {
				DBConnection.closeStatement(cst);
			}
			if(con != null) {
				DBConnection.closeConnection(con);
			}
		}
		return null;
	}
	
	public static ManpowerModel isAuthenticatedInvestigator(Admin admin) throws SQLException {
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
//			boolean loginFlag = UserLogin.NTLogin(admin.getLOGIN_ID(),admin.getADMIN_PASSWORD());
//	            if(loginFlag){
				con = DBConnection.getConnection();
				//cst = con.prepareCall("{call PCK_GMS_SEC_LOGIN_SCR.GMS_SEC_LOGIN_INVESTIGATOR(?,?)}");
				cst = con.prepareCall("{call PCK_GMS_SEC_LOGIN_SCR.GMS_SEC_NT_LOGIN_INVESTIGATOR(?,?)}");
				cst.setString(1, admin.getLOGIN_ID());
				cst.registerOutParameter(2, OracleTypes.CURSOR);
				cst.execute();
				rs=(ResultSet)cst.getObject(2);
				ManpowerModel Manpower =new ManpowerModel();
					while (rs.next()) {
					Manpower.setNAME(rs.getString("NAME"));
					Manpower.setEMPLOYEE_ID(rs.getString("EMPLOYEE_ID"));
			        }  
						return Manpower;
 //           }
		} catch (Exception ex) {
			ex.printStackTrace();
			 Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(cst != null) {
				DBConnection.closeStatement(cst);
			}
			if(con != null) {
				DBConnection.closeConnection(con);
			}
		}
		return null;
	}
	 
	public static ManpowerModel isAuthenticatedAdmin(Admin admin) throws SQLException {
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
//			boolean loginFlag = UserLogin.NTLogin(admin.getLOGIN_ID(),admin.getADMIN_PASSWORD());
//            if(loginFlag){
				con = DBConnection.getConnection();
				//cst = con.prepareCall("{call PCK_GMS_SEC_LOGIN_SCR.GMS_SEC_LOGIN_ADMIN(?,?)}");
				cst = con.prepareCall("{call PCK_GMS_SEC_LOGIN_SCR.GMS_SEC_NT_LOGIN_ADMIN(?,?)}");
				cst.setString(1, admin.getLOGIN_ID());
				cst.registerOutParameter(2, OracleTypes.CURSOR);
				cst.execute();
				rs=(ResultSet)cst.getObject(2);
				ManpowerModel Manpower =new ManpowerModel();
					while (rs.next()) {
						Manpower.setNAME(rs.getString("NAME"));
						Manpower.setEMPLOYEE_ID(rs.getString("EMPLOYEE_ID"));
					}
				return Manpower;
 //           }
		} catch (Exception ex) {
			ex.printStackTrace();
			 Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(cst != null) {
				DBConnection.closeStatement(cst);
			}
			if(con != null) {
				DBConnection.closeConnection(con);
			}
		}
		return null;
	}
	
	public static boolean NTLogin(String username,String password) throws NamingException
    {
        //logger.debug(" ---- Inside the NTLogin method ---- ");
       // System.out.println(username);
       // System.out.println(password);
        boolean loginFlag=true;
        try{
            InitialDirContext context = null;
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, FACTINIT);
            props.put(Context.PROVIDER_URL, LDAPURL);
            props.put(Context.SECURITY_PRINCIPAL, "CN="+username.trim()+LDAPPRINCIPAL);
            props.put(Context.SECURITY_CREDENTIALS, password);
            context = new InitialDirContext(props);
            context.close();
            loginFlag=true;
        }catch(NamingException e){
            loginFlag=false;
            e.printStackTrace();
          	logger.info("Exception in the NTLogin() method  Exception : "+ e.getMessage());
         
        }
       // logger.debug(" ---- Leaving the NTLogin method ---- ");
        return loginFlag;
    }


}
