
package com.moringaschool.eloque.dictionary_api.dictionary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sense {

    @SerializedName("definitions")
    @Expose
    private List<String> definitions = null;
    @SerializedName("domains")
    @Expose
    private List<Domain> domains = null;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("shortDefinitions")
    @Expose
    private List<String> shortDefinitions = null;
    @SerializedName("subsenses")
    @Expose
    private List<Subsense> subsenses = null;
    @SerializedName("thesaurusLinks")
    @Expose
    private List<ThesaurusLink_> thesaurusLinks = null;
    @SerializedName("examples")
    @Expose
    private List<Example_> examples = null;
    @SerializedName("registers")
    @Expose
    private List<Register> registers = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Sense() {
    }

    /**
     * 
     * @param examples
     * @param shortDefinitions
     * @param domains
     * @param registers
     * @param id
     * @param thesaurusLinks
     * @param definitions
     * @param subsenses
     */
    public Sense(List<String> definitions, List<Domain> domains, String id, List<String> shortDefinitions, List<Subsense> subsenses, List<ThesaurusLink_> thesaurusLinks, List<Example_> examples, List<Register> registers) {
        super();
        this.definitions = definitions;
        this.domains = domains;
        this.id = id;
        this.shortDefinitions = shortDefinitions;
        this.subsenses = subsenses;
        this.thesaurusLinks = thesaurusLinks;
        this.examples = examples;
        this.registers = registers;
    }

    public List<String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }

    public List<Domain> getDomains() {
        return domains;
    }

    public void setDomains(List<Domain> domains) {
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

    public List<Subsense> getSubsenses() {
        return subsenses;
    }

    public void setSubsenses(List<Subsense> subsenses) {
        this.subsenses = subsenses;
    }

    public List<ThesaurusLink_> getThesaurusLinks() {
        return thesaurusLinks;
    }

    public void setThesaurusLinks(List<ThesaurusLink_> thesaurusLinks) {
        this.thesaurusLinks = thesaurusLinks;
    }

    public List<Example_> getExamples() {
        return examples;
    }

    public void setExamples(List<Example_> examples) {
        this.examples = examples;
    }

    public List<Register> getRegisters() {
        return registers;
    }

    public void setRegisters(List<Register> registers) {
        this.registers = registers;
    }

}
