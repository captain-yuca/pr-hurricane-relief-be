package com.uprm.prhr.helpers;

public enum Region {
    Mayaguez("Mayaguez"),Arecibo("Arecibo"),Bayamon("Bayamon"),San_Juan("San Juan"),Carolina("Carolina"),Humacao("Humacao"), Ponce("Ponce"),Guayama("Guayama");

    private String label;
    private Region(String label){ this.label = label;}
    public static Region findByLabel(String byLabel){
        for(Region r:Region.values()){
            if(r.label.equalsIgnoreCase(byLabel))
                return r;
        }
        return null;
    }

}
