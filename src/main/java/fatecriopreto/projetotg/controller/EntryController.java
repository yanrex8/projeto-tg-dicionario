package fatecriopreto.projetotg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fatecriopreto.projetotg.model.EntryModel;
import fatecriopreto.projetotg.service.EntryService;

@Controller
public class EntryController
{
	@Autowired
	private EntryService service;

	@GetMapping("/")
	public String home(Model model)
	{
		service.createEntry();

		EntryModel entry = service.findByName("color");

		model.addAttribute("entry", entry);
		return "index.html";
	}
}
