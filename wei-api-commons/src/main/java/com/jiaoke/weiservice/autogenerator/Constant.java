package com.jiaoke.weiservice.autogenerator;

public enum Constant {
    GLOBAL_CONFIG_OUT_DIR("E:\\JIAO-PERSONAL-PROJECT\\wei-service\\wei-api-commons\\src\\main\\java\\com\\jiaoke\\weiservice\\autogenerator\\out"),
    ENTITY_OUT_DIR("E:\\JIAO-PERSONAL-PROJECT\\wei-service\\wei-api-commons\\src\\main\\java\\com\\jiaoke\\weiservice\\autogenerator\\out"),
    MAPPER_OUT_DIR("E:\\JIAO-PERSONAL-PROJECT\\wei-service\\wei-api-commons\\src\\main\\java\\com\\jiaoke\\weiservice\\autogenerator\\out");

    private String realPath;

    Constant(String s) {
        this.realPath = s;
    }

    public String getRealPath() {
        return realPath;
    }

    public void setRealPath(String realPath) {
        this.realPath = realPath;
    }

    public static void main(String[] args) {
        Constant entity_out_dir = Constant.valueOf("ENTITY_OUT_DIR");
        System.out.println(entity_out_dir.getRealPath());
    }
}
