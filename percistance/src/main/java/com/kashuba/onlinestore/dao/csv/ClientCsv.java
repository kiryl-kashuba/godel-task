package com.kashuba.onlinestore.dao.csv;

import com.kashuba.onlinestore.entity.Client;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class ClientCsv {
    public void writeClient(Client client) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        Writer writer = new FileWriter("ClientData.csv");
        StatefulBeanToCsv<Client> beanToCsv = new StatefulBeanToCsvBuilder<Client>(writer)
                .withSeparator(';')
                .withLineEnd(CSVWriter.DEFAULT_LINE_END)
                .withOrderedResults(true)
                .build();

        System.out.println("CSV" + client);
        beanToCsv.write(client);
        beanToCsv.getCapturedExceptions();
        writer.close();
    }
}
