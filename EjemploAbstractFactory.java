// --- I. Productos Abstractos (La "familia" de objetos) ---
interface Boton {
    void pintar();
}

interface CajaTexto {
    void escribir(String texto);
}

// --- II. Fábrica Abstracta ---
// Interfaz para crear un conjunto (familia) de productos.
interface FabricaUI {
    Boton crearBoton();
    CajaTexto crearCajaTexto();
}

// --- III. Productos Concretos (Estilo Windows) ---
class BotonWindows implements Boton {
    @Override
    public void pintar() {
        System.out.println("Pintando Botón estilo Windows.");
    }
}

class CajaTextoWindows implements CajaTexto {
    @Override
    public void escribir(String texto) {
        System.out.println("CajaTexto Windows: " + texto);
    }
}

// --- IV. Fábrica Concreta (Estilo Windows) ---
class FabricaUIWindows implements FabricaUI {
    @Override
    public Boton crearBoton() {
        return new BotonWindows();
    }

    @Override
    public CajaTexto crearCajaTexto() {
        return new CajaTextoWindows();
    }
}

// --- V. Productos y Fábrica Concretos (Estilo Mac) ---
class BotonMac implements Boton {
    @Override
    public void pintar() {
        System.out.println("Pintando Botón estilo Mac.");
    }
}

class CajaTextoMac implements CajaTexto {
    @Override
    public void escribir(String texto) {
        System.out.println("CajaTexto Mac: " + texto);
    }
}

class FabricaUIMac implements FabricaUI {
    @Override
    public Boton crearBoton() {
        return new BotonMac();
    }

    @Override
    public CajaTexto crearCajaTexto() {
        return new CajaTextoMac();
    }
}

// --- VI. Clase Cliente (Uso) ---
class Aplicacion {
    private Boton boton;
    private CajaTexto cajaTexto;

    // La aplicación recibe la fábrica a través del constructor (Inyección de Dependencias)
    public Aplicacion(FabricaUI fabrica) {
        this.boton = fabrica.crearBoton();
        this.cajaTexto = fabrica.crearCajaTexto();
    }

    public void pintarInterfaz() {
        System.out.println("\n--- Pintando Interfaz ---");
        boton.pintar();
        cajaTexto.escribir("Hola, soy una Caja de Texto.");
    }
}

public class EjemploAbstractFactory {
    public static void main(String[] args) {
        // En tiempo de ejecución decidimos qué fábrica usar
        FabricaUI fabricaWindows = new FabricaUIWindows();
        Aplicacion appWindows = new Aplicacion(fabricaWindows);
        appWindows.pintarInterfaz();

        FabricaUI fabricaMac = new FabricaUIMac();
        Aplicacion appMac = new Aplicacion(fabricaMac);
        appMac.pintarInterfaz();
    }
}