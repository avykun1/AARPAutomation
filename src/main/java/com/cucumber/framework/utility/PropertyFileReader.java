package com.cucumber.framework.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.log4j.Level;
import com.cucumber.framework.utility.ResourceHelper;

public class PropertyFileReader{

	private Properties prop = null;
	String strValue;

	public PropertyFileReader(String fileName) {
		prop = new Properties();
		try {
			prop.load(ResourceHelper.getResourcePathInputStream(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String strKey) {
		try {
				strValue = prop.getProperty(strKey);
			}
        catch (Exception e) {
			System.out.println(e);
		}
		return strValue;
	}




}
