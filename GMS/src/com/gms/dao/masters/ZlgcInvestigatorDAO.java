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
import com.gms.model.masters.OrganisationHierarchyMasterModel;
import com.gms.model.masters.ZlgcInvestigatorMasterModel;

import oracle.jdbc.OracleTypes;

public class ZlgcInvestigatorDAO {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ZlgcInvestigatorDAO.class.getName());
	public static boolean insertZlgcInv(ZlgcInvestigatorMasterModel ZlgcInvestigatorMaster) throws SQLException {
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_ZLGC_INVSTGR.GMS_MA_ZLGC_INVSTGR_INSERT(?,?,?,?,?)}");
			cst.setString(1, ZlgcInvestigatorMaster.getZONE_CODE());
			cst.setInt(2, ZlgcInvestigatorMaster.getINVESTIGATOR_EMPLOYEE_ID());
			cst.setString(3, ZlgcInvestigatorMaster.getIS_HR());
			cst.setString(4, ZlgcInvestigatorMaster.getIS_ACTIVE());
			cst.setInt(5,1);
			cst.execute();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(ZlgcInvestigatorDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static List<ZlgcInvestigatorMasterModel> ZlgcInvestigatorMaster() throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_MA_ZLGC_INVSTGR_SCR.GMS_MA_ZLGC_INV_GRID_LIST(?)}");
			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(1);
			List<ZlgcInvestigatorMasterModel> list = new ArrayList<ZlgcInvestigatorMasterModel>();
			while (rs.next()) {
				list.add(new ZlgcInvestigatorMasterModel(rs.getInt("ZLGCID"), rs.getString("ZONE_CODE"),
						rs.getString("ZONE_NAME"), rs.getInt("INVESTIGATOR_EMPLOYEE_ID"), rs.getString("NAME"),
						rs.getString("DESIGNATION"), rs.getString("DEPARTMENT"), rs.getString("IS_HR"),
						rs.getString("IS_ACTIVE"), rs.getString("DATE_CREATED")));
			}
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(ZlgcInvestigatorDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static boolean updateZlgcInv(ZlgcInvestigatorMasterModel ZlgcInvestigatorMaster) throws SQLException {
        Connection con = null;
        CallableStatement cst = null;
        
        try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_ZLGC_INVSTGR.GMS_MA_ZLGC_INVSTGR_UPDATE(?,?,?,?,?,?)}");
			cst.setInt(1, ZlgcInvestigatorMaster.getZLGCID());
			cst.setString(2, ZlgcInvestigatorMaster.getZONE_CODE());
			cst.setInt(3, ZlgcInvestigatorMaster.getINVESTIGATOR_EMPLOYEE_ID());
			cst.setString(4, ZlgcInvestigatorMaster.getIS_HR());
			cst.setString(5, ZlgcInvestigatorMaster.getIS_ACTIVE());
			cst.setInt(6,1);
			return cst.executeUpdate() > 0; 
		} catch (SQLException ex) {
				ex.printStackTrace();
				Logger.getLogger(ZlgcInvestigatorDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static ZlgcInvestigatorMasterModel getzlgcInvestigator(int Id) throws SQLException{
	    Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    ZlgcInvestigatorMasterModel ZlgcInvestigatorMaster = null;
	    
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_MA_ZLGC_INVSTGR_SCR.GMS_MA_ZLGC_INV_GRID_SELECT(?,?,?,?)}");
	        cst.setInt(1, Id);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
	        cst.registerOutParameter(4, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(4);
			if (rs.next()){
				ZlgcInvestigatorMaster = (new ZlgcInvestigatorMasterModel(rs.getInt("ZLGCID"),
						rs.getString("ZONE_CODE"), rs.getString("ZONE_NAME"), rs.getInt("INVESTIGATOR_EMPLOYEE_ID"),
						rs.getString("NAME"), rs.getString("DESIGNATION"), rs.getString("DEPARTMENT"),
						rs.getString("IS_HR"), rs.getString("IS_ACTIVE"), rs.getString("DATE_CREATED"),
						rs.getTimestamp("DATE_UPDATED"), rs.getTimestamp("DATE_DELETED"), rs.getInt("CREATEDBY"),
						rs.getInt("UPDATEDBY"), rs.getInt("DELETEDBY")));
			}                                                            
	        return ZlgcInvestigatorMaster;
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        	 Logger.getLogger(ZlgcInvestigatorDAO.class.getName()).log(Level.SEVERE, null, ex);
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

}
