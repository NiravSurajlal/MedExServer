package common;

import java.io.File;
import java.io.FileReader;
import java.util.Map;

import com.cucumber.listener.Reporter;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;



public class YMLUtil {
	
	static ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
	// read YAML file
	static Map<String, Object> ymlData;
	
	static String YMLNode="";
	static Object ymlObject;
	static Object ymlObjectRepo;
	static Object ymlpayloadObject;
	
	public static String getYMLData(String key) {
		String output = "";
		try {		
		   // System.out.println(ymlObject); 
		    Map map = (Map)ymlObject; 
		    output=((Map)map).get(key).toString();
		    if(output == null || output.isEmpty())
		    {
		    	output=((Map)map.get(YMLNode)).get(key).toString();
		    }	
			//output = ymlData.get(key).toString();
			if (output == null || output.isEmpty()) {
				output = key;
			}
			else
			{
			Reporter.addStepLog(key+" : "+output);
			}
			//System.out.println(output);
		} catch (Exception ex) {
			output = key;
		}
		return output;

	}
	
	public static String getYMLObjectRepositoryData(String key) {
		String output = "";
		try {
		String[] keys=key.split("[.]",0);
		  // System.out.println(ymlObject);
		  if(keys.length>1)
		{
		   Map map = (Map)ymlObjectRepo;
		   output=((Map)map.get(keys[0])).get(keys[1]).toString();
		  //output=(map.get(keys[1])).toString().trim();
		}
		else
		{
			 Map map = (Map)ymlObjectRepo;
			   output=((Map)map).get(key).toString();
		}

		//output = ymlData.get(key).toString();
		if (output == null || output.isEmpty()) {
		output = key;
		}
		//System.out.println(output);
		} catch (Exception ex) {
		output = key;
		}
		return output;
		}

	public static void updateYML(String key, String value) {
		try {
			if (ymlData.containsKey(key)) {
				ymlData.replace(key, value);
			} else {
				ymlData.put(key, value);
			}
			objectMapper.writeValue(new File("src/test/java/TestData.yml"), ymlData);
		} catch (Exception ex) {

		}
	}

	public static void loadYML(String file,String node) {
		try {			
			YamlReader reader = new YamlReader(new FileReader(file));
			ymlObject = reader.read(); 
		    YMLNode=node;
			//ymlData = objectMapper.readValue(new File("src/test/resources/TestData.yml"),
			//		new TypeReference<Map<String, Object>>() {
			//		});
		} catch (Exception ex) {

		}
	}
	public static void loadObjectRepoYML(String file) {
		try {			
			YamlReader reader = new YamlReader(new FileReader(file));
			ymlObjectRepo = reader.read(); 
			//ymlData = objectMapper.readValue(new File("src/test/resources/TestData.yml"),
			//		new TypeReference<Map<String, Object>>() {
			//		});
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	public static void PayloadYML(String file,String node) {
		
		try {			
			YamlReader reader = new YamlReader(new FileReader(file));
			ymlpayloadObject = reader.read();
			 Map map = (Map)ymlpayloadObject;
			int abc=((Map)map).keySet().size();
		    for (Object rule : ((Map)map).keySet()) {
		    CommonUtil.apiPayloadDictionary.put(rule.toString(),((Map)map).get(rule).toString());
				 // System.out.println(rule);
				//  System.out.println(((Map)map).get(rule).toString());
				  }
			YMLNode=node;
			//System.out.println("ymlObject  read value:"+ymlpayloadObject);		    			
		} catch (Exception ex) {

		}
	}

}
