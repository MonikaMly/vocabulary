import java.awt.event.ActionEvent;
import java.io.File;
import model.Dictionary;
import java.util.Optional;

import model.CsvDao;
import model.DAO;

public class Controller {
    private GUI gui;
    private Dictionary dictionary;
    private String englishWord;

    public void actionPerformed(ActionEvent event){
        switch (event.getActionCommand()){
            case GUI.OPEN:
                createDictionary();
                break;
            case GUI.START:
                startGame();
                break;
            case GUI.CHECK:
                checkAnswer();
                break;
        }
    }

    private void checkAnswer(){
        String textToCheck = gui.getTextToCheck();
        boolean isCorrect = dictionary.checkTranslation(englishWord, textToCheck);
        if(isCorrect){
            gui.addPoints();
        } else {
            gui.takePoint();
        }
        showNextWord();
        gui.clearTextField();
    }

    private void startGame(){
        dictionary.clearFlags();
        gui.clearTextField();
        showNextWord();
        gui.resetPoints();
    }

    private void showNextWord(){
        Optional<String> randomWord = dictionary.getRandomWord();
        if(randomWord.isPresent()){
            this.englishWord = randomWord.get();
            gui.showEnglishWord(englishWord);
        } else {
            gui.showGameOverInfo();
            startGame();
        }
    }
    public void setGui(GUI gui){
        this.gui = gui;
    }
    private void createDictionary(){
        File file = gui.getFile();
        DAO dao = new CsvDao();
        this.dictionary = dao.createDictionaryFromFile(file);
    }
}
