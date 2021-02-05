package com.github.sebyplays.jarson;

import com.github.sebyplays.jarson.io.JSONFile;
import com.github.sebyplays.logmanager.api.LogManager;
import com.github.sebyplays.logmanager.api.LogType;
import jdk.nashorn.internal.parser.JSONParser;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;

@Data public class Document {
    private JSONFile jsonFile;
    private boolean autoSave = false;
    private boolean suppressLogManager = false;
    public JSONObject jsonObject = new JSONObject();
    private DocumentReader documentReader;
    private DocumentWriter documentWriter;

    @SneakyThrows
    public Document(JSONFile jsonFile){
        this.setJsonFile(this.prepareFile(jsonFile));
        this.setDocumentReader(new DocumentReader(this));
        this.setDocumentWriter(new DocumentWriter(this));
        new LogManager("JarSON").log(LogType.NORMAL, "Document initialized. [" + this.getJsonFile() + "]", true, false, true, !this.isSuppressLogManager());
    }

    @SneakyThrows
    private JSONFile prepareFile(JSONFile file){
        if(file.exists()){
            this.setJsonObject(new JSONObject(new BufferedReader(new FileReader(file)).readLine()));
            return file;
        }
        new File(file.getParent()).mkdirs();
        file.createNewFile();
        return file;
    }



}
