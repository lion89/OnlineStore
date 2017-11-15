package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TCepingDAO;
import com.dao.TXiangmuDAO;
import com.model.TCeping;
import com.opensymphony.xwork2.ActionSupport;

public class cepingAction extends ActionSupport
{
	private Integer id;
	private Integer xiangmuId;
	private Integer fenzhi;
	private String beizhu;
	
	private String shijian;
	private Integer userId;
	
	private TCepingDAO cepingDAO;
	private TXiangmuDAO xiangmuDAO;
	
	public String cepingAdd()
	{
		
		
		TCeping ceping=new TCeping();
		
		//ceping.setId(id);
		ceping.setXiangmuId(xiangmuId);
		ceping.setFenzhi(xiangmuDAO.findById(xiangmuId).getFenzhi());
		ceping.setBeizhu(beizhu);
		
		ceping.setShijian(shijian);
		ceping.setUserId(userId);
		
		cepingDAO.save(ceping);
		
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "信息添加完毕");
		return "msg";
	}
	
	
	public String cepingMana()
	{
		String sql="from TCeping where userId="+userId;
		List cepingList =cepingDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<cepingList.size();i++)
		{
			TCeping ceping=(TCeping)cepingList.get(i);
			ceping.setXiangmu(xiangmuDAO.findById(ceping.getXiangmuId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("cepingList", cepingList);
		return ActionSupport.SUCCESS;
	}
	
	public String cepingDel()
	{
		TCeping ceping=cepingDAO.findById(id);
		cepingDAO.delete(ceping);
		
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "信息删除完毕");
		return "msg";
	}

	
	public String cepingAll()
	{
		String sql="from TCeping where userId="+userId;
		List cepingList =cepingDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<cepingList.size();i++)
		{
			TCeping ceping=(TCeping)cepingList.get(i);
			ceping.setXiangmu(xiangmuDAO.findById(ceping.getXiangmuId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("cepingList", cepingList);
		return ActionSupport.SUCCESS;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}




	public Integer getXiangmuId() {
		return xiangmuId;
	}


	public void setXiangmuId(Integer xiangmuId) {
		this.xiangmuId = xiangmuId;
	}


	public TCepingDAO getCepingDAO() {
		return cepingDAO;
	}


	public void setCepingDAO(TCepingDAO cepingDAO) {
		this.cepingDAO = cepingDAO;
	}


	public Integer getFenzhi() {
		return fenzhi;
	}


	public void setFenzhi(Integer fenzhi) {
		this.fenzhi = fenzhi;
	}


	public String getBeizhu() {
		return beizhu;
	}


	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}


	public String getShijian() {
		return shijian;
	}


	public void setShijian(String shijian) {
		this.shijian = shijian;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public TCepingDAO geTCepingDAO() {
		return cepingDAO;
	}


	public void seTCepingDAO(TCepingDAO cepingDAO) {
		this.cepingDAO = cepingDAO;
	}


	public TXiangmuDAO getXiangmuDAO() {
		return xiangmuDAO;
	}


	public void setXiangmuDAO(TXiangmuDAO xiangmuDAO) {
		this.xiangmuDAO = xiangmuDAO;
	}

}
