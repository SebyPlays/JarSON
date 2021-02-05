package com.github.sebyplays.jarson.api;

import com.github.sebyplays.jarson.Document;
import com.github.sebyplays.jarson.io.JSONFile;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;

@Data public class JarSON {
    private Document document;

    //Usage:
    //JarSON jarSON = new JarSON(new Document(new JSONFile(System.getProperty("user.dir") + "/JSON/jarsonTest.json")));
    //jarSON.getDocument().getWriter().setString("key", "value");
    //jarSON.getDocument().getReader().getString("key");

    public JarSON(Document document){
        this.setDocument(document);
    }

    public JarSON(){

    }

    public void loadDocument(JSONFile jsonDocument){
        this.setDocument(new Document(jsonDocument));
    }

    public void loadDocument(Document document){
        this.setDocument(document);
    }

    @SneakyThrows
    public void saveDocument(Document document){
        FileWriter fileWriter = new FileWriter(this.getDocument().getJsonFile());
        fileWriter.write(this.getDocument().getJsonObject().toString());
        fileWriter.close();
    }

}
