package com.gms.dao.admin;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gms.commons.Common;
import com.gms.commons.DBConnection;
import com.gms.commons.SQLConnection;
import com.gms.model.admin.GridCase;
import com.gms.model.admin.GrievanceDesc;
import com.gms.model.grievance.TriggerEmailData;

import oracle.jdbc.OracleTypes;

public class ReopenCaseDAO {
	
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ReopenCaseDAO.class.getName());
	public static GrievanceDesc getGrievanceDesc(int GRVDETID) throws SQLException{
	    Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    GrievanceDesc grievanceDesc= new GrievanceDesc();
	    
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_ADM_REOPEN_CASE_SCR.GMS_MA_CC_SEARCH_GRID_LIST(?,?,?)}");
	        cst.setInt(1, GRVDETID);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(2);
			if (rs.next()) {		
				grievanceDesc.setGRVDETID(rs.getInt("GRVDETID"));
				grievanceDesc.setCASEID(rs.getInt("CASEID"));
				grievanceDesc.setCASENUMBER(rs.getString("CASENUMBER"));
				grievanceDesc.setMAIN_CATEGORY_CODE(rs.getString("MAIN_CATEGORY_CODE"));
				grievanceDesc.setMAIN_CATEGORY_NAME(rs.getString("MAIN_CATEGORY_NAME"));
				grievanceDesc.setSUB_CATEGORY_CODE(rs.getString("SUB_CATEGORY_CODE"));
				grievanceDesc.setSUB_CATEGORY_NAME(rs.getString("SUB_CATEGORY_NAME"));
				grievanceDesc.setNAME(rs.getString("NAME"));
				grievanceDesc.setCOMPLAINT_DESC(rs.getString("COMPLAINT_DESC"));
				grievanceDesc.setRESPONDENT_EMPLOYEE_ID(rs.getInt("RESPONDENT_EMPLOYEE_ID"));
				grievanceDesc.setRESPONDENT_EMPLOYEE_NAME(rs.getString("RESPONDENT_EMPLOYEE_NAME"));
				grievanceDesc.setGRVID(rs.getInt("GRVID"));
				grievanceDesc.setCOMPLIANT_EMPLOYEE_ID(rs.getInt("COMPLIANT_EMPLOYEE_ID"));
				grievanceDesc.setGROUP_COMPLIANT(rs.getString("GROUP_COMPLIANT"));
				grievanceDesc.setSTATUSID(rs.getInt("STATUSID"));
				grievanceDesc.setSTATUSNAME(rs.getString("STATUSNAME"));
			
			}
			return grievanceDesc;
	    } catch (SQLException ex) {
	       	 ex.printStackTrace();
	       	Logger.getLogger(ReopenCaseDAO.class.getName()).log(Level.SEVERE, null, ex);
	    } finally {
            if (cst != null) {
                DBConnection.closeStatement(cst);
            }
            if (rs != null) {
                DBConnection.closeResultSet(rs);
            }
            if (con != null) {
                DBConnection.closeConnection(con);
            }
	    }
	    
	   return null;
	  }
	
	public static List<GridCase> getGridCase(int GRVDETID) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_ADM_REOPEN_CASE_SCR.GMS_MA_CC_SEARCH_GRID_LIST(?,?,?)}");
	        cst.setInt(1, GRVDETID);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(3);
			List<GridCase> list = new ArrayList<GridCase>();
			while (rs.next()) {
			    list.add(new GridCase( rs.getInt("CASEID"), rs.getString("HIERCODE"), rs.getInt("HIERORDER"),rs.getString("TAT_START_DATE"),rs.getString("TAT_END_DATE"),rs.getString("CURRENT_ROW_COMPLETED"),rs.getString("CURRENT_ROW_ACTIVE"),rs.getString("IS_ACTIVE"),rs.getInt("INVESTIGATOR_EMPLOYEE_ID"),rs.getString("NAME")));
			}
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(ReopenCaseDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (cst != null) {
                DBConnection.closeStatement(cst);
            }
            if (rs != null) {
                DBConnection.closeResultSet(rs);
            }
            if (con != null) {
                DBConnection.closeConnection(con);
            }
		}
		return null;
	}
	
	public static boolean reopenCaseStatus(GridCase gridCase) throws SQLException, java.text.ParseException {
		Date date=Date.valueOf((Common.StringToDateFormat(gridCase.getREOPEN_DATE())));
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_DT_GRIEVANCE.GMS_ADM_REOPEN_CASE(?,?,?,?,?,?,?)}");
			cst.setInt(1,gridCase.getCASEID());
			cst.setInt(2, gridCase.getGRVDETID());
			cst.setInt(3, gridCase.getHIERORDER());
			cst.setDate(4, date);
			cst.setInt(5, gridCase.getREOPEN_HIERORDER());
			cst.setString(6, gridCase.getREOPEN_REASON());
			cst.registerOutParameter(7,OracleTypes.INTEGER);
			cst.execute();
			int grivId = cst.getInt(7);;
				if(grivId != 0) {
					List<TriggerEmailData> triggerMail = getMailData(grivId);
					insertMailingDetails(triggerMail);
				}
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(ReopenCaseDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(cst != null) {
				DBConnection.closeStatement(cst);
			}
			if(con != null) {
				DBConnection.closeConnection(con);
			}
		}
		return false;
	}
	
	/*public static List<GridCase> getCaseReopenLevel(int GRVDETID) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_ADM_REOPEN_CASE_SCR.GMS_REOPEN_HIERORDER_DDL(?,?)}");
	        cst.setInt(1, GRVDETID);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(2);
			List<GridCase> list = new ArrayList<GridCase>();
			while (rs.next()) {
				GridCase gridCase = new GridCase();
				gridCase.setHIERORDER(rs.getInt("HIERORDER"));
				list.add(gridCase);
			}
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(ReopenCaseDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (cst != null) {
                DBConnection.closeStatement(cst);
            }
            if (rs != null) {
                DBConnection.closeResultSet(rs);
            }
            if (con != null) {
                DBConnection.closeConnection(con);
            }
		}
		return null;
	} */
	public static List<GridCase> getCaseReopenLevel(int GRVDETID) throws SQLException{
		Connection con = null;
		PreparedStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			String sql = "SELECT DISTINCT HIERORDER FROM GMS_DT_CASE WHERE IS_ACTIVE='Y' AND HIERORDER <> 1 ORDER BY HIERORDER";
	        cst = con.prepareStatement(sql);
            rs= cst.executeQuery();
			List<GridCase> list = new ArrayList<GridCase>();
			while (rs.next()) {
				GridCase gridCase = new GridCase();
				gridCase.setHIERORDER(rs.getInt("HIERORDER"));
				list.add(gridCase);
			}
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(ReopenCaseDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (cst != null) {
                DBConnection.closeStatement(cst);
            }
            if (rs != null) {
                DBConnection.closeResultSet(rs);
            }
            if (con != null) {
                DBConnection.closeConnection(con);
            }
		}
		return null;
	}
	
	public static List<TriggerEmailData> getMailData(int grvId) throws SQLException{
		logger.info("Inside the getMailData() method");
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
			try {
				con = DBConnection.getConnection();
				cst = con.prepareCall("{ call PCK_GMS_DT_GRIEVANCE.EMAIL_SELECT1(?,?)}");
				cst.setInt(1, grvId);
				cst.registerOutParameter(2, OracleTypes.CURSOR);
				cst.execute();
	            rs=(ResultSet)cst.getObject(2);
				List<TriggerEmailData> list = new ArrayList<TriggerEmailData>();
				while (rs.next()) {
					TriggerEmailData emailList = new TriggerEmailData();
					emailList.setSendTo(rs.getString("EMAILTO"));
					emailList.setSendCC(rs.getString("EMAILCC"));
					emailList.setSubject(rs.getString("EMAILSUBJECT"));
					emailList.setMessage(rs.getString("EMAILCONTENT"));
					list.add(emailList);
				}
		        return list;
			} catch (Exception ex) {
					ex.printStackTrace();
					logger.info("Exception Inside the getMailData() method Exception "+ex.getMessage());
			} finally {
				if (cst != null) {
	                DBConnection.closeStatement(cst);
	            }
	            if (rs != null) {
	                DBConnection.closeResultSet(rs);
	            }
	            if (con != null) {
	                DBConnection.closeConnection(con);
	            }
			}
		logger.info("Leaving the getMailData() method");
		return null;
	}
	
	public static int insertMailingDetails(List<TriggerEmailData> list) throws SQLException {
		logger.info("Inside the insertMailingDetails() method");
		System.out.println("Inside the insertMailingDetails() method");
		Connection con= null;
		PreparedStatement ps = null;
	    int count = 0;
	    int insertCount = 0;
	    System.out.println("Inside the insertMailingDetails() method"+list.toString());	
	    	try {
	    		 System.out.println("Inside the insertMailingDetails() method try block size"+list.size());
				 con= SQLConnection.getConnection();
				 String sql = "insert into MailRequest (Class, SendTo, SendCC, SendBcc, Message, Attachement, AttahementType, AttachName,"+ 
					 		"SendType, Priority, SUBJECT, status, SendOn, AttachSize, ReqOn, SentOn, AttahementType1, Attachement1, AttachName1, "+
					 		"AttachSize1, Attachement2, AttahementType2, AttachName2, AttachSize2, Attachement3, AttahementType3, AttachName3, "+
					 		"AttachSize3, Attachement4, AttahementType4, AttachName4, AttachSize4, SysID, RefNO, OpType, Err_Description)	values ( "
					 		+ " 'M-pos', ?, ?, '', ?, '', '', '', 'html', '', ?, '', '', '', getdate(), getdate(), '', '', '', '', '', '', '', "
					 		+ " '', '', '', '', '', '', '', '', '', 'GMS', '', '', '') ";
				 con.setAutoCommit(false);
				 ps = con.prepareStatement(sql);
				 for (TriggerEmailData details : list) {
					 ps.setString(1, details.getSendTo());
					 ps.setString(2, details.getSendCC());
					 ps.setString(3, details.getMessage());
					 ps.setString(4, details.getSubject());
					 ps.addBatch();
					 count++;
					 if(count % 10000 == 0){
						 int[] result = ps.executeBatch();
						 insertCount += result.length;
					 }
				 	}
				 	int[] result = ps.executeBatch();
				 	insertCount += result.length;
				 	con.commit();
			} catch(Exception ex) {
				ex.printStackTrace();
				System.out.println(ex.getMessage());
			} finally {
				if(ps != null) {
					SQLConnection.closeStatement(ps);
				} 
				if(con!= null) {
					SQLConnection.closeConnection(con);
				}
			}
			return insertCount;
	}
}
