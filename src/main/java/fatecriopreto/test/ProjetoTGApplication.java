// package fatecriopreto.test;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

// @SpringBootApplication
// @EnableMongoRepositories
// public class ProjetoTGApplication implements CommandLineRunner
// {

// 	@Autowired
// 	DatabaseRepository databaseRepo;

// 	List<DatabaseModel> itemList = new ArrayList<>();

// 	public static void main(String[] args)
// 	{
// 		SpringApplication.run(ProjetoTGApplication.class, args);
// 	}

// 	@Override
// 	public void run(String... args)
// 	{
// 		databaseRepo.deleteAll();

// 		System.out.println("criar");

// 		criarItens();

// 		System.out.println("mostrar");

// 		mostrarTodosItens();

// 		System.out.println("trazer por nome");

// 		trazerPorNome("Whole Wheat Biscuit");

// 		System.out.println("trazer por categoria");

// 		trazerPorCategoria("millets");

// 		System.out.println("update categoria");

// 		updateCategoria("snacks");

// 		System.out.println("deletar item");

// 		deletarItem("Kodo Millet");

// 		System.out.println("contagem total");

// 		contagemTotal();

// 		System.out.println("eh nois");
// 	}

// 	void criarItens()
// 	{
// 		System.out.println("Data creation started...");

// 		databaseRepo.save(new DatabaseModel("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
// 		databaseRepo.save(new DatabaseModel("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
// 		databaseRepo.save(new DatabaseModel("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
// 		databaseRepo.save(new DatabaseModel("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
// 		databaseRepo.save(new DatabaseModel("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));

// 		System.out.println("Data creation complete...");
// 	}

// 	public String trazerDetalhes(DatabaseModel item)
// 	{

// 		System.out.println(
// 				"Item Name: " + item.getName() +
// 						", \nItem Quantity: " + item.getQuantity() +
// 						", \nItem Category: " + item.getCategory());
// 		return "";
// 	}

// 	public void mostrarTodosItens()
// 	{

// 		itemList = databaseRepo.findAll();

// 		itemList.forEach(item -> System.out.println(trazerDetalhes(item)));
// 	}

// 	public void trazerPorNome(String name)
// 	{
// 		System.out.println("Getting item by name: " + name);
// 		DatabaseModel item = databaseRepo.encontrarPorNome(name);
// 		System.out.println(trazerDetalhes(item));
// 	}

// 	public void trazerPorCategoria(String category)
// 	{
// 		System.out.println("Getting items for the category " + category);
// 		List<DatabaseModel> list = databaseRepo.encontrarTodos(category);

// 		list.forEach(item -> System.out.println("Name: " + item.getName() + ", Quantity: " + item.getQuantity()));
// 	}

// 	public void updateCategoria(String category)
// 	{

// 		String newCategory = "munchies";

// 		List<DatabaseModel> list = databaseRepo.encontrarTodos(category);

// 		list.forEach(item ->
// 		{
// 			item.setCategory(newCategory);
// 		});

// 		List<DatabaseModel> itemsUpdated = databaseRepo.saveAll(list);

// 		if (itemsUpdated != null)
// 			System.out.println("Successfully updated " + itemsUpdated.size() + " items.");
// 	}

// 	public void deletarItem(String id)
// 	{
// 		databaseRepo.deleteById(id);
// 		System.out.println("Item with id " + id + " deleted...");
// 	}

// 	public void contagemTotal()
// 	{
// 		long count = databaseRepo.count();
// 		System.out.println("Number of documents in the collection = " + count);
// 	}
// }
