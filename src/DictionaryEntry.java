package src;
public class DictionaryEntry implements Comparable<DictionaryEntry> {
    private String englishWord;
    private String spanishWord;
    private String frenchWord;

    public DictionaryEntry(String englishWord, String spanishWord, String frenchWord) {
        this.englishWord = englishWord;
        this.spanishWord = spanishWord;
        this.frenchWord = frenchWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public String getSpanishWord() {
        return spanishWord;
    }

    public String getFrenchWord() {
        return frenchWord;
    }

    @Override
    public int compareTo(DictionaryEntry other) {
        return this.englishWord.compareTo(other.englishWord);
    }
}
