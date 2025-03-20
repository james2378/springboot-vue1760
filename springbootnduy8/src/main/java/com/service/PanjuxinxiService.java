package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PanjuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PanjuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PanjuxinxiView;


/**
 * 番剧信息
 *
 * @author 
 * @email 
 * @date 2023-04-28 15:29:41
 */
public interface PanjuxinxiService extends IService<PanjuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PanjuxinxiVO> selectListVO(Wrapper<PanjuxinxiEntity> wrapper);
   	
   	PanjuxinxiVO selectVO(@Param("ew") Wrapper<PanjuxinxiEntity> wrapper);
   	
   	List<PanjuxinxiView> selectListView(Wrapper<PanjuxinxiEntity> wrapper);
   	
   	PanjuxinxiView selectView(@Param("ew") Wrapper<PanjuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PanjuxinxiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<PanjuxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<PanjuxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<PanjuxinxiEntity> wrapper);



}

