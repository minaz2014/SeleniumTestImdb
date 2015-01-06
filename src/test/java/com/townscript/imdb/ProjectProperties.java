package test.java.com.townscript.imdb;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjectProperties {
	
	private static String baseUrl;
	
	public static String getBaseUrl() {
		if (baseUrl == null) {
			Properties pro = new Properties();
			try {
				pro.load(new FileInputStream("src/test/resources/com/townscript/imdb/project.properties"));
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			
			baseUrl = pro.getProperty("url");
			return baseUrl;
		} else {
			return baseUrl;
		}
	}

}
