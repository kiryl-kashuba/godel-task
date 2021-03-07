package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.service.InfoService;

public class SaveInfoCommand {
    public String saveInfo(FileInitialization fileInitialization) {
        InfoService infoService = new InfoService();
        return infoService.saveInfo(fileInitialization);
    }
}