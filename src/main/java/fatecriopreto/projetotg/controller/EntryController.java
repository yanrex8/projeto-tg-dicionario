package fatecriopreto.projetotg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fatecriopreto.projetotg.model.EntryModel;
import fatecriopreto.projetotg.service.EntryService;

@Controller
public class EntryController
{
	@Autowired
	private EntryService service;

	@GetMapping("/")
	public String home(@RequestParam(name = "usWord", required = false) String usWord, Model model)
	{
		try{
			if (usWord != null && !usWord.isEmpty())
			{
				System.out.println("Fetching entry for usWord: " + usWord);
				EntryModel entry = service.findByName(usWord.toUpperCase());

				// Add debug logs to verify data
				if (entry != null)
				{
					System.out.println("Entry found: " + entry.getUsWord() + ", " + entry.getUsPronounciation());
				}
				else
				{
					System.out.println("Entry not found.");
				}
				model.addAttribute("entry", entry);
			}
			else
			{
				System.out.println("No usWord parameter provided.");
				model.addAttribute("entry", null);
			}
			return "index.html";
		}
		catch (Exception e)
		{
			model.addAttribute("e", e);
			return "error.html";
		}
	}
}