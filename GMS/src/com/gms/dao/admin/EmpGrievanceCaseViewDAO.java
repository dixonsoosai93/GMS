package com.gms.dao.admin;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gms.commons.DBConnection;
import com.gms.model.admin.EmployeeGrievanceCaseView;
import com.gms.model.admin.GridCase;
import com.gms.model.grievance.DtGrievanceModel;
import com.gms.model.investigator.DtDailyDairy;
import com.gms.model.investigator.DtVerdict;
import com.gms.model.masters.BranchModel;
import com.gms.model.masters.HdRegionModel;
import com.gms.model.masters.ZoneModel;

import oracle.jdbc.OracleTypes;

public class EmpGrievanceCaseViewDAO {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(EmpGrievanceCaseViewDAO.class.getName());
	
	public static List<ZoneModel> getZone() throws SQLException{
	    Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    List<ZoneModel> list = new ArrayList<ZoneModel>();
	    
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_ADM_EMP_GRV_SCR.GMS_ADM_EMP_DDL(?,?,?)}");
	        cst.registerOutParameter(1, OracleTypes.CURSOR);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(3);
            while (rs.next()) {
				list.add(new ZoneModel(rs.getString("ZONE_CODE"),rs.getString("ZONE_NAME")));
			}                                         
	        return list;
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        	 Logger.getLogger(EmpGrievanceCaseViewDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static List<BranchModel> getBranch() throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
        try {
        	con = DBConnection.getConnection();
        	cst = con.prepareCall("{call PCK_GMS_ADM_EMP_GRV_SCR.GMS_ADM_EMP_DDL(?,?,?)}");
	        cst.registerOutParameter(1, OracleTypes.CURSOR);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(1);
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
			Logger.getLogger(EmpGrievanceCaseViewDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static List<HdRegionModel> getRegion() throws SQLException{
	    Connection con = null;
	    CallableStatement cst = null;
	    ResultSet rs = null;
	    List<HdRegionModel> list = new ArrayList<HdRegionModel>();
	    
	    try {
	        con = DBConnection.getConnection();
	        cst = con.prepareCall("{call PCK_GMS_ADM_EMP_GRV_SCR.GMS_ADM_EMP_DDL(?,?,?)}");
	        cst.registerOutParameter(1, OracleTypes.CURSOR);
	        cst.registerOutParameter(2, OracleTypes.CURSOR);
	        cst.registerOutParameter(3, OracleTypes.CURSOR);
            cst.execute();
            rs=(ResultSet)cst.getObject(2);
            while (rs.next()) {
            	HdRegionModel HdRegion = new HdRegionModel();
				HdRegion.setREGION_CODE(rs.getString("REGION_ID"));
				HdRegion.setREGION_NAME(rs.getString("REGION_NAME"));
				list.add(HdRegion);  	
			}                                         
	        return list;
	        } catch (SQLException ex) {
	        	 ex.printStackTrace();
	        	 Logger.getLogger(EmpGrievanceCaseViewDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static List<EmployeeGrievanceCaseView> getInvList(EmployeeGrievanceCaseView employeeGrievanceCaseView) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		List<EmployeeGrievanceCaseView> list = new ArrayList<EmployeeGrievanceCaseView>();
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_ADM_EMP_GRV_SCR.GMS_ADM_EMP_GRV_INV_LIST(?,?,?,?,?,?,?)}");
			cst.setString(1, employeeGrievanceCaseView.getEMP_TYPE());
			cst.setString(2, employeeGrievanceCaseView.getSTATUSID());
			cst.setString(3, employeeGrievanceCaseView.getBRANCH_CODE());
			cst.setInt(4, employeeGrievanceCaseView.getREGION_ID());
			cst.setString(5, employeeGrievanceCaseView.getZONE_CODE());
			cst.setString(6, employeeGrievanceCaseView.getEmployeeID());
			cst.registerOutParameter(7, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(7);
            while (rs.next()) {
            	EmployeeGrievanceCaseView employeeGrievance =new  EmployeeGrievanceCaseView();
			    employeeGrievance.setINVESTIGATOR_ID(rs.getInt("INVESTIGATOR_ID"));
			    employeeGrievance.setINVESTIGATOR_EMPLOYEE_ID(rs.getInt("INVESTIGATOR_EMPLOYEE_ID"));
			    employeeGrievance.setINVESTIGATOR_EMPLOYEE_NAME(rs.getString("INVESTIGATOR_EMPLOYEE_NAME"));
			    employeeGrievance.setHIERCODE(rs.getString("HIERCODE"));
			    employeeGrievance.setDEPARTMENT(rs.getString("DEPARTMENT"));
			    employeeGrievance.setREGION_NAME(rs.getString("REGION_NAME"));
			    employeeGrievance.setZONE_NAME(rs.getString("ZONE_NAME"));
			    employeeGrievance.setIS_ACTIVE(rs.getString("IS_ACTIVE"));
			    list.add(employeeGrievance);
			}
            System.out.println(list.toString());
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(EmpGrievanceCaseViewDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	 * public static List<EmployeeGrievanceCaseView> getCompList(String EMP_TYPE, String statusId, String branchCode, int regionId, String zoneCode ,String employeeId) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_ADM_EMP_GRV_SCR.GMS_ADM_EMP_GRV_ACTIVE_LIST(?,?,?,?,?,?,?)}");
			cst.setString(1, EMP_TYPE);
			cst.setString(2, statusId);
			cst.setString(3, branchCode);
			cst.setInt(4, regionId);
			cst.setString(5, zoneCode);
			cst.setString(6, employeeId);
			System.out.println(" EmployeeType :"+EMP_TYPE+ " StatusId :"+statusId);
			cst.registerOutParameter(7, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(7);
            List<EmployeeGrievanceCaseView> list = new ArrayList<EmployeeGrievanceCaseView>();
            while (rs.next()) {
			   // list.add(new EmployeeGrievanceCaseView(rs.getInt("GRVID"),rs.getDate("GRVDATE"),rs.getString("GRVNUMBER"),rs.getInt("COMPLIANT_EMPLOYEE_ID"),rs.getString("NAME"),rs.getString("EMPLOYEE_TYPE"),rs.getString("GROUP_COMPLIANT"),rs.getString("IS_ACTIVE")));
			    EmployeeGrievanceCaseView employeeGrievance =new  EmployeeGrievanceCaseView();
			    employeeGrievance.setGRVID(rs.getInt("GRVID"));
			    employeeGrievance.setGrvDate(rs.getDate("GRVDATE")); 
			    employeeGrievance.setGRVNUMBER(rs.getString("GRVNUMBER"));
			    employeeGrievance.setCOMPLIANT_EMPLOYEE_ID(rs.getInt("COMPLIANT_EMPLOYEE_ID"));
			    employeeGrievance.setNAME(rs.getString("NAME"));
			    employeeGrievance.setEMP_TYPE(rs.getString("EMPLOYEE_TYPE"));
			    employeeGrievance.setGROUP_COMPLIANT(rs.getString("GROUP_COMPLIANT"));
			    employeeGrievance.setIS_ACTIVE(rs.getString("IS_ACTIVE"));
			    list.add(employeeGrievance);
            }
            System.out.println("list when employee-wise"+list);
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(EmpGrievanceCaseViewDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	} */
	
	public static List<EmployeeGrievanceCaseView> getCompList(EmployeeGrievanceCaseView gmployeeGrievanceCaseView) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_ADM_EMP_GRV_SCR.GMS_ADM_EMP_GRV_ACTIVE_LIST(?,?,?,?,?,?,?)}");
			cst.setString(1, gmployeeGrievanceCaseView.getEMP_TYPE());
			cst.setString(2, gmployeeGrievanceCaseView.getSTATUSID());
			cst.setString(3, gmployeeGrievanceCaseView.getBRANCH_CODE());
			cst.setInt(4, gmployeeGrievanceCaseView.getREGION_ID());
			cst.setString(5, gmployeeGrievanceCaseView.getZONE_CODE());
			cst.setString(6, gmployeeGrievanceCaseView.getEmployeeID());
			System.out.println(" EmployeeType :"+gmployeeGrievanceCaseView.getEMP_TYPE()+ " StatusId :"+gmployeeGrievanceCaseView.getSTATUSID());
			cst.registerOutParameter(7, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(7);
            List<EmployeeGrievanceCaseView> list = new ArrayList<EmployeeGrievanceCaseView>();
            while (rs.next()) {
			   // list.add(new EmployeeGrievanceCaseView(rs.getInt("GRVID"),rs.getDate("GRVDATE"),rs.getString("GRVNUMBER"),rs.getInt("COMPLIANT_EMPLOYEE_ID"),rs.getString("NAME"),rs.getString("EMPLOYEE_TYPE"),rs.getString("GROUP_COMPLIANT"),rs.getString("IS_ACTIVE")));
			    EmployeeGrievanceCaseView employeeGrievance =new  EmployeeGrievanceCaseView();
			    employeeGrievance.setGRVID(rs.getInt("GRVID"));
			    employeeGrievance.setGrvDate(rs.getDate("GRVDATE")); 
			    employeeGrievance.setGRVNUMBER(rs.getString("GRVNUMBER"));
			    employeeGrievance.setCOMPLIANT_EMPLOYEE_ID(rs.getInt("COMPLIANT_EMPLOYEE_ID"));
			    employeeGrievance.setNAME(rs.getString("NAME"));
			    employeeGrievance.setEMP_TYPE(rs.getString("EMPLOYEE_TYPE"));
			    employeeGrievance.setGROUP_COMPLIANT(rs.getString("GROUP_COMPLIANT"));
			    employeeGrievance.setIS_ACTIVE(rs.getString("IS_ACTIVE"));
			    list.add(employeeGrievance);
            }
            System.out.println("list when employee-wise"+list);
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(EmpGrievanceCaseViewDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static List<EmployeeGrievanceCaseView> getCompList(EmployeeGrievanceCaseView gmployeeGrievanceCaseView) throws SQLException{
		Connection con = null;
		PreparedStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			String sql = "SELECT H.GRVID, H.GRVDATE,H.GRVNUMBER,H.COMPLIANT_EMPLOYEE_ID,M.NAME, CASE WHEN H.COMPLIANT_EMPLOYEE_ID IS NOT NULL THEN 'ACTIVE-EMP' ELSE 'EX-EMPLOYEE' END EMPLOYEE_TYPE,H.GROUP_COMPLIANT,H.IS_ACTIVE FROM GMS_HD_GRIEVANCE H LEFT JOIN VW_HRC_MANPOWER M ON H.COMPLIANT_EMPLOYEE_ID=M.EMPLOYEE_ID WHERE H.IS_ACTIVE='Y' AND H.COMPLIANT_EMPLOYEE_ID IS NOT NULL ORDER BY H.DATE_CREATED DESC";
			cst = con.prepareStatement(sql);
			rs = cst.executeQuery();
            List<EmployeeGrievanceCaseView> list = new ArrayList<EmployeeGrievanceCaseView>();
            while (rs.next()) {
			   // list.add(new EmployeeGrievanceCaseView(rs.getInt("GRVID"),rs.getDate("GRVDATE"),rs.getString("GRVNUMBER"),rs.getInt("COMPLIANT_EMPLOYEE_ID"),rs.getString("NAME"),rs.getString("EMPLOYEE_TYPE"),rs.getString("GROUP_COMPLIANT"),rs.getString("IS_ACTIVE")));
			    EmployeeGrievanceCaseView employeeGrievance =new  EmployeeGrievanceCaseView();
			    employeeGrievance.setGRVID(rs.getInt("GRVID"));
			    employeeGrievance.setGrvDate(rs.getDate("GRVDATE")); 
			    employeeGrievance.setGRVNUMBER(rs.getString("GRVNUMBER"));
			    employeeGrievance.setCOMPLIANT_EMPLOYEE_ID(rs.getInt("COMPLIANT_EMPLOYEE_ID"));
			    employeeGrievance.setNAME(rs.getString("NAME"));
			    employeeGrievance.setEMP_TYPE(rs.getString("EMPLOYEE_TYPE"));
			    employeeGrievance.setGROUP_COMPLIANT(rs.getString("GROUP_COMPLIANT"));
			    employeeGrievance.setIS_ACTIVE(rs.getString("IS_ACTIVE"));
			    list.add(employeeGrievance);
            }
            System.out.println("list when employee-wise"+list);
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(EmpGrievanceCaseViewDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	/*
	public static List<EmployeeGrievanceCaseView> getCompList(EmployeeGrievanceCaseView gmployeeGrievanceCaseView) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_ADM_EMP_GRV_SCR.GMS_ADM_EMP_GRV_COMP_LIST(?,?,?,?,?,?,?)}");
			cst.setString(1, gmployeeGrievanceCaseView.getEMP_TYPE());
			cst.setString(2, gmployeeGrievanceCaseView.getSTATUSID());
			cst.setString(3, gmployeeGrievanceCaseView.getBRANCH_CODE());
			cst.setInt(4,gmployeeGrievanceCaseView.getREGION_ID());
			cst.setString(5, gmployeeGrievanceCaseView.getZONE_CODE());
			cst.setString(6, gmployeeGrievanceCaseView.getEmployeeID());
			cst.registerOutParameter(7, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(7);
            List<EmployeeGrievanceCaseView> list = new ArrayList<EmployeeGrievanceCaseView>();
            while (rs.next()) {
			    list.add(new EmployeeGrievanceCaseView(rs.getInt("GRVID"),rs.getDate("GRVDATE"),rs.getString("GRVNUMBER"),rs.getInt("COMPLIANT_EMPLOYEE_ID"),rs.getString("NAME"),rs.getString("EMPLOYEE_TYPE"),rs.getString("GROUP_COMPLIANT"),rs.getString("IS_ACTIVE")));
			}
            System.out.println("list when employee-wise"+list);
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(EmpGrievanceCaseViewDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static List<DtGrievanceModel> getGrvCaseList(String INVESTIGATOR_EMPLOYEE_ID,int GRVID) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			if(GRVID==0) {
			  cst = con.prepareCall("{ call PCK_GMS_ADM_EMP_GRV_SCR.GMS_ADM_EMP_GRV_INV_CASE_LIST(?,?)}");
			  cst.setString(1,INVESTIGATOR_EMPLOYEE_ID);
			}else {
			  cst = con.prepareCall("{ call PCK_GMS_ADM_EMP_GRV_SCR.GMS_ADM_EMP_GRV_GRV_CASE_LIST(?,?)}");
			  cst.setInt(1,GRVID);
			}
			cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(2);
            List<DtGrievanceModel> list = new ArrayList<DtGrievanceModel>();
            while (rs.next()) {
            	DtGrievanceModel dtGrievanceModel = new DtGrievanceModel();
            	dtGrievanceModel.setGRVID(rs.getInt("GRVID"));
            	dtGrievanceModel.setGRVDETID(rs.getInt("GRVDETID"));
            	dtGrievanceModel.setCASENUMBER(rs.getString("CASENUMBER"));
            	dtGrievanceModel.setMAIN_CATEGORY_CODE(rs.getString("MAIN_CATEGORY_CODE"));
            	dtGrievanceModel.setSUB_CATEGORY_CODE(rs.getString("SUB_CATEGORY_CODE"));
            	dtGrievanceModel.setEMPLOYEETYPE(rs.getString("EMPLOYEE_TYPE"));
            	dtGrievanceModel.setRESPONDENT_EMPLOYEE_ID(rs.getInt("RESPONDENT_EMPLOYEE_ID"));
            	dtGrievanceModel.setRESPONDENT_EMPLOYEE_NAME(rs.getString("RESPONDENT_EMPLOYEE_NAME"));
            	dtGrievanceModel.setCOMPLAINT_DESC(rs.getString("COMPLAINT_DESC"));
            	dtGrievanceModel.setDEFAULT_HIERCODE(rs.getString("DEFAULT_HIERCODE"));
            	dtGrievanceModel.setSTART_HIERCODE(rs.getString("START_HIERCODE"));
            	dtGrievanceModel.setSTATUSNAME(rs.getString("STATUSNAME"));
			    list.add(dtGrievanceModel);
			}
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(EmpGrievanceCaseViewDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static List<DtVerdict> getFinalVerdict(String GRVDETID) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		List<DtVerdict> list = new ArrayList<DtVerdict>();
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_ADM_EMP_GRV_SCR.GMS_ADM_EMP_GRV_EMP_FINAL_VER(?,?)}");
			cst.setString(1, GRVDETID);
			cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(2);
            while (rs.next()) {
            	DtVerdict dtVerdict =new  DtVerdict();
            	dtVerdict.setGRVDETID(rs.getInt("GRVDETID"));
            	dtVerdict.setCASENUMBER(rs.getString("CASENUMBER"));
            	dtVerdict.setVERDICTID(rs.getInt("VERDICTID"));
            	dtVerdict.setVERDICT_REPORT_DATE(rs.getString("HIERCODE"));
            	dtVerdict.setVERDICT_REPORT_CONTENT(rs.getString("DEPARTMENT"));
			    list.add(dtVerdict);
			}
            
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(EmpGrievanceCaseViewDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	public static List<GridCase> getHierarchyWiseDetail(String GRVDETID) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		List<GridCase> list = new ArrayList<GridCase>();
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_ADM_EMP_GRV_SCR.GMS_ADM_EMP_GRV_EMP_HIER_CASE(?,?)}");
			cst.setString(1, GRVDETID);
			cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(2);
            while (rs.next()) {
            	GridCase gridCase =new  GridCase();
            	gridCase.setCASEID(rs.getInt("CASEID"));
            	gridCase.setGRVDETID(rs.getInt("GRVDETID"));
            	gridCase.setCASENUMBER(rs.getString("CASENUMBER"));
            	gridCase.setMAIN_CATEGORY_CODE(rs.getString("MAIN_CATEGORY_CODE"));
            	gridCase.setSUB_CATEGORY_CODE(rs.getString("SUB_CATEGORY_CODE"));
            	gridCase.setHIERCODE(rs.getString("HIERCODE"));
            	gridCase.setHIERORDER(rs.getInt("HIERORDER"));
            	gridCase.setTAT_START_DATE(rs.getString("TAT_START_DATE"));
            	gridCase.setTAT_ACTUAL_END_DATE(rs.getString("TAT_ACTUAL_END_DATE"));
            	gridCase.setTAT_EXTENDED(rs.getString("TAT_EXTENDED"));
            	gridCase.setTAT_EXTENDED_EMPLOYEE_ID(rs.getInt("TAT_EXTENDED_EMPLOYEE_ID"));
            	gridCase.setTAT_END_DATE(rs.getString("TAT_END_DATE"));
            	gridCase.setINVESTIGATOR_NEEDED(rs.getString("INVESTIGATOR_NEEDED"));
            	gridCase.setDECISION_ARRIVED(rs.getString("DECISION_ARRIVED"));
            	gridCase.setREASON_NO_DECISION(rs.getString("REASON_NO_DECISION"));
            	gridCase.setINVESTIGATOR_ASSIGNED(rs.getString("INVESTIGATOR_ASSIGNED"));
            	gridCase.setDECISION_REPORT(rs.getString("DECISION_REPORT"));
            	gridCase.setDECISION_SIGNATURE(rs.getString("DECISION_SIGNATURE"));
            	gridCase.setEMP_ACCEPT_DECISION(rs.getString("EMP_ACCEPT_DECISION"));
            	gridCase.setEMP_NOT_ACCEPT_REASON(rs.getString("EMP_NOT_ACCEPT_REASON"));
            	gridCase.setCURRENT_ROW_ACTIVE(rs.getString("CURRENT_ROW_ACTIVE"));
            	gridCase.setCURRENT_ROW_COMPLETED(rs.getString("CURRENT_ROW_COMPLETED"));
            	gridCase.setIS_ACTIVE(rs.getString("IS_ACTIVE"));
            	gridCase.setDECISION_REPORT_DATE(rs.getString("DECISION_REPORT_DATE"));
            	gridCase.setDECISION_REPORT_CONTENT(rs.getString("DECISION_REPORT_CONTENT"));
			    list.add(gridCase);
			}
            
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(EmpGrievanceCaseViewDAO.class.getName()).log(Level.SEVERE, null, ex);
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
	
	public static List<DtDailyDairy> getDailyDairy(int CASEID) throws SQLException{
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			cst = con.prepareCall("{ call PCK_GMS_ADM_EMP_GRV_SCR.GMS_ADM_EMP_GRV_DAILY_DAIRY(?,?)}");
			cst.setInt(1, CASEID);
			cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.execute();
            rs=(ResultSet)cst.getObject(2);
            List<DtDailyDairy> list = new ArrayList<DtDailyDairy>();
            while (rs.next()) {
			    list.add(new DtDailyDairy(rs.getInt("CASEID"),rs.getInt("INVESTIGATOR_EMPLOYEE_ID"),rs.getString("NAME"),rs.getString("HIERCODE"),rs.getInt("DAIRYID"),rs.getDate("DAIRY_DATE"),rs.getString("DAIRY_DETAILS"),rs.getInt("ENTRY_EMPLOYEE_ID"),rs.getString("NAME1")));
			}
	        return list;
		} catch (Exception ex) {
				ex.printStackTrace();
				Logger.getLogger(EmpGrievanceCaseViewDAO.class.getName()).log(Level.SEVERE, null, ex);
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
