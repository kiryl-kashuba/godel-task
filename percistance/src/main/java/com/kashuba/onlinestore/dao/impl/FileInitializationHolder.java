package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.dao.fileservice.FileInitialization;

public abstract class FileInitializationHolder {

    public FileInitialization fileInitialization = FileInitialization.getInstance();
}
