package abinashDash.data;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class getJsonData {
	
	public List<HashMap<String, String>> jsonData() throws IOException {
	//json to String
	// readFileToString is Depreciated and we have to give Encoding Format(StandardCharsets.UTF_8))
	String readFiletoString = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "src//test//java//abinashDash//data//PurchaseOrder.json"), StandardCharsets.UTF_8);
	
	//String to HashMap via Jackson databind
	ObjectMapper mapper= new ObjectMapper();
	List<HashMap<String, String>> data = mapper.readValue(readFiletoString, new TypeReference<List<HashMap<String, String>>>() {});
	return data;
	
	}
}
