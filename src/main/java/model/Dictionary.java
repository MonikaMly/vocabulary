package model;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Dictionary {
    private Set<Item> items;

    public Dictionary() {
        this.items = new HashSet<>();
    }

    public Optional<String> getRandomWord() {
        List<Item> unansweredItems = items
                .stream()
                .filter(item -> !item.isGuessed())
                .collect(Collectors.toList());

        String selectedWord = null;

        if(unansweredItems.size() > 0){
            int index = (int) (Math.random() * unansweredItems.size());
            selectedWord = unansweredItems.get(index).getWord();
        }

        return Optional.ofNullable(selectedWord);
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){
        items.add(item);
    }

    @Override
    public String toString() {
        return "model.Dictionary{" +
                "items=" + items +
                '}';
    }

    public boolean checkTranslation(String englishWord, String toCheck){
        Optional<String> any = items
                .stream()
                .filter(item -> item.getWord().equals(englishWord))
                .findFirst()
                .get()
                .getTranslations()
                .stream()
                .filter(translation -> translation.equalsIgnoreCase(toCheck))
                .findAny();
        if(any.isPresent()){
            markAnswered(englishWord);
        }
        return any.isPresent();
    }
    private void markAnswered(String englishWord){
        items
                .stream()
                .filter(item -> item.getWord().equals(englishWord))
                .findFirst()
                .get()
                .setGuessed(true);
    }
    public void clearFlags(){
        items
                .stream()
                .forEach(item -> item.setGuessed(false));
    }
}
