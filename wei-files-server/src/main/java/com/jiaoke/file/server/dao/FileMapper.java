package com.jiaoke.file.server.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiaoke.file.server.po.entity.BaseFileInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper extends BaseMapper<BaseFileInfo> {
}
