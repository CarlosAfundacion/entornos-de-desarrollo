/// CO3 · Ejemplo resuelto de los apuntes: convierte minutos en horas y minutos.
///
/// Los datos van escritos dentro del programa para que la salida sea siempre
/// la misma y se pueda comparar entre entornos. La última línea sirve para
/// comprobar que las tildes y la eñe llegan bien a la consola.
void main() {
    int minutos = 135;
    int horas = minutos / 60;
    int resto = minutos % 60;

    IO.println("Conversión de duraciones · versión Java");
    IO.println(minutos + " minutos son " + horas + " h y " + resto + " min");
    IO.println("Texto de prueba: año, canción, pequeño, acción");
}
