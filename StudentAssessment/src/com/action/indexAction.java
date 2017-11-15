package com.action;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TCepingDAO;
import com.dao.TGonggaoDAO;
import com.dao.TUserDAO;
import com.dao.TXiangmuDAO;
import com.model.TCeping;
import com.model.TUser;
import com.model.TXiangmu;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.ComparatorUser;

public class indexAction extends ActionSupport
{
    private TGonggaoDAO gonggaoDAO;
    private TUserDAO userDAO;
	private TCepingDAO cepingDAO;
	
	public TUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(TUserDAO userDAO) {
		this.userDAO = userDAO;
	}


	public TCepingDAO getCepingDAO() {
		return cepingDAO;
	}

	public void setCepingDAO(TCepingDAO cepingDAO) {
		this.cepingDAO = cepingDAO;
	}

	public TGonggaoDAO getGonggaoDAO()
	{
		return gonggaoDAO;
	}

	public void setGonggaoDAO(TGonggaoDAO gonggaoDAO)
	{
		this.gonggaoDAO = gonggaoDAO;
	}
	public String index()
	{
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		Map session=ActionContext.getContext().getSession();
		
		
		List gonggaoList =gonggaoDAO.findAll();
		request.put("gonggaoList", gonggaoList);
		
		
		
		String sql="from TUser where userDel='no'";
		List userList=userDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<userList.size();i++)
		{
			TUser user=(TUser)userList.get(i);
			int userId=user.getUserId();
			user.setZongfen(get_fen(userId));
		}
		
		ComparatorUser comparator = new ComparatorUser();
		Collections.sort(userList, comparator);
		
		/*if(userList.size()>3)
		{
			userList=userList.subList(0, 3);
		}*/
		
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	public int get_fen(int userId)
	{
        int jj=0;
		
		String sql="from TCeping where userId="+userId;
		List cepingList =cepingDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<cepingList.size();i++)
		{
			TCeping ceping=(TCeping)cepingList.get(i);
			jj=jj+ceping.getFenzhi();
		}
		
		return jj;
	}

}
