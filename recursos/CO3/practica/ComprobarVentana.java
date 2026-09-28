/// CO3 · Comprobación del entorno gráfico y del Java que ejecuta el programa.
///
/// Escribe en la consola la versión y la carpeta del Java con el que se ha
/// lanzado, y después abre una ventana. Si la ventana aparece, el entorno
/// sabe compilar y ejecutar programas con Swing, que viene dentro del JDK.
/// La ventana no sustituye a la comprobación de versión: las dos líneas de
/// consola son las que dicen qué Java se ha usado de verdad.
void main() {
    String version = System.getProperty("java.version");
    IO.println("Java en ejecución: " + version);
    IO.println("Carpeta de ese Java: " + System.getProperty("java.home"));
    javax.swing.JOptionPane.showMessageDialog(null, "Hola desde Swing con Java " + version);
    IO.println("Ventana cerrada. Comprobación terminada.");
}
