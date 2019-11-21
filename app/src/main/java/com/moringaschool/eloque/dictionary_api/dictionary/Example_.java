
package com.moringaschool.eloque.dictionary_api.dictionary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example_ {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("notes")
    @Expose
    private List<Note_> notes = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Example_() {
    }

    /**
     * 
     * @param notes
     * @param text
     */
    public Example_(String text, List<Note_> notes) {
        super();
        this.text = text;
        this.notes = notes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Note_> getNotes() {
        return notes;
    }

    public void setNotes(List<Note_> notes) {
        this.notes = notes;
    }

}
