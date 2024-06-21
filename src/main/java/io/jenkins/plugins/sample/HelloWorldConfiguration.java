package io.jenkins.plugins.sample;

import hudson.Extension;
import hudson.util.FormValidation;
import jenkins.model.GlobalConfiguration;

@Extension
public class HelloWorldConfiguration extends GlobalConfiguration {
    private String name;
    private String description;

    public HelloWorldConfiguration() {
        load();
    }

    public HelloWorldConfiguration(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        save();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        save();
    }

    public FormValidation inputValidator(){
        return null;
    }
}
