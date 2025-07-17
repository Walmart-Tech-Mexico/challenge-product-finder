import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Base de datos de productos (incompleta y desordenada)
        Producto[] productos = new Producto[] {
            new Producto("Laptop", "Electrónicos", 1200.0),
            new Producto("Camiseta", "Ropa", 25.0),
            new Producto("Auriculares", "Electrónicos", 100.0),
            new Producto("Pantalones", "Ropa", 50.0),
            new Producto("Libro", "Libros", 20.0),
            new Producto("Mouse", "Electrónicos", null), // Precio faltante
            new Producto("Calcetines", null, 15.0)       // Categoría faltante
        };

        // Categoría a filtrar (puede ser nula o vacía)
        String categoriaDeseada = "Electrónicos";

        // TODO: Implementar la lógica para filtrar productos por categoría.
        // Consideraciones:
        // 1. Manejar casos donde la categoría del producto o la categoría deseada sean nulas o vacías.
        // 2. Asegurarse de que el código sea robusto y no lance excepciones inesperadas.
        // 3. Mostrar solo los productos que coincidan con la categoría deseada.
        // 4. Si un producto tiene un precio nulo, mostrar "Precio no disponible".

        if (categoriaDeseada == null || categoriaDeseada.isEmpty()) categoriaDeseada = "X";
        System.out.println("Productos en la categoría " + categoriaDeseada + ":");

        String products = filteredProducts(productos, categoriaDeseada);
        if (products.isEmpty()) System.out.println("No hay productos");
        else System.out.println(products);
    }

    public static String filteredProducts(Producto[] products, String category) {
        if (products == null || products.length == 0 || category == null || category.isEmpty()) return "";
        return Arrays.stream(products)
                .filter(product -> product.getCategoria() != null && product.getCategoria().equals(category))
                .map(product -> {
                    String name = product.getNombre();
                    Double price = product.getPrecio();
                    String priceStr = (price != null) ? "$" + price : "Precio no disponible";
                    return name + ": " + priceStr + "\n";
                })
                .collect(Collectors.joining());
    }
}

class Producto {
    private String nombre;
    private String categoria;
    private Double precio; // Usamos Double para permitir valores nulos

    public Producto(String nombre, String categoria, Double precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public Double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                '}';
    }
}