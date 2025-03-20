package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.PanjuxinxiDao;
import com.entity.PanjuxinxiEntity;
import com.service.PanjuxinxiService;
import com.entity.vo.PanjuxinxiVO;
import com.entity.view.PanjuxinxiView;

@Service("panjuxinxiService")
public class PanjuxinxiServiceImpl extends ServiceImpl<PanjuxinxiDao, PanjuxinxiEntity> implements PanjuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PanjuxinxiEntity> page = this.selectPage(
                new Query<PanjuxinxiEntity>(params).getPage(),
                new EntityWrapper<PanjuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PanjuxinxiEntity> wrapper) {
		  Page<PanjuxinxiView> page =new Query<PanjuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PanjuxinxiVO> selectListVO(Wrapper<PanjuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PanjuxinxiVO selectVO(Wrapper<PanjuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PanjuxinxiView> selectListView(Wrapper<PanjuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PanjuxinxiView selectView(Wrapper<PanjuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<PanjuxinxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<PanjuxinxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<PanjuxinxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
