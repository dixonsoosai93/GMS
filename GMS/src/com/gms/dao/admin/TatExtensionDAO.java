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

import oracle.jdbc.OracleTypes;

public class TatExtensionDAO {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(TatExtensionDAO.class.getName());

	public static GrievanceDesc getGrievanceDesc(int GRVDETID) throws SQLException{
	    Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    GrievanceDesc grievanceDesc= new GrievanceDesc();
	    
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_ADM_TAT_EXT_SCR.GMS_ADM_TAT_EXT_GRID_LIST(?,?,?)}");
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
			}
			return grievanceDesc;
	    } catch (SQLException ex) {
	       	 ex.printStackTrace();
	       	Common.LogError(ex);
			Logger.getLogger(TatExtensionDAO.class.getName()).log(Level.SEVERE, null, ex);
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
			cst = con.prepareCall("{call PCK_GMS_ADM_TAT_EXT_SCR.GMS_ADM_TAT_EXT_GRID_LIST(?,?,?)}");
	        cst.setInt(1, GRVDETID);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(3);
			List<GridCase> list = new ArrayList<GridCase>();
			while (rs.next()) {
			    list.add(new GridCase( rs.getInt("CASEID"), rs.getString("HIERCODE"), rs.getInt("HIERORDER"),rs.getString("TAT_START_DATE"),rs.getString("TAT_END_DATE"),rs.getString("CURRENT_ROW_COMPLETED"),rs.getString("CURRENT_ROW_ACTIVE"),rs.getString("IS_ACTIVE"),rs.getInt("INVESTIGATOR_EMPLOYEE_ID"),rs.getString("NAME"),rs.getInt("BUFFERDAYS"), rs.getString("TATEXT_REASON")));
			}
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Common.LogError(ex);
				Logger.getLogger(TatExtensionDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	/*public static boolean tatExtend(GridCase gridCase) throws SQLException  {
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_DT_GRIEVANCE.GMS_ADM_TAT_EXTEND(?,?,?)}");
			cst.setInt(1, gridCase.getCASEID());
			cst.setInt(2,gridCase.getBUFFERDAYS());
			cst.setInt(3,gridCase.getINVESTIGATOR_EMPLOYEE_ID());
			cst.execute();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(TatExtensionDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(cst != null) {
				DBConnection.closeStatement(cst);
			}
			if(con != null) {
				DBConnection.closeConnection(con);
			}
		}
		return false;
	}*/
	
	/*
	 * public static boolean tatExtend(GridCase gridCase) throws SQLException  {
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_DT_GRIEVANCE.GMS_ADM_TAT_EXTEND(?,?,?,?,?)}");
			cst.setInt(1, gridCase.getCASEID());
			cst.setInt(2, gridCase.getBUFFERDAYS());
			cst.setInt(3, gridCase.getTAT_EXTENDED_EMPLOYEE_ID());
			cst.setString(4, gridCase.getTATEXT_REASON());
			cst.registerOutParameter(5, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(5);
            if(rs.next()) {
            	
            }
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(TatExtensionDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(cst != null) {
				DBConnection.closeStatement(cst);
			}
			if(con != null) {
				DBConnection.closeConnection(con);
			}
		}
		return false;
	}*/
	
	public static GridCase tatExtend(GridCase gridCase) throws SQLException  {
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_DT_GRIEVANCE.GMS_ADM_TAT_EXTEND(?,?,?,?,?)}");
			cst.setInt(1, gridCase.getCASEID());
			cst.setInt(2, gridCase.getBUFFERDAYS());
			cst.setInt(3, gridCase.getTAT_EXTENDED_EMPLOYEE_ID());
			cst.setString(4, gridCase.getTATEXT_REASON());
			cst.registerOutParameter(5, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(5);
            GridCase  gridCase1 = new GridCase();
            if(rs.next()) {
            	gridCase1.setBUFFERDAYS(rs.getInt("DAYS"));
            	gridCase1.setIsTatExtn(rs.getInt("TATEXTEND"));
            }
			return gridCase1;
		} catch (Exception ex) {
			ex.printStackTrace();
			Common.LogError(ex);
			Logger.getLogger(TatExtensionDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
}
