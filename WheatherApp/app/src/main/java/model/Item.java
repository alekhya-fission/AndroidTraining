package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alekhya on 21/5/16.
 */
public class Item {
    private String  title;
    private double  lat;
    private String link;
    private double longe;
    private String pubDate;
    private String description;
    private Condition condition;
    private Guid guid;
    private ArrayList<Forecast> forecast=new ArrayList<Forecast>();

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Guid getGuid() {
        return guid;
    }

    public void setGuid(Guid guid) {
        this.guid = guid;
    }

    public ArrayList<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(ArrayList<Forecast> forecast) {
        this.forecast = forecast;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public double getLonge() {
        return longe;
    }

    public void setLonge(double longe) {
        this.longe = longe;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }






}
