package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.BoundInfo;
import com.common.db.BaseDao;

public interface BoundInfoDao extends BaseDao<BoundInfo>{

	List<BoundInfo> getAll();
	public void add(BoundInfo boundInfo);
	public void delete(String id);
	public void update(BoundInfo boundInfo);
	public BoundInfo get(String id);
	public BoundInfo getByProperties(Map<String,Object> props);
}
