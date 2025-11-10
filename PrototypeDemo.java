///patrón Prototype

// Interfaz Prototype
public interface Figura extends Cloneable {
    Figura clonar();
}

// Clase concreta que implementa Prototype
public class Circulo implements Figura {
    private int x;
    private int y;
    private String color;

    public Circulo(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    // Método para clonar el objeto
    @Override
    public Figura clonar() {
        return new Circulo(x, y, color);
    }

    @Override
    public String toString() {
        return "Círculo [x=" + x + ", y=" + y + ", color=" + color + "]";
    }
}

// Clase principal para probar Prototype
public class Main {
    public static void main(String[] args) {
        Circulo original = new Circulo(10, 20, "rojo");
        Circulo copia = (Circulo) original.clonar();

        System.out.println("Original: " + original);
        System.out.println("Copia: " + copia);
    }
}
