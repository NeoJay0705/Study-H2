package org.iisi.easysetting;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * JsonFile
 */
public class JsonFile {

    public static void main(String[] args) {
        JsonFile jsonFile = new JsonFile();
        jsonFile.createSettings(new Jdbc());
    }

    private Path path;

    public JsonFile() {
        setPath("./configs");
    }

    public JsonFile(String path) {
        setPath(path);
    }

    public void createSettings(Object object) {
        Gson gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();
        String jsonFormat = gson.toJson(object);
        writeAsJsonFile(object, jsonFormat);
    }

    public void writeAsJsonFile(Object object, String jsonFormat) {
        try {
            Path path = Paths.get(this.path.toString() + "/" 
                                    + object.getClass().getName().substring(
                                            object.getClass().getName().lastIndexOf(".") + 1) 
                                    + ".json");
            BufferedWriter bufferWritter = Files.newBufferedWriter(path);
            bufferWritter.write(jsonFormat);
            bufferWritter.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void setPath(String path) {
        this.path = Paths.get(path);
        if(!Files.isDirectory(this.path)) {
            createDirectory();
        }
    }

    private void createDirectory() {
        try {
            Files.createDirectory(this.path);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}