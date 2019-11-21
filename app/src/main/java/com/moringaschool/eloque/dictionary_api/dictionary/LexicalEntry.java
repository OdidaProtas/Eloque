
package com.moringaschool.eloque.dictionary_api.dictionary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LexicalEntry {

    @SerializedName("derivatives")
    @Expose
    private List<Derivative> derivatives = null;
    @SerializedName("entries")
    @Expose
    private List<Entry> entries = null;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("lexicalCategory")
    @Expose
    private LexicalCategory lexicalCategory;
    @SerializedName("pronunciations")
    @Expose
    private List<Pronunciation> pronunciations = null;
    @SerializedName("text")
    @Expose
    private String text;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LexicalEntry() {
    }

    /**
     * 
     * @param derivatives
     * @param entries
     * @param lexicalCategory
     * @param language
     * @param text
     * @param pronunciations
     */
    public LexicalEntry(List<Derivative> derivatives, List<Entry> entries, String language, LexicalCategory lexicalCategory, List<Pronunciation> pronunciations, String text) {
        super();
        this.derivatives = derivatives;
        this.entries = entries;
        this.language = language;
        this.lexicalCategory = lexicalCategory;
        this.pronunciations = pronunciations;
        this.text = text;
    }

    public List<Derivative> getDerivatives() {
        return derivatives;
    }

    public void setDerivatives(List<Derivative> derivatives) {
        this.derivatives = derivatives;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LexicalCategory getLexicalCategory() {
        return lexicalCategory;
    }

    public void setLexicalCategory(LexicalCategory lexicalCategory) {
        this.lexicalCategory = lexicalCategory;
    }

    public List<Pronunciation> getPronunciations() {
        return pronunciations;
    }

    public void setPronunciations(List<Pronunciation> pronunciations) {
        this.pronunciations = pronunciations;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
