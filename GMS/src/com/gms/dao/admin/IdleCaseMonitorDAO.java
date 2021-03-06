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
import com.gms.model.admin.IdleCaseMonitor;

import oracle.jdbc.OracleTypes;

public class IdleCaseMonitorDAO {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(IdleCaseMonitorDAO.class.getName());
	
	public static List<IdleCaseMonitor> getIdleCase() throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_ADM_IDLE_CASE_SCR.GMS_ADM_IDLE_CASE_GRID_LIST(?)}");
	        cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(1);
			List<IdleCaseMonitor> list = new ArrayList<IdleCaseMonitor>();
			while (rs.next()) {
			    list.add(new IdleCaseMonitor( rs.getInt("CASEID"), rs.getInt("GRVDETID"), rs.getString("CASENUMBER"),rs.getString("MAIN_CATEGORY_CODE"),rs.getString("SUB_CATEGORY_CODE"),rs.getString("HIERCODE"),rs.getInt("HIERORDER"),rs.getString("TAT_START_DATE"),rs.getString("TAT_ACTUAL_END_DATE"),rs.getString("CURRENT_ROW_COMPLETED"),rs.getString("CURRENT_ROW_ACTIVE"),rs.getString("IS_ACTIVE"),rs.getInt("INVESTIGATOR_EMPLOYEE_ID"),rs.getString("NAME"),rs.getString("DESIGNATION"),rs.getString("TAT"),rs.getString("COUNT_DAIRYID"), rs.getString("TAT"), rs.getString("COUNT_DAIRYID")));
			}
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Common.LogError(ex);
				Logger.getLogger(IdleCaseMonitorDAO.class.getName()).log(Level.SEVERE, null, ex);
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
