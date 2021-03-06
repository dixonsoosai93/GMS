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
import com.gms.model.masters.CityModel;
import com.gms.model.masters.GrievanceHandlingTatModel;
import com.gms.model.masters.ManpowerModel;
import com.gms.model.masters.OrganisationHierarchyMasterModel;
import oracle.jdbc.OracleTypes;
public class OrganisationHierarchyMasterDAO {
	
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(OrganisationHierarchyMasterDAO.class.getName());
	public static boolean insertOrgHierarchy(OrganisationHierarchyMasterModel organisationHierarchyMasterModel) throws SQLException {
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_ORG_HIERARCHY.GMS_MA_ORG_HIERARCHY_INSERT(?,?,?,?,?,?,?,?,?)}");
			cst.setString(1, organisationHierarchyMasterModel.getHIERCODE());
			cst.setString(2, organisationHierarchyMasterModel.getCLIENTCAPTION());
			cst.setString(3, organisationHierarchyMasterModel.getHIERNAME());
			cst.setString(4, organisationHierarchyMasterModel.getHIERDESIGNATIONID());
			cst.setInt(5,organisationHierarchyMasterModel.getHIERORDER());
			cst.setInt(6,organisationHierarchyMasterModel.getHIERCAP());
			cst.setString(7,organisationHierarchyMasterModel.getINVESTIGATOR_NEEDED());
			cst.setString(8,organisationHierarchyMasterModel.getIS_ACTIVE());
			cst.setInt(9,1);
			cst.execute();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(OrganisationHierarchyMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static List<OrganisationHierarchyMasterModel> getOrgHierarchy() throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_MA_ORG_HIER_SCR.GMS_MA_ORG_HIER_GRID_LIST(?)}");
			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(1);
			List<OrganisationHierarchyMasterModel> list = new ArrayList<OrganisationHierarchyMasterModel>();
			while (rs.next()) {
			    list.add(new OrganisationHierarchyMasterModel( rs.getInt("HIERID"), rs.getString("HIERCODE"), rs.getString("CLIENTCAPTION"),rs.getString("HIERNAME"),rs.getString("HIERDESIGNATIONID"),rs.getInt("HIERORDER"),rs.getInt("HIERCAP"),rs.getString("INVESTIGATOR_NEEDED"),rs.getString("IS_ACTIVE"),rs.getString("DATE_CREATED"),rs.getString("DESIGNATION")));
			}
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(OrganisationHierarchyMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static OrganisationHierarchyMasterModel getOrganisationHierarchy(int Id) throws SQLException{
	    Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    OrganisationHierarchyMasterModel organisationHierarchyMasterModel = null;
	    
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_MA_ORG_HIER_SCR.GMS_MA_ORG_HIER_GRID_SELECT(?,?,?)}");
	        cst.setInt(1, Id);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(2);
			if (rs.next()) {
			organisationHierarchyMasterModel =(new OrganisationHierarchyMasterModel( rs.getInt("HIERID"), rs.getString("HIERCODE"), rs.getString("CLIENTCAPTION"),rs.getString("HIERNAME"),rs.getString("HIERDESIGNATIONID"),rs.getInt("HIERORDER"),rs.getInt("HIERCAP"),rs.getString("INVESTIGATOR_NEEDED"),rs.getString("IS_ACTIVE"),rs.getString("DATE_CREATED")));
			}
	        return organisationHierarchyMasterModel;
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        	 Logger.getLogger(OrganisationHierarchyMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static boolean updateOrgHierarchy(OrganisationHierarchyMasterModel organisationHierarchyMasterModel) throws SQLException {
        Connection con = null;
        CallableStatement cst = null;
        
        try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{call PCK_GMS_MA_ORG_HIERARCHY.GMS_MA_ORG_HIERARCHY_UPDATE(?,?,?,?,?,?,?,?,?,?)}");
			cst.setInt(1, organisationHierarchyMasterModel.getHIERID());
			cst.setString(2, organisationHierarchyMasterModel.getHIERCODE());
			cst.setString(3, organisationHierarchyMasterModel.getCLIENTCAPTION());
			cst.setString(4, organisationHierarchyMasterModel.getHIERNAME());
			cst.setString(5, organisationHierarchyMasterModel.getHIERDESIGNATIONID());
			cst.setInt(6,organisationHierarchyMasterModel.getHIERORDER());
			cst.setInt(7,organisationHierarchyMasterModel.getHIERCAP());
			cst.setString(8,organisationHierarchyMasterModel.getINVESTIGATOR_NEEDED());
			cst.setString(9,organisationHierarchyMasterModel.getIS_ACTIVE());
			cst.setInt(10,1);
			return cst.executeUpdate() > 0; 
		} catch (SQLException ex) {
				ex.printStackTrace();
				Logger.getLogger(OrganisationHierarchyMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static List<ManpowerModel> getOrganisationDesignation() throws SQLException{
	    Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_MA_ORG_HIER_SCR.GMS_MA_ORG_HIER_GRID_SELECT(?,?,?)}");
	        cst.setString(1, null);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(3);
            List<ManpowerModel> list = new ArrayList<ManpowerModel>();
			while (rs.next()) {
				ManpowerModel Manpower =new ManpowerModel();
				Manpower.setDESIGNATION_CODE(rs.getString("DESIGNATION_CODE"));
				Manpower.setDESIGNATION(rs.getString("DESIGNATION"));
				list.add(Manpower);
			}
	        return list;
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        	 Logger.getLogger(OrganisationHierarchyMasterDAO.class.getName()).log(Level.SEVERE, null, ex);
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
