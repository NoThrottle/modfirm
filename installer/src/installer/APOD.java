package installer;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class APOD {
    public final String copyright;
    public final String date;
    public final String explanation;
    public final String hdUrl;
    public final String mediaType;
    public final String serviceVersion;
    public final String title;
    public final String url;
    public final String range;
    public final String majorDimension;
    public List values;

    public APOD(@JsonProperty("copyright") String copyright,
                @JsonProperty("date") String date,
                @JsonProperty("explanation") String explanation,
                @JsonProperty("hdurl") String hdUrl,
                @JsonProperty("media_type") String mediaType,
                @JsonProperty("service_version") String serviceVersion,
                @JsonProperty("title") String title,
                @JsonProperty("url") String url,
                @JsonProperty("range") String range,
                @JsonProperty("majorDimension") String majorDimension,
                @JsonProperty("vaulues") List values) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdUrl = hdUrl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
        this.range = range;
        this.majorDimension = majorDimension;
        this.values = values;
    }
}