package com.gms.dao.masters;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gms.commons.Common;
import com.gms.commons.DBConnection;
import com.gms.dao.grievance.EmployeeGrievanceDAO;
import com.gms.model.masters.HolidayMasterModel;

import oracle.jdbc.OracleTypes;

public class HolidayMasterDAO {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HolidayMasterDAO.class.getName());
	public static boolean insertholidayMaster(HolidayMasterModel holidayMaster) throws SQLException, java.text.ParseException {
		Date date=Date.valueOf((Common.StringToDateFormat(holidayMaster.getHOLIDAYDATE())));
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		boolean isDuplicate = false;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_HOLIDAY.GMS_MA_HOLIDAY_INSERT(?,?,?,?,?,?)}");
			cst.setString(1, holidayMaster.getSTATE_CODE());
			cst.setDate(2,date);
			cst.setString(3, holidayMaster.getHOLIDAYNAME());
			cst.setString(4, holidayMaster.getIS_ACTIVE());
			cst.setInt(5, 1);
			cst.registerOutParameter(6, OracleTypes.CURSOR);
			cst.execute();
			rs=(ResultSet)cst.getObject(6);
			if (rs.next()) {
				isDuplicate = rs.getBoolean("STATUS");
			}
			return isDuplicate == false ?false:true;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(HolidayMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static List<HolidayMasterModel> getHolidayMaster() throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_MA_HOLIDAY_SCR.GMS_MA_HOLIDAY_GRID_LIST(?)}");
			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(1);
			List<HolidayMasterModel> list = new ArrayList<HolidayMasterModel>();
			while (rs.next()) {
			    list.add(new HolidayMasterModel(rs.getInt("HOLIDAY_ID"),rs.getString("STATE_CODE"), rs.getString("STATE_NAME"),rs.getDate("HOLIDAYDATE"),rs.getString("HOLIDAY"), rs.getString("HOLIDAYNAME"), rs.getString("IS_ACTIVE"),rs.getString("DATE_CREATED")));
			}
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(HolidayMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static List<HolidayMasterModel> getState() throws SQLException{
	    Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    List<HolidayMasterModel> list = new ArrayList<HolidayMasterModel>();
	    
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_MA_HOLIDAY_SCR.GMS_MA_HOLIDAY_GRID_SELECT(?,?,?)}");
	        cst.setString(1, null);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(2);
            while (rs.next()) {
				list.add(new HolidayMasterModel(rs.getString("STATE_CODE"),rs.getString("STATE_NAME")));
			}                                         
	        return list;
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        	 Logger.getLogger(HolidayMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static boolean deleteHoliday(int HOLIDAYID) throws SQLException {
        Connection con = null;
        CallableStatement cst =  null;
        
        try {
            con = DBConnection.getConnection();
            cst = con.prepareCall("{call PCK_GMS_MA_HOLIDAY.GMS_MA_HOLIDAY_DELETE(?,?)}");
            cst.setInt(1, HOLIDAYID);
            cst.setInt(2, 1);
            return cst.executeUpdate() > 0; 
       } catch (SQLException ex) {
      	  ex.printStackTrace();
      	Logger.getLogger(HolidayMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static boolean updateHoliday(HolidayMasterModel HolidayMasterModel) throws SQLException, java.text.ParseException {
		Date date=Date.valueOf((Common.StringToDateFormat(HolidayMasterModel.getHOLIDAYDATE())));
        Connection con = null;
        CallableStatement cst = null;
        ResultSet rs = null;
		boolean isDuplicate = false;
        try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_HOLIDAY.GMS_MA_HOLIDAY_UPDATE(?,?,?,?,?,?,?)}");
			cst.setInt(1, HolidayMasterModel.getHOLIDAY_ID());
			cst.setString(2, HolidayMasterModel.getSTATE_CODE());
			cst.setDate(3,date);
			cst.setString(4, HolidayMasterModel.getHOLIDAYNAME());
			cst.setString(5, HolidayMasterModel.getIS_ACTIVE());
			cst.setInt(6,1);
			cst.registerOutParameter(7, OracleTypes.CURSOR);
			cst.executeUpdate();
			rs=(ResultSet)cst.getObject(7);
			if (rs.next()) {
				isDuplicate = rs.getBoolean("STATUS");
			}
			return isDuplicate == false ?false:true;
		} catch (SQLException ex) {
				ex.printStackTrace();
				Logger.getLogger(HolidayMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
