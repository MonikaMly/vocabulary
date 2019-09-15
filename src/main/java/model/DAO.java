package model;

import java.io.File;
import model.Dictionary;

public interface DAO {
    Dictionary createDictionaryFromFile(File file);
}
