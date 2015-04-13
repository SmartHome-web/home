package com.smart.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.smart.domain.Message1;

@Repository
public class MessageDao {

	@Autowired
	private HibernateTemplate hibernateTemplate ;
	
	public void saveMessage(Message1 mes){
		hibernateTemplate.save(mes);
	}
	
	public List<Message1> getMessage(){
		String hql="from Message";
		return (List<Message1>)hibernateTemplate.find(hql);
	}
}
