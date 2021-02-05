package com.github.sebyplays.jarson.io;

import com.github.sebyplays.jarson.exceptions.InvalidFileTypeException;
import lombok.SneakyThrows;

import java.io.File;

public class JSONFile extends File {
    @SneakyThrows
    public JSONFile(String pathname) {
        super(pathname);
        if(!pathname.endsWith(".json")){
            throw new InvalidFileTypeException("Not a JSON file!");
        }
    }
}
