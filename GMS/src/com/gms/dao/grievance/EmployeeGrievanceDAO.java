package com.gms.dao.grievance;

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
import com.gms.model.grievance.DtCaseEmpModel;
import com.gms.model.grievance.DtGrievanceModel;
import com.gms.model.grievance.HdGrievanceModel;
import com.gms.model.grievance.TriggerEmailData;
import com.gms.model.masters.CaseStatusMasterModel;
import com.gms.model.masters.ManpowerModel;

import oracle.jdbc.OracleTypes;

public class EmployeeGrievanceDAO {
	static Logger logger = Logger.getLogger(EmployeeGrievanceDAO.class.getName());
	
	public static boolean insertHdGrievance(HdGrievanceModel HdGrievance ,ArrayList<DtGrievanceModel> list, ArrayList<DtCaseEmpModel> Dtlist) throws SQLException, java.text.ParseException {
		logger.info("Inside the insertHdGrievance() method");
		Date date = Date.valueOf((Common.StringToDateFormat(HdGrievance.getGRVDATE())));
		Connection con = null;
		CallableStatement cst = null;
		String GRVID =null;
			try {
				con = DBConnection.getConnection();
				cst = con.prepareCall("{call PCK_GMS_HD_GRIEVANCE.GMS_HD_GRIEVANCE_INSERT(?,?,?,?,?,?)}");
				cst.setDate(1,date);
				cst.setString(2, HdGrievance.getGROUP_COMPLAINT());
				cst.setInt(3, HdGrievance.getCOMPLIANT_EMPLOYEE_ID());
				cst.setString(4, HdGrievance.getCOMPLIANT_EX_EMPLOYEE_ID());
				cst.setInt(5, 1);
				cst.registerOutParameter(6,OracleTypes.INTEGER);
				cst.execute();
				GRVID=cst.getString(6);
				int insertcount = insertDtGrievance(list, GRVID);
				int dtInsertCount = insertDtCaseEmp(Dtlist,GRVID);
				List<TriggerEmailData> triggerMail = getMailData(GRVID);
				insertMailingDetails(triggerMail);
				return true;
			} catch (Exception ex) {
				ex.printStackTrace();
				logger.info("Exception Inside the insertHdGrievance() method Exception "+ex.getMessage());
				Logger.getLogger(EmployeeGrievanceDAO.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				if(cst != null) {
					DBConnection.closeStatement(cst);
				}
				if(con != null) {
					DBConnection.closeConnection(con);
				}
			}
		logger.info("Leaving the insertHdGrievance() method");
		return false;
	}
	
	public static List<HdGrievanceModel> gethdGrievance() throws SQLException{
		logger.info("Inside the gethdGrievance() method");
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
			try {
				con = DBConnection.getConnection();
				cst = con.prepareCall("{ call PCK_GMS_DT_GRIEVANCE_SCR.GMS_DT_GRIEVANCE_GRID_LIST(?)}");
				cst.registerOutParameter(1, OracleTypes.CURSOR);
				cst.execute();
	            rs=(ResultSet)cst.getObject(1);
				List<HdGrievanceModel> list = new ArrayList<HdGrievanceModel>();
				while (rs.next()) {
				    list.add(new HdGrievanceModel( rs.getInt("GRVID"), rs.getDate("GRVDATE"), rs.getString("GRVNUMBER"), rs.getInt("COMPLIANT_EMPLOYEE_ID"),rs.getString("EMPLOYEETYPE"), rs.getString("GRIEVANCE_TYPE"), rs.getInt("ACCEPT_CASES_COUNT"),rs.getInt("REJECT_CASES_COUNT"),rs.getString("IS_ACTIVE"), rs.getString("DATE_CREATED"),rs.getString("NAME")));
				}
		        return list;
			} catch (Exception ex) {
					ex.printStackTrace();
					logger.info("Exception Inside the gethdGrievance() method Exception "+ex.getMessage());
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
		logger.info("Leaving the gethdGrievance() method");
		return null;
	}
	
	public static List<HdGrievanceModel> gethdGrievanceEmp(String id) throws SQLException{
		logger.info("Inside the gethdGrievanceEmp() method");
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
			try {
				con = DBConnection.getConnection();
				cst = con.prepareCall("{ call PCK_GMS_DT_GRIEVANCE_SCR.GMS_DT_GRIEVANCE_EMP_LIST(?,?)}");
				cst.setString(1,id);
				cst.registerOutParameter(2, OracleTypes.CURSOR);
				cst.execute();
	            rs=(ResultSet)cst.getObject(2);
				List<HdGrievanceModel> list = new ArrayList<HdGrievanceModel>();
				while (rs.next()) {
				    list.add(new HdGrievanceModel( rs.getInt("GRVID"), rs.getDate("GRVDATE"), rs.getString("GRVNUMBER"),rs.getInt("COMPLIANT_EMPLOYEE_ID"),rs.getString("EMPLOYEETYPE"), rs.getString("GRIEVANCE_TYPE"), rs.getInt("ACCEPT_CASES_COUNT"),rs.getInt("REJECT_CASES_COUNT"),rs.getString("IS_ACTIVE"), rs.getString("DATE_CREATED"),rs.getString("NAME")));
				}
		        return list;
			} catch (Exception ex) {
					ex.printStackTrace();
					logger.info("Exception Inside the gethdGrievanceEmp() method Exception "+ex.getMessage());
					Logger.getLogger(EmployeeGrievanceDAO.class.getName()).log(Level.SEVERE, null, ex);
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
		logger.info("Leaving the gethdGrievanceEmp() method");
		return null;
	}

	public static List<CaseStatusMasterModel> getStatus() throws SQLException{
		logger.info("Inside the getStatus() method");
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
			try {
				con = DBConnection.getConnection();
				cst = con.prepareCall("{ call PCK_GMS_DT_GRIEVANCE_SCR.GMS_DT_GRIEVANCE_GRID_SELECT(?,?,?,?,?)}");
				cst.setString(1,null);
				cst.registerOutParameter(2, OracleTypes.CURSOR);
				cst.registerOutParameter(3, OracleTypes.CURSOR);
				cst.registerOutParameter(4, OracleTypes.CURSOR);
				cst.registerOutParameter(5, OracleTypes.CURSOR);
				cst.execute();
	            rs=(ResultSet)cst.getObject(5);
				List<CaseStatusMasterModel> list = new ArrayList<CaseStatusMasterModel>();
				while (rs.next()) {
				    list.add(new CaseStatusMasterModel( rs.getString("STATUSID"), rs.getString("STATUSNAME")));
				}
		        return list;
			} catch (Exception ex) {
					ex.printStackTrace();
					logger.info("Exception Inside the getStatus() method Exception "+ex.getMessage());
					Logger.getLogger(EmployeeGrievanceDAO.class.getName()).log(Level.SEVERE, null, ex);
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
		logger.info("Leaving the getStatus() method");
		return null;
	}
	
	public static List<DtGrievanceModel> getGrievanceDt(int id) throws SQLException{
		logger.info("Inside the getGrievanceDt() method");
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
			try {
				con = DBConnection.getConnection();
				cst = con.prepareCall("{call PCK_GMS_DT_GRIEVANCE_SCR.GMS_DT_GRIEVANCE_GRID_CASE(?,?)}");
				cst.setInt(1,id);
				cst.registerOutParameter(2, OracleTypes.CURSOR);
				cst.execute();
	            rs=(ResultSet)cst.getObject(2);
				List<DtGrievanceModel> list = new ArrayList<DtGrievanceModel>();
				while (rs.next()) {
				    list.add(new DtGrievanceModel(rs.getInt("GRVID"), rs.getInt("GRVDETID"), rs.getString("MAIN_CATEGORY_CODE"), rs.getString("SUB_CATEGORY_CODE"), rs.getString("EMPLOYEETYPE"), rs.getInt("RESPONDENT_EMPLOYEE_ID"), rs.getString("RESPONDENT_EMPLOYEE_NAME"), rs.getString("COMPLAINT_DESC"), rs.getString("CASENUMBER"), rs.getString("DEFAULT_HIERCODE"), rs.getString("START_HIERCODE"), rs.getString("STATUSNAME"), rs.getString("REOPEN_FLAG"), rs.getString("MAIN_CATEGORY_NAME"), rs.getString("SUB_CATEGORY_NAME")));
				}
		        return list;
			} catch (Exception ex) {
					ex.printStackTrace();
					logger.info("Exception Inside the getGrievanceDt() method Exception "+ex.getMessage());
					Logger.getLogger(EmployeeGrievanceDAO.class.getName()).log(Level.SEVERE, null, ex);
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
		logger.info("Leaving the getGrievanceDt() method");
		return null;
	}
	
	public static int insertDtGrievance(List<DtGrievanceModel> list, String GRVID) throws SQLException {
		logger.info("Inside the insertDtGrievance() method");
		Connection con = null;
		CallableStatement cst = null;
	    int count = 0;
	    int insertCount = 0;
			try {
				 con = DBConnection.getConnection();
				 cst = con.prepareCall("{call PCK_GMS_DT_GRIEVANCE.GMS_DT_GRIEVANCE_INSERT(?,?,?,?,?,?,?,?,?,?)}");
				 con.setAutoCommit(false);
				 for (DtGrievanceModel DtGrievance : list) {
					cst.setInt(1,Integer.parseInt(GRVID));
					cst.setInt(2, DtGrievance.getRESPONDENT_EMPLOYEE_ID());
					cst.setString(3, DtGrievance.getRESPONDENT_EMPLOYEE_NAME());
					cst.setString(4, DtGrievance.getMAIN_CATEGORY_CODE());
					cst.setString(5, DtGrievance.getSUB_CATEGORY_CODE());
					cst.setString(6, DtGrievance.getCOMPLAINT_DESC());
					cst.setString(7, DtGrievance.getDEFAULT_HIERCODE());
					cst.setString(8, DtGrievance.getSTART_HIERCODE());
					cst.setString(9, DtGrievance.getSTATUSID());
					cst.setInt(10, 1);
			        cst.addBatch();
			        count++;
			        if(count % 10000 == 0){
			           int[] result = cst.executeBatch();
			           insertCount += result.length;
			        }
				 }
				 int[] result = cst.executeBatch();
				 insertCount += result.length;
				 con.commit();
			} catch (Exception ex) {
				ex.printStackTrace();
				logger.info("Exception Inside the insertDtGrievance() method Exception "+ex.getMessage());
				Logger.getLogger(EmployeeGrievanceDAO.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				if(cst != null) {
					DBConnection.closeStatement(cst);
				}
				if(con != null) {
					DBConnection.closeConnection(con);
				}
			}
		logger.info("Leaving the insertDtGrievance() method");
		return insertCount;
	}
	
	public static int insertDtCaseEmp(List<DtCaseEmpModel> list, String GRVID) throws SQLException {
		logger.info("Inside the insertDtCaseEmp() method");
		Connection con = null;
		CallableStatement cst = null;
		int count = 0;
		int insertCount = 0;
			try {
				 con = DBConnection.getConnection();
				 cst = con.prepareCall("{call PCK_GMS_DT_CASE_EMP.GMS_DT_CASE_EMP_INSERT(?,?,?,?,?)}");
				 con.setAutoCommit(false);
				 for (DtCaseEmpModel DtCaseEmp : list) {
					 cst.setInt(1,Integer.parseInt(GRVID));
					 cst.setInt(2, DtCaseEmp.getEMPLOYEE_ID());
					 cst.setString(3,"Y");
					 cst.setString(4,"Y");
					 cst.setInt(5, 1);
			         cst.addBatch();
			         count++;
			         if(count % 10000 == 0){
			        	 int[] result = cst.executeBatch();
			        	 insertCount += result.length;
			           }
		           }
		           int[] result = cst.executeBatch();
		           insertCount += result.length;
		           con.commit();
			} catch (Exception ex) {
				ex.printStackTrace();
				logger.info("Exception Inside the insertDtCaseEmp() method Exception "+ex.getMessage());
				Logger.getLogger(EmployeeGrievanceDAO.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				if(cst != null) {
					DBConnection.closeStatement(cst);
				}
				if(con != null) {
					DBConnection.closeConnection(con);
				}
			}
		logger.info("Leaving the insertDtCaseEmp() method");
		return insertCount;
	}
	public static List<ManpowerModel> getGroupEmployee(int id) throws SQLException{
		logger.info("Inside the getGroupEmployee() method");
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
			try {
				con = DBConnection.getConnection();
				cst = con.prepareCall("{ call PCK_GMS_DT_GRIEVANCE_SCR.GMS_DT_GRIEVANCE_GRID_SELECT(?,?,?,?,?)}");
				cst.setInt(1,id);
				cst.registerOutParameter(2, OracleTypes.CURSOR);
				cst.registerOutParameter(3, OracleTypes.CURSOR);
				cst.registerOutParameter(4, OracleTypes.CURSOR);
				cst.registerOutParameter(5, OracleTypes.CURSOR);
				cst.execute();
	            rs=(ResultSet)cst.getObject(4);
				List<ManpowerModel> list = new ArrayList<ManpowerModel>();
				while (rs.next()) {
				    list.add(new ManpowerModel( rs.getString("EMPLOYEE_ID"), rs.getString("NAME"),rs.getString("DESIGNATION"), rs.getString("DEPARTMENT")));
				}
		        return list;
			} catch (Exception ex) {
					ex.printStackTrace();
					logger.info("Exception Inside the getGroupEmployee() method Exception "+ex.getMessage());
					Logger.getLogger(EmployeeGrievanceDAO.class.getName()).log(Level.SEVERE, null, ex);
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
		logger.info("Leaving the getGroupEmployee() method");
		return null;
	}
	
	public static boolean getGrvEmpReopen(int grvDtId) throws SQLException{
		logger.info("Inside the getGrvEmpReopen() method");
		Connection con = null;
		CallableStatement cst = null;
			try {
				con = DBConnection.getConnection();
				cst = con.prepareCall("{call PCK_GMS_DT_GRIEVANCE.GMS_EMP_REOPEN(?)}");
				cst.setInt(1,grvDtId);
				cst.execute();
				return true;
			} catch (Exception ex) {
					ex.printStackTrace();
					logger.info("Exception Inside the getGrvEmpReopen() method Exception "+ex.getMessage());
					Logger.getLogger(EmployeeGrievanceDAO.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				if (cst != null) {
	                DBConnection.closeStatement(cst);
	            }
	            if (con != null) {
	                DBConnection.closeConnection(con);
	            }
			}
		logger.info("Leaving the getGrvEmpReopen() method");
		return false;
	}
	
	public static List<TriggerEmailData> getMailData(String grvId) throws SQLException{
		logger.info("Inside the getMailData() method");
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
			try {
				con = DBConnection.getConnection();
				cst = con.prepareCall("{ call PCK_GMS_DT_VERDICT.EMAIL_SELECT2(?,?)}");
				cst.setString(1, grvId);
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
		Connection con= null;
		PreparedStatement ps = null;
	    int count = 0;
	    int insertCount = 0;
	    	try {
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
				logger.info("Exception Inside the insertMailingDetails() method"+ex.getMessage());
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
				 
	/*
	public static int insertMailingDetails(List<TriggerEmailData> list) throws SQLException {
		logger.info("Inside the insertMailingDetails() method");
		Connection connnection = null;
		PreparedStatement ps = null;
	    int count = 0;
	    int insertCount = 0;
			try {
				 connnection = SQLConnection.getConnection();
				 String sql = "";
				 con.setAutoCommit(false);
				 for (TriggerEmailData details : list) {
					cst.setInt(1, details.getEmailIdInt());
					cst.setString(2, details.getSendCC());
					cst.setString(3, details.getSubject());
					cst.setString(4, details.getEmailContent());
			        cst.addBatch();
			        count++;
			        if(count % 10000 == 0){
			           int[] result = cst.executeBatch();
			           insertCount += result.length;
			        }
				 }
				 int[] result = cst.executeBatch();
				 insertCount += result.length;
				 con.commit();
			} catch (Exception ex) {
				ex.printStackTrace();
				logger.info("Exception Inside the insertDtGrievance() method Exception "+ex.getMessage());
				Logger.getLogger(EmployeeGrievanceDAO.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				if(cst != null) {
					DBConnection.closeStatement(cst);
				}
				if(con != null) {
					DBConnection.closeConnection(con);
				}
			}
		logger.info("Leaving the insertDtGrievance() method");
		return insertCount;
	}
	*/
}
