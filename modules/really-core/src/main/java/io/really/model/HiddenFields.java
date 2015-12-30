package io.really.model;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import io.really.js.InternalSDKException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class HiddenFields {
    private ArrayList<String> hiddenFields = new ArrayList<>();
    public Consumer<ScriptObjectMirror> hide = fields -> {
        for (Object f: fields.values()) {
           if (!(f instanceof String)) {
             throw new InternalSDKException("hide() expects strings only.");
           }
            hiddenFields.add((String) f);
        }
    };
    public String[] getHiddenFields() {
        String[] fieldsArray = new String[hiddenFields.size()];
        return hiddenFields.toArray(fieldsArray);
    }
}
