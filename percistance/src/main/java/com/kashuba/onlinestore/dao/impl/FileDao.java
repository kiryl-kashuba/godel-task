package com.kashuba.onlinestore.dao.impl;

import com.kashuba.onlinestore.IdGenerator;
import com.kashuba.onlinestore.dao.fileservice.FileInitialization;
import com.kashuba.onlinestore.dao.fileservice.FileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.kashuba.onlinestore.dao.fileservice.FileInitialization.*;

public class FileDao {
    public void saveInfo(FileInitialization fileInitialization) {
        List<Object> lists = new ArrayList();
        lists.add(fileInitialization.getReadedClients());
        lists.add(fileInitialization.getReadedCart());
        lists.add(fileInitialization.getReadedCategory());
        lists.add(fileInitialization.getReadedOrder());
        lists.add(fileInitialization.getReadedProduct());
        lists.add(fileInitialization.getReadedPA());
        lists.add(fileInitialization.getReadedUser());
        lists.add(fileInitialization.getReadedPAV());

        List<Object> listsOfFile = new ArrayList();
        listsOfFile.add(CLIENTR);
        listsOfFile.add(CARTR);
        listsOfFile.add(CATEGORYR);
        listsOfFile.add(ORDERR);
        listsOfFile.add(PRODUCTR);
        listsOfFile.add(PAR);
        listsOfFile.add(USERR);
        listsOfFile.add(PAVR);

        try {
        for (int x = 0; x < lists.size(); x++) {
            FileRepository.writeObject((String) listsOfFile.get(x), lists.get(x));
        }
            FileRepository.writeId(IDR, IdGenerator.getIdCounter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
