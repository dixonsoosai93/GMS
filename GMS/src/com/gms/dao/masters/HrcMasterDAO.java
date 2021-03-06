package com.gms.dao.masters;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gms.commons.DBConnection;
import com.gms.model.grievance.DtCaseEmpModel;
import com.gms.model.masters.ALBranch;
import com.gms.model.masters.ALDepartment;
import com.gms.model.masters.ALDesignation;
import com.gms.model.masters.ALJobFunction;
import com.gms.model.masters.ComplaintEmpSelect;
import com.gms.model.masters.ManpowerModel;
import com.gms.model.masters.ZoneModel;

import oracle.jdbc.OracleTypes;

public class HrcMasterDAO {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HrcMasterDAO.class.getName());
	public static List<ZoneModel> getZone() throws SQLException{
	    Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    List<ZoneModel> list = new ArrayList<ZoneModel>();
	    
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_MA_ZLGC_INVSTGR_SCR.GMS_MA_ZLGC_INV_GRID_SELECT(?,?,?,?)}");
	        cst.setString(1, null);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
	        cst.registerOutParameter(4, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(2);
            while (rs.next()) {
				list.add(new ZoneModel(rs.getString("ZONE_CODE"),rs.getString("ZONE_NAME")));
			}                                         
	        return list;
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        	 Logger.getLogger(HrcMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static List<ManpowerModel> getManpower() throws SQLException{
	    Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    List<ManpowerModel> list = new ArrayList<ManpowerModel>();
	    
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_MA_ZLGC_INVSTGR_SCR.GMS_MA_ZLGC_INV_GRID_SELECT(?,?,?,?)}");
	        cst.setString(1, null);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
	        cst.registerOutParameter(4, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(3);
            while (rs.next()) {
            	list.add(new ManpowerModel( rs.getString("EMPLOYEE_ID"), rs.getString("TITLE"), rs.getString("NAME"), rs.getString("DESIGNATION"), rs.getString("BRANCH_CODE"), rs.getString("STAFF_TYPE"), rs.getString("DOJ"), rs.getString("DOB"), rs.getString("GENDER"), rs.getString("ZONE_CODE"), rs.getString("STATE_CODE"), rs.getString("CITY_CODE"), rs.getString("JOB_CODE"), rs.getString("JOB_FUNCTION_CODE"), rs.getString("JOB_FUNCTION"), rs.getString("DEPARTMENT"), rs.getString("COST_CENTER"), rs.getString("SUPERVISIOR_ID"), rs.getString("IS_ACTIVE"), rs.getString("DATE_CREATED")));
			}                                         
	        return list;
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        	 Logger.getLogger(HrcMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static List<ManpowerModel> getCentralManpower() throws SQLException{
	    Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    List<ManpowerModel> list = new ArrayList<ManpowerModel>();
	    
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_MA_CENTRAL_INVSTGR_SCR.GMS_MA_CENTRAL_INV_GRID_SELECT(?,?,?)}");
	        cst.setString(1, null);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(2);
            while (rs.next()) {
            	list.add(new ManpowerModel( rs.getString("EMPLOYEE_ID"), rs.getString("TITLE"), rs.getString("NAME"), rs.getString("DESIGNATION"), rs.getString("BRANCH_CODE"), rs.getString("STAFF_TYPE"), rs.getString("DOJ"), rs.getString("DOB"), rs.getString("GENDER"), rs.getString("ZONE_CODE"), rs.getString("STATE_CODE"), rs.getString("CITY_CODE"), rs.getString("JOB_CODE"), rs.getString("JOB_FUNCTION_CODE"), rs.getString("JOB_FUNCTION"), rs.getString("DEPARTMENT"), rs.getString("COST_CENTER"), rs.getString("SUPERVISIOR_ID"), rs.getString("IS_ACTIVE"), rs.getString("DATE_CREATED")));
			} 
	        return list;
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        	 Logger.getLogger(HrcMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static ComplaintEmpSelect getFilterList() throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rsB = null;
		ResultSet rsJ = null;
		ResultSet rsD = null;
		ResultSet rsDesign = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_MA_EMP_SEARCH_SCR.GMS_EMPLOYEE_FILTER(?,?,?,?)}");
			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.registerOutParameter(3, OracleTypes.CURSOR);
			cst.registerOutParameter(4, OracleTypes.CURSOR);
			cst.execute();
			ComplaintEmpSelect cEmpSelect = new ComplaintEmpSelect();
			rsB=(ResultSet)cst.getObject(1);
			rsJ=(ResultSet)cst.getObject(2);
			rsD=(ResultSet)cst.getObject(3);
			rsDesign=(ResultSet)cst.getObject(4);
			ArrayList<ALBranch> tBranch = new ArrayList<ALBranch>();
			ArrayList<ALJobFunction> tJob = new ArrayList<ALJobFunction>();
			ArrayList<ALDepartment> tDept = new ArrayList<ALDepartment>();
			ArrayList<ALDesignation> tDesign = new ArrayList<ALDesignation>();
			while (rsB.next()) {
				ALBranch br = new ALBranch();
				br.setBranchCode(rsB.getString("BRANCH_CODE"));
				br.setBranchName(rsB.getString("BRANCH_NAME"));
				tBranch.add(br);
			}
			while (rsJ.next()) {
				ALJobFunction jb = new ALJobFunction();
				jb.setJobFunctionCode(rsJ.getString("JOB_FUNCTION_CODE"));
				jb.setJobFunction(rsJ.getString("JOB_FUNCTION"));
				tJob.add(jb);
			}
			while(rsD.next()) {
				ALDepartment dpt = new ALDepartment();
				dpt.setDepartmentCode(rsD.getString("DEPARTMENT_CODE"));
				dpt.setDepartment(rsD.getString("DEPARTMENT"));
				tDept.add(dpt);
			}
			while(rsDesign.next()) {
				ALDesignation design = new ALDesignation();
				design.setDesignationCode(rsDesign.getString("DESIGNATION_CODE"));
				design.setDesignationName(rsDesign.getString("DESIGNATION"));
				tDesign.add(design);
			}
		cEmpSelect.settBranch(tBranch);
		cEmpSelect.settJobFUnction(tJob);
		cEmpSelect.settDepartment(tDept);
		cEmpSelect.settDesignation(tDesign);
		return cEmpSelect;
		}catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(HrcMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
		}finally {
			if(cst != null) {
				DBConnection.closeStatement(cst);
			}
			if(rsB != null) {
				DBConnection.closeResultSet(rsB);
			}
			if(rsJ != null) {
				DBConnection.closeResultSet(rsJ);
			}
			if(rsD != null) {
				DBConnection.closeResultSet(rsD);
			}
			if(rsDesign != null) {
				DBConnection.closeResultSet(rsDesign);
			}
			if(con != null) {
				DBConnection.closeConnection(con);
			}
		}
		return null;
	}

	public static List<ManpowerModel> getManpowerListScr(String branchCode, String desgination, String jobCode, String departmentId, String NTID, String Name ) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_EMP_SEARCH_SCR.GMS_EMPLOYEE_GRID_LIST(?,?,?,?,?,?,?)}");
			cst.setString(1, branchCode);
			cst.setString(2, desgination);
			cst.setString(3, jobCode);
			cst.setString(4, departmentId);
			cst.setString(5, NTID);
			cst.setString(6, Name);
			cst.registerOutParameter(7, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(7);
			List<ManpowerModel> list = new ArrayList<ManpowerModel>();
			while (rs.next()) {
				ManpowerModel mPow = new ManpowerModel();
				mPow.setEMPLOYEE_ID(rs.getString("EMPLOYEE_ID"));
				mPow.setNAME(rs.getString("NAME"));
				mPow.setTITLE(rs.getString("TITLE"));
				mPow.setDOB(rs.getString("DOB"));
				mPow.setGENDER(rs.getString("GENDER"));
				mPow.setDESIGNATION(rs.getString("DESIGNATION"));
				mPow.setJOB_FUNCTION(rs.getString("JOB_FUNCTION"));
				mPow.setDEPARTMENT(rs.getString("DEPARTMENT"));
				mPow.setSUPERVISIOR_ID(rs.getString("SUPERVISIOR_ID"));
				mPow.setBRANCH_NAME(rs.getString("BRANCH_NAME"));
				mPow.setIS_ACTIVE(rs.getString("IS_ACTIVE"));
				mPow.setDATE_CREATED(rs.getString("DATE_CREATED"));
				list.add(mPow);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(HrcMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static List<ManpowerModel> getEmpGrievanceManpower() throws SQLException{
	    Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    List<ManpowerModel> list = new ArrayList<ManpowerModel>();
	    
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_MA_EMP_SEARCH_SCR.GMS_EMPLOYEE_DROPDOWN(?)}");
	        cst.registerOutParameter(1, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(1);
            while (rs.next()) {
            	list.add(new ManpowerModel( rs.getString("EMPLOYEE_ID"),rs.getString("NAME")));
			} 
	        return list;
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        	 Logger.getLogger(HrcMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	// procedure to get  unique data : EmployeeGrivence
	public static List<ManpowerModel> getManpowerList(String branchCode, String desgination, String jobCode, String departmentId, String NTID, String Name) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_HRC_MANPOWER.HRC_MANPOWER_GRID_LIST(?,?,?,?,?,?,?)}");
			cst.setString(1, branchCode);
			cst.setString(2, desgination);
			cst.setString(3, jobCode);
			cst.setString(4, departmentId);
			cst.setString(5, NTID);
			cst.setString(6, Name);
			cst.registerOutParameter(7, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(7);
			List<ManpowerModel> list = new ArrayList<ManpowerModel>();
			while (rs.next()) {
				ManpowerModel mPow = new ManpowerModel();
				mPow.setEMPLOYEE_ID(rs.getString("EMPLOYEE_ID"));
				mPow.setNAME(rs.getString("NAME"));
				mPow.setTITLE(rs.getString("TITLE"));
				mPow.setDOB(rs.getString("DOB"));
				mPow.setGENDER(rs.getString("GENDER"));
				mPow.setDESIGNATION(rs.getString("DESIGNATION"));
				mPow.setJOB_FUNCTION(rs.getString("JOB_FUNCTION"));
				mPow.setDEPARTMENT(rs.getString("DEPARTMENT"));
				mPow.setSUPERVISIOR_ID(rs.getString("SUPERVISIOR_ID"));
				mPow.setBRANCH_NAME(rs.getString("BRANCH_NAME"));
				mPow.setIS_ACTIVE(rs.getString("IS_ACTIVE"));
				mPow.setDATE_CREATED(rs.getString("DATE_CREATED"));
				list.add(mPow);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(HrcMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
		// for employee Griv group list exclude selected employees:	
		public static List<ManpowerModel> getManpowerListEmployeeGriv(String branchCode, String desgination, String jobCode, String departmentId, String NTID, String Name, int groupList/*ArrayList<DtCaseEmpModel> excludeGroupList*/) throws SQLException{
			Connection con = null;
			CallableStatement cst = null;
			ResultSet rs = null;
			int count = 0;
		    int insertCount = 0;
			try {
				con = DBConnection.getConnection();
				cst = con.prepareCall("{call PCK_HRC_MANPOWER.HRC_MANPOWER_GRID_LIST(?,?,?,?,?,?,?,?)}");
				cst.setString(1, branchCode);
				cst.setString(2, desgination);
				cst.setString(3, jobCode);
				cst.setString(4, departmentId);
				cst.setString(5, NTID);
				cst.setString(6, Name);
				cst.setInt(7, groupList);
				cst.registerOutParameter(8, OracleTypes.CURSOR);
				cst.execute();
	            rs=(ResultSet)cst.getObject(8);
				List<ManpowerModel> list = new ArrayList<ManpowerModel>();
				while (rs.next()) {
					ManpowerModel mPow = new ManpowerModel();
					mPow.setEMPLOYEE_ID(rs.getString("EMPLOYEE_ID"));
					mPow.setNAME(rs.getString("NAME"));
					mPow.setTITLE(rs.getString("TITLE"));
					mPow.setDOB(rs.getString("DOB"));
					mPow.setGENDER(rs.getString("GENDER"));
					mPow.setDESIGNATION(rs.getString("DESIGNATION"));
					mPow.setJOB_FUNCTION(rs.getString("JOB_FUNCTION"));
					mPow.setDEPARTMENT(rs.getString("DEPARTMENT_CODE"));
					mPow.setSUPERVISIOR_ID(rs.getString("SUPERVISIOR_ID"));
					mPow.setBRANCH_NAME(rs.getString("BRANCH_CODE"));
					mPow.setIS_ACTIVE(rs.getString("IS_ACTIVE"));
					mPow.setDATE_CREATED(rs.getString("DATE_CREATED"));
					list.add(mPow);
				}
				return list;
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println(ex.getMessage());
				Logger.getLogger(HrcMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
