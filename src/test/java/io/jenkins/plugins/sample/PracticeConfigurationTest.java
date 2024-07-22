package io.jenkins.plugins.sample;

import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import hudson.Extension;
import hudson.ExtensionList;
import hudson.util.FormValidation;
import jenkins.model.GlobalConfiguration;

import static org.junit.jupiter.api.Assertions.*;

public class PracticeConfigurationTest {

    @Rule
    public JenkinsRule jenkins = new JenkinsRule();
    String testDescription = "camelCase";

    @Test
    public void formValidationTest() {

        PracticeConfiguration practiceConfig = GlobalConfiguration.all().get(PracticeConfiguration.class);

        FormValidation result = practiceConfig.doCheckDescription(testDescription);
        assertEquals(FormValidation.Kind.ERROR, result.kind);
        assertEquals(PracticeConfiguration.VALIDATION_ERROR_MESSAGE, result.getMessage());
    }

    @Test
    public void test1(){
        ExtensionList.lookupSingleton(PracticeConfiguration.class);
        ExtensionList.lookup(GlobalConfiguration.class);


    }

    @Test
    public void descriptionValidationLowerCaseTest(){
        boolean isValid = PracticeConfiguration.descriptionValidation(testDescription.toLowerCase());
        assertFalse(isValid);
    }

    @Test
    public void descriptionValidationUpperCaseTest(){
        boolean isValid = PracticeConfiguration.descriptionValidation(testDescription.toUpperCase());
        assertTrue(isValid);
    }

    @Test
    public void descriptionValidationCamelCaseTest(){
        boolean isValid = PracticeConfiguration.descriptionValidation(testDescription);
        assertFalse(isValid);
    }

    @Test
    public void descriptionValidationSpaceTest(){
        boolean isValid = PracticeConfiguration.descriptionValidation("  ");
        assertTrue(isValid);
    }



}