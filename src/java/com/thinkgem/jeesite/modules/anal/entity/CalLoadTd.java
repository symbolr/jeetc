/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.anal.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 负荷分析Entity
 * @author 沈波
 * @version 2017-06-02
 */
public class CalLoadTd extends DataEntity<CalLoadTd> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String max;		// 最大负荷值
	private String min;		// 最小负荷值
	private String avg;		// 平均荷值
	
	public CalLoadTd() {
		super();
	}

	public CalLoadTd(String id){
		super(id);
	}

	@Length(min=0, max=100, message="名称长度必须介于 0 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=100, message="最大负荷值长度必须介于 0 和 100 之间")
	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}
	
	@Length(min=0, max=100, message="最小负荷值长度必须介于 0 和 100 之间")
	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}
	
	@Length(min=0, max=100, message="平均荷值长度必须介于 0 和 100 之间")
	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}
	
}