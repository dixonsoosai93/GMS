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
import com.gms.model.masters.GrievanceHandlingTatModel;
import com.gms.model.masters.OrganisationHierarchyMasterModel;

import oracle.jdbc.OracleTypes;

public class GrievanceHandlingTatMasterDAO {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(GrievanceHandlingTatMasterDAO.class.getName());
    
	public static boolean insertGrvHandlingTat(GrievanceHandlingTatModel grievanceHandlingTatModel) throws SQLException {
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_TAT.GMS_MA_TAT_INSERT(?,?,?,?,?)}");
			cst.setInt(1, grievanceHandlingTatModel.getHIERID());
			cst.setInt(2, grievanceHandlingTatModel.getTATDAYS());
			cst.setInt(3, grievanceHandlingTatModel.getBUFFERDAYS());
			cst.setString(4, grievanceHandlingTatModel.getIS_ACTIVE());
			cst.setInt(5, 1);
			cst.execute();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(GrievanceHandlingTatMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static List<GrievanceHandlingTatModel> getGrvHandling() throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_MA_TAT_SCR.GMS_MA_TAT_GRID_LIST(?)}");
			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(1);
			List<GrievanceHandlingTatModel> list = new ArrayList<GrievanceHandlingTatModel>();
			while (rs.next()) {
			    list.add(new GrievanceHandlingTatModel( rs.getInt("TATID"), rs.getInt("HIERID"), rs.getString("HIERCODE"), rs.getString("HIERNAME"),rs.getInt("TATDAYS"),rs.getInt("BUFFERDAYS"),rs.getString("IS_ACTIVE"),rs.getString("DATE_CREATED")));
			}
			System.out.println(list);
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(GrievanceHandlingTatMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	 public static boolean updateGrvHandling(GrievanceHandlingTatModel grievanceHandlingTatModel) throws SQLException {
	        Connection con = null;
	        CallableStatement cst = null;
	        
	        try {
				con = DBConnection.getConnection();
				cst = con.prepareCall("{call PCK_GMS_MA_TAT.GMS_MA_TAT_UPDATE(?,?,?,?,?,?)}");
				cst.setInt(1, grievanceHandlingTatModel.getTATID());
				cst.setInt(2, grievanceHandlingTatModel.getHIERID());
				cst.setInt(3, grievanceHandlingTatModel.getTATDAYS());
				cst.setInt(4, grievanceHandlingTatModel.getBUFFERDAYS());
				cst.setString(5, grievanceHandlingTatModel.getIS_ACTIVE());
				cst.setInt(6, 1);
				return cst.executeUpdate() > 0; 
			} catch (SQLException ex) {
					ex.printStackTrace();
					Logger.getLogger(GrievanceHandlingTatMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
