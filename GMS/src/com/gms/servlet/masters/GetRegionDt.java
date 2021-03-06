package com.gms.servlet.masters;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.gms.dao.masters.RegionMasterDAO;
import com.gms.model.masters.DtRegionModel;
import com.gms.servlet.AdminLogin;

@WebServlet("/GetRegionDt")
public class GetRegionDt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(GetRegionDt.class.getName());
       
    public GetRegionDt() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	logger.info("Inside the doPost() method");
		String jsonResponse = null;
        JSONObject jsonObject = new JSONObject();
        String regionGridList = "";
        try {
			int REGIONID = Integer.parseInt(request.getParameter("REGIONID"));
			List<DtRegionModel> DtRegion = RegionMasterDAO.getDtRegion(REGIONID);
			if(DtRegion != null && DtRegion.size() > 0) { 
				int i=1;
				for(DtRegionModel item: DtRegion) {
					regionGridList += "<tr>";
					regionGridList += "<td>"+i+"</td>";
					regionGridList += "<td>"+item.getREGION_DET_ID()+"</td>";
					regionGridList += "<td>"+item.getCITY_CODE()+"</td>";
					regionGridList += "<td>"+item.getCITY_NAME()+"</td>";
					regionGridList += "<td>"+item.getSTATE_NAME()+"</td>";
					regionGridList += "<td>"+item.getZONE_NAME()+"</td>";
					regionGridList += "<td>"+item.getBRANCH_CODE()+"</td>";
					regionGridList += "<td>"+item.getBRANCH_NAME()+"</td>";
					regionGridList += "<td>"+item.getIS_ACTIVE()+"</td>";
					regionGridList += "</tr>";
					i++;
				}
			}
        }  catch(Exception ex) {
        	ex.printStackTrace();
        	logger.info("Exception Inside the doPost() method Exception "+ex.getMessage());
        	Logger.getLogger(GetRegionDt.class.getName()).log(Level.SEVERE, null, ex);
        	regionGridList = "<tr><td colspan=\"12\">No detail found</td></tr>";
        } 
        if(regionGridList.equals("")) {
        	regionGridList = "<tr><td colspan=\"12\">No detail found</td></tr>";
        }
        jsonObject.put("status", 200);
		jsonObject.put("data", regionGridList);
		jsonResponse = jsonObject.toString();
        response.setContentType("application/json");
    	response.getWriter().write(jsonResponse);
    	logger.info("Leaving the doPost() method");
	}

}
