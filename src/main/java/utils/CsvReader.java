package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvReader {
    public static Object[][] getCsvData(String csvPath, int csv_attributes) throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(csvPath));
        List<String[]> csvData = csvReader.readAll();
        Object[][] csvDataObject = new Object[csvData.size()-1][csv_attributes];    //Neu k co truong username, pass thi csvdata.size(), ko co -1
        for(int i=0; i<csvData.size()-1; i++) {                             //Neu k co truong username, pass thi csvdata.size(), ko co -1
            csvDataObject[i] = csvData.get(i+1);                            //Neu k co truong username, pass thi get(i), ko co +1
        }
        return  csvDataObject;
    }
}
