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
import com.gms.model.masters.HdRegionModel;
import com.gms.model.masters.ManpowerModel;
import com.gms.model.masters.RhrInvestigatorMasterModel;

import oracle.jdbc.OracleTypes;

public class RhrInvestigatorDAO {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RhrInvestigatorDAO.class.getName());
	public static boolean insertRhrInv(RhrInvestigatorMasterModel RhrInvestigatorMaster) throws SQLException {
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_RHR_INVSTGR.GMS_MA_RHR_INVSTGR_INSERT(?,?,?,?,?)}");
			cst.setString(1, RhrInvestigatorMaster.getREGION_CODE());
			cst.setInt(2, RhrInvestigatorMaster.getINVESTIGATOR_EMPLOYEE_ID());
			cst.setString(3, RhrInvestigatorMaster.getIS_HR());
			cst.setString(4, RhrInvestigatorMaster.getIS_ACTIVE());
			cst.setInt(5,1);
			cst.execute();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(RhrInvestigatorDAO.class.getName()).log(Level.SEVERE, null, ex);
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

	public static List<RhrInvestigatorMasterModel> RhrInvestigatorMaster() throws SQLException {
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_MA_RHR_INVSTGR_SCR.GMS_MA_RHR_INVSTGR_GRID_LIST(?)}");
			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.execute();
			rs = (ResultSet) cst.getObject(1);
			List<RhrInvestigatorMasterModel> list = new ArrayList<RhrInvestigatorMasterModel>();
			while (rs.next()) {
				list.add(new RhrInvestigatorMasterModel(rs.getInt("RHRID"), rs.getString("REGION_CODE"),
						rs.getString("REGION_NAME"),
						rs.getInt("INVESTIGATOR_EMPLOYEE_ID"), rs.getString("NAME"), rs.getString("DESIGNATION"),
						rs.getString("DEPARTMENT"), rs.getString("IS_HR"), rs.getString("IS_ACTIVE"),
						rs.getString("DATE_CREATED")));
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(RhrInvestigatorDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static RhrInvestigatorMasterModel getrhrInvestigator(int Id) throws SQLException{
	    Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_MA_RHR_INVSTGR_SCR.GMS_MA_RHR_INVSTGR_GRID_SELECT(?,?,?,?)}");
	        cst.setInt(1, Id);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
	        cst.registerOutParameter(4, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(3);
            RhrInvestigatorMasterModel rhr = new RhrInvestigatorMasterModel();
            if (rs.next()){
				rhr.setRHRID(rs.getInt("RHRID"));
				rhr.setREGION_CODE(rs.getString("REGION_CODE"));
				rhr.setREGION_NAME(rs.getString("REGION_NAME"));
				rhr.setINVESTIGATOR_EMPLOYEE_ID(rs.getInt("INVESTIGATOR_EMPLOYEE_ID"));
				rhr.setNAME(rs.getString("NAME"));
				rhr.setDESIGNATION(rs.getString("DESIGNATION"));
				rhr.setDEPARTMENT(rs.getString("DEPARTMENT"));
				rhr.setIS_HR(rs.getString("IS_HR"));
				rhr.setIS_ACTIVE(rs.getString("IS_ACTIVE"));
				
			} 
			System.out.println(rhr.toString());
	        return rhr;
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        	 Logger.getLogger(RhrInvestigatorDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static RhrInvestigatorMasterModel getrhrInvestigator(int Id) throws SQLException{
	    Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    RhrInvestigatorMasterModel RhrInvestigatorMaster = null;
	    
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_MA_RHR_INVSTGR_SCR.GMS_MA_RHR_INVSTGR_GRID_SELECT(?,?,?,?)}");
	        cst.setInt(1, Id);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
	        cst.registerOutParameter(4, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(3);
			if (rs.next()){
				RhrInvestigatorMaster = (new RhrInvestigatorMasterModel(rs.getInt("RHRID"),
						rs.getString("REGION_CODE"),
						rs.getString("REGION_NAME"), rs.getInt("INVESTIGATOR_EMPLOYEE_ID"),
						rs.getString("NAME"), rs.getString("DESIGNATION"), rs.getString("DEPARTMENT"),
						rs.getString("IS_HR"), rs.getString("IS_ACTIVE"), rs.getString("DATE_CREATED")));
			} 
			System.out.println(RhrInvestigatorMaster.toString());
	        return RhrInvestigatorMaster;
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        	 Logger.getLogger(RhrInvestigatorDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static boolean updateRhrInv(RhrInvestigatorMasterModel RhrInvestigatorMaster) throws SQLException {
        Connection con = null;
        CallableStatement cst = null;
        
        try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_RHR_INVSTGR.GMS_MA_RHR_INVSTGR_UPDATE(?,?,?,?,?,?)}");
			cst.setInt(1, RhrInvestigatorMaster.getRHRID());
			cst.setString(2, RhrInvestigatorMaster.getREGION_CODE());
			cst.setInt(3, RhrInvestigatorMaster.getINVESTIGATOR_EMPLOYEE_ID());
			cst.setString(4, RhrInvestigatorMaster.getIS_HR());
			cst.setString(5, RhrInvestigatorMaster.getIS_ACTIVE());
			cst.setInt(6,1);
			return cst.executeUpdate() > 0; 
		} catch (SQLException ex) {
				ex.printStackTrace();
				Logger.getLogger(RhrInvestigatorDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static List<ManpowerModel> getRhrManpower() throws SQLException{
	    Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    List<ManpowerModel> list = new ArrayList<ManpowerModel>();
	    
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_MA_RHR_INVSTGR_SCR.GMS_MA_RHR_INVSTGR_GRID_SELECT(?,?,?,?)}");
	        cst.setString(1, null);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
	        cst.registerOutParameter(4, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(2);
            while (rs.next()) {
            	list.add(new ManpowerModel( rs.getString("EMPLOYEE_ID"), rs.getString("TITLE"), rs.getString("NAME"), rs.getString("DESIGNATION"), rs.getString("BRANCH_CODE"), rs.getString("STAFF_TYPE"), rs.getString("DOJ"), rs.getString("DOB"), rs.getString("GENDER"), rs.getString("ZONE_CODE"), rs.getString("STATE_CODE"), rs.getString("CITY_CODE"), rs.getString("JOB_CODE"), rs.getString("JOB_FUNCTION_CODE"), rs.getString("JOB_FUNCTION"), rs.getString("DEPARTMENT"), rs.getString("COST_CENTER"), rs.getString("SUPERVISIOR_ID"), rs.getString("IS_ACTIVE"), rs.getString("DATE_CREATED")));
			}                                         
	        return list;
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        	 Logger.getLogger(RhrInvestigatorDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static List<HdRegionModel> getRegion() throws SQLException{
	    Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    List<HdRegionModel> list = new ArrayList<HdRegionModel>();
	    
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_MA_RHR_INVSTGR_SCR.GMS_MA_RHR_INVSTGR_GRID_SELECT(?,?,?,?)}");
	        cst.setString(1, null);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
	        cst.registerOutParameter(4, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(4);
            while (rs.next()) {
            	HdRegionModel HdRegion = new HdRegionModel();
				HdRegion.setREGION_CODE(rs.getString("REGION_CODE"));
				HdRegion.setREGION_NAME(rs.getString("REGION_NAME"));
				
				list.add(HdRegion);  	
			}                                         
	        return list;
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        	 Logger.getLogger(RhrInvestigatorDAO.class.getName()).log(Level.SEVERE, null, ex);
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
