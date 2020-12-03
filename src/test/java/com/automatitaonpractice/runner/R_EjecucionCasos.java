package com.automatitaonpractice.runner;
import java.io.IOException;

import org.junit.runner.RunWith;
import com.aut.project.bdd.datadriven.BeforeSuite;
import com.aut.project.bdd.datadriven.DatosAlFeature;
import com.aut.project.bdd.datadriven.RunnerPersonalizado;

import io.cucumber.junit.CucumberOptions;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(plugin = { "pretty", "html:target/site/cucumber-pretty",
		"json:target/cucumber.json" }, features = "src/test/resources/features", glue = {
				"com.automatitaonpractice.stepdefinition" }, monochrome = false, tags = "@EjecucionCasos")
public class R_EjecucionCasos {

	@BeforeSuite
	public static void test() throws IOException {
		DatosAlFeature.overrideFeatureFiles(
				/* featuresDirectoryPath */"./src/test/resources/features/RegistroUsuarioYNuevaEtiqueta.feature");
	}
}
