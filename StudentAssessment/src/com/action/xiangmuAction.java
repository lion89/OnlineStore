package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TXiangmuDAO;
import com.model.TXiangmu;
import com.opensymphony.xwork2.ActionSupport;

public class xiangmuAction extends ActionSupport
{
	private Integer id;
	private String mingcheng;
	private int fenzhi;
	private String del;
	
	private TXiangmuDAO xiangmuDAO;
	
	public String xiangmuAdd()
	{
		TXiangmu xiangmu=new TXiangmu();
		
		//xiangmu.setId(id);
		xiangmu.setMingcheng(mingcheng);
		xiangmu.setFenzhi(fenzhi);
		xiangmu.setDel("no");
		
		xiangmuDAO.save(xiangmu);
		
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "信息添加完毕");
		return "msg";
	}
	
	
	public String xiangmuMana()
	{
		String sql="from TXiangmu where del='no'";
		List xiangmuList =xiangmuDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xiangmuList", xiangmuList);
		return ActionSupport.SUCCESS;
	}
	
	public String xiangmuDel()
	{
		TXiangmu xiangmu=xiangmuDAO.findById(id);
		xiangmu.setDel("yes");
		xiangmuDAO.attachDirty(xiangmu);
		
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "信息删除完毕");
		return "msg";
	}


	public Integer getId()
	{
		return id;
	}


	public void setId(Integer id)
	{
		this.id = id;
	}


	public String getMingcheng()
	{
		return mingcheng;
	}


	public void setMingcheng(String mingcheng)
	{
		this.mingcheng = mingcheng;
	}


	public int getFenzhi() {
		return fenzhi;
	}


	public void setFenzhi(int fenzhi) {
		this.fenzhi = fenzhi;
	}


	public String getDel() {
		return del;
	}


	public void setDel(String del) {
		this.del = del;
	}


	public TXiangmuDAO getXiangmuDAO()
	{
		return xiangmuDAO;
	}


	public void setXiangmuDAO(TXiangmuDAO xiangmuDAO)
	{
		this.xiangmuDAO = xiangmuDAO;
	}

}
