package io.jenkins.plugins.sample;

import java.util.logging.Level;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;
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
    protected static final String VALIDATION_ERROR_MESSAGE = "Only uppercase characters allowed.";

    public PracticeConfiguration() {
        load();
    }

    @DataBoundConstructor
    public PracticeConfiguration(String name, String description) {
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

//    @DataBoundSetter
    public void setDescription(String description) {
        this.description = description;
    }

    public FormValidation doCheckDescription(@QueryParameter String description) {
        if(!descriptionValidation(description)){
            return FormValidation.error(VALIDATION_ERROR_MESSAGE);
        }
        return FormValidation.ok();
    }

//    @Override
//    public boolean configure(StaplerRequest req, JSONObject json) throws FormException {
//       description = json.getString("description");
//       save();
//       return super.configure(req, json);
//    }


    @Override
    public synchronized void save(){

        if(descriptionValidation(description)){
            super.save();
            System.out.println("Saving the form");
        }else{
            load();
            System.out.println("InValid input");
        }
    }

    protected static boolean descriptionValidation(String desc){
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
