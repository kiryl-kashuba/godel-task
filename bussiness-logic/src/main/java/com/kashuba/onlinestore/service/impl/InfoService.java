package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.FileDao;
import com.kashuba.onlinestore.dao.fileservice.FileInitialization;


public class InfoService {
    FileDao fileDao = new FileDao();

    public String saveInfo(FileInitialization fileInitialization) {
        return fileDao.saveInfo(fileInitialization);
    }
}