
package com.moringaschool.eloque.dictionary_api.dictionary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThesaurusLink {

    @SerializedName("entry_id")
    @Expose
    private String entryId;
    @SerializedName("sense_id")
    @Expose
    private String senseId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ThesaurusLink() {
    }

    /**
     * 
     * @param senseId
     * @param entryId
     */
    public ThesaurusLink(String entryId, String senseId) {
        super();
        this.entryId = entryId;
        this.senseId = senseId;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public String getSenseId() {
        return senseId;
    }

    public void setSenseId(String senseId) {
        this.senseId = senseId;
    }

}
