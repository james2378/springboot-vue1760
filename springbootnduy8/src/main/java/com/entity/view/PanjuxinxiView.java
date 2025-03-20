package com.entity.view;

import com.entity.PanjuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 番剧信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-28 15:29:41
 */
@TableName("panjuxinxi")
public class PanjuxinxiView  extends PanjuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PanjuxinxiView(){
	}
 
 	public PanjuxinxiView(PanjuxinxiEntity panjuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, panjuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
