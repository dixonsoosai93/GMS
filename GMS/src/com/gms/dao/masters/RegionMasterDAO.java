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
import com.gms.model.grievance.HdGrievanceModel;
import com.gms.model.masters.BranchModel;
import com.gms.model.masters.CityModel;
import com.gms.model.masters.DtRegionModel;
import com.gms.model.masters.GrievanceCategoryHierarchyModel;
import com.gms.model.masters.HdRegionModel;
import com.gms.model.masters.ManpowerModel;

import oracle.jdbc.OracleTypes;

public class RegionMasterDAO {
	
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RegionMasterDAO.class.getName());
	public static boolean insertHdRegion(HdRegionModel HdRegion ,ArrayList<DtRegionModel> list) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		String REGION_ID =null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_HD_REGION.GMS_HD_REGION_INSERT(?,?,?,?,?,?,?)}");
			cst.setString(1,HdRegion.getREGION_CODE());
			cst.setString(2, HdRegion.getREGION_NAME());
			cst.setString(3, HdRegion.getREGION_DESC());
			cst.setString(4, HdRegion.getEMPLOYEE_ID());
			cst.setString(5,HdRegion.getIS_ACTIVE());
			cst.setInt(6,1);
			cst.registerOutParameter(7,OracleTypes.INTEGER);
			cst.execute();
			REGION_ID=cst.getString(7);
			int insertcount=insertDtRegion(list,REGION_ID);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(RegionMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static int insertDtRegion(List<DtRegionModel> list,String REGION_ID) throws SQLException {
		Connection con = null;
		CallableStatement cst = null;
	      int count = 0;
	      int insertCount = 0;
		try {
			 con = DBConnection.getConnection();
			 cst = con.prepareCall("{call PCK_GMS_DT_REGION.GMS_DT_REGION_INSERT(?,?,?,?,?)}");
			  con.setAutoCommit(false);
			   for (DtRegionModel DtRegion : list) {
				    cst.setInt(1,Integer.parseInt(REGION_ID));
					cst.setString(2, DtRegion.getCITY_CODE());
					cst.setString(3, DtRegion.getBRANCH_CODE());
					cst.setString(4, (DtRegion.getIS_ACTIVE().equalsIgnoreCase("Yes")?"Y":"N"));
					cst.setInt(5,1);
		           cst.addBatch();
		           count++;
		           if(count % 10000 == 0){
		        	   int[] result = cst.executeBatch();
		        	   insertCount += result.length;
		           }
	           }
	           int[] result = cst.executeBatch();
	           insertCount += result.length;
	           con.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(RegionMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(cst != null) {
				DBConnection.closeStatement(cst);
			}
			if(con != null) {
				DBConnection.closeConnection(con);
			}
		}
		return insertCount;
	}
	
	public static List<HdRegionModel> getHdRegion() throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_HD_REGION_SCR.GMS_HD_REGION_GRID_LIST(?)}");
			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(1);
			List<HdRegionModel> list = new ArrayList<HdRegionModel>();
			while (rs.next()) {
				HdRegionModel HdRegion =new HdRegionModel();
				HdRegion.setREGION_ID(rs.getInt("REGION_ID"));
				HdRegion.setREGION_CODE(rs.getString("REGION_CODE"));
				HdRegion.setREGION_NAME(rs.getString("REGION_NAME"));
				HdRegion.setREGION_DESC(rs.getString("REGION_DESC"));
				HdRegion.setEMPLOYEE_ID(rs.getString("EMPLOYEE_ID"));
				HdRegion.setNAME(rs.getString("NAME"));
				HdRegion.setIS_ACTIVE(rs.getString("IS_ACTIVE"));
				list.add(HdRegion);
			}
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(RegionMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static List<DtRegionModel> getDtRegion(int id) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
        try {
        	con = DBConnection.getConnection();
        	cst = con.prepareCall("{call PCK_GMS_HD_REGION_SCR.GMS_HD_REGION_GRID_SELECT(?,?,?,?,?,?)}");
        	cst.setInt(1,id);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
	        cst.registerOutParameter(4, OracleTypes.CURSOR);
	        cst.registerOutParameter(5, OracleTypes.CURSOR);
	        cst.registerOutParameter(6, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(5);
			List<DtRegionModel> list = new ArrayList<DtRegionModel>();
			while (rs.next()) {
				DtRegionModel dtRegion = new DtRegionModel();
				System.out.println(" In region Master dao Region DT Id : "+rs.getInt("REGION_DET_ID"));
				dtRegion.setREGION_DET_ID(rs.getInt("REGION_DET_ID"));
				dtRegion.setCITY_CODE(rs.getString("CITY_CODE"));
				dtRegion.setCITY_NAME(rs.getString("CITY_NAME"));
				dtRegion.setSTATE_NAME(rs.getString("STATE_NAME"));
				dtRegion.setZONE_NAME(rs.getString("ZONE_NAME"));
				dtRegion.setBRANCH_CODE(rs.getString("BRANCH_CODE"));
				dtRegion.setBRANCH_NAME(rs.getString("BRANCH_NAME"));
				dtRegion.setIS_ACTIVE((rs.getString("IS_ACTIVE").equalsIgnoreCase("Y")?"YES":"NO"));
				list.add(dtRegion);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(RegionMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(cst !=null) {
				DBConnection.closeStatement(cst);
			}
			if(rs !=null) {
				DBConnection.closeResultSet(rs);
			}
			if(con != null) {
				DBConnection.closeConnection(con);
			}
		}
		return null;
	}
	
	public static HdRegionModel getSelectDtRegion(int id) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
        try {
        	con = DBConnection.getConnection();
        	cst = con.prepareCall("{call PCK_GMS_HD_REGION_SCR.GMS_HD_REGION_GRID_SELECT (?,?,?,?,?,?)}");
        	cst.setInt(1,id);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
	        cst.registerOutParameter(4, OracleTypes.CURSOR);
	        cst.registerOutParameter(5, OracleTypes.CURSOR);
	        cst.registerOutParameter(6, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(6);
			HdRegionModel HdRegion =new HdRegionModel();
			while (rs.next()) {
				HdRegion.setREGION_ID(rs.getInt("REGION_ID"));
				HdRegion.setREGION_CODE(rs.getString("REGION_CODE"));
				HdRegion.setREGION_NAME(rs.getString("REGION_NAME"));
				HdRegion.setREGION_DESC(rs.getString("REGION_DESC"));
				HdRegion.setEMPLOYEE_ID(rs.getString("EMPLOYEE_ID"));
				HdRegion.setNAME(rs.getString("NAME"));
				HdRegion.setIS_ACTIVE(rs.getString("IS_ACTIVE"));
			}
			return HdRegion;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(RegionMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(cst !=null) {
				DBConnection.closeStatement(cst);
			}
			if(rs !=null) {
				DBConnection.closeResultSet(rs);
			}
			if(con != null) {
				DBConnection.closeConnection(con);
			}
		}
		return null;
	}
	
	public static List<ManpowerModel> getManpowerRegion() throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_HD_REGION_SCR.GMS_HD_REGION_GRID_SELECT (?,?,?,?,?,?)}");
			cst.setString(1, null);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
	        cst.registerOutParameter(4, OracleTypes.CURSOR);
	        cst.registerOutParameter(5, OracleTypes.CURSOR);
	        cst.registerOutParameter(6, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(2);
			List<ManpowerModel> list = new ArrayList<ManpowerModel>();
			while (rs.next()) {
				ManpowerModel mPow = new ManpowerModel();
				mPow.setEMPLOYEE_ID(rs.getString("EMPLOYEE_ID"));
				mPow.setNAME(rs.getString("NAME"));
				mPow.setBRANCH_NAME(rs.getString("BRANCH_NAME"));
				mPow.setDESIGNATION(rs.getString("DESIGNATION"));
				mPow.setDEPARTMENT(rs.getString("DEPARTMENT"));
				list.add(mPow);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(RegionMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static List<BranchModel> getBranchList() throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
        try {
        	con = DBConnection.getConnection();
        	cst = con.prepareCall("{call PCK_GMS_HD_REGION_SCR.GMS_HD_REGION_GRID_SELECT (?,?,?,?,?,?)}");
        	cst.setString(1, null);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
	        cst.registerOutParameter(4, OracleTypes.CURSOR);
	        cst.registerOutParameter(5, OracleTypes.CURSOR);
	        cst.registerOutParameter(6, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(4);
			List<BranchModel> list = new ArrayList<BranchModel>();
			while (rs.next()) {
				BranchModel branch = new BranchModel();
				branch.setBRANCH_CODE(rs.getString("BRANCH_CODE"));
				branch.setBRANCH_NAME(rs.getString("BRANCH_NAME"));
				list.add(branch);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(RegionMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(cst !=null) {
				DBConnection.closeStatement(cst);
			}
			if(rs !=null) {
				DBConnection.closeResultSet(rs);
			}
			if(con != null) {
				DBConnection.closeConnection(con);
			}
		}
		return null;
	}
	public static List<CityModel> getCityList() throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
        try {
        	con = DBConnection.getConnection();
        	cst = con.prepareCall("{call PCK_GMS_HD_REGION_SCR.GMS_HD_REGION_GRID_SELECT (?,?,?,?,?,?)}");
        	cst.setString(1, null);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
	        cst.registerOutParameter(4, OracleTypes.CURSOR);
	        cst.registerOutParameter(5, OracleTypes.CURSOR);
	        cst.registerOutParameter(6, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(3);
			List<CityModel> list = new ArrayList<CityModel>();
			while (rs.next()) {
				CityModel city = new CityModel();
				city.setCITY_CODE(rs.getString("CITY_CODE"));
				city.setCITY_NAME(rs.getString("CITY_NAME"));
				city.setSTATE_NAME(rs.getString("STATE_NAME"));
				city.setZONE_NAME(rs.getString("ZONE_NAME"));
				list.add(city);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(RegionMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(cst !=null) {
				DBConnection.closeStatement(cst);
			}
			if(rs !=null) {
				DBConnection.closeResultSet(rs);
			}
			if(con != null) {
				DBConnection.closeConnection(con);
			}
		}
		return null;
	}
	public static boolean checkBranch(String id) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		int REGION_DET_ID=0;
        try {
        	con = DBConnection.getConnection();
        	cst = con.prepareCall("{call PCK_GMS_HD_REGION_SCR.GMS_HD_REGION_CHECK_BRANCH (?,?)}");
        	cst.setString(1, id);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(2);
			while (rs.next()) { 
				REGION_DET_ID=(rs.getInt("REGION_DET_ID"));
			}
         if(REGION_DET_ID>0) {
			return true;}
         else {
        	 return false;
         }
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(RegionMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(cst !=null) {
				DBConnection.closeStatement(cst);
			}
			if(rs !=null) {
				DBConnection.closeResultSet(rs);
			}
			if(con != null) {
				DBConnection.closeConnection(con);
			}
		}
		return false;
	}
	
	public static int updateRegion(List<DtRegionModel> list) throws SQLException {
		Connection con = null;
		CallableStatement cst = null;
	      int count = 0;
	      int insertCount = 0;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_DT_REGION.GMS_DT_REGION_UPDATE(?,?,?,?,?,?)}");
			  con.setAutoCommit(false);
				   for (DtRegionModel dtRegionModel : list) {
						cst.setInt(1, dtRegionModel.getREGION_DET_ID());
						cst.setInt(2, dtRegionModel.getREGION_ID());
				        cst.setString(3, dtRegionModel.getCITY_CODE());
				        cst.setString(4, dtRegionModel.getBRANCH_CODE());
				        cst.setString(5,(dtRegionModel.getIS_ACTIVE().equalsIgnoreCase("Yes")?"Y":"N"));
				        cst.setInt(6,1);
		           cst.addBatch();
		           count++;
		           if(count % 10000 == 0){
		        	   int[] result = cst.executeBatch();
		        	   insertCount += result.length;
		           }
	           }
	           int[] result = cst.executeBatch();
	           insertCount += result.length;
	           con.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(RegionMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(cst != null) {
				DBConnection.closeStatement(cst);
			}
			if(con != null) {
				DBConnection.closeConnection(con);
			}
		}
		return insertCount;
	}

}
