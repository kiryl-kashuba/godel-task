package com.kashuba.onlinestore.service.impl;

import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.dao.impl.FileDao;


public class InfoService {
    FileDao fileDao = new FileDao();

    public void saveInfo(FileInitialization fileInitialization) {
        fileDao.saveInfo(fileInitialization);
    }
}