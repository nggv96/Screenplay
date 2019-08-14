package co.com.screenplay.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtil {

public static Properties readPropertiesFile(String fileName) throws FileNotFoundException, IOException {
		
		Properties p = new Properties();
		p.load(new FileReader(fileName));
		
		return p;	
	}
}
