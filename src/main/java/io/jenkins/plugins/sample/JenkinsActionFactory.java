package io.jenkins.plugins.sample;

import java.util.Collection;
import java.util.List;

import edu.umd.cs.findbugs.annotations.NonNull;

import hudson.Extension;
import hudson.model.Action;
import hudson.model.Job;
import jenkins.model.TransientActionFactory;

@Extension
public class JenkinsActionFactory extends TransientActionFactory<Job> {

    @Override
    public Class<Job> type() {
        return Job.class;
    }

    @NonNull
    @Override
    public Collection<? extends Action> createFor(@NonNull Job target) {
        // Register all the actions in the factory
        return List.of(new PracticeAction(), new PracticeGroovyAction());
    }
}
