/// CO3 · Ejemplo resuelto de los apuntes: convierte las duraciones de un fichero.
///
/// Se usa para practicar una configuración de ejecución con argumento y
/// directorio de trabajo. Recibe el nombre de un fichero de texto con un
/// número de minutos por línea; el nombre se busca a partir del directorio de
/// trabajo de la ejecución.
void main(String[] args) {
    if (args.length == 0) {
        IO.println("Falta el argumento: el nombre del fichero de duraciones.");
        return;
    }
    Path fichero = Path.of(args[0]);
    List<String> lineas;
    try {
        lineas = Files.readAllLines(fichero);
    } catch (IOException e) {
        IO.println("No puedo leer " + fichero.toAbsolutePath());
        IO.println("Directorio de trabajo: " + Path.of("").toAbsolutePath());
        return;
    }
    IO.println("Duraciones leídas de " + fichero);
    for (String linea : lineas) {
        if (linea.isBlank()) {
            continue;
        }
        int minutos = Integer.parseInt(linea.trim());
        IO.println(minutos + " minutos son " + (minutos / 60) + " h y " + (minutos % 60) + " min");
    }
}
