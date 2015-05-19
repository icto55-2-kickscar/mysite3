package com.sds.icto.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sds.icto.mysite.domain.GuestbookVo;
import com.sds.icto.mysite.service.GuestbookService;

@Controller
@RequestMapping( "/guestbook" )
public class GuestbookController {
	
	@Autowired
	GuestbookService guestbookService;
	
	@RequestMapping( value={ "", "/" }, method=RequestMethod.GET  )
	public String list( Model model ) {
		List<GuestbookVo> list = guestbookService.getGuestbookItemList();
		model.addAttribute( "list", list );
		return "guestbook/list";
	}
	
	@RequestMapping( value={ "", "/" }, method=RequestMethod.POST )
	public String insert( @ModelAttribute GuestbookVo vo  ) {
		guestbookService.insertGuestbookItem( vo );
		return "redirect:/guestbook";
	}
	
	@RequestMapping( value="/delete/{no}",  method=RequestMethod.GET  )
	public String deleteForm( @PathVariable Long no, Model model ) {
		model.addAttribute( "no", no );
		return "guestbook/deleteform";
	}

	@RequestMapping( value="/delete",  method=RequestMethod.POST )
	public String delete( @ModelAttribute GuestbookVo vo ) {
		guestbookService.deleteGuestbookItem( vo );
		return "redirect:/guestbook";
	}
	
}
