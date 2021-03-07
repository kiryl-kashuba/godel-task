package com.kashuba.onlinestore.console.command.impl;

import com.kashuba.onlinestore.fileservice.FileInitialization;
import com.kashuba.onlinestore.service.InfoService;

import java.util.List;

public class SaveInfoCommand {
    public String saveInfo(FileInitialization fileInitialization) {
        InfoService infoService = new InfoService();
        return infoService.saveInfo(fileInitialization);
    }
}