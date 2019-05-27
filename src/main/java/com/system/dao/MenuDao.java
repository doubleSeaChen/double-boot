package com.system.dao;


import java.util.List;
import java.util.Map;

import com.system.domain.MenuDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author doublesea
 */
@Mapper
public interface MenuDao {

	MenuDO get(String id);
	
	List<MenuDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MenuDO menu);
	
	int update(MenuDO menu);
	
	int remove(String id);
	
	int batchRemove(String[] ids);

	List<String> listUserPerms(String id);

	List<MenuDO> listByUserId(String id);

	List<MenuDO> listOfNoButton(Map<String, Object> map);
}
