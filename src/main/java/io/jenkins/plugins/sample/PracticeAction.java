package io.jenkins.plugins.sample;

import hudson.model.Action;

public class PracticeAction implements Action {


    @Override
    public String getIconFileName() {
        return "notepad";
    }

    @Override
    public String getDisplayName() {
        return "Hello";
    }

    @Override
    public String getUrlName() {
        return "hello";
    }
}
