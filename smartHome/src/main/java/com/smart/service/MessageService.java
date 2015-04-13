package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.MessageDao;
import com.smart.domain.Message1;

@Service
public class MessageService {
	
	@Autowired
	private MessageDao messageDao;
	
	public void saveMessage(Message1 mes){
			messageDao.saveMessage(mes);
	}

}
