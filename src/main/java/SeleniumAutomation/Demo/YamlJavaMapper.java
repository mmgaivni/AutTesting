package SeleniumAutomation.Demo;

import org.yaml.snakeyaml.Yaml;

public class YamlJavaMapper {
	
	public Object yamlToJavaObject(String filePath, Class clazz)  {
		    return  new Yaml().loadAs( Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath), clazz);
		}

}