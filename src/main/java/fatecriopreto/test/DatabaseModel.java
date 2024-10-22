// package fatecriopreto.test;

// import org.springframework.data.annotation.Id;
// import org.springframework.data.mongodb.core.mapping.Document;

// @Document(collection = "projetotg")
// // especifica o nome da coleção a ser usada pelo Model
// // se não existir, o MongoDB criará
// public class DatabaseModel
// // representa o modelo dos dados que quero armazenar
// {

// 	@Id
// 	// se não utilizar essa anotação
// 	// o MongoDB irá criar um campo de ID
// 	private String id;

// 	private String name;
// 	private int quantity;
// 	private String category;

// 	public DatabaseModel(String id, String name, int quantity, String category)
// 	{
// 		super();
// 		this.id = id;
// 		this.name = name;
// 		this.quantity = quantity;
// 		this.category = category;
// 	}

// 	public String getId()
// 	{
// 		return id;
// 	}

// 	public void setId(String id)
// 	{
// 		this.id = id;
// 	}

// 	public String getName()
// 	{
// 		return name;
// 	}

// 	public void setName(String name)
// 	{
// 		this.name = name;
// 	}

// 	public int getQuantity()
// 	{
// 		return quantity;
// 	}

// 	public void setQuantity(int quantity)
// 	{
// 		this.quantity = quantity;
// 	}

// 	public String getCategory()
// 	{
// 		return category;
// 	}

// 	public void setCategory(String category)
// 	{
// 		this.category = category;
// 	}

// }
