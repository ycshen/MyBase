package com.brp.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.brp.entity.Area;
import com.brp.entity.Province;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: PositionMapper.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Repository
public interface AreaMapper {
	void insertArea(Area area);
	List<Area> getAreaListByCityId(String cityId);
}

