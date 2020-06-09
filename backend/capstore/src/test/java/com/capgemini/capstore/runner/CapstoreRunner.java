package com.capgemini.capstore.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "feature", glue = { "com.capgemini.capstore" })
public class CapstoreRunner {

}
