import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Base de datos de productos (incompleta y desordenada)
        Producto[] productos = new Producto[] {
            new Producto("Laptop", "Electrónicos", 1200.0),
            new Producto("Camiseta", null, 25.0),
            new Producto("Auriculares", "Electrónicos", 100.0),
            new Producto("Pantalones", "Ropa", 50.00),
            new Producto("Libro", "Libros", 20.0),
            new Producto("Mouse", "Electrónicos", null), // Precio faltante
            new Producto("Calcetines", null, 15.0)       // Categoría faltante
        };

        // Categoría a filtrar (puede ser nula o vacía)
        String categoriaDeseada = null;

        // TODO: Implementar la lógica para filtrar productos por categoría.
        // Consideraciones:
        // 1. Manejar casos donde la categoría del producto o la categoría deseada sean nulas o vacías.
        // 2. Asegurarse de que el código sea robusto y no lance excepciones inesperadas.
        // 3. Mostrar solo los productos que coincidan con la categoría deseada.
        // 4. Si un producto tiene un precio nulo, mostrar "Precio no disponible".

        System.out.println("Productos en la categoría " + categoriaDeseada + ":");
        // Aquí debe ir la lógica de filtrado e impresión de resultados.
        printFilteredProducts(searchProductsByCategory(getValidProducts(productos,false),categoriaDeseada));
    }

    /*Obtiene los productos con una categoría valida para poder filtrarse, tiene la opción de imprimir los productos con categorías invalidos
     */
    public static List<Producto> getValidProducts(Producto[] productos, Boolean printProductWhitCategoryInvalid) {
        return Arrays.stream(productos).filter(p -> {
                    boolean isInvalid = p.getCategoria() == null || p.getCategoria().isEmpty();
                    if (isInvalid && printProductWhitCategoryInvalid) {
                        System.out.printf("El producto %s no tiene una categoría válida: {%s}%n", p.getNombre(), p.getCategoria());
                    }
                    return !isInvalid; // Retorna solo productos válidos
                }).toList();
    }


    //Filtra los productos dada una categoría,maneja el caso donde se requiera buscar una categoría invalida
    public static List<Producto> searchProductsByCategory(List<Producto> productos, String categoria) {
        if (categoria == null || categoria.isEmpty()) {
            System.out.println("La categoría no puede estar vacia o ser null");
            return null;
        }
        return productos.stream().filter(p-> p.getCategoria().equals(categoria)).toList();
    }


    /*
        Da el formato correcto a los productos para poder imprimir correctamete la información
     */
    public static void printFilteredProducts(List<Producto> productos) {
        if(productos==null || productos.isEmpty()){
            System.out.println("No hay productos asociados  a la categoría buscada");
            return;
        }
        productos.forEach(p->{
            if(p.getPrecio()==null) {
                System.out.println(p.toString().replace("precio:" + p.getPrecio(), "Precio no disponible"));
            }else {
                System.out.println(p);
            }
        });
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
        return "Producto {" +
                "nombre:'" + nombre + '\'' +
                ", categoria:'" + categoria + '\'' +
                ", precio:" + precio +
                '}';
    }
}