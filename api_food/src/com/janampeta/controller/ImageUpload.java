package com.janampeta.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;

import javax.servlet.http.Part;

import com.janampeta.dao.AdminDao;
import com.janampeta.model.Encript;
@WebServlet("/imgUpload")
@MultipartConfig(fileSizeThreshold=1024*1024*10)  
public class ImageUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  private static final String UPLOAD_DIR = "uploads";
	     
	    protected void doPost(HttpServletRequest request,
	            HttpServletResponse response) throws ServletException, IOException {
	       
	    	String title=request.getParameter("title");
	    	String shortdesc=request.getParameter("sd");
	    	String longdesc=request.getParameter("ld");
	    	String imageUrl=request.getParameter("url");
	    	String catId=request.getParameter("catId");
	    	
	    	// gets absolute path of the web application
	        String applicationPath = request.getServletContext().getRealPath("");
	        // constructs path of the directory to save uploaded file
	        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
	         
	        // creates the save directory if it does not exists
	        File fileSaveDir = new File(uploadFilePath);
	        if (!fileSaveDir.exists()) {
	            fileSaveDir.mkdirs();
	        }
	        
	        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
	        
	        String fileName = null;
	        //Get all the parts from request and write it to the file on server
	        /*for (Part part : request.getParts()) {
	            fileName = getFileName(part);
	            part.write(uploadFilePath + File.separator + fileName);
	        }*/
	        for (Part part : request.getParts()) {
	            fileName = getFileName(part);
	            
	            if (fileName != null && !"".equals(fileName)) {
	            	imageUrl=imageUrl+"/"+fileName;
	                part.write(uploadFilePath + File.separator + fileName);
	            }

	        }
	      
	      Encript e = new Encript();
	      e.setTitle(title);
	      e.setSdec(shortdesc);
	      e.setLdec(longdesc);
	      e.setImgUrl(imageUrl);
	      e.setCatId(catId);
	
	      int status=new AdminDao().uploadEncriptData(e);
	      if(status==0)
	    	  request.setAttribute("status", "fail");
	      else
	    	  request.setAttribute("status", "succes");
	      request.getRequestDispatcher("upload.jsp").forward(request, response);
	       /* request.setAttribute("message", fileName + " File uploaded successfully!");
	        getServletContext().getRequestDispatcher("/response.jsp").forward(
	                request, response);*/
	   // response.getWriter().print("http://localhost:8080/upload/uplods/"+fileName +"  "+uploadFilePath);
	    }
	 
	    /**
	     * Utility method to get file name from HTTP header content-disposition
	     */
	    private String getFileName(Part part) {
	        String contentDisp = part.getHeader("content-disposition");
	        System.out.println("content-disposition header= "+contentDisp);
	        String[] tokens = contentDisp.split(";");
	        for (String token : tokens) {
	            if (token.trim().startsWith("filename")) {
	                return token.substring(token.indexOf("=") + 2, token.length()-1);
	            }
	        }
	        return "";
	    }

}
