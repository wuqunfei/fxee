package org.javafxee.util;

/**
 * Created by wuqunfei on 16/1/9.
 */
public class MyMessage {
    private String id;
    private String message;
    public boolean isUsed;

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
