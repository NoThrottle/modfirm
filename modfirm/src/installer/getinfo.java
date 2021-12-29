package installer;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class getinfo {

	public static void main(String[] args) {
		
		System.out.println(Info("apikey"));
	}
	
	
	/**
	 * Returns a value from datavalues.yaml
	 * Possible returns:
	 * _apiKey
	 * _sheetID
	 * _versionOld_coded
	 * _versionOld_readable
	 * _versionNew_coded
	 * _versionNew_readable
	 * _changelog
	 * _modsListRange
	 * _hashListColumn 
	 */
	public static String Info(String type) {
		
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		ParseConfig ParseConfig = null;
		String toreturn = null;
		
		try {
			ParseConfig = mapper.readValue(new File("src/installer/datavalues.yaml"), ParseConfig.class);
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		switch (type) {
			case "_apiKey":
				toreturn = ParseConfig.getApiKey();
				break;
			case "_sheetID":
				toreturn = ParseConfig.getSheetID();
				break;
			case "_versionOld_coded":
				toreturn = "hello";
				break;
			case "_versionOld_readable":
				toreturn = "hello";
				break;
			case "_versionNew_coded":
				toreturn = "hello";
				break;
			case "_changelog":
				toreturn = "hello";
				break;
			case "_modsListRange":
				toreturn = "hello";
				break;
			case "_hashListColumn":
				toreturn = "hello";
				break;
			default:
				toreturn = "?";
		
		}
		
		return toreturn;
	}
	
}
