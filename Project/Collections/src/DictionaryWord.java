
import java.util.Objects;


public class DictionaryWord implements Comparable<DictionaryWord> {
    private String word;
    private String meanings;

    public DictionaryWord(String word, String meanings) {
        this.word = word;
        this.meanings = meanings;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeanings() {
        return meanings;
    }

    public void setMeanings(String meanings) {
        this.meanings = meanings;
    }
    
    @Override
    public String toString()
    {
        return word + "\n" + meanings + "\n";
    }
    
    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object o)
    {
        DictionaryWord dw = (DictionaryWord) o;
        return word.equals(dw.getWord());
    }

    @Override
    public int hashCode() {
        int hash = 9;
        hash = 97 * hash + Objects.hashCode(this.word);
        return hash;
    }
    
    @Override
    public int compareTo(DictionaryWord o)
    {
        return word.compareTo(o.getWord());
    }
}
