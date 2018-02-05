/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.anal.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.anal.entity.CalLoadTd;
import com.thinkgem.jeesite.modules.anal.dao.CalLoadTdDao;

/**
 * 负荷分析Service
 * @author 沈波
 * @version 2017-06-02
 */
@Service
@Transactional(readOnly = true)
public class CalLoadTdService extends CrudService<CalLoadTdDao, CalLoadTd> {

	public CalLoadTd get(String id) {
		return super.get(id);
	}
	
	public List<CalLoadTd> findList(CalLoadTd calLoadTd) {
		return super.findList(calLoadTd);
	}
	
	public Page<CalLoadTd> findPage(Page<CalLoadTd> page, CalLoadTd calLoadTd) {
		return super.findPage(page, calLoadTd);
	}
	
	@Transactional(readOnly = false)
	public void save(CalLoadTd calLoadTd) {
		super.save(calLoadTd);
	}
	
	@Transactional(readOnly = false)
	public void delete(CalLoadTd calLoadTd) {
		super.delete(calLoadTd);
	}
	
}