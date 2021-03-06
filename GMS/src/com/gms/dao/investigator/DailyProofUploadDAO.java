package com.gms.dao.investigator;

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
import com.gms.model.grievance.TriggerEmailData;
import com.gms.model.investigator.CaseView;
import com.gms.model.investigator.DailyDairyProof;
import com.gms.model.investigator.DecisionReport;
import com.gms.model.investigator.DtVerdict;

import oracle.jdbc.OracleTypes;

public class DailyProofUploadDAO {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DailyProofUploadDAO.class.getName());
	
	public static boolean insertDtVerdict(DtVerdict DtVerdict) throws SQLException, java.text.ParseException  {
		logger.info("Inside the insertDtVerdict() method");
		Date date=Date.valueOf((Common.StringToDateFormat(DtVerdict.getVERDICT_REPORT_DATE())));
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_DT_VERDICT.GMS_DT_VERDICT_INSERT(?,?, ?,?,?, ?,?)}");
			cst.setInt(1, DtVerdict.getCASEID());
			cst.setInt(2,DtVerdict.getGRVDETID());
			cst.setDate(3,date);
			cst.setString(4,DtVerdict.getVERDICT_REPORT_CONTENT());
			cst.setString(5, DtVerdict.getIS_ACTIVE());
			cst.setInt(6,1);
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
			logger.info("Exception Inside the insertDtVerdict() method Exception"+ex.getMessage());
			Logger.getLogger(DailyProofUploadDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(cst != null) {
				DBConnection.closeStatement(cst);
			}
			if(con != null) {
				DBConnection.closeConnection(con);
			}
		}
		logger.info("Leaving the insertDtVerdict() method");
		return false;
	}
	
	public static CaseView getViewCaseRecord(int CASEID, int GRVDETID, int GRVID) throws SQLException{
		logger.info("Inside the getViewCaseRecord() method");
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_DAILY_DAIRY_SCR.GMS_DAILY_DAIRY_CASE_VIEW(?,?,?,?,?,?)}");
			cst.setInt(1, CASEID);
			cst.setInt(2, GRVDETID);
			cst.setInt(3, GRVID);
			cst.registerOutParameter(4, OracleTypes.CURSOR);
			cst.registerOutParameter(5, OracleTypes.CURSOR);
			cst.registerOutParameter(6, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(4);
			CaseView caseview = null;
			while (rs.next()) {
				caseview=  (new CaseView(rs.getInt("GRVID"),rs.getInt("COMPLIANT_EMPLOYEE_ID"), rs.getString("NAME"), rs.getString("COMPLAINT_DESC"), rs.getInt("GRVDETID"),rs.getInt("RESPONDENT_EMPLOYEE_ID"),rs.getString("RESPONDENT_EMPLOYEE_NAME"),rs.getInt("CASEID"),rs.getString("CASENUMBER"),rs.getString("MAIN_CATEGORY_CODE"),rs.getString("SUB_CATEGORY_CODE"),rs.getInt("INVESTIGATOR_EMPLOYEE_ID"),rs.getString("HIERCODE"),rs.getString("HIERORDER"),rs.getString("TAT_START_DATE"),rs.getString("TAT_END_DATE"),rs.getString("IS_ACTIVE"),rs.getString("MAIN_CATEGORY_NAME"),rs.getString("SUB_CATEGORY_NAME"),rs.getString("INVESTIGATOR_TYPE")));
			}
	        return caseview;
		} catch (Exception ex) {
				ex.printStackTrace();
				logger.info("Exception Inside the getViewCaseRecord() method Exception "+ex.getMessage());
				Logger.getLogger(DailyProofUploadDAO.class.getName()).log(Level.SEVERE, null, ex);
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
		logger.info("Leaving the getViewCaseRecord() method");
		return null;
	}
	
	public static List<CaseView> getComplainantName(int CASEID,int GRVDETID,int GRVID) throws SQLException{
		logger.info("Inside the getComplainantName() method");
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_DAILY_DAIRY_SCR.GMS_DAILY_DAIRY_CASE_VIEW(?,?,?,?,?,?)}");
			cst.setInt(1, CASEID);
			cst.setInt(2, GRVDETID);
			cst.setInt(3, GRVID);
			cst.registerOutParameter(4, OracleTypes.CURSOR);
			cst.registerOutParameter(5, OracleTypes.CURSOR);
			cst.registerOutParameter(6, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(5);
            List<CaseView> list = new ArrayList<CaseView>();
            while (rs.next()) {
			    list.add(new CaseView(rs.getInt("EMPLOYEE_ID"), rs.getString("NAME")));
			}
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				logger.info("Exception Inside the getComplainantName() method Exception "+ex.getMessage());
				Logger.getLogger(DailyProofUploadDAO.class.getName()).log(Level.SEVERE, null, ex);
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
		logger.info("Leaving the getComplainantName() method");
		return null;
	}
	
	public static boolean updateDecision(DecisionReport DecisionReport) throws SQLException, java.text.ParseException  {
		logger.info("Inside the updateDecision() method");
		Date date=Date.valueOf((Common.StringToDateFormat(DecisionReport.getDECISION_REPORT_DATE())));
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_DT_GRIEVANCE.GMS_DECISION_REPORT_UPDATE(?,?,?)}");
			cst.setInt(1, DecisionReport.getCASEID());
			cst.setDate(2,date);
			cst.setString(3,DecisionReport.getDECISION_REPORT_CONTENT());
			cst.execute();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.info("Exception Inside the updateDecision() method Exception "+ex.getMessage());
			Logger.getLogger(DailyProofUploadDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(cst != null) {
				DBConnection.closeStatement(cst);
			}
			if(con != null) {
				DBConnection.closeConnection(con);
			}
		}
		logger.info("Leaving the updateDecision() method");
		return false;
	}  
	
	public static DtVerdict getDtVerdict(int caseId) throws SQLException{
		logger.info("Inside the getDtVerdict() method");
		Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    DtVerdict dtVerdict = new DtVerdict();
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_DAILY_DAIRY_SCR.GMS_DAILY_DAIRY_FV_GRID_SELECT(?,?)}");
	        cst.setInt(1, caseId);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(2);
			if (rs.next()){
				dtVerdict.setVERDICTID(rs.getInt("VERDICTID"));
				dtVerdict.setCOMPLIANT_EMPLOYEE_ID(rs.getInt("COMPLIANT_EMPLOYEE_ID"));
				dtVerdict.setNAME(rs.getString("NAME"));
				dtVerdict.setVERDICT_REPORT_DATE(rs.getString("VERDICT_REPORT_DATE"));
				dtVerdict.setVERDICT_REPORT_CONTENT(rs.getString("VERDICT_REPORT_CONTENT"));
				dtVerdict.setIS_ACTIVE(rs.getString("IS_ACTIVE"));
			} 
	        return dtVerdict;
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        	 logger.info("Exception Inside the getDtVerdict() method Exception "+ex.getMessage());
	        	 Logger.getLogger(DailyProofUploadDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	    logger.info("Leaving the getDtVerdict() method");
		  return null;
	  }
	
	public static boolean updateFinalVerdict(DtVerdict DtVerdict) throws SQLException, java.text.ParseException  {
		logger.info("Inside the updateFinalVerdict() method");
		Date date=Date.valueOf((Common.StringToDateFormat(DtVerdict.getVERDICT_REPORT_DATE())));
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_DT_VERDICT.GMS_DT_VERDICT_UPDATE(?,?,?,?,?,?)}");
			cst.setInt(1, DtVerdict.getCASEID());
			cst.setInt(2, DtVerdict.getGRVDETID());
			cst.setDate(3,date);
			cst.setString(4,DtVerdict.getVERDICT_REPORT_CONTENT());
			cst.setString(5,DtVerdict.getIS_ACTIVE());
			cst.setInt(6, 1);
			cst.execute();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.info("Exception Inside the updateFinalVerdict() method Exception "+ex.getMessage());
			Logger.getLogger(DailyProofUploadDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(cst != null) {
				DBConnection.closeStatement(cst);
			}
			if(con != null) {
				DBConnection.closeConnection(con);
			}
		}
		logger.info("Leaving the updateFinalVerdict() method");
		return false;
	}
	
	public static DecisionReport getDecisionReport(int caseId) throws SQLException{
		logger.info("Inside the getDecisionReport() method");
		Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    DecisionReport decisionReport = new DecisionReport();
	    
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_DAILY_DAIRY_SCR.GMS_DAILY_DAIRY_DR_GRID_SELECT(?,?)}");
	        cst.setInt(1, caseId);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(2);
			if (rs.next()){
				decisionReport.setGRVDETID(rs.getInt("GRVDETID"));
				decisionReport.setEMPLOYEE_ID(rs.getInt("COMPLIANT_EMPLOYEE_ID"));
				decisionReport.setNAME(rs.getString("NAME"));
				decisionReport.setDECISION_REPORT_DATE(rs.getString("DECISION_REPORT_DATE"));
				decisionReport.setDECISION_REPORT_CONTENT(rs.getString("DECISION_REPORT_CONTENT"));
			} 
	        return decisionReport;
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        	 logger.info("Exception Inside the getDecisionReport() method Exception "+ex.getMessage());
	        	 Logger.getLogger(DailyProofUploadDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	    logger.info("Leaving the getDecisionReport() method");
		  return null;
	  }
	
	public static DailyDairyProof getHierLevel(String invId) throws SQLException{
		logger.info("Inside the getHierLevel() method");
		Connection con = null;
		PreparedStatement cst = null;
		ResultSet rs = null;
		try {
			DailyDairyProof dailyDairyProof = new DailyDairyProof();
			con = DBConnection.getConnection();
			String sql = "SELECT M.NAME, C.HIERCODE FROM GMS_DT_CASE C LEFT JOIN HRC_BCT_MANPOWER M ON M.EMPLOYEE_ID = C.INVESTIGATOR_EMPLOYEE_ID WHERE C.INVESTIGATOR_EMPLOYEE_ID="+invId+"AND ROWNUM=1";
			cst = con.prepareStatement(sql);
			rs = cst.executeQuery();
			if(rs.next()) {
				dailyDairyProof.setHIRECODE(rs.getString("HIERCODE"));
				}
			return dailyDairyProof;
		} catch (Exception e) {
			logger.info("Exception Inside the getHierLevel() method Exception "+e.getMessage());
			e.printStackTrace();
		}  finally {
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
		logger.info("Leaving the getHierLevel() method");
		return null;
	}
			
	public static List<DailyDairyProof> getInvReport(String Report_Type,int id) throws SQLException{
		logger.info("Inside the getInvReport() method");
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_DAILY_DAIRY_SCR.GMS_DAILY_DAIRY_GRID_LIST(?,?,?,?)}");
			cst.setString(1, Report_Type);
			cst.setInt(2, id);
			cst.registerOutParameter(3, OracleTypes.CURSOR);
			cst.registerOutParameter(4, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(3);
			List<DailyDairyProof> list = new ArrayList<DailyDairyProof>();
			while (rs.next()) {
				DailyDairyProof dProof = new DailyDairyProof();
				dProof.setGRVID(rs.getInt("GRVID"));
				dProof.setGRVNUMBER(rs.getString("GRVNUMBER"));
				dProof.setGRVDATE(rs.getString("GRVDATE"));
				dProof.setCOMPLIANT_EMPLOYEE_ID(rs.getInt("COMPLIANT_EMPLOYEE_ID"));
				dProof.setNAME(rs.getString("NAME"));
				dProof.setEMP_TYPE(rs.getString("EMP_TYPE"));
				dProof.setGRVDETID(rs.getInt("GRVDETID"));
				dProof.setRESPONDENT_EMPLOYEE_ID(rs.getInt("RESPONDENT_EMPLOYEE_ID"));
				dProof.setRESPONDENT_EMPLOYEE_NAME(rs.getString("RESPONDENT_EMPLOYEE_NAME"));
				dProof.setCOMPLAINT_DESC(rs.getString("COMPLAINT_DESC"));
				dProof.setTAT_START_DATE(rs.getString("TAT_START_DATE"));
				dProof.setTAT_END_DATE(rs.getString("TAT_END_DATE"));
				dProof.setCASEID(rs.getInt("CASEID"));
				dProof.setFLAG(rs.getString("FLAG"));
				dProof.setIsCompleted(rs.getString("IS_COMPELETED"));
				dProof.setDecisionReportFlag(rs.getString("DECISION_REPORT_FLAG"));
				list.add(dProof);
			}
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				logger.info("Exception Inside the getInvReport() method Exception "+ex.getMessage());
				Logger.getLogger(DailyProofUploadDAO.class.getName()).log(Level.SEVERE, null, ex);
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
		logger.info("Leaving the getInvReport() method");
		return null;
	}
	
	
	public static List<TriggerEmailData> getMailData(int grvId) throws SQLException{
		logger.info("Inside the getMailData() method");
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
			try {
				con = DBConnection.getConnection();
				cst = con.prepareCall("{ call PCK_GMS_DT_VERDICT.EMAIL_SELECT2(?,?)}");
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
