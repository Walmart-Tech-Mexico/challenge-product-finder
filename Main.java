import java.util.Arrays;

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
            new Producto("Calcetines", null, 15.0),       // Categoría faltante
            new Producto("Test empty string", "", 15.0)
        };

        // Categoría a filtrar (puede ser nula o vacía)
        String categoriaDeseada = "Electrónicos";

        System.out.println("Productos en la categoría " + categoriaDeseada + ":");
        // Aquí debe ir la lógica de filtrado e impresión de resultados.

        Arrays.stream(productos).filter(producto -> {
            String categoriaProducto = producto.getCategoria();
            
            if (categoriaProducto == null && categoriaDeseada == null)
                return true;

            if (categoriaProducto != null && categoriaProducto.isEmpty() && categoriaDeseada != null && categoriaDeseada.isEmpty())
                return true;
        
            if (
                categoriaProducto == null || categoriaProducto.isEmpty()
                || categoriaDeseada == null || categoriaDeseada.isEmpty()
            )
                return false;

            return categoriaDeseada.equals(categoriaProducto);
        }).forEach(System.out::println);
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
        String precioAMostrar = precio == null ? "Precio no disponible" : precio.toString();

        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precioAMostrar +
                '}';
    }
}