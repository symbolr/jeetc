/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.anal.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.anal.entity.CalLoadTd;

/**
 * 负荷分析DAO接口
 * @author 沈波
 * @version 2017-06-02
 */
@MyBatisDao
public interface CalLoadTdDao extends CrudDao<CalLoadTd> {
	
}