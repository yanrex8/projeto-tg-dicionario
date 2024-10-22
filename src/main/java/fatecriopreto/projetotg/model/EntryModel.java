package fatecriopreto.projetotg.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "projetotg")
public class EntryModel
{
	@Id
	private String id;

	private String usWord;
	private String usPronounciation;
	private String ukWord;
	private String ukPronounciation;
	private String nounDefinition;
	private String nounExample;
	private String verbDefinition;
	private String verbExample;
	private String adjectiveDefinition;
	private String adjectiveExample;
	// public String adverbDefinition;
	// public String prepositionDefinition;
	// public String pronounDefinition;
	private List<String> synonyms;
	private Map<String, String> translations;

	public EntryModel(String id, String usWord, String usPronounciation, String ukWord, String ukPronounciation,
			String nounDefinition, String nounExample, String verbDefinition, String verbExample,
			String adjectiveDefinition, String adjectiveExample, List<String> synonyms,
			Map<String, String> translations)
	{
		this.id = id;
		this.usWord = usWord;
		this.usPronounciation = usPronounciation;
		this.ukWord = ukWord;
		this.ukPronounciation = ukPronounciation;
		this.nounDefinition = nounDefinition;
		this.nounExample = nounExample;
		this.verbDefinition = verbDefinition;
		this.verbExample = verbExample;
		this.adjectiveDefinition = adjectiveDefinition;
		this.adjectiveExample = adjectiveExample;
		this.synonyms = synonyms;
		this.translations = translations;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getUsWord()
	{
		return usWord;
	}

	public void setUsWord(String usWord)
	{
		this.usWord = usWord;
	}

	public String getUsPronounciation()
	{
		return usPronounciation;
	}

	public void setUsPronounciation(String usPronounciation)
	{
		this.usPronounciation = usPronounciation;
	}

	public String getUkWord()
	{
		return ukWord;
	}

	public void setUkWord(String ukWord)
	{
		this.ukWord = ukWord;
	}

	public String getUkPronounciation()
	{
		return ukPronounciation;
	}

	public void setUkPronounciation(String ukPronounciation)
	{
		this.ukPronounciation = ukPronounciation;
	}

	public String getNounDefinition()
	{
		return nounDefinition;
	}

	public void setNounDefinition(String nounDefinition)
	{
		this.nounDefinition = nounDefinition;
	}

	public String getNounExample()
	{
		return nounExample;
	}

	public void setNounExample(String nounExample)
	{
		this.nounExample = nounExample;
	}

	public String getVerbDefinition()
	{
		return verbDefinition;
	}

	public void setVerbDefinition(String verbDefinition)
	{
		this.verbDefinition = verbDefinition;
	}

	public String getVerbExample()
	{
		return verbExample;
	}

	public void setVerbExample(String verbExample)
	{
		this.verbExample = verbExample;
	}

	public String getAdjectiveDefinition()
	{
		return adjectiveDefinition;
	}

	public void setAdjectiveDefinition(String adjectiveDefinition)
	{
		this.adjectiveDefinition = adjectiveDefinition;
	}

	public String getAdjectiveExample()
	{
		return adjectiveExample;
	}

	public void setAdjectiveExample(String adjectiveExample)
	{
		this.adjectiveExample = adjectiveExample;
	}

	public List<String> getSynonyms()
	{
		return synonyms;
	}

	public void setSynonyms(List<String> synonyms)
	{
		this.synonyms = synonyms;
	}

	public Map<String, String> getTranslations()
	{
		return translations;
	}

	public void setTranslations(Map<String, String> translations)
	{
		this.translations = translations;
	}

}
