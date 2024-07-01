package io.jenkins.plugins.sample;

import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;

import net.sf.json.JSONObject;

import hudson.Extension;
import hudson.util.FormValidation;
import jenkins.model.GlobalConfiguration;

@Extension
public class PracticeConfiguration extends GlobalConfiguration {
    private String name;
    private String description;

    public PracticeConfiguration() {
        load();
    }

    public PracticeConfiguration(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if(!descriptionValidation(description)){
            save();
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        save();
    }

    public FormValidation doCheckDescription(@QueryParameter String description) {
        if(!descriptionValidation(description)){
            return FormValidation.error("Only uppercase characters allowed.");
        }
        return FormValidation.ok();
    }

//    @Override
//    public boolean configure(StaplerRequest req, JSONObject json) throws FormException {
//        req.bindJSON(this, json);
//        if(!descriptionValidation(description)){
//            save();
//        }
//        return true;
//    }

    private boolean descriptionValidation(String desc){
        for (int i = 0; i < desc.length(); i++) {
            char ch = desc.charAt(i);
            if (Character.isSpaceChar(ch) || (Character.isLetter(ch) && Character.isUpperCase(ch))) {
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
