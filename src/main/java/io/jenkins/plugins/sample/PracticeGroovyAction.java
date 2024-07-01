package io.jenkins.plugins.sample;

public class PracticeGroovyAction extends PracticeAction {

    @Override
    public String getIconFileName() {
        return "star";
    }

    @Override
    public String getDisplayName() {
        return "Hello from Groovy";
    }

    @Override
    public String getUrlName() {
        return "hiGroovy";
    }
}
