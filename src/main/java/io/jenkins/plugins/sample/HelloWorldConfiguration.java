package io.jenkins.plugins.sample;

import hudson.Extension;
import jenkins.model.GlobalConfiguration;

@Extension
public class HelloWorldConfiguration extends GlobalConfiguration {
    private String name;
    private String description;

    public HelloWorldConfiguration(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
