package com.virtualpairprogrammers;

import java.io.Serializable;

public class Data implements Serializable {
    private String VALUES;
    private String Delimiter;

    public String getValue() {
        return VALUES;
    }
    public void setVALUES (String VALUES){
        this.VALUES = VALUES;
    }

    public String getDelimiter(){
        return Delimiter;
    }

    public void setDelimiter(String Delimiter){
        this.Delimiter =  Delimiter;
    }




}
