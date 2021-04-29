package ru.job4j.pooh;

public class Req {

    private static String id;
    private final String method;
    private final String mode;
    private final String text;
    private final String nameType;

    private Req(String method, String mode, String text, String nameType) {
        this.method = method;
        this.mode = mode;
        this.text = text;
        this.nameType = nameType;
    }

    public static Req of(String content) {
        String method, text;
        String mode = null;
        String nameType = null;
        text = content;
        String[] reqParam = content.split(" ");
        method = reqParam[0];
        String[] modeAndNameType = reqParam[1].split("/");
        if (modeAndNameType.length > 2) {
            mode = modeAndNameType[1];
            nameType = modeAndNameType[2];
        }
        if (modeAndNameType.length > 3) {
            id = modeAndNameType[3];
        }
        return new Req(method, mode, text, nameType);
    }

    public String method() {
        return method;
    }

    public String mode() {
        return mode;
    }

    public String text() {
        return text;
    }

    public String nameType() {
        return nameType;
    }

    public String id() {
        return id;
    }
}
