package com.hcl.library.service;

import com.hcl.library.dao.StaffDao;
import com.hcl.library.model.po.StaffPO;

public class StaffService {
	private StaffDao staffDao;
	
	public StaffService(){
		staffDao = new StaffDao();
	}
	
	public boolean saveStaff(StaffPO staff) {
		StaffPO staffFound = findByCurp(staff.getCurp());
		if(staffFound!=null) {
			return staffDao.create(staff);
		}
		return false;
	}
	
	public StaffPO findByCurp(String curp) {
		return staffDao.find(staffDao.criteriaOfSearching(curp, "getCurp"));
	}
	
	public StaffPO findByName(String name) {
		return staffDao.find(staffDao.criteriaOfSearching(name, "getFullName"));
	}
	
	public StaffPO findByUserName(String userName) {
		return staffDao.find(staffDao.criteriaOfSearching(userName,"getUserName"));
	}
}
