package com.rhc.insurance;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

/**
 * 
 * 
 * @author bmeisele
 * 
 */
@RunWith(Cucumber.class)
@Cucumber.Options(features = { "src/test/resources" }, format = {
		"json:target/cucumber.json", "html:target/cucumber" })
public class RunCukesTest {
}
