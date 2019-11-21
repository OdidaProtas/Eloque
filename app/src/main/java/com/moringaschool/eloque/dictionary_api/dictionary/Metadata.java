
package com.moringaschool.eloque.dictionary_api.dictionary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metadata {

    @SerializedName("operation")
    @Expose
    private String operation;
    @SerializedName("provider")
    @Expose
    private String provider;
    @SerializedName("schema")
    @Expose
    private String schema;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Metadata() {
    }

    /**
     * 
     * @param schema
     * @param provider
     * @param operation
     */
    public Metadata(String operation, String provider, String schema) {
        super();
        this.operation = operation;
        this.provider = provider;
        this.schema = schema;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

}
