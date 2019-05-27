package com.system.service.impl;

import com.common.tool.CreateTree;
import com.common.tool.Tree;
import com.system.dao.DeptDao;
import com.system.domain.DeptDO;
import com.system.domain.MenuDO;
import com.system.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao deptDao;
	
	@Override
	public DeptDO get(String id){
		return deptDao.get(id);
	}
	
	@Override
	public List<DeptDO> list(Map<String, Object> map){
		return deptDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return deptDao.count(map);
	}
	
	@Override
	public int save(DeptDO dept){
		return deptDao.save(dept);
	}
	
	@Override
	public int update(DeptDO dept){
		return deptDao.update(dept);
	}
	
	@Override
	public int remove(String id){
		return deptDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return deptDao.batchRemove(ids);
	}

	@Override
	public Tree<DeptDO> getTree() {
		List<Tree<DeptDO>> trees = new ArrayList<Tree<DeptDO>>();
		List<DeptDO> deptDOs = deptDao.list(new HashMap<>(16));
		for (DeptDO deptDO : deptDOs) {
			Tree<DeptDO> tree = new Tree<DeptDO>();
			tree.setId(deptDO.getId().toString());
			tree.setParentId(deptDO.getParentId());
			tree.setText(deptDO.getName());
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		Tree<DeptDO> t = CreateTree.build(trees);
		return t;
	}
}
