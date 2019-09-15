package model;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;



public class CsvDao implements DAO {

    @Override
    public Dictionary createDictionaryFromFile(File file) {
        Dictionary dictionary = new Dictionary();

        try{
            List<String> readLines = FileUtils.readLines(file, Charset.defaultCharset());
            readLines
                    .stream()
                    .forEach(element -> dictionary.addItem(new Item(element)));
        } catch (IOException e){
            e.printStackTrace();
        }
        return dictionary;
    }
}
