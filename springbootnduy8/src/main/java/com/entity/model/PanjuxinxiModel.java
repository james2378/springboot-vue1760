package com.entity.model;

import com.entity.PanjuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 番剧信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-04-28 15:29:41
 */
public class PanjuxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 标题
	 */
	
	private String biaoti;
		
	/**
	 * 子标题
	 */
	
	private String zibiaoti;
		
	/**
	 * 评分
	 */
	
	private String pingfen;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 选集
	 */
	
	private String xuanji;
		
	/**
	 * epid
	 */
	
	private String epid;
		
	/**
	 * 评价
	 */
	
	private String pingjia;
		
	/**
	 * 播放量
	 */
	
	private Integer bofangliang;
		
	/**
	 * 弹幕量
	 */
	
	private Integer danmu;
		
	/**
	 * 评分人数
	 */
	
	private Integer pfrs;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
				
	
	/**
	 * 设置：标题
	 */
	 
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	
	/**
	 * 获取：标题
	 */
	public String getBiaoti() {
		return biaoti;
	}
				
	
	/**
	 * 设置：子标题
	 */
	 
	public void setZibiaoti(String zibiaoti) {
		this.zibiaoti = zibiaoti;
	}
	
	/**
	 * 获取：子标题
	 */
	public String getZibiaoti() {
		return zibiaoti;
	}
				
	
	/**
	 * 设置：评分
	 */
	 
	public void setPingfen(String pingfen) {
		this.pingfen = pingfen;
	}
	
	/**
	 * 获取：评分
	 */
	public String getPingfen() {
		return pingfen;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：选集
	 */
	 
	public void setXuanji(String xuanji) {
		this.xuanji = xuanji;
	}
	
	/**
	 * 获取：选集
	 */
	public String getXuanji() {
		return xuanji;
	}
				
	
	/**
	 * 设置：epid
	 */
	 
	public void setEpid(String epid) {
		this.epid = epid;
	}
	
	/**
	 * 获取：epid
	 */
	public String getEpid() {
		return epid;
	}
				
	
	/**
	 * 设置：评价
	 */
	 
	public void setPingjia(String pingjia) {
		this.pingjia = pingjia;
	}
	
	/**
	 * 获取：评价
	 */
	public String getPingjia() {
		return pingjia;
	}
				
	
	/**
	 * 设置：播放量
	 */
	 
	public void setBofangliang(Integer bofangliang) {
		this.bofangliang = bofangliang;
	}
	
	/**
	 * 获取：播放量
	 */
	public Integer getBofangliang() {
		return bofangliang;
	}
				
	
	/**
	 * 设置：弹幕量
	 */
	 
	public void setDanmu(Integer danmu) {
		this.danmu = danmu;
	}
	
	/**
	 * 获取：弹幕量
	 */
	public Integer getDanmu() {
		return danmu;
	}
				
	
	/**
	 * 设置：评分人数
	 */
	 
	public void setPfrs(Integer pfrs) {
		this.pfrs = pfrs;
	}
	
	/**
	 * 获取：评分人数
	 */
	public Integer getPfrs() {
		return pfrs;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
			
}
