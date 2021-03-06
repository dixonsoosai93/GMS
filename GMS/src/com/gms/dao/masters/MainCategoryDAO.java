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
import com.gms.model.masters.CaseStatusMasterModel;
import com.gms.model.masters.MainCategoryModel;

import oracle.jdbc.OracleTypes;

public class MainCategoryDAO {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MainCategoryDAO.class.getName());
	public static boolean insertMainCategory(MainCategoryModel maincategory) throws SQLException {
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_CATEGORY.GMS_MA_CATEGORY_INSERT(?,?,?,?)}");
			cst.setString(1, maincategory.getMAIN_CATEGORY_CODE());
			cst.setString(2, maincategory.getMAIN_CATEGORY_NAME());
			cst.setString(3, maincategory.getIS_ACTIVE());
			cst.setInt(4, 1);
			cst.execute();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(MainCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static List<MainCategoryModel> getMainCategory() throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_MA_CATEGORY_SCR.GMS_MA_CATEGORY_GRID_LIST(?)}");
			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(1);
			List<MainCategoryModel> list = new ArrayList<MainCategoryModel>();
			while (rs.next()) {
			    list.add(new MainCategoryModel( rs.getString("MAIN_CATEGORY_CODE"), rs.getString("MAIN_CATEGORY_NAME"), rs.getString("IS_ACTIVE"),rs.getString("DATE_CREATED")));
			}
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(MainCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static boolean updateMainCategory(MainCategoryModel maincategory) throws SQLException {
        Connection con = null;
        CallableStatement cst = null;
        
        try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_CATEGORY.GMS_MA_CATEGORY_UPDATE(?,?,?,?)}");
			cst.setString(1, maincategory.getMAIN_CATEGORY_CODE());
			cst.setString(2, maincategory.getMAIN_CATEGORY_NAME());
			cst.setString(3, maincategory.getIS_ACTIVE());
			cst.setInt(4, 1);
			return cst.executeUpdate() > 0; 
		} catch (SQLException ex) {
				ex.printStackTrace();
				Logger.getLogger(MainCategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
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
