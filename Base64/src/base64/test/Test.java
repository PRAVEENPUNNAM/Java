package base64.test;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("i am get");
		System.out.println(request.getParameter("data"));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("i am post");
		String string=request.getParameter("data");
		System.out.println(string);
		/*String base64Image = string.split(",")[1];*/
		byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(string);
       /* BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));*/
       FileOutputStream fs= new FileOutputStream("D:/image.png");
       try
       {
       fs.write(imageBytes);
       }finally
       {
    	fs.close();   
    	   
       }
}
}