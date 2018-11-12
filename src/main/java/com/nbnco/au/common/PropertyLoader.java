package com.nbnco.au.common;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyLoader {
	
	static Logger logger = Logger.getLogger(Helper.class);

    private Properties prop = new Properties();
    
    private String envName = System.getProperty("envName");    
    

    public PropertyLoader() {
        try {
        	//logger.info("Environment Selected is:"+envName);
        	if(envName == null || envName.isEmpty() || envName == "")
        	{
        		envName = "psupdc1";
        	}
            File envConfigFile = new File(getClass().getClassLoader().getResource(String.format(Constants.environmentConfigFile,envName)).getFile());
            FileInputStream fileInput = new FileInputStream(envConfigFile);
            prop.load(fileInput);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getEnvValue(){
        return prop.getProperty("ENVIRONMENT");
    }
    public String getTMValue(){
        return prop.getProperty("TM");
    }
    public String getProperty(String key){
        return  prop.getProperty(key);
    }
}
