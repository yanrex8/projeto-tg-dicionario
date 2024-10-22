package fatecriopreto.projetotg.model;

// import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EntryRepository extends MongoRepository<EntryModel, String>
{

	@Query("{usWord:'?0'}")
	EntryModel findByName(String word);

	// @Query(value = "{category:'?0'}", fields = "{'name' : 1, 'quantity' : 1}")
	// List<EntryModel> findAll(String category);

	@Override
	public long count();

}
