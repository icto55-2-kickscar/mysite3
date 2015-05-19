package com.sds.icto.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.icto.mysite.domain.GuestbookVo;
import com.sds.icto.mysite.repository.GuestbookDao;

@Service
public class GuestbookService {

	@Autowired
	GuestbookDao guestbookDao;
	
	public List<GuestbookVo> getGuestbookItemList() {
		return guestbookDao.getList();
	}
	
	public void insertGuestbookItem( GuestbookVo vo  ) {
		guestbookDao.insert(vo);
	}
	
	public void deleteGuestbookItem( GuestbookVo vo ) {
		guestbookDao.delete(vo);
	}
}
