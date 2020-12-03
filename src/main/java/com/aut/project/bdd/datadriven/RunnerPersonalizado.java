package com.aut.project.bdd.datadriven;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.apache.logging.log4j.LogManager;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.logging.log4j.Logger;

public class RunnerPersonalizado extends Runner {

	public static final Logger logger = LogManager.getLogger(RunnerPersonalizado.class.getName());
	private Class<CucumberWithSerenity> classValue = null;
	private CucumberWithSerenity cucumberWithSerenity = null;

	/**
	 * @param classValue
	 * @throws IOException
	 * @throws InitializationError
	 */
	public RunnerPersonalizado(Class<CucumberWithSerenity> classValue) throws IOException, InitializationError {
		this.classValue = classValue;
		cucumberWithSerenity = new CucumberWithSerenity(classValue);
	}

	@Override
	public Description getDescription() {
		return cucumberWithSerenity.getDescription();
	}

	/**
	 * @param annotation
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private void runAnnotatedMethods(Class<?> annotation) throws InvocationTargetException, IllegalAccessException {
		if (!annotation.isAnnotation()) {
			return;
		}
		Method[] methods = this.classValue.getMethods();
		for (Method method : methods) {
			Annotation[] annotations = method.getAnnotations();
			for (Annotation item : annotations) {
				if (item.annotationType().equals(annotation)) {
					method.invoke(null);
					break;
				}
			}
		}
	}

	@Override
	public void run(RunNotifier notifier) {
		try {
			runAnnotatedMethods(BeforeSuite.class);
			cucumberWithSerenity = new CucumberWithSerenity(classValue);
		} catch (Exception e) {
			logger.info(e);
		}
		cucumberWithSerenity.run(notifier);
	}
}
