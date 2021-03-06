package com.gms.dao.admin;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gms.commons.DBConnection;
import com.gms.model.admin.ReopenAttachment;

import oracle.jdbc.OracleTypes;

public class ReopenAttachmentDao {
	/*
	public static boolean insertReopenAttachment(ReopenAttachment reAttach) throws SQLException, FileNotFoundException {
		Connection con = null;
        CallableStatement cst = null;
        try {
            con = DBConnection.getConnection();
            cst = con.prepareCall("call PCK_GMS_DT_REOPEN_GRV_ATTACH.GMS_DT_REN_GRV_ATTACH_INSERT(?,?,?,?,?,?,?,?,?)");
            cst.setInt(1, reAttach.getGRVDETID());
            cst.setInt(2, reAttach.getGRVID());
            cst.setString(3, reAttach.getATTACH_REMARKS());
            cst.setString(4, reAttach.getFILEPATH());
            cst.setString(5, reAttach.getFILENAME());
            cst.setString(6, reAttach.getIS_ACTIVE());
            cst.setInt(7, 1);
            if(reAttach.getFILEPATH() !=null) {
	            FileInputStream fin = new FileInputStream(reAttach.getFILEPATH());
	            cst.setBinaryStream(8, fin, (int) reAttach.getFILEPATH().length());
            }else {
            	cst.setBytes(8, null);
            }
            cst.setString(9, reAttach.getFileNameExtns());
            return cst.executeUpdate() > 0; 
        } catch (SQLException ex) {
        	ex.printStackTrace();
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
	*/
	public static boolean insertReopenAttachment(ReopenAttachment reAttach) throws SQLException, FileNotFoundException {
		Connection con = null;
        PreparedStatement cst = null;
        try {
            con = DBConnection.getConnection();
            String slq = "INSERT INTO GMS_DT_REOPEN_GRV_ATTACH ( ATTACHID, GRVDETID, GRVID, ATTACH_REMARKS, FILEPATH, FILENAME, IS_ACTIVE, CREATEDBY, DATE_CREATED, FILE_ATTACH, FILENAME_XT ) VALUES ( GMS_DT_REOPEN_GRV_ATTACH_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ? )"; 
            cst = con.prepareStatement(slq);
            cst.setInt(1, reAttach.getGRVDETID());
            cst.setInt(2, reAttach.getGRVID());
            cst.setString(3, reAttach.getATTACH_REMARKS());
            cst.setString(4, reAttach.getFILEPATH());
            cst.setString(5, reAttach.getFILENAME());
            cst.setString(6, reAttach.getIS_ACTIVE());
            cst.setInt(7, 1);
            if(reAttach.getFILEPATH() !=null) {
	            FileInputStream fin = new FileInputStream(reAttach.getFILEPATH());
	            cst.setBinaryStream(8, fin, (int) reAttach.getFILEPATH().length());
            }else {
            	cst.setBytes(8, null);
            }
            cst.setString(9, reAttach.getFileNameExtns());
            return cst.executeUpdate() > 0;
        } catch (SQLException ex) {
        	ex.printStackTrace();
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
	
	public static List<ReopenAttachment> getComplaintAttachment(int grvDtId) throws SQLException{
		Connection con = null;
        CallableStatement cst = null;
        ResultSet rs = null;
        try {
            con = DBConnection.getConnection();
            cst = con.prepareCall("call PCK_GMS_DT_REOPEN_GRV_ATTACH.GMS_DT_REOPEN_GRV_GRID_ATTACH(?,?)");
            cst.setInt(1, grvDtId);
            cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.execute();
            rs = (ResultSet)cst.getObject(2);
			List<ReopenAttachment> list = new ArrayList<ReopenAttachment>();
			while(rs.next()) {
				ReopenAttachment reopenAttachment = new ReopenAttachment();
				reopenAttachment.setATTACHID(rs.getInt("ATTACHID"));
				reopenAttachment.setGRVDETID(rs.getInt("GRVDETID"));
				reopenAttachment.setGRVID(rs.getInt("GRVID"));
				reopenAttachment.setFILENAME(rs.getString("FILENAME"));
				reopenAttachment.setFILEPATH(rs.getString("FILEPATH"));
				reopenAttachment.setATTACH_REMARKS(rs.getString("ATTACH_REMARKS"));
				reopenAttachment.setIS_ACTIVE(rs.getString("IS_ACTIVE"));
				reopenAttachment.setDATE(rs.getString("DATE_CREATED"));
				reopenAttachment.setCOMPLIANT_EMPLOYEE_ID(rs.getString("COMPLIANT_EMPLOYEE_ID"));
				reopenAttachment.setNAME(rs.getString("NAME"));
				list.add(reopenAttachment);
			}
			return list;
        } catch (SQLException ex) {
        	ex.printStackTrace();
        } finally {
            if (cst != null) {
                DBConnection.closeStatement(cst);
            }
            if (con != null) {
                DBConnection.closeConnection(con);
            }
        }
		return null;
	}
	/*
	public static List<ReopenAttachment> reopenFileDownLoad(int ATTACHID) throws SQLException{
		Connection con = null;
        CallableStatement cst = null;
        ResultSet rs = null;
        try {
            con = DBConnection.getConnection();
            cst = con.prepareCall("call PCK_GMS_DT_REOPEN_GRV_ATTACH.GMS_DT_REOPEN_GRV_GRID_ATTACH(?,?)");
            cst.setInt(1, ATTACHID);
            cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.execute();
            rs = (ResultSet)cst.getObject(2);
			List<ReopenAttachment> list = new ArrayList<ReopenAttachment>();
			while(rs.next()) {
				ReopenAttachment reopenAttachment = new ReopenAttachment();
				reopenAttachment.setATTACHID(rs.getInt("ATTACHID"));
				reopenAttachment.setGRVDETID(rs.getInt("GRVDETID"));
				reopenAttachment.setGRVID(rs.getInt("GRVID"));
				reopenAttachment.setFILENAME(rs.getString("FILENAME"));
				list.add(reopenAttachment);
			}
			return list;
        } catch (SQLException ex) {
        	ex.printStackTrace();
        } finally {
            if (cst != null) {
                DBConnection.closeStatement(cst);
            }
            if (con != null) {
                DBConnection.closeConnection(con);
            }
        }
		return null;
	}
	*/
	/*
	public static ReopenAttachment reopenFileDownLoad(int ATTACHID) throws SQLException, IOException{
		Connection con = null;
        PreparedStatement cst = null;
        ResultSet rs = null;
        try {
            con = DBConnection.getConnection();
            String sql = "SELECT a.filename, A.FILEPATH, A.FILE_ATTACH FROM GMS_DT_REOPEN_GRV_ATTACH A INNER JOIN GMS_DT_GRIEVANCE D ON D.GRVDETID=A.GRVDETID INNER JOIN GMS_HD_GRIEVANCE H ON H.GRVID=D.GRVID LEFT JOIN HRC_BCT_MANPOWER M ON M.EMPLOYEE_ID=H.COMPLIANT_EMPLOYEE_ID WHERE A.IS_ACTIVE = 'Y' AND A.ATTACHID ="+ATTACHID;
            cst = con.prepareStatement(sql);
            rs = cst.executeQuery();
            ReopenAttachment reopenAttachment = new ReopenAttachment();
			while(rs.next()) {
				reopenAttachment.setFILENAME(rs.getString("filename"));
				reopenAttachment.setFILEPATH(rs.getString("FILEPATH"));
				Blob blob = rs.getBlob("FILE_ATTACH");
                InputStream inputStream = blob.getBinaryStream();
                int fileLength = inputStream.available();
                // setted the file length to caseId as GRV-DET-ID its not using and why to create a variable to store this: 
                reopenAttachment.setGRVDETID(fileLength);
			}
			return reopenAttachment;
        } catch (SQLException ex) {
        	ex.printStackTrace();
        } finally {
            if (cst != null) {
                DBConnection.closeStatement(cst);
            }
            if (con != null) {
                DBConnection.closeConnection(con);
            }
        }
		return null;
	}
	 */
	public static ReopenAttachment reopenFileDownLoad(int attachId) throws SQLException, IOException{
		Connection con = null;
        CallableStatement cst = null;
        ResultSet rs = null;
        byte[] bytes = null;
        try {
            con = DBConnection.getConnection();
            cst = con.prepareCall("{call PCK_GMS_DT_REOPEN_GRV_ATTACH.GMS_DT_REOPEN_GRV_CASE_ATTACH(?,?)}");
            cst.setInt(1, attachId);
            cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.execute();
            rs = (ResultSet)cst.getObject(2);
            ReopenAttachment reAttach= new ReopenAttachment();
			if(rs.next()) {
				String filePath = rs.getString("FILEPATH");
                
				Blob blob = rs.getBlob("FILE_ATTACH");
                InputStream in = blob.getBinaryStream();
                
                
                int fLength =  (int) blob.length();
                reAttach.setFILEPATH(filePath);
                reAttach.setFileLength(fLength);
                
                //String fName = rs.getString("FILENAME_XT");
                //reAttach.setFileNameExtns(fName);
                System.out.println(" fLength :"+fLength+" filePath "+filePath);
			}
			return reAttach;
        } catch (SQLException ex) {
        	ex.printStackTrace();
        } finally {
            if (cst != null) {
                DBConnection.closeStatement(cst);
            }
            if (con != null) {
                DBConnection.closeConnection(con);
            }
        }
		return null;
	}
	
	public static boolean deleteAttachment(int attachId) throws SQLException {
		Connection con = null;
		CallableStatement cst =  null;
		try {
		      con = DBConnection.getConnection();
		      cst = con.prepareCall("{call PCK_GMS_DT_REOPEN_GRV_ATTACH.GMS_DT_REN_GRV_ATTACH_DELETE(?,?)}");
		      cst.setInt(1, attachId);
		      cst.setInt(2, 1);
		      return cst.executeUpdate() > 0; 
		 } catch (SQLException ex) {
			  ex.printStackTrace();
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
