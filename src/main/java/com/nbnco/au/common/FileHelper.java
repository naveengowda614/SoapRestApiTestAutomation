package com.nbnco.au.common;

import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

public class FileHelper {
    static Logger logger = Logger.getLogger(Helper.class);

    public File GetFileByPathFromResource(String fileName){
        return new File(getClass().getClassLoader().getResource(fileName).getFile());
    }
    public File GetXmlFile(String fileName){
        return new File(getClass().getClassLoader().getResource(fileName).getFile());
    }

    public String GetXmlAsString (String filePath) {
        String result;
        try {
           File file = new File(getClass().getClassLoader().getResource(filePath).getFile());
           BufferedReader br = new BufferedReader(new FileReader(file));
            result = br.lines().collect(Collectors.joining("\n"));
       }
       catch (FileNotFoundException e) {
           logger.error("File Not Found :" + e.getStackTrace().toString());
           result = "";
       }
        catch (Exception e) {
            logger.error("Exception :" + e.getStackTrace().toString());
            result = "";
        }
        return  result;
    }

    public String GetXmlAsStringAndReplaceUUID (String filePath, String correlationId) {

      String result;
      try{
          File file = new File(getClass().getClassLoader().getResource(filePath).getFile());
          BufferedReader br = new BufferedReader(new FileReader(file));
          String content = br.lines().collect(Collectors.joining("\n"));
          result = content.replace("CorrelationID-UUID",correlationId);
      }
      catch (FileNotFoundException e) {
          logger.error("File Not Found :" + e.getStackTrace().toString());
          result = "";
      }
      catch (Exception e) {
          logger.error("Exception :" + e.getStackTrace().toString());
          result = "";
      }
      return  result;
      }
}
