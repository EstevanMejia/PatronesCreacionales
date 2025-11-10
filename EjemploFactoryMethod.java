// 1. Interfaz de Producto (Documento)
interface Documento {
    void abrir();
}

// 2. Productos Concretos
class DocumentoPDF implements Documento {
    @Override
    public void abrir() {
        System.out.println("Abriendo un documento PDF.");
    }
}

class DocumentoDOCX implements Documento {
    @Override
    public void abrir() {
        System.out.println("Abriendo un documento DOCX.");
    }
}

// 3. Clase Creadora Abstracta (Fábrica)
// Declara el método de fábrica, que devuelve un objeto de tipo Documento.
abstract class CreadorDocumento {
    // El "Factory Method"
    public abstract Documento crearDocumento();

    // Lógica de negocio que utiliza el Factory Method
    public void mostrarDocumento() {
        Documento doc = crearDocumento();
        System.out.println("Preparando documento...");
        doc.abrir();
    }
}

// 4. Creadores Concretos (Implementan el Factory Method)
class CreadorPDF extends CreadorDocumento {
    @Override
    public Documento crearDocumento() {
        return new DocumentoPDF();
    }
}

class CreadorDOCX extends CreadorDocumento {
    @Override
    public Documento crearDocumento() {
        return new DocumentoDOCX();
    }
}

// 5. Clase Cliente (Uso)
public class EjemploFactoryMethod {
    public static void main(String[] args) {
        System.out.println("--- Cliente que necesita un PDF ---");
        CreadorDocumento creadorPDF = new CreadorPDF();
        creadorPDF.mostrarDocumento(); // El creador decide qué Documento instanciar

        System.out.println("\n--- Cliente que necesita un DOCX ---");
        CreadorDocumento creadorDOCX = new CreadorDOCX();
        creadorDOCX.mostrarDocumento();
    }
}