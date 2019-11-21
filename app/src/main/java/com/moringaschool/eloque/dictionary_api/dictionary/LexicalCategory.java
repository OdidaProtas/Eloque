
package com.moringaschool.eloque.dictionary_api.dictionary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LexicalCategory {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("text")
    @Expose
    private String text;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LexicalCategory() {
    }

    /**
     * 
     * @param id
     * @param text
     */
    public LexicalCategory(String id, String text) {
        super();
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
