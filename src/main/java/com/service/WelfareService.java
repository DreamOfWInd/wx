package com.service;

import java.util.List;
import java.util.Map;

import com.entity.Book;
import com.entity.Welfare;

public interface WelfareService {
	public List<Welfare> getAll();
	public int getCount();
	public void add(Welfare welfare);
	public void delete(String id);
	public Welfare get(String id);
	public void update(Welfare welfare);
	public List<Welfare> getListByProperties(Map<String, Object> like, int startIndex,
			int itemsPerPage);
	public int getCountByLikeProperties(Map<String, Object> like);
	public List<Welfare> getPagination(int i, int itemsPerPage);
	public int getCountByProperties(Map<String, Object> like);
	public List<Welfare> getListByProperties(Map<String, Object> andProps);
}
