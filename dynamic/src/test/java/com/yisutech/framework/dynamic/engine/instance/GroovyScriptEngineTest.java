package com.yisutech.framework.dynamic.engine.instance;

import org.junit.Assert;
import org.junit.Test;

public class GroovyScriptEngineTest {

    @Test
    public void instance() throws Exception {

        String groovyName = "test";
        String groovyScript = "def test=1111; print test;";

        GroovyScriptEngine engine = initAndReturn(groovyName, groovyScript);
        Assert.assertNotNull(engine.getInstanceObject(groovyName));
    }

    @Test
    public void run_return_not_null() throws Exception {

        String groovyName = "test";
        String groovyScript = "def test=1111; test;";

        GroovyScriptEngine engine = initAndReturn(groovyName, groovyScript);
        Assert.assertNotNull(engine.getInstanceObject(groovyName));
    }

    @Test
    public void run_return_null() throws Exception {

        String groovyName = "test";
        String groovyScript = "def test=1111; print test;";

        GroovyScriptEngine engine = initAndReturn(groovyName, groovyScript);
        Assert.assertNull(engine.run(groovyName));
    }

    private GroovyScriptEngine initAndReturn(String groovyName, String groovyScript) {

        GroovyScriptEngine engine = new GroovyScriptEngine();
        try {
            engine.instance(groovyScript, groovyName);

        } catch (Throwable e) {
            e.printStackTrace();
        }
        return engine;
    }
}