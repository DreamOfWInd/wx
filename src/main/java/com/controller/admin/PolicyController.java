package com.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.common.util.JsonUtil;
import com.entity.Policy;
import com.service.PolicyService;

@Controller
@RequestMapping("/admin/policy")
public class PolicyController {
	@Autowired
	public PolicyService policyService;
	//全查
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView showListPage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("admin/policy/list");
		return mv;
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public void getListData(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Policy> list=new ArrayList<Policy>();
		String keyword=request.getParameter("keyword");
	
		if(keyword!=null && !keyword.isEmpty()){
			Map<String,Object> like=new HashMap<String,Object>();
			like.put("name", "%"+keyword+"%");
			like.put("content", "%"+keyword+"%");
		
				list=this.policyService.getLikeProperty(like);
			
		}
		else{
			list=this.policyService.getAll();
		}
		map.put("success", true);
		map.put("list", list);
		JsonUtil.writeCommonJson(response, map);
	}

	public ModelAndView list(HttpServletRequest request) {
		List<Policy> list=this.policyService.getAll();
		return null;
	}
	
	//增加
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(HttpServletResponse response,Policy policy) throws IOException{
	
		this.policyService.add(policy);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("success", true);
		JsonUtil.writeCommonJson(response, map);
		
	}
	//按ID删除
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleteById(HttpServletResponse response,String id) throws IOException{
		//String id = request.getParameter("id");
		System.out.println(id);
		this.policyService.delete(id);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("success", true);
		JsonUtil.writeCommonJson(response, map);
	}
	
	
	//详细显示要修改的记录
	@RequestMapping(value = "/get",method = RequestMethod.GET)
	public void get(HttpServletResponse response,String id) throws IOException{
		System.out.println(id);
		Policy policy=this.policyService.get(id);
		//System.out.println(book.getBookName());
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("success", true);
		map.put("item", policy);
		JsonUtil.writeCommonJson(response, map);
		
	}
	//更新记录
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(HttpServletResponse response,Policy policy) throws IOException{
		this.policyService.alter(policy);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("success", true);
		JsonUtil.writeCommonJson(response, map);
	}
}
