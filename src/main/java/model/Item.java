package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Item {
    private String word;
    private Set<String> translations;
    private boolean isGuessed;

    public Item(String line){
        this.translations = new HashSet<>();
        this.isGuessed = false;
        setFields(line);
    }

    public String getWord(){
        return word;
    }
    public void setWord(String word){
        this.word = word;
    }
    public Set<String> getTranslations(){
        return translations;
    }
    public void setTranslations(Set<String> translations){
        this.translations = translations;
    }

    public boolean isGuessed(){
        return isGuessed;
    }
    public void setGuessed(boolean guessed){
        this.isGuessed = guessed;
    }

    @Override
    public String toString() {
        return "model.Item{" +
                "word='" + word + '\'' +
                ", translations=" + translations +
                ", isGuessed=" + isGuessed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return isGuessed == item.isGuessed &&
                Objects.equals(word, item.word) &&
                Objects.equals(translations, item.translations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, translations, isGuessed);
    }
    private void setFields(String line){
        String[] splited = line.split(",");
        this.word = splited[0];

        for (int i = 1; i < splited.length; i++) {
            translations.add(splited[i]);
        }
    }
}
