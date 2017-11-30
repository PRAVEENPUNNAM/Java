package com.janampeta.util;

public enum HostUrl {

	/*   
	LOCAL("http://admin.hifeast.com/"),
	HIFEAST("http://admin.hifeast.com/"),
    FPICKER("http://www.fpicker.com/"),
    IMAGE("http://img.hifeast.com/"),
    DIR("/var/lib/tomcat7/webapps/img_Hifeast/"),
    EMAILIIMAGES("http://img.hifeast.com/resources/emailImage/"),
    PICTUREPATH("http://admin.hifeast.com"),
    FEATUREIMAGE("http://admin.hifeast.com/resources/featureimages/"),
    UNKNOWN("");
    
    */

	LOCAL("http://localhost:8080/smts_food/"),
	HIFEAST("http://localhost:8080/smts_food/"),
    FPICKER("http://localhost:8080/delivery_system_master/"),
    IMAGE("http://192.168.0.19:8080/foodimages/"),
    DIR("E:/SMTS_FOOD_ECLIPSE/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/foodimages/"),
	PICTUREPATH("http://192.168.0.19:8080/smts_food"),
	EMAILIIMAGES("http://img.hifeast.com/resources/emailImage/"), 
    FEATUREIMAGE("http://localhost:8080/smts_food/resources/featureimages/"),
    UNKNOWN("");
	
	
	
	
	
	
	   
    private String url;

    HostUrl(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }
}
