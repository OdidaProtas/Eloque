package com.moringaschool.eloque.models;

import org.parceler.Parcel;

import java.util.ArrayList;


@Parcel
public class Projects {
    String projectTitle;
    String category;
    String description;
    String level;
    String requirements;
    String offerInKes;
    boolean isAvailable;
    String postedByName;
    String postedbyEmail;
    String pushId;
    String color;

    ArrayList<Projects> allProjects = new ArrayList<Projects>();

    public  Projects(){

    }

    public Projects(String projectTitle, String category, String description, String level, String requirements, String offerInKes, String postedByName, String postedByEmail) {
        this.projectTitle = projectTitle;
        this.category = category;
        this.description = description;
        this.level = level;
        this.requirements = requirements;
        this.offerInKes = offerInKes;
        isAvailable = true;
        this.postedByName = postedByName;
        this.postedbyEmail = postedByEmail;
        allProjects.add(this);
    }


    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getOfferInKes() {
        return offerInKes;
    }

    public void setOfferInKes(String offerInKes) {
        this.offerInKes = offerInKes;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getPostedBy() {
        return postedByName;
    }

    public void setPostedBy(String postedBy) {
        this.postedByName = postedBy;
    }

    public String getPostedbyEmail() {
        return postedbyEmail;
    }

    public void setPostedbyEmail(String postedbyEmail) {
        this.postedbyEmail = postedbyEmail;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
