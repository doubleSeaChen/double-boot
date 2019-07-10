package com.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.shiro.ShiroTool;
import com.common.tool.FileUtil;
import com.common.tool.MyUtils;
import com.common.tool.ParamsForMatter;
import com.common.tool.Tree;
import com.system.config.DoubleBootConfig;
import com.system.domain.DeptDO;
import com.system.domain.UserDO;
import com.system.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author doublesea
 * @date 2018-11-18 13:11:22
 */
 
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private DoubleBootConfig doubleBootConfig;
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sys:user")
	public Object list(@RequestParam Map<String, Object> params){
		ParamsForMatter currenParams = new ParamsForMatter(params);
		List<UserDO> userList = userService.list(currenParams);
		int total = userService.count(currenParams);
		Map<String, Object> data = new HashMap<>();
		data.put("userList", userList);
		data.put("total", total);
		return data;
	}

	@PostMapping("/isExist/{userName}")
	@ResponseBody
	public Object isExist(@PathVariable("userName") String userName){
		return userService.getByUserName(userName)==null?0:1;
	}

    @PostMapping("/get/{id}")
    @ResponseBody
    public Object get(@PathVariable("id") String id){
        return userService.get(id);
    }
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sys:user:add")
	public Object save(@RequestBody UserDO user){
		if(userService.save(user)>0){
			return 1;
		}else{
			return 0;
		}
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sys:user:update")
	public Object update(@RequestBody UserDO user){
		if(userService.update(user)>0){
			return 1;
		}else{
			return 0;
		}
	}

	@ResponseBody
	@RequestMapping("/personUpdate")
	@RequiresPermissions("person:msg")
	public Object personUpdate(@RequestBody UserDO user){
		if(userService.personUpdate(user)>0){
			return 1;
		}else{
			return 0;
		}
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove/{id}")
	@ResponseBody
	@RequiresPermissions("system:user:delete")
	public Object remove(@PathVariable("id") String id){
		if(userService.remove(id)>0){
			return 1;
		}else{
			return 0;
		}
	}

	@GetMapping( "/checkOldPassword")
	@ResponseBody
	@RequiresPermissions("person:pwd")
	public Object checkOldPassword(@RequestParam Map<String, Object> params){
		UserDO userDO = userService.get(params.get("id").toString());
		if(userDO.getPassword().equals(MyUtils.EncoderByMd5(params.get("pwd").toString()))){
			return 1;
		}else{
			return 0;
		}
	}

	@GetMapping( "/updatePwd")
	@ResponseBody
	@RequiresPermissions("person:pwd")
	public Object updatePwd(@RequestParam Map<String, Object> params){
		UserDO userDO = userService.get(params.get("id").toString());
		userDO.setPassword(MyUtils.EncoderByMd5(params.get("pwd").toString()));
		if(userService.personUpdate(userDO)>0){
			return 1;
		}else{
			return 0;
		}
	}

	@RequestMapping("/img")
	@ResponseBody
	@RequiresPermissions("person:head")
	public Object uploadFile(@RequestParam("file")MultipartFile file){
		try{
			// 更改图片名为用户ID+文件名后缀
			String name = file.getOriginalFilename();
			UserDO userDO = ShiroTool.getUser();
			String reName = userDO.getId() + "." + name.substring(name.lastIndexOf(".") + 1);
			userDO.setHeadPath(doubleBootConfig.getUploadPath() +  reName);
			if(userService.personUpdate(userDO) > 0){
				FileUtil.uploadFile(file.getBytes(), doubleBootConfig.getUploadPath(), reName);
			}

		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
