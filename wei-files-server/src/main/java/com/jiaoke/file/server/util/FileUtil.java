package com.jiaoke.file.server.util;



import cn.hutool.core.util.StrUtil;

import java.util.UUID;

public class FileUtil {

    public static String generateFileName() {
        // 生成 UUID
        UUID uuid = UUID.randomUUID();
        // 将 UUID 转换为字符串，并去掉横线
        String uuidStr = uuid.toString().replace("-", "");
        // 返回随机生成的文件名
        return uuidStr;
    }
    public static String getExtension(String realName){

        String fileExtension = null;
        if (!StrUtil.isEmpty(realName) && !StrUtil.isBlankOrUndefined(realName)){
            int i = realName.lastIndexOf(".");
             fileExtension = realName.substring(i + 1);
        }
        return fileExtension;
    }
}
