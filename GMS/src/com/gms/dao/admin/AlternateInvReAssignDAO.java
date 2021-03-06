package com.gms.dao.admin;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gms.commons.Common;
import com.gms.commons.DBConnection;
import com.gms.model.admin.GridCase;
import com.gms.model.admin.GrievanceDesc;
import com.gms.model.masters.CentralCommitteeInvestigatorModel;
import com.gms.model.masters.RhrInvestigatorMasterModel;
import com.gms.model.masters.ZlgcInvestigatorMasterModel;

import oracle.jdbc.OracleTypes;

public class AlternateInvReAssignDAO {
	static Logger logger = Logger.getLogger(AlternateInvReAssignDAO.class.getName());
	
	// Method to get the values on the page.	
	public static GrievanceDesc getGrievanceDesc(int GRVDETID) throws SQLException{
	    Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    GrievanceDesc grievanceDesc= new GrievanceDesc();
	    try {
	    	logger.info("Inside try block GrievanceDesc() method ");
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_ADM_INV_REA_SCR.GMS_ADM_INV_REA_GRID_LIST(?,?,?)}");
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
				grievanceDesc.setZONE_CODE(rs.getString("ZONE_CODE"));
				grievanceDesc.setREGION_CODE(rs.getString("REGION_CODE"));
			}
			logger.info("Leaving try block GrievanceDesc() method ");
			return grievanceDesc;
	    } catch (SQLException ex) {
	       	 ex.printStackTrace();
	       	Common.LogError(ex);
			logger.info("Exception Inside GrievanceDesc() method Exception"+ex.getMessage());
	       	Logger.getLogger(AlternateInvReAssignDAO.class.getName()).log(Level.SEVERE, null, ex);
	       	Common.LogError(ex);
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
	
	// To get the data in the list at initial page load 
	public static List<GridCase> getGridCase(int GRVDETID) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			logger.info("Inside try block getGridCase() method ");
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_ADM_INV_REA_SCR.GMS_ADM_INV_REA_GRID_LIST(?,?,?)}");
	        cst.setInt(1, GRVDETID);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(3);
			List<GridCase> list = new ArrayList<GridCase>();
			while (rs.next()) {
			    list.add(new GridCase( rs.getInt("CASEID"), rs.getString("HIERCODE"), rs.getInt("HIERORDER"),rs.getString("TAT_START_DATE"),rs.getString("TAT_END_DATE"),rs.getString("CURRENT_ROW_COMPLETED"),rs.getString("CURRENT_ROW_ACTIVE"),rs.getString("IS_ACTIVE"),rs.getInt("INVESTIGATOR_EMPLOYEE_ID"),rs.getString("NAME"), rs.getString("RE_ASSIGN"), rs.getString("BUTTON_FLAG"), rs.getString("REASSIGN_REASON")));
			}
			logger.info("Leaving try block getGridCase() method ");
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Common.LogError(ex);
				logger.info("Exception Inside getGridCase() method Exception"+ex.getMessage());
				Common.LogError(ex);
				Logger.getLogger(AlternateInvReAssignDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static List<RhrInvestigatorMasterModel> getRhrList(String REGION_CODE) throws SQLException {
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			logger.info("Inside try block getRhrList() method ");
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_MA_RHR_SEARCH_SCR.GMS_MA_RHR_SEARCH_GRID_LIST(?,?)}");
			cst.setString(1, REGION_CODE);
			cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.execute();
			rs = (ResultSet) cst.getObject(2);
			List<RhrInvestigatorMasterModel> list = new ArrayList<RhrInvestigatorMasterModel>();
			while (rs.next()) {
				list.add(new RhrInvestigatorMasterModel(rs.getInt("RHRID"), rs.getString("REGION_CODE"),
						rs.getString("REGION_ID"),rs.getString("REGION_NAME"),
						rs.getInt("INVESTIGATOR_EMPLOYEE_ID"), rs.getString("NAME"), rs.getString("DESIGNATION"),
						rs.getString("DEPARTMENT"), rs.getString("IS_HR")));
			}
			logger.info("Leaving try block getRhrList() method ");
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			Common.LogError(ex);
			logger.info("Exception Inside getRhrList() method Exception"+ex.getMessage());
			Logger.getLogger(AlternateInvReAssignDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static List<CentralCommitteeInvestigatorModel> getCentralCommitteeList() throws SQLException {
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			logger.info("Inside try block GrievanceDesc() method ");
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_MA_CC_SEARCH_SCR.GMS_MA_CC_SEARCH_GRID_LIST(?)}");
			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.execute();
			rs = (ResultSet) cst.getObject(1);
			List<CentralCommitteeInvestigatorModel> list = new ArrayList<CentralCommitteeInvestigatorModel>();
			while (rs.next()) {
				list.add(new CentralCommitteeInvestigatorModel(rs.getInt("CENTRALID"),
						rs.getInt("INVESTIGATOR_EMPLOYEE_ID"), rs.getString("NAME"), rs.getString("DESIGNATION"),
						rs.getString("DEPARTMENT"), rs.getString("IS_HR")));
			}
			logger.info("Leaving try block GrievanceDesc() method ");
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			Common.LogError(ex);
			logger.info("Exception Inside GrievanceDesc() method Exception"+ex.getMessage());
			Logger.getLogger(AlternateInvReAssignDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static List<ZlgcInvestigatorMasterModel> getZlgcInvestigator(String ZONE_CODE) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			logger.info("Inside try block GrievanceDesc() method ");
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_MA_ZLGC_SEARCH_SCR.GMS_MA_ZLGC_SEARCH_GRID_LIST(?,?)}");
			cst.setString(1, ZONE_CODE);
			cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(2);
			List<ZlgcInvestigatorMasterModel> list = new ArrayList<ZlgcInvestigatorMasterModel>();
			while (rs.next()) {
				list.add(new ZlgcInvestigatorMasterModel(rs.getInt("ZLGCID"), rs.getString("ZONE_CODE"),
						rs.getString("ZONE_NAME"), rs.getInt("INVESTIGATOR_EMPLOYEE_ID"), rs.getString("NAME"),
						rs.getString("DESIGNATION"), rs.getString("DEPARTMENT"), rs.getString("IS_HR")));			
			}
			logger.info("Leaving try block GrievanceDesc() method ");
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Common.LogError(ex);
				logger.info("Exception Inside GrievanceDesc() method Exception"+ex.getMessage());
				Logger.getLogger(AlternateInvReAssignDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static boolean caseInvReAssign(GridCase gridCase) throws SQLException  {
		Connection con = null;
		CallableStatement cst = null;
		try {
			logger.info("Inside try block GrievanceDesc() method ");
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_DT_GRIEVANCE.GMS_DT_CASE_INV_REA(?,?,?)}");
			cst.setInt(1, gridCase.getCASEID());
			cst.setInt(2,gridCase.getINVESTIGATOR_EMPLOYEE_ID());
			cst.setString(3, gridCase.getTATEXT_REASON());
			cst.execute();
			logger.info("Leaving try block GrievanceDesc() method ");
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			Common.LogError(ex);
			logger.info("Exception Inside GrievanceDesc() method Exception"+ex.getMessage());
			Logger.getLogger(AlternateInvReAssignDAO.class.getName()).log(Level.SEVERE, null, ex);
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
}
