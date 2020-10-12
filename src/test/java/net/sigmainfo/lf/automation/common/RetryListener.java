package net.sigmainfo.lf.automation.common;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by           : Shaishav.s on 18-04-2018.
 * Test class           : RetryListener.java
 * Description          : RetryListener
 */
public class RetryListener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation testannotation, Class testClass,
                          Constructor testConstructor, Method testMethod)	{
        IRetryAnalyzer retry = testannotation.getRetryAnalyzer();

        if (retry == null)	{
            testannotation.setRetryAnalyzer(Retry.class);
        }

    }

}
