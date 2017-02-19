package com.brp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.brp.entity.MemoEntity;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: MenuMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface MemoMapper {
	void insertMemo(MemoEntity memo);
	List<MemoEntity> getMemoByUserId(Integer userId);
	List<MemoEntity> getMemoByStartAndEndTime(@Param("startTime")String startTime, @Param("endTime")String endTime);
	List<MemoEntity> getMemoList(@Param("startTime")String startTime, @Param("endTime")String endTime, @Param("userId")Integer userId);
}

