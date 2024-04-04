package model;

public class RegionModel {
    private int regionId;
    private String regionDescription;

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
    
    public String getRegionDescription(){
        return regionDescription;
    }
    public void setRegionDescription(String regionDescription){
        this.regionDescription = regionDescription;
    }
    public String[] getProperties(){
        String[] data = {String.valueOf(this.regionId), this.regionDescription};
        return data;  
    }
}
