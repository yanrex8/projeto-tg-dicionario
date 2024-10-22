package fatecriopreto.projetotg.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatecriopreto.projetotg.model.EntryModel;
import fatecriopreto.projetotg.model.EntryRepository;

@Service
public class EntryService
{
	@Autowired
	EntryRepository repo;

	public void createEntry()
	{
		List<String> synonyms = new ArrayList<>();
		synonyms.add("hue");
		synonyms.add("paint");
		synonyms.add("glow");
		synonyms.add("dye");

		Map<String, String> translations = new HashMap<>();
		translations.put("pt-br", "cor");
		translations.put("es-es", "color");
		translations.put("it", "colore");

		repo.save(new EntryModel(UUID.randomUUID().toString(), "color", "[ˈkɒ.lə˞]", "colour", "[ˈkɒ.lə]", "Hue.",
				"That's a hue.", "Apply color.", "Color it.", "", "", synonyms, translations));
	}

	public EntryModel findByName(String word)
	{
		EntryModel item = repo.findByName(word);
		return item;
	}
}