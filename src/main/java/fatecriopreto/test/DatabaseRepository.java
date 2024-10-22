// package fatecriopreto.test;

// import java.util.List;

// import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.data.mongodb.repository.Query;

// public interface DatabaseRepository extends MongoRepository<DatabaseModel, String>
// {
// 	@Query("{name:'?0'}")
// 	// o parâmetro para a query é especificado pela anotação
// 	DatabaseModel encontrarPorNome(String name);

// 	@Query(value = "{category:'?0'}", fields = "{'name' : 1, 'quantity' : 1}")
// 	// o campo categoria é usado para trazer todos os itens de uma categoria
// 	// para trazer os campos da forma que são, coloca-se o valor 1
// 	List<DatabaseModel> encontrarTodos(String category);

// 	@Override
// 	public long count();
// }
