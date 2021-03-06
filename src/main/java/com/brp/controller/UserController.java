package com.brp.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.brp.base.Config;
import com.brp.base.ResponseStatus;
import com.brp.base.UserStatus;
import com.brp.entity.ConfigEntity;
import com.brp.entity.Constant;
import com.brp.entity.DepartmentEntity;
import com.brp.entity.MemoEventEntity;
import com.brp.entity.UserEntity;
import com.brp.service.ConfigService;
import com.brp.service.DepartmentService;
import com.brp.service.MemoEventService;
import com.brp.service.UserService;
import com.brp.util.SHA1Utils;
import com.brp.util.UserUtils;
import com.brp.util.query.UserQuery;
import com.google.gson.Gson;

/** 
 * <p>Project: MyBase</p> 
 * <p>Title: UserController.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
@Controller
@RequestMapping("/inner/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private ConfigService configService;
	@Autowired
	private MemoEventService memoEventService;
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Integer saveOrUpdate(@ModelAttribute UserEntity user, HttpServletRequest request){
		Integer result = 0;
		Long id = user.getId();
		UserEntity loginUser = UserUtils.getLoginUser(request);
		if(id == null){
			user.setCreateTime(new Date());
			user.setCreateUser(loginUser.getUserName());
			String initPass = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
			try{
				user.setPassword(SHA1Utils.getSecretPassword(initPass));
			}catch(Exception e){
				e.printStackTrace();
			}
			
			user.setStatus(UserStatus.NORMAL_INT);
			user.setIsLoginMybase(0);
			userService.insertUser(user);
			List<ConfigEntity> configList = configService.getConfigListByCode(Config.INIT_MEMOEVENT);
			if(configList != null && configList.size() > 0){
				MemoEventEntity memoEvent = null;
				for (ConfigEntity config : configList) {
					memoEvent = new MemoEventEntity();
					memoEvent.setCreateTime(new Date());
					memoEvent.setIsDelete(0);
					memoEvent.setCreateUser(user.getUserName());
					memoEvent.setLevelColor(config.getKey());
					memoEvent.setMomeEventName(config.getValue());
					memoEvent.setUserId(user.getId());
					memoEventService.insertMemoEvent(memoEvent);
				}
			}
			result = 1;
		}else{
			user.setUpdateTime(new Date());
			user.setUpdateUser(loginUser.getUserName());
			userService.updateUser(user);
			result = 2;
		}
		
		return result;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editUser(String id, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/user/user_edit");
		UserEntity user = null;
		List<DepartmentEntity> departmentList = null;
		if(StringUtils.isNotBlank(id)){
			user = userService.getUserById(Integer.parseInt(id));
			Long companyId = user.getCompanyId();
			departmentList = departmentService.getListByCompanyId(companyId.toString());
		}
		
		mav.addObject("user", user);
		mav.addObject("departmentList", departmentList);
		
		return mav;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addUser(String id, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		DepartmentEntity department = null;
		if(StringUtils.isNotBlank(id)){
			mav.setViewName("/user/user_add");
			
			List<DepartmentEntity> departmentList = departmentService.getDepartmentListByPId(id);
			mav.addObject("department", department);
			if(departmentList != null && departmentList.size() > 0){
				mav.addObject("departmentList", departmentList);
			}else{
				department = departmentService.getDepartmentById(Integer.parseInt(id));
				mav.addObject("department", department);
			}
		}else{
			mav.setViewName("/user/user_edit");
			UserEntity loginUser = UserUtils.getLoginUser(request);
			Long companyId = loginUser.getCompanyId();
			List<DepartmentEntity> departmentList = departmentService.getListByCompanyId(companyId.toString());
			mav.addObject("departmentList", departmentList);
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView viewUser(String id, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/user/user_detail");
		UserEntity user = null;
		if(StringUtils.isNotBlank(id)){
			user = userService.getUserById(Integer.parseInt(id));
		}
		
		mav.addObject("user", user);
		
		return mav;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listUser(@ModelAttribute UserQuery userQuery, HttpServletRequest request){
		ModelAndView mav = new ModelAndView("/user/user_list");
		userQuery = userService.getUserList(userQuery);
		mav.addObject("userQuery", userQuery);
		
		return mav;
	}
	
	@RequestMapping(value = "/getUserListByDepartmentId", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getUserListByDepartmentId(@ModelAttribute UserQuery userQuery, HttpServletRequest request){
		String result = StringUtils.EMPTY;
		List<UserEntity> list = userService.getUserPage(userQuery);
		if(list != null && list.size() > 0){
			result = new Gson().toJson(list);
		}
		
		return result;
	}
	
	@RequestMapping(value = "/isExistTelphone", method = RequestMethod.GET)
	@ResponseBody
	public Integer isExistTelphone(String departmentId, String telphone, Long userId, HttpServletRequest request){
		Integer result = Constant.EXIST;
		if(StringUtils.isNotBlank(telphone) && StringUtils.isNotBlank(departmentId)){
			boolean isExist = userService.isExistTelphone(departmentId, telphone, userId);
			result = isExist ? Constant.EXIST : Constant.NO_EXIST;
		}
		
		return result;
	}
	
	@RequestMapping(value = "/leave", method = RequestMethod.GET)
	@ResponseBody
	public Integer leave(String id, HttpServletRequest request){
		UserEntity loginUser = UserUtils.getLoginUser(request);
		if(StringUtils.isNotBlank(id)){
			UserEntity user = userService.getUserById(Integer.parseInt(id));
			user.setUpdateTime(new Date());
			user.setUpdateUser(loginUser.getUserName());
			user.setStatus(UserStatus.LEAVE_INT);
			userService.updateUser(user);
		}
			
		return ResponseStatus.UPDATE_SUCCESS;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public Integer deleteUser(String id, HttpServletRequest request){
		UserEntity loginUser = UserUtils.getLoginUser(request);
		if(StringUtils.isNotBlank(id)){
			UserEntity user = userService.getUserById(Integer.parseInt(id));
			user.setUpdateTime(new Date());
			user.setUpdateUser(loginUser.getUserName());
			user.setStatus(UserStatus.FORBIDDEN_INT);
			userService.updateUser(user);
		}
			
		return ResponseStatus.UPDATE_SUCCESS;
	}
	
	@RequestMapping(value = "/changeIsLoginMyBase", method = RequestMethod.GET)
	@ResponseBody
	public Integer changeIsLogin(String userId, HttpServletRequest request){
		UserEntity loginUser = UserUtils.getLoginUser(request);
		Integer isLoginMybase = -1;
		if(StringUtils.isNotBlank(userId)){
			UserEntity user = userService.getUserById(Integer.parseInt(userId));
			user.setUpdateTime(new Date());
			user.setUpdateUser(loginUser.getUserName());
			isLoginMybase = user.getIsLoginMybase();
			if(isLoginMybase != null && isLoginMybase == 1){
				isLoginMybase = 0;
			}else{
				isLoginMybase = 1;
			}
			
			user.setIsLoginMybase(isLoginMybase);
			userService.updateUser(user);
		}
			
		return isLoginMybase;
	}
}

