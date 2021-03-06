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
import com.gms.model.masters.GrievanceCategoryHierarchyModel;

import oracle.jdbc.OracleTypes;

public class GrievanceCategoryHierarchyDAO {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(GrievanceCategoryHierarchyDAO.class.getName());
	public static int insertGrievanceCategory(List<GrievanceCategoryHierarchyModel> list) throws SQLException {
		logger.info("Inside the insertGrievanceCategory() method");
		Connection con = null;
		CallableStatement cst = null;
	      int count = 0;
	      int insertCount = 0;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_CAT_HIER_FLOW.GMS_MA_CAT_HIER_FLOW_INSERT(?,?,?,?,?,?,?)}");
			  con.setAutoCommit(false);
			   for (GrievanceCategoryHierarchyModel grievanceCategory : list) {
		           cst.setString(1, grievanceCategory.getMAIN_CATEGORY_CODE());
		           cst.setString(2, grievanceCategory.getSUB_CATEGORY_CODE());
		           cst.setString(3, grievanceCategory.getSUB_CATEGORY_NAME());
		           cst.setInt(4, grievanceCategory.getHIERID());
		           cst.setInt(5, grievanceCategory.getCATEGORY_ORDER());
		           cst.setString(6,(grievanceCategory.getIS_ACTIVE().equalsIgnoreCase("Yes")?"Y":"N"));
		           cst.setInt(7,1);
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
			logger.info("Exception Inside the insertGrievanceCategory() method Exception "+ex.getMessage());
			Logger.getLogger(GrievanceCategoryHierarchyDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(cst != null) {
				DBConnection.closeStatement(cst);
			}
			if(con != null) {
				DBConnection.closeConnection(con);
			}
		}
		logger.info("Leaving the insertGrievanceCategory() method");
		return insertCount;
	}
	public static List<GrievanceCategoryHierarchyModel> getGrvCategory() throws SQLException{
		logger.info("Inside the getGrvCategory() method");
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_MA_CAT_HIER_FLOW_SCR.GMS_MA_CAT_HIER_FLOW_GRID_LIST(?)}");
			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(1);
			List<GrievanceCategoryHierarchyModel> list = new ArrayList<GrievanceCategoryHierarchyModel>();
			while (rs.next()) {
			    list.add(new GrievanceCategoryHierarchyModel(rs.getInt("FLOWID"),rs.getString("MAIN_CATEGORY_CODE"), rs.getString("MAIN_CATEGORY_NAME"), rs.getString("SUB_CATEGORY_CODE"), rs.getString("SUB_CATEGORY_NAME"),rs.getInt("HIERID"),rs.getString("HIERCODE"),rs.getInt("CATEGORY_ORDER"),rs.getString("IS_ACTIVE"),rs.getString("DATE_CREATED")));
			}
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				logger.info("Exception Inside the getGrvCategory() method Exception "+ex.getMessage());
				Logger.getLogger(GrievanceCategoryHierarchyDAO.class.getName()).log(Level.SEVERE, null, ex);
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
		logger.info("Leaving the getGrvCategory() method");
		return null;
	}
	public static GrievanceCategoryHierarchyModel getgrievanceCategory(int Id) throws SQLException{
		logger.info("Inside the getgrievanceCategory() method");
		Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    GrievanceCategoryHierarchyModel grievanceCategory = null;
	    
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_MA_CAT_HIER_FLOW_SCR.GMS_MA_CAT_HIERFW_GRID_SELECT(?,?,?,?,?)}");
	        cst.setInt(1, Id);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
	        cst.registerOutParameter(4, OracleTypes.CURSOR);
	        cst.registerOutParameter(5, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(5);
			if (rs.next()) {;
			grievanceCategory =(new GrievanceCategoryHierarchyModel( rs.getInt("FLOWID"), rs.getString("MAIN_CATEGORY_CODE"), rs.getString("MAIN_CATEGORY_NAME"),rs.getString("SUB_CATEGORY_CODE"),rs.getString("SUB_CATEGORY_NAME"),rs.getInt("HIERID"),rs.getString("HIERCODE"),rs.getString("HIERNAME"),rs.getInt("CATEGORY_ORDER"),rs.getString("IS_ACTIVE"),rs.getString("DATE_CREATED")));
			}
	        return grievanceCategory;
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        	 logger.info("Exception Inside the getgrievanceCategory() method Exception "+ex.getMessage());
	        	 Logger.getLogger(GrievanceCategoryHierarchyDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	    logger.info("Leaving the getgrievanceCategory() method");
		  return null;
	  }
	
	public static List<GrievanceCategoryHierarchyModel> getSubGrid(String id) throws SQLException{
		logger.info("Inside the getSubGrid() method");
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_CAT_HIER_FLOW_SCR.GMS_MA_CAT_HIERFW_SUB_GRID(?,?)}");
			cst.setString(1,id);
			cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(2);
			List<GrievanceCategoryHierarchyModel> list = new ArrayList<GrievanceCategoryHierarchyModel>();
			while (rs.next()) {
			    list.add(new GrievanceCategoryHierarchyModel(rs.getInt("FLOWID"),rs.getString("SUB_CATEGORY_CODE"),rs.getString("SUB_CATEGORY_NAME"),rs.getInt("HIERID"),rs.getString("HIERCODE"),rs.getString("HIERNAME"),rs.getInt("CATEGORY_ORDER"),rs.getString("IS_ACTIVE")));
			}
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				logger.info("Exception Inside the getSubGrid() method Exception "+ex.getMessage());
				Logger.getLogger(GrievanceCategoryHierarchyDAO.class.getName()).log(Level.SEVERE, null, ex);
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
		logger.info("Leaving the getSubGrid() method");
		return null;
	}
	public static int updategrievanceCategory(List<GrievanceCategoryHierarchyModel> list) throws SQLException {
		logger.info("Inside the updategrievanceCategory() method");
		Connection con = null;
		CallableStatement cst = null;
	      int count = 0;
	      int insertCount = 0;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_CAT_HIER_FLOW.GMS_MA_CAT_HIER_FLOW_UPDATE(?,?,?,?,?,?,?,?)}");
			  con.setAutoCommit(false);
				   for (GrievanceCategoryHierarchyModel grievanceCategory : list) {
						cst.setInt(1, grievanceCategory.getFLOWID());
						cst.setString(2, grievanceCategory.getMAIN_CATEGORY_CODE());
				        cst.setString(3, grievanceCategory.getSUB_CATEGORY_CODE());
				        cst.setString(4, grievanceCategory.getSUB_CATEGORY_NAME());
				        cst.setInt(5, grievanceCategory.getHIERID());
				        cst.setInt(6, grievanceCategory.getCATEGORY_ORDER());
				        cst.setString(7,(grievanceCategory.getIS_ACTIVE().equalsIgnoreCase("Yes")?"Y":"N"));
				        cst.setInt(8,1);
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
			logger.info("Exception Inside the updategrievanceCategory() method Exception "+ex.getMessage());
			Logger.getLogger(GrievanceCategoryHierarchyDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if(cst != null) {
				DBConnection.closeStatement(cst);
			}
			if(con != null) {
				DBConnection.closeConnection(con);
			}
		}
		logger.info("Leaving the updategrievanceCategory() method");
		return insertCount;
	}
	
}
	
