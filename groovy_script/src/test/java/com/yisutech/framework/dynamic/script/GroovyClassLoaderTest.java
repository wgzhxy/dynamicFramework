package com.yisutech.framework.dynamic.script;

import groovy.lang.GroovyClassLoader;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

public class GroovyClassLoaderTest {

    @Test
    public void testGroovyClassLoader() {

        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        Class<?> footCalss = groovyClassLoader.parseClass("class Foo { def doIt() { \"ok\" } }");

        try {
            Object obj = footCalss.newInstance();
            Method Method = footCalss.getMethod("doIt", null);
            String result = (String) Method.invoke(obj, null);

            Assert.assertTrue(result.equals("ok"));

        } catch (Throwable e) {
            Assert.fail();
        }
    }
}
