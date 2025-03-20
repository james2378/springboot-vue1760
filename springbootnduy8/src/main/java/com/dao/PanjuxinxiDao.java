package com.dao;

import com.entity.PanjuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PanjuxinxiVO;
import com.entity.view.PanjuxinxiView;


/**
 * 番剧信息
 * 
 * @author 
 * @email 
 * @date 2023-04-28 15:29:41
 */
public interface PanjuxinxiDao extends BaseMapper<PanjuxinxiEntity> {
	
	List<PanjuxinxiVO> selectListVO(@Param("ew") Wrapper<PanjuxinxiEntity> wrapper);
	
	PanjuxinxiVO selectVO(@Param("ew") Wrapper<PanjuxinxiEntity> wrapper);
	
	List<PanjuxinxiView> selectListView(@Param("ew") Wrapper<PanjuxinxiEntity> wrapper);

	List<PanjuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<PanjuxinxiEntity> wrapper);
	
	PanjuxinxiView selectView(@Param("ew") Wrapper<PanjuxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<PanjuxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<PanjuxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<PanjuxinxiEntity> wrapper);



}
