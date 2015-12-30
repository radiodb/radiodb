package io.really.model;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.function.Consumer;

public interface OnGet {
    void onGet(String auth, String obj, Consumer<ScriptObjectMirror> hide);
}
