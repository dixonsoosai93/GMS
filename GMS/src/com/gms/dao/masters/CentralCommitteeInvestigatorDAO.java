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
import com.gms.model.masters.CentralCommitteeInvestigatorModel;

import oracle.jdbc.OracleTypes;

public class CentralCommitteeInvestigatorDAO {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CentralCommitteeInvestigatorDAO.class.getName());
	public static boolean insertCentralInv(CentralCommitteeInvestigatorModel CentralInvestigator) throws SQLException {
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_CENTRAL_INVSTGR.GMS_MA_CENTRAL_INVSTGR_INSERT(?,?,?,?)}");
			cst.setInt(1, CentralInvestigator.getINVESTIGATOR_EMPLOYEE_ID());
			cst.setString(2, CentralInvestigator.getIS_HR());
			cst.setString(3, CentralInvestigator.getIS_ACTIVE());
			cst.setInt(4, 1);
			cst.execute();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(CentralCommitteeInvestigatorDAO.class.getName()).log(Level.SEVERE, null, ex);
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

	public static List<CentralCommitteeInvestigatorModel> centralInvMaster() throws SQLException {
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_MA_CENTRAL_INVSTGR_SCR.GMS_MA_CENTRAL_INV_GRID_LIST(?)}");
			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.execute();
			rs = (ResultSet) cst.getObject(1);
			List<CentralCommitteeInvestigatorModel> list = new ArrayList<CentralCommitteeInvestigatorModel>();
			while (rs.next()) {
				list.add(new CentralCommitteeInvestigatorModel(rs.getInt("CENTRALID"),
						rs.getInt("INVESTIGATOR_EMPLOYEE_ID"), rs.getString("NAME"), rs.getString("DESIGNATION"),
						rs.getString("DEPARTMENT"), rs.getString("IS_HR"), rs.getString("IS_ACTIVE"),
						rs.getString("DATE_CREATED")));
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(CentralCommitteeInvestigatorDAO.class.getName()).log(Level.SEVERE, null, ex);
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

	public static CentralCommitteeInvestigatorModel getcentralCommittee(int Id) throws SQLException {
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		CentralCommitteeInvestigatorModel CentralInvestigator = null;

		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_CENTRAL_INVSTGR_SCR.GMS_MA_CENTRAL_INV_GRID_SELECT(?,?,?)}");
			cst.setInt(1, Id);
			cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.registerOutParameter(3, OracleTypes.CURSOR);
			cst.execute();
			rs = (ResultSet) cst.getObject(3);
			if (rs.next()) {
				CentralInvestigator = (new CentralCommitteeInvestigatorModel(rs.getInt("CENTRALID"),
						rs.getInt("INVESTIGATOR_EMPLOYEE_ID"), rs.getString("NAME"), rs.getString("DESIGNATION"),
						rs.getString("DEPARTMENT"), rs.getString("IS_HR"), rs.getString("IS_ACTIVE"),
						rs.getString("DATE_CREATED"), rs.getTimestamp("DATE_UPDATED"), rs.getTimestamp("DATE_DELETED"),
						rs.getInt("CREATEDBY"), rs.getInt("UPDATEDBY"), rs.getInt("DELETEDBY")));
			}
			return CentralInvestigator;
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(CentralCommitteeInvestigatorDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static boolean updateCentralCommittee(CentralCommitteeInvestigatorModel CentralInvestigator) throws SQLException {
        Connection con = null;
        CallableStatement cst = null;
        
        try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_CENTRAL_INVSTGR.GMS_MA_CENTRAL_INVSTGR_UPDATE(?,?,?,?,?)}");
			cst.setInt(1, CentralInvestigator.getCENTRALID());
			cst.setInt(2, CentralInvestigator.getINVESTIGATOR_EMPLOYEE_ID());
			cst.setString(3, CentralInvestigator.getIS_HR());
			cst.setString(4, CentralInvestigator.getIS_ACTIVE());
			cst.setInt(5,1);
			return cst.executeUpdate() > 0; 
		} catch (SQLException ex) {
				ex.printStackTrace();
				Logger.getLogger(CentralCommitteeInvestigatorDAO.class.getName()).log(Level.SEVERE, null, ex);
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
