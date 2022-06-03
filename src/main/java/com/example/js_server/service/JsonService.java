package com.example.js_server.service;

import com.example.js_server.dto.Db;
import com.example.js_server.dto.Menu;
import com.example.js_server.dto.Request;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@AllArgsConstructor
public class JsonService {

    private static final Path file = Paths.get("src/main/resources/db/db.json");

    public void saveRequest(Request r) throws IOException {
        Db db = readDb();
        mergeRequests(db, r);
        writeDb(db);
    }

    public void saveMenu(Menu m) throws IOException {
        Db db = readDb();
        mergeMenu(db, m);
        writeDb(db);
    }

    private void mergeRequests(Db db, Request r) {
        Request[] requestsArr = db.getRequests();
        Request[] requests = ArrayUtils.addAll(requestsArr, r);
        db.setRequests(requests);
    }

    private void mergeMenu(Db db, Menu m) {
        Menu[] menuArr = db.getMenu();
        Menu[] menu = ArrayUtils.addAll(menuArr, m);
        db.setMenu(menu);
    }

    private Db readDb() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = Files.readString(file);
        return gson.fromJson(s, Db.class);
    }

    private void writeDb(Db db) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s = gson.toJson(db);
        Files.writeString(file, s, StandardCharsets.UTF_8);
    }

}
