package com.crm.mapper;

import com.crm.domain.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Position record);

    Position selectByPrimaryKey(Long id);

    List<Position> selectAll(@Param("keyword") String keyword);

    int updateByPrimaryKey(Position record);
}