package installer;

import java.util.List;

public class ParseConfig {
    private String apiKey;
    private String sheetID;

    public ParseConfig() {

    }

    public ParseConfig(
    		String apiKey,
    		String sheetID
    		) {
    	
        super();
        this.apiKey = apiKey;
        this.sheetID = sheetID;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getSheetID() {
        return sheetID;
    }


    //IDK what this does
    @Override
    public String toString() {
        return "?";
    }

}