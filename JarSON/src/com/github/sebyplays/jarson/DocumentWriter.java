package com.github.sebyplays.jarson;

import com.github.sebyplays.jarson.api.JarSON;
import com.github.sebyplays.logmanager.api.LogManager;
import com.github.sebyplays.logmanager.api.LogType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@Data public class DocumentWriter {

    private Document document;

    @SneakyThrows
    public DocumentWriter(Document document){
        this.setDocument(document);
        new LogManager("JarSON").log(LogType.NORMAL, "DocumentWriter initialized for document: [" + document.getJsonFile() + "]", true, false, true, !this.getDocument().isSuppressLogManager());

    }

    @SneakyThrows
    public void setValue(String path, Object value){
        this.getDocument().getJsonObject().put(path, value);
        new LogManager("JarSON").log(LogType.NORMAL, "DocWriter | Value [" + value.toString() + "] bound to key [" + path + "]", true, false, true, !this.getDocument().isSuppressLogManager());
    }

    public void setDouble(String key, double value){
        this.setValue(key, value);
    }

    public void setBoolean(String key, boolean value){
        this.setValue(key, value);
    }

    public void setString(String key, String value){
        this.setValue(key, value);
    }

    public void setInteger(String key, int value){
        this.setValue(key, value);
    }

    public void setLong(String key, int value){
        this.setValue(key, value);
    }
}
