package com.gms.servlet;

import static java.nio.file.StandardOpenOption.*;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONObject;

public class DonwloadTest {

	public static void main(String[] args) throws IOException {
		// Convert the string to a
	    // byte array.
	   /* String s = "Hello World! ";
	    byte data[] = s.getBytes();
	    Path path = Paths.get("./logfile.docx");
	    try (OutputStream out = new BufferedOutputStream( Files.newOutputStream(path, CREATE) )) {
	      out.write(data, 0, data.length);
	    } catch (IOException x) {
	      System.err.println(x.getMessage());
	    }*/
			String abc = "abc0";
		       JSONObject jsonObject = new JSONObject("{"+abc+ ":"+ "def"+" }");
		       System.out.println(jsonObject.toString());
			
			JSONObject jo = new JSONObject("{ \"abc\" : \"def\" }");
		       System.out.println(jo.toString());
	}

}
