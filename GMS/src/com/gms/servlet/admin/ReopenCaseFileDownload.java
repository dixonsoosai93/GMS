package com.gms.servlet.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gms.commons.DBConnection;
import oracle.jdbc.OracleTypes;


@WebServlet("/ReopenCaseFileDownload")
public class ReopenCaseFileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ReopenCaseFileDownload() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
    	System.out.print("inside porcessRequest");
    	int attachId = Integer.parseInt(request.getParameter("ATTACHID"));
    	String filePath =null;
    	String fileNameExtn = null;
    	if(attachId != 0) {
    		System.out.print("inside porcessRequest if condition");
    		Connection con = null;
    		CallableStatement cst = null;
    		ResultSet rs = null;
    		byte[] bytes = null;
    		try {
    			System.out.print("inside porcessRequest try block");
    			con = DBConnection.getConnection();
    			cst = con.prepareCall("{call PCK_GMS_DT_REOPEN_GRV_ATTACH.GMS_DT_REOPEN_GRV_CASE_ATTACH(?,?)}");
    			cst.setInt(1, attachId);
    			cst.registerOutParameter(2, OracleTypes.CURSOR);
    			cst.execute();
    			rs = (ResultSet)cst.getObject(2);
    			if(rs.next()) {
    				Blob blob = rs.getBlob("FILE_ATTACH");
    				InputStream in = blob.getBinaryStream();
    				bytes = blob.getBytes(1, (int)blob.length());
    				filePath = rs.getString("FILEPATH");
    				fileNameExtn = rs.getString("FILENAME_XT");
    				byte [] array = blob.getBytes( 1, ( int ) blob.length() );
                    File file = File.createTempFile(filePath, "."+fileNameExtn, new File("."));
                    FileOutputStream out = new FileOutputStream( file );
                    out.write( array );
                    System.out.println(array);
                    out.close();
    				
    				/*
					 * System.out.println(filePath); OutputStream out = new
					 * FileOutputStream(filePath); byte[] buff =
					 * blob.getBytes(1,(int)blob.length()); out.write(buff); out.close();
					 */
    			}
                //System.out.println("Read "+ blob.length() + " bytes ");
                //InputStream in = blob.getBinaryStream();
               
               //out.write(buff);
                //out.close();

    			/*
    			String fileP = filePath;
    			System.out.println(fileP);
    			OutputStream out = new FileOutputStream(fileP);
    			out.write(bytes);
    			Path path = Paths.get(fileP);
    			byte[] genFile = Files.readAllBytes(path);
    			File f = new File(fileP);
    			f.delete();
    			response.setContentType("application/octet-stream");
    			OutputStream output = response.getOutputStream();
    			System.out.print(output);
    			output.write(genFile);
    			output.close();
    			*/
    		} catch (Exception e) {
				e.getMessage();
				System.out.println(e.getMessage());
			}
    		
    	}
    }
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
