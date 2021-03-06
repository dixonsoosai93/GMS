package com.gms.dao.masters;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gms.commons.DBConnection;
import com.gms.model.masters.CaseStatusMasterModel;

import oracle.jdbc.OracleTypes;

public class CaseStatusMasterDAO {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CaseStatusMasterDAO.class.getName());
	
	public static boolean insertComplaintStatus(CaseStatusMasterModel complaintStatus) throws SQLException {
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		boolean isDuplicate = false;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_COMPLIANT_STATUS.GMS_MA_COMPLIANT_STATUS_INSERT(?,?,?,?)}");
			cst.setString(1, complaintStatus.getSTATUSNAME());
			cst.setString(2, complaintStatus.getIS_ACTIVE());
			cst.setInt(3, 1);
			cst.registerOutParameter(4, OracleTypes.CURSOR);
			cst.execute();
			rs=(ResultSet)cst.getObject(4);
			if (rs.next()) {
				isDuplicate = rs.getBoolean("STATUS");
			}
			return isDuplicate == false ?false:true;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(CaseStatusMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static List<CaseStatusMasterModel> getComplaintStatus() throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_MA_CM_STATUS_SCR.GMS_MA_CM_STATUS_GRID_LIST(?)}");
			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(1);
			List<CaseStatusMasterModel> list = new ArrayList<CaseStatusMasterModel>();
			while (rs.next()) {
			    list.add(new CaseStatusMasterModel( rs.getString("STATUSID"), rs.getString("STATUSNAME"), rs.getString("IS_ACTIVE"),rs.getString("DATE_CREATED")));
			}
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(CaseStatusMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static CaseStatusMasterModel getComplaintStatusByID(String STATUSID) throws SQLException{
	    Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    CaseStatusMasterModel complaintStatus= null;
	    
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_MA_CM_STATUS_SCR.GMS_MA_CM_STATUS_GRID_SELECT(?,?)}");
	        cst.setString(1, STATUSID);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(2);
			if (rs.next()) {		
				complaintStatus = (new CaseStatusMasterModel( rs.getString("STATUSID"), rs.getString("STATUSNAME"), rs.getString("IS_ACTIVE"),rs.getString("DATE_CREATED") , rs.getTimestamp("DATE_UPDATED "),rs.getTimestamp("DATE_DELETED"), rs.getInt("CREATEDBY"),rs.getInt("UPDATEDBY"),rs.getInt("DELETEDBY")));
			}
			return complaintStatus;
	    } catch (SQLException ex) {
	       	 ex.printStackTrace();
	       	Logger.getLogger(CaseStatusMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	 public static boolean updateComplaintStatus(CaseStatusMasterModel complaintStatus) throws SQLException {
        Connection con = null;
        CallableStatement cst = null;
        ResultSet rs = null;
		boolean isDuplicate = false;
        try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_COMPLIANT_STATUS.GMS_MA_COMPLIANT_STATUS_UPDATE(?,?,?,?,?)}");
			cst.setString(1, complaintStatus.getSTATUSID());
			cst.setString(2, complaintStatus.getSTATUSNAME());
			cst.setString(3, complaintStatus.getIS_ACTIVE());
			cst.setInt(4, 1);
			cst.registerOutParameter(5, OracleTypes.CURSOR);
			cst.executeUpdate();
			rs=(ResultSet)cst.getObject(5);
			if (rs.next()) {
				isDuplicate = rs.getBoolean("STATUS");
			}
			return isDuplicate == false ?false:true; 
		} catch (SQLException ex) {
				ex.printStackTrace();
				Logger.getLogger(CaseStatusMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (cst != null) {
		        DBConnection.closeStatement(cst);
		    }
			if (con != null) {
		        DBConnection.closeConnection(con);
		    }
		}
       return false;
	 }
	  
	 public static boolean deleteComplaintStatus(int STATUSID) throws SQLException {
          Connection con = null;
          CallableStatement cst =  null;
          
          try {
              con = DBConnection.getConnection();
              cst = con.prepareCall("{call PCK_GMS_MA_COMPLIANT_STATUS.GMS_MA_COMPLIANT_STATUS_DELETE(?,?)}");
              cst.setInt(1, STATUSID);
              cst.setInt(2, 1);
              return cst.executeUpdate() > 0; 
         } catch (SQLException ex) {
        	  ex.printStackTrace();
        	  Logger.getLogger(CaseStatusMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
         } finally {
        	 if (cst != null) {
        		 DBConnection.closeStatement(cst);
        	 }
        	 if (con != null) {
        		 DBConnection.closeConnection(con);
        	 }
         }
          
        return false;
	  }

}
