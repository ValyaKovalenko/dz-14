package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Config {
    static final private List<Param> _paramsList = new LinkedList<>();
    static final public Param WEB_BROWSER = new Param("web.browser", "chrome", true);

    static {
        InitErrors.showErrors();
    }

    final static public class Param {
        final public String name;
        final public String value;

        public Param(String name) {
            this(name, null, false);
        }

        public Param(String name, String defaultValue) {
            this(name, defaultValue, false);
        }

        public Param(String name, String defaultValue, boolean isSys) {
            this.name = name;
            String tmpVal = null;
            if (isSys) {
                tmpVal = System.getProperty(name);
                if (tmpVal == null)
                    tmpVal = System.getenv(name);
            }
        //    if (tmpVal == null)
         //       tmpVal = getEnvProperties().getProperty(name);
            if (tmpVal == null)
                tmpVal = defaultValue;
            if (tmpVal == null)
                InitErrors.addError("Parameter value is not found. Parameter " + name);
            value = tmpVal;
            Config._paramsList.add(this);
        }

        public boolean isTrue() {
            return "true".equalsIgnoreCase(value);
        }

        public Integer asInt() {
            return Integer.parseInt(value);
        }
    }

    static final private class InitErrors {
        static final private List<String> _errorsList = new ArrayList<>();

        static private void addError(String errorMessage) {
            _errorsList.add(errorMessage);
        }

        static private void showErrors() {
            if (_errorsList.size() > 0) {
                throw new RuntimeException("\n" + String.join("\n", _errorsList));
            }
        }
    }

}

