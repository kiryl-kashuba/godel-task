package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.service.impl.InfoService;

public class SaveInfoCommand {

    private static SaveInfoCommand instance;

    private SaveInfoCommand() {
    }

    public static SaveInfoCommand getInstance() {
        if (instance == null) {
            instance = new SaveInfoCommand();
        }
        return instance;
    }

    public String saveInfo(FileInitialization fileInitialization) {
        InfoService infoService = new InfoService();
        return infoService.saveInfo(fileInitialization);
    }
}