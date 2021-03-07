package com.kashuba.onlinestore.service;

import com.kashuba.onlinestore.dao.FileDao;
import com.kashuba.onlinestore.fileservice.FileInitialization;


public class InfoService {
    FileDao fileDao = new FileDao();

    public String saveInfo(FileInitialization fileInitialization) {
        return fileDao.saveinfo(fileInitialization);
    }
}