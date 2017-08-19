

/**
 * 
 */
package framework.Business.Layer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import com.jayway.jsonpath.spi.mapper.GsonMappingProvider;

/**
 * @author cdeyso
 * @author Souvik Dey
 * 
 * This method is to be used to read a JSON file based on Key/Value Combinations upon the 
 * JSONPath for the desired Keys
 *
 */
public class ReadJsonFile {
	
	/** The location of Json Config File */
	public static String jsonConfigFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CSD/Configuration/JSONconfig.propertiess";
	
	/** The variable to store the location of the JSON File to be read */
	public static String JSON_filePath = null;
	
	/** The JSON Path to read */
	public static String JSON_path = null;
	
	/** The list of Values that is returned from the JSON after it is read */
	public static List<String> categories = new ArrayList<String>();
	
	@SuppressWarnings("unchecked")
	public static List<String> readJsonFileStatic() {
		
		JSON_filePath = ReadPropertyFile.getInstance(jsonConfigFile).getProperty("json_FILENAME");
		JSON_path = ReadPropertyFile.getInstance(jsonConfigFile).getProperty("json_Path_1");
		
		try 
		{
			String content = new String(Files.readAllBytes(Paths.get(JSON_filePath)));
			Configuration conf = Configuration.builder()
		            .jsonProvider(new GsonJsonProvider())
		            .mappingProvider(new GsonMappingProvider())
		            .build();
		
			DocumentContext context = JsonPath.using(conf).parse(content);
			categories = context.read(JSON_path, List.class);//List<String> 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return categories;
	}
	
	/** This Method always returns a list of values, even if there is only a single value 
	 * in the JSON File 
	*/
	@SuppressWarnings("unchecked")
	public static List<String> readJsonFileDynamic(String filePath, String jsonPath) {
		
		System.out.println("jsonpath - "+jsonPath);
		try 
		{
			String content = new String(Files.readAllBytes(Paths.get(filePath)));
			Configuration conf = Configuration.builder()
		            .jsonProvider(new GsonJsonProvider())
		            .mappingProvider(new GsonMappingProvider())
		            .build();
		
			DocumentContext context = JsonPath.using(conf).parse(content);
			categories = context.read(jsonPath, List.class);//List<String> 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return categories;
		
	}

}
