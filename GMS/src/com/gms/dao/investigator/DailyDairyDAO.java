package com.gms.dao.investigator;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
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
import com.gms.model.investigator.DtDailyDairy;

import oracle.jdbc.OracleTypes;

public class DailyDairyDAO {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DailyDairyDAO.class.getName());
	
	public static boolean insertDailyDairy(DtDailyDairy DtDailyDairy) throws SQLException, java.text.ParseException  {
		Date date=Date.valueOf((Common.StringToDateFormat(DtDailyDairy.getDAIRY_DATE())));
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_DT_DAILY_DAIRY.GMS_DT_DAILY_DAIRY_INSERT(?,?,?,?,?,?)}");
			cst.setInt(1, DtDailyDairy.getCASEID());
			cst.setDate(2,date);
			cst.setString(3,DtDailyDairy.getDAIRY_DETAILS());
			cst.setInt(4,DtDailyDairy.getEMPLOYEE_ID());
			cst.setString(5, DtDailyDairy.getIS_ACTIVE());
			cst.setInt(6,1);
			cst.execute();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(DailyDairyDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static List<DtDailyDairy> getDailyDairy(int CASEID,int GRVDETID,int GRVID) throws SQLException{
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
            rs=(ResultSet)cst.getObject(6);
            List<DtDailyDairy> list = new ArrayList<DtDailyDairy>();
            while (rs.next()) {
			    list.add(new DtDailyDairy(rs.getInt("CASEID"),rs.getInt("ENTRY_EMPLOYEE_ID"),rs.getString("NAME"),rs.getString("HIERCODE"),rs.getInt("DAIRYID"),rs.getString("DAIRY_DATE"),rs.getString("DAIRY_DETAILS"),rs.getString("IS_ACTIVE")));
			}
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(DailyDairyDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static boolean updateDailyDairy(DtDailyDairy dtDailyDairy) throws SQLException, java.text.ParseException {
		Date date=Date.valueOf((Common.StringToDateFormat(dtDailyDairy.getDAIRY_DATE())));
        Connection con = null;
        CallableStatement cst = null;
        
        try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_DT_DAILY_DAIRY.GMS_DT_DAILY_DAIRY_UPDATE(?,?,?,?,?,?,?)}");
			cst.setInt(1, dtDailyDairy.getDAIRYID());
			cst.setInt(2, dtDailyDairy.getCASEID());
			cst.setDate(3,date);
			cst.setString(4, dtDailyDairy.getDAIRY_DETAILS());
			cst.setInt(5, dtDailyDairy.getEMPLOYEE_ID());
			cst.setString(6, dtDailyDairy.getIS_ACTIVE());
			cst.setInt(7,1);
			return cst.executeUpdate() > 0; 
		} catch (SQLException ex) {
				ex.printStackTrace();
				Logger.getLogger(DailyDairyDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
//	public static boolean insertDailyDairyAttach(DtDailyDairy DtDailyDairy) throws SQLException, java.text.ParseException  {
//		Connection con = null;
//		CallableStatement cst = null;
//		try {
//			con = DBConnection.getConnection();
//			cst = con.prepareCall("{call PCK_GMS_DT_CASE_ATTACH.GMS_DT_CASE_ATTACH_INSERT(?,?,?,?,?,?,?)}");
//			cst.setInt(1, DtDailyDairy.getCASEID());
//			cst.setInt(2,DtDailyDairy.getDAIRYID());
//			cst.setString(3, DtDailyDairy.getFILEPATH());
//			cst.setString(4, DtDailyDairy.getFILENAME());
//			cst.setString(5,"Y");
//			cst.setInt(6,1);
//			if(DtDailyDairy.getFILEPATH() !=null) {
//	            FileInputStream fin = new FileInputStream(DtDailyDairy.getFILEPATH());
//	            cst.setBinaryStream(7, fin, (int) DtDailyDairy.getFILEPATH().length());
//            }else {
//            	cst.setBytes(7, null);
//            }
//			cst.execute();
//			return true;
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			Logger.getLogger(DailyDairyDAO.class.getName()).log(Level.SEVERE, null, ex);
//		} finally {
//			if(cst != null) {
//				DBConnection.closeStatement(cst);
//			}
//			if(con != null) {
//				DBConnection.closeConnection(con);
//			}
//		}
//		return false;
//	}
	
	public static boolean insertDailyDairyAttach(DtDailyDairy DtDailyDairy) throws SQLException, java.text.ParseException  {
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_DT_CASE_ATTACH.GMS_DT_CASE_ATTACH_INSERT(?,?,?,?,?,?,?,?)}");
			cst.setInt(1, DtDailyDairy.getCASEID());
			cst.setInt(2,DtDailyDairy.getDAIRYID());
			cst.setString(3, DtDailyDairy.getFILEPATH());
			cst.setString(4, DtDailyDairy.getFILENAME());
			cst.setString(5,"Y");
			cst.setInt(6,1);
			if(DtDailyDairy.getFILEPATH() !=null) {
	            FileInputStream fin = new FileInputStream(DtDailyDairy.getFILEPATH());
	            cst.setBinaryStream(7, fin, (int) DtDailyDairy.getFILEPATH().length());
            }else {
            	cst.setBytes(7, null);
            }
			cst.setString(8, DtDailyDairy.getFileNameXtn());
			cst.execute();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(DailyDairyDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static List<DtDailyDairy> getDailyDairyAttach(int DAIRYID) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_DAILY_DAIRY_SCR.GMS_DAILY_DAIRY_GRID_ATTACH(?,?)}");
			cst.setInt(1, DAIRYID);
			cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(2);
            List<DtDailyDairy> list = new ArrayList<DtDailyDairy>();
            while (rs.next()) {
			    list.add(new DtDailyDairy(rs.getInt("ATTACHID"),rs.getInt("DAIRYID"),rs.getInt("CASEID"),rs.getInt("COMPLIANT_EMPLOYEE_ID"),rs.getString("FILEPATH"),rs.getString("FILENAME"),rs.getString("NAME"),rs.getString("IS_ACTIVE")));
			}
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(DailyDairyDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    /*
	public static DtDailyDairy getDailyDairyAttachFile(int ATTACHID) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_DAILY_DAIRY_SCR.GMS_DAILY_DAIRY_UD_GRID_SELECT(?,?)}");
			cst.setInt(1, ATTACHID);
			cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(2);
            DtDailyDairy dailyDairy = new DtDailyDairy();
            while (rs.next()) {
            	dailyDairy.setFILEPATH(rs.getString("FILEPATH"));
			}
	        return dailyDairy;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(DailyDairyDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	}*/
	
	public static DtDailyDairy getDailyDairyAttachFile(int ATTACHID) throws SQLException{
		Connection con = null;
		PreparedStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			String sql = "SELECT A.ATTACHID, A.CASEID, A.DAIRYID, A.ATTACH_REMARKS, A.FILEPATH, A.FILENAME, A.IS_ACTIVE, R.DAIRY_DATE, A.FILE_ATTACH, A.FILENAME_XT FROM GMS_DT_CASE_ATTACH A LEFT JOIN GMS_DT_DAILY_DAIRY  R ON R.DAIRYID = A.DAIRYID WHERE A.ATTACHID ="+ATTACHID+"AND A.IS_ACTIVE='Y'";
			cst = con.prepareStatement(sql);
			rs = cst.executeQuery();
            DtDailyDairy dailyDairy = new DtDailyDairy();
            if (rs.next()) {
            	dailyDairy.setFILENAME(rs.getString("FILENAME_XT"));
            	Blob blob = rs.getBlob("FILE_ATTACH");
                InputStream inputStream = blob.getBinaryStream();
                int fileLength = inputStream.available();
                // setted the file length to caseId as caseId its not using and why to create a varible to store this: 
                dailyDairy.setCASEID(fileLength);
			}
	        return dailyDairy;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(DailyDairyDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static boolean deleteDownloadCaseAttcah(int attachmentId) throws SQLException {
		Connection con = null;
		PreparedStatement cst = null;
		try {
			con = DBConnection.getConnection();
			String sql = "UPDATE GMS_DT_CASE_ATTACH SET is_active='D' WHERE ATTACHID = ?";
			cst = con.prepareStatement(sql);
			cst.setInt(1, attachmentId);
			cst.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
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
