package com.jiaoke.file.server.enums;

public enum FileType {
    JPG("jpg"), //  FileType JPG= new FileType
    PNG("png"),
    GIF("gif"),
    PDF("pdf");

    private String suffix;

    FileType(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffix() {
        return suffix;
    }

}
