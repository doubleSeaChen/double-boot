package com.system.service;

import com.common.tool.Tree;
import com.system.domain.DeptDO;
import java.util.List;
import java.util.Map;

/**
 * 部门管理
 * @author doublesea
 */
public interface DeptService {
	
	DeptDO get(String id);
	
	List<DeptDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DeptDO dept);
	
	int update(DeptDO dept);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	Tree<DeptDO> getTree();
}
