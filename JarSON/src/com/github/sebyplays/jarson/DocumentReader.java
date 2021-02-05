package com.github.sebyplays.jarson;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data public class DocumentReader {

    @Getter @Setter private Document document;

    public DocumentReader(Document document){
        this.setDocument(document);
    }

    public Object getValue(String path){
        return this.getDocument().getJsonObject().get(path);
    }

    public String getString(String path){
        return (String) this.getValue(path);
    }

    public int getInteger(String path){
        return (int) this.getValue(path);
    }

    public boolean getBoolean(String path){
        return (boolean) this.getValue(path);
    }

    public long getLong(String path){
        return (long) this.getValue(path);
    }

}
