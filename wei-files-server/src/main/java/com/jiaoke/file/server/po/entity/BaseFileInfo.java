package com.jiaoke.file.server.po.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author jrj
 * @since 2023-06-19
 */
@TableName("base_file_info")
@ApiModel(value = "BaseFileInfo对象", description = "")
public class BaseFileInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String fileId;

    private String fileLocation;

    private String fileRealName;

    private String generatorFileName;

    private LocalDateTime createTime;

    private String creator;

    private LocalDateTime updateTime;

    private String updater;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getFileRealName() {
        return fileRealName;
    }

    public void setFileRealName(String fileRealName) {
        this.fileRealName = fileRealName;
    }

    public String getGeneratorFileName() {
        return generatorFileName;
    }

    public void setGeneratorFileName(String generatorFileName) {
        this.generatorFileName = generatorFileName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    @Override
    public String toString() {
        return "BaseFileInfo{" +
        "id=" + id +
        ", fileId=" + fileId +
        ", fileLocation=" + fileLocation +
        ", fileRealName=" + fileRealName +
        ", generatorFileName=" + generatorFileName +
        ", createTime=" + createTime +
        ", creator=" + creator +
        ", updateTime=" + updateTime +
        ", updater=" + updater +
        "}";
    }
}
