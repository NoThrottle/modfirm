package installer;

import java.util.List;

public class ParseConfig {
    private String apiKey;
    private String sheetID;
    private String versionOld_coded;
    private String versionOld_readable;
    private String versionNew_coded;
    private String versionNew_readable;
    private String changelog;
    private String modsListRange;

    public ParseConfig() {

    }

    public ParseConfig(
    		String apiKey,
    		String sheetID,
    		String versionOld_coded,
    		String versionOld_readable,
    		String versionNew_coded,
    		String versionNew_readable,
    		String changelog,
    		String modsListRange
    		) {
    	
        super();
        this.apiKey = apiKey;
        this.sheetID = sheetID;
        this.versionOld_coded = versionOld_coded;
        this.versionOld_readable = versionOld_readable;
        this.versionNew_coded = versionNew_coded;
        this.versionNew_readable = versionNew_readable;
        this.changelog = changelog;
        this.modsListRange = modsListRange;
    }

    
    //-----PUBLIC_RETURNS------
    public String getApiKey() {
        return apiKey;
    }

    public String getSheetID() {
        return sheetID;
    }
    
    public String getVersionOld_coded() {
    	return versionOld_coded;
    }

    public String getVersionOld_readable() {
    	return versionOld_readable;
    }
    
    public String getVersionNew_coded() {
    	return versionNew_coded;
    }

    public String getVersionNew_readable() {
    	return versionNew_readable;
    }
    
    public String getChangelog() {
    	return changelog;
    }
    
    public String getModsListRange() {
    	return modsListRange;
    }
    

    
    //IDK what this does
    @Override
    public String toString() {
        return "?";
    }

}