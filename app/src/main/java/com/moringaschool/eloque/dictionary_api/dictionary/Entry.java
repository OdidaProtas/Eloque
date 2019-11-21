
package com.moringaschool.eloque.dictionary_api.dictionary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Entry {

    @SerializedName("etymologies")
    @Expose
    private List<String> etymologies = null;
    @SerializedName("senses")
    @Expose
    private List<Sense> senses = null;
    @SerializedName("grammaticalFeatures")
    @Expose
    private List<GrammaticalFeature> grammaticalFeatures = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Entry() {
    }

    /**
     * 
     * @param grammaticalFeatures
     * @param senses
     * @param etymologies
     */
    public Entry(List<String> etymologies, List<Sense> senses, List<GrammaticalFeature> grammaticalFeatures) {
        super();
        this.etymologies = etymologies;
        this.senses = senses;
        this.grammaticalFeatures = grammaticalFeatures;
    }

    public List<String> getEtymologies() {
        return etymologies;
    }

    public void setEtymologies(List<String> etymologies) {
        this.etymologies = etymologies;
    }

    public List<Sense> getSenses() {
        return senses;
    }

    public void setSenses(List<Sense> senses) {
        this.senses = senses;
    }

    public List<GrammaticalFeature> getGrammaticalFeatures() {
        return grammaticalFeatures;
    }

    public void setGrammaticalFeatures(List<GrammaticalFeature> grammaticalFeatures) {
        this.grammaticalFeatures = grammaticalFeatures;
    }

}
