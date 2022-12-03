package com.example.SpringUnitTestLearning;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;

public class FindSlowTestExtension implements AfterTestExecutionCallback, BeforeTestExecutionCallback {
    private long THRESHOLD = 1000L;
    public FindSlowTestExtension( long threshold ){
        this.THRESHOLD = threshold;
    }
    //Save current time in Context.Store
    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        //Get Annotation if exist
        Method requiredTestMethod = context.getRequiredTestMethod();
        SlowTest annotation = requiredTestMethod.getAnnotation(SlowTest.class);
        //Get name of class and method
        String testClassname = context.getRequiredTestClass().getName();
        String testMethodName = context.getRequiredTestMethod().getName();
        ExtensionContext.Store store = context.getStore(ExtensionContext.Namespace.create(testClassname, testMethodName));
        long start_time = store.remove("START_TIME", long.class);
        long duration = System.currentTimeMillis() - start_time;
        if(duration > THRESHOLD && annotation == null){
            System.out.printf("Please considr mark method [%s] with @SlowTest\n", testMethodName);
        }
    }
    //Get starting time from Context.Store and get duration. If the duration is long enough then print message to mark test method with @SlowTest
    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        String testClassname = context.getRequiredTestClass().getName();
        String testMethodName = context.getRequiredTestMethod().getName();
        ExtensionContext.Store store = context.getStore(ExtensionContext.Namespace.create(testClassname, testMethodName));
        store.put("START_TIME",System.currentTimeMillis());
    }
}
