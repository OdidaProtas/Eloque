
package com.moringaschool.eloque.dictionary_api.dictionary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Subsense {

    @SerializedName("definitions")
    @Expose
    private List<String> definitions = null;
    @SerializedName("domains")
    @Expose
    private List<Domain_> domains = null;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("shortDefinitions")
    @Expose
    private List<String> shortDefinitions = null;
    @SerializedName("examples")
    @Expose
    private List<Example> examples = null;
    @SerializedName("notes")
    @Expose
    private List<Note> notes = null;
    @SerializedName("thesaurusLinks")
    @Expose
    private List<ThesaurusLink> thesaurusLinks = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Subsense() {
    }

    /**
     * 
     * @param notes
     * @param examples
     * @param shortDefinitions
     * @param domains
     * @param id
     * @param thesaurusLinks
     * @param definitions
     */
    public Subsense(List<String> definitions, List<Domain_> domains, String id, List<String> shortDefinitions, List<Example> examples, List<Note> notes, List<ThesaurusLink> thesaurusLinks) {
        super();
        this.definitions = definitions;
        this.domains = domains;
        this.id = id;
        this.shortDefinitions = shortDefinitions;
        this.examples = examples;
        this.notes = notes;
        this.thesaurusLinks = thesaurusLinks;
    }

    public List<String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }

    public List<Domain_> getDomains() {
        return domains;
    }

    public void setDomains(List<Domain_> domains) {
        this.domains = domains;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getShortDefinitions() {
        return shortDefinitions;
    }

    public void setShortDefinitions(List<String> shortDefinitions) {
        this.shortDefinitions = shortDefinitions;
    }

    public List<Example> getExamples() {
        return examples;
    }

    public void setExamples(List<Example> examples) {
        this.examples = examples;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<ThesaurusLink> getThesaurusLinks() {
        return thesaurusLinks;
    }

    public void setThesaurusLinks(List<ThesaurusLink> thesaurusLinks) {
        this.thesaurusLinks = thesaurusLinks;
    }

}
