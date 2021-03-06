package com.gms.dao.dashboard;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import com.gms.commons.DBConnection;
import oracle.jdbc.OracleTypes;

public class Graph {
	static Logger logger = Logger.getLogger(Graph.class.getName());
	
	public static JSONArray getStatus(int days) throws SQLException {
		logger.info("Inside getStatus() method ");
		Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs=null;
	    try {
	    	logger.info("Inside try block getStatus() method ");
	    	con = DBConnection.getConnection();
	    	cst=con.prepareCall("{call PCK_GMS_GRAPH.GMS_STATUS_GRAPH(?,?)}");
            cst.setInt(1, days);
	    	cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet) cst.getObject(2);
    	    JSONArray series = new JSONArray();
            while (rs.next()) {
            	JSONObject jsonObject = new JSONObject();
	            jsonObject.put("name", rs.getString("statusname"));
	            jsonObject.put("y", rs.getInt("STATUS_COUNT"));
	            series.put(jsonObject);
            }
            logger.info("Leaving try block getStatus() method ");
            return series;
	    } catch (SQLException ex) {
	    	ex.printStackTrace();
	    	logger.info("Exception Inside getStatus() method Exception "+ex.getMessage());
	    } finally {
           if (con != null) {
               DBConnection.closeConnection(con);
           }
           if (cst != null) {
               DBConnection.closeStatement(cst);
           }
           if (rs != null) {
               DBConnection.closeResultSet(rs);
           }
        }
	    logger.info("Leaving getStatus() method");
		return null;
	}
	
	public static JSONArray getZone(int days) throws SQLException {
		logger.info("Inside getZone() method ");
		Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs=null;
	    try {
	    	logger.info("Inside try block getZone() method ");
	    	con = DBConnection.getConnection();
	    	cst=con.prepareCall("{call PCK_GMS_GRAPH.GMS_ZONE_GRAPH(?,?)}");
            cst.setInt(1, days);
	    	cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet) cst.getObject(2);
    	    JSONArray series = new JSONArray();
            while (rs.next()) {
            	JSONObject jsonObject = new JSONObject();
	            jsonObject.put("name", rs.getString("ZONE_NAME"));
	            jsonObject.put("y", rs.getInt("ZONE_COUNT"));
	            series.put(jsonObject);
            }
            logger.info("Leaving try block getZone() method ");
            return series;
	    } catch (SQLException ex) {
	    	ex.printStackTrace();
	    	logger.info("Exception Inside getZone() method Exception "+ex.getMessage());
	    } finally {
           if (con != null) {
               DBConnection.closeConnection(con);
           }
           if (cst != null) {
               DBConnection.closeStatement(cst);
           }
           if (rs != null) {
               DBConnection.closeResultSet(rs);
           }
        }
	    logger.info("Leaving getZone() method ");
		return null;
	}

	public static JSONArray getGrievanceGraph(int days) throws SQLException {
		logger.info("Inside getGrievanceGraph() method ");
		Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs=null;
	    try {
	    	logger.info("Inside try block getGrievanceGraph() method ");
	    	con = DBConnection.getConnection();
	    	cst=con.prepareCall("{call PCK_GMS_GRAPH.GMS_GRIEVANCE_GRAPH(?,?)}");
            cst.setInt(1, days);
	    	cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet) cst.getObject(2);
    	    JSONArray series = new JSONArray();
            while (rs.next()) {
            	JSONObject jsonObject = new JSONObject();
	            jsonObject.put("name", rs.getString("Qtr"));
	            jsonObject.put("y", rs.getInt("count"));
	            series.put(jsonObject);
            }
            logger.info("Leaving try block getGrievanceGraph() method ");
            return series;
	    } catch (SQLException ex) {
	    	ex.printStackTrace();
	    	logger.info("Exception Inside getGrievanceGraph() method Exception "+ex.getMessage());
	    } finally {
           if (con != null) {
               DBConnection.closeConnection(con);
           }
           if (cst != null) {
               DBConnection.closeStatement(cst);
           }
           if (rs != null) {
               DBConnection.closeResultSet(rs);
           }
        }
	    logger.info("Leaving getGrievanceGraph() method ");
		return null;
	}
	
	public static JSONArray getHierCode(int days) throws SQLException {
		logger.info("Inside getHierCode() method ");
		Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs=null;
	    try {
	    	logger.info("Inside try block getHierCode() method ");
	    	con = DBConnection.getConnection();
	    	cst=con.prepareCall("{call PCK_GMS_GRAPH.GMS_HIERCODE_GRAPH(?,?)}");
            cst.setInt(1, days);
	    	cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet) cst.getObject(2);
    	    JSONArray series = new JSONArray();
            while (rs.next()) {
            	JSONObject jsonObject = new JSONObject();
	            jsonObject.put("name", rs.getString("hiercode"));
	            jsonObject.put("y", rs.getInt("HIERCODE_COUNT"));
	            series.put(jsonObject);
            }
            //series.put( "isIntermediateSum": true,
	        //    "color: Highcharts.getOptions().colors[1]");
            logger.info("Leaving try block getHierCode() method ");
            return series;
	    } catch (SQLException ex) {
	    	ex.printStackTrace();
	    	logger.info("Exception Inside getHierCode() method Exception "+ex.getMessage());
	    } finally {
           if (con != null) {
               DBConnection.closeConnection(con);
           }
           if (cst != null) {
               DBConnection.closeStatement(cst);
           }
           if (rs != null) {
               DBConnection.closeResultSet(rs);
           }
        }
	    logger.info("Leaving getHierCode() method ");
		return null;
	}
	
	public static JSONArray getSubCategory(int days) throws Exception {
		logger.info("Inside getSubCategory() method ");
		Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs=null;
	    try {
	    	logger.info("Inside try block getSubCategory() method ");
	    	con = DBConnection.getConnection();
	    	cst=con.prepareCall("{call PCK_GMS_GRAPH.GMS_SUBCATEGORY_GRAPH(?,?)}");
            cst.setInt(1, days);
	    	cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet) cst.getObject(2);
    	    JSONArray series = new JSONArray();
            while (rs.next()) {
            	JSONObject jsonObject = new JSONObject();
            	jsonObject.put("name", rs.getString("sub_category_code"));
            	jsonObject.put("y", rs.getInt("sub_category_code_COUNT"));
	            series.put(jsonObject);
            }
            logger.info("Leaving try block getSubCategory() method ");
            return series;
	    } catch (SQLException ex) {
	    	ex.printStackTrace();
	    	logger.info("Exception Inside getSubCategory() method Exception "+ex.getMessage());
	    } finally {
           if (con != null) {
               DBConnection.closeConnection(con);
           }
           if (cst != null) {
               DBConnection.closeStatement(cst);
           }
           if (rs != null) {
               DBConnection.closeResultSet(rs);
           }
        }
	    logger.info("Leaving getSubCategory() method ");
		return null;
	}
	
	public static JSONArray getDepartment(int days) throws SQLException {
		logger.info("Inside getDepartment() method ");
		Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs=null;
	    try {
	    	logger.info("Inside try block getDepartment() method ");
	    	con = DBConnection.getConnection();
	    	cst=con.prepareCall("{call PCK_GMS_GRAPH.GMS_DEPARTMENT_GRAPH(?,?)}");
            cst.setInt(1, days);
	    	cst.registerOutParameter(2, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet) cst.getObject(2);
    	    JSONArray series = new JSONArray();
            while (rs.next()) {
            	JSONObject jsonObject = new JSONObject();
	            jsonObject.put("name", rs.getString("department"));
	            jsonObject.put("y", rs.getInt("DEPARTMENT_COUNT"));
	            series.put(jsonObject);
            }
            logger.info("Leaving try block getDepartment() method ");
            return series;
	    } catch (SQLException ex) {
	    	ex.printStackTrace();
	    	logger.info("Exception Inside getDepartment() method Exception "+ex.getMessage());
	    } finally {
           if (con != null) {
               DBConnection.closeConnection(con);
           }
           if (cst != null) {
               DBConnection.closeStatement(cst);
           }
           if (rs != null) {
               DBConnection.closeResultSet(rs);
           }
        }
	    logger.info("Leaving getDepartment() method ");
		return null;
	}
}
