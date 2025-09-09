package ProjectFilesPoli;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/* Integrantes
 * Andres Felipe Escudero Gutierrez
 * Paula Sierra
 * Ismael Perez
 * 
 * 
 */


public class GenerateInfoFiles {
	
	private static final Random random = new Random();

	public static void main(String[] args) {
		
		  try {
	            createProductsFile(15);              // generate product
	            createSalesManInfoFile(5);          // generate vendors
	            createSalesMenFile(5, "Vendedor poli", 123456789L); // sales files
	            System.out.println("Files generated successsfully");
	        } catch (Exception e) {
	            System.err.println("Error generating files: " + e.getMessage());
	        }
	}
	
	 // Method to generate files of vendors
    public static void createSalesMenFile(int randomSalesCount, String name, long id) throws IOException {
        String fileName = "ventas_" + id + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // seller header
            writer.write("CC;" + id);
            writer.newLine();

            // Pseudo-random sales
            for (int i = 0; i < randomSalesCount; i++) {
                int productId = random.nextInt(10) + 1;
                int quantity = random.nextInt(5) + 1;
                writer.write(productId + ";" + quantity + ";");
                writer.newLine();
            }
        }
    }
    
    // Method to generate file with list of products
    public static void createProductsFile(int countProducts) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Products.txt"))) {
            for (int i = 1; i <= countProducts; i++) {
                String productName = "Products" + i;
                double price = 1000 + random.nextInt(9000);
                writer.write(i + ";" + productName + ";" + price);
                writer.newLine();
            }
        }
    }
    
 // Method to generate a file with list of sellers
    public static void createSalesManInfoFile(int salesmanCount) throws IOException {
        String[] names = {"Jennifer", "Mary", "Juana", "Elisa", "Felipe"};
        String[] lastNameList = {"Estrada", "Lopez", "Miranda", "Gutierrez", "Henao"};

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("vendors.txt"))) {
            for (int i = 0; i < salesmanCount; i++) {
                String name = names[random.nextInt(names.length)];
                String lastName = lastNameList[random.nextInt(lastNameList.length)];
                long id = 10000000L + random.nextInt(90000000);
                writer.write("CC;" + id + ";" + name + ";" + lastName);
                writer.newLine();
            }
        }
    }
}



