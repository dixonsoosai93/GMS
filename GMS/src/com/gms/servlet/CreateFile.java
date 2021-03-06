package com.gms.servlet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class CreateFile {
		
		public static void main(String args[]) throws IOException, SQLException {
		        //String fileSeparator = System.getProperty("file.separator");
			/*
				int attachmentId = 144;
		        ReopenAttachment attachmentFile = ReopenAttachmentDao.reopenFileDownLoad(attachmentId);
				
		        int fileLength = attachmentFile.getFileLength();
				System.out.println(fileLength);
				String filename = attachmentFile.getFileNameExtns();
		        BufferedWriter buff = new BufferedWriter(new FileWriter(filename));
		        buff.write(fileLength);
		        buff.close();
		    */
		        String fileName = "hello.docx";//attachmentFile.getFILEPATH();
				String str = "Hello";
			    BufferedWriter buff = new BufferedWriter(new FileWriter(fileName));
			    buff.write(str);
			    buff.close();
		}
}
		        //absolute file name with path
		       /* String absoluteFilePath = fileSeparator+"Users"+fileSeparator+"Ashish"+fileSeparator+"file.txt";
		        File file = new File(absoluteFilePath);
		        if(file.createNewFile()){
		        	System.out.println("absolute file name with path"+"1 thing works fine ");
		            System.out.println(absoluteFilePath+" File Created");
		        } else {
		        	System.out.println("File "+absoluteFilePath+" already exists");
		        }
		        
		        //file name only
		        File file = new File("file.txt");
		        if(file.createNewFile()){
		        	System.out.println("file name only");
		        	System.out.println("file.txt File Created in Project root directory"+"2 thing works fine ");
		        } else { 
		        	System.out.println("File file.txt already exists in the project root directory");
		        }
		        
		        //relative path
		        String relativePath = "tmp"+fileSeparator+"file.txt";
		        file = new File(relativePath);
		        if(file.createNewFile()){
		        	System.out.println("//relative path"+"1 thing works fine ");
		            System.out.println(relativePath+" File Created in Project root directory");
		        } else {
		        	System.out.println("File "+relativePath+" already exists in the project root directory");
		    }
		}
	}*/




    
        
        
        
    


