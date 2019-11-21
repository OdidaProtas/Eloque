
package com.moringaschool.eloque.dictionary_api.dictionary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OxfordSearchResponse {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("word")
    @Expose
    private String word;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OxfordSearchResponse() {
    }

    /**
     * 
     * @param metadata
     * @param id
     * @param results
     * @param word
     */
    public OxfordSearchResponse(String id, Metadata metadata, List<Result> results, String word) {
        super();
        this.id = id;
        this.metadata = metadata;
        this.results = results;
        this.word = word;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

}
