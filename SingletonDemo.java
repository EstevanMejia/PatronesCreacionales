// Archivo: singletonDemo.java

class ConexionBD {
    // Atributo estático que guarda la única instancia
    private static ConexionBD instancia;

    // Constructor privado para evitar que otros creen objetos
    private ConexionBD() {
        System.out.println("Conectando a la base de datos...");
    }

    // Método público y estático que devuelve la única instancia
    public static ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
        } else {
            System.out.println("Ya existe una conexión activa.");
        }
        return instancia;
    }

    // Método de ejemplo para simular una consulta
    public void consultar(String consulta) {
        System.out.println("Ejecutando consulta: " + consulta);
    }
}

public class singletonDemo {
    public static void main(String[] args) {
        // Intentamos crear varias conexiones
        ConexionBD conexion1 = ConexionBD.getInstancia();
        conexion1.consultar("SELECT * FROM usuarios");

        ConexionBD conexion2 = ConexionBD.getInstancia();
        conexion2.consultar("SELECT * FROM productos");

        // Verificamos si ambas conexiones son la misma
        if (conexion1 == conexion2) {
            System.out.println("\nAmbas conexiones son la misma instancia (Singleton funcionando).");
        } else {
            System.out.println("\nLas conexiones son diferentes (Singleton falló).");
        }
    }
}
