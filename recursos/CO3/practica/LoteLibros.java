/// CO3 · Práctica: calcula el importe de un lote de libros para una biblioteca.
///
/// No hace falta modificar este programa: la práctica trata del entorno, no
/// del código. Sirve para comprobar que dos entornos distintos construyen y
/// ejecutan el mismo fuente con el mismo resultado.
///
/// - **Sin argumentos** usa el lote de referencia, escrito aquí dentro.
/// - **Con un argumento** lee el lote de ese fichero de texto. El nombre se
///   busca a partir del directorio de trabajo, así que el fichero tiene que
///   estar donde la ejecución «cree que está».
///
/// Formato del fichero, en UTF-8: una línea por título con
/// `título;unidades;precio`. Las líneas vacías y las que empiezan por `#` se
/// ignoran. El precio admite coma o punto decimal.
void main(String[] args) {
    List<String> lineas;
    String origen;

    if (args.length == 0) {
        origen = "lote de referencia (sin argumentos)";
        lineas = List.of(
                "Cien años de soledad;3;12,50",
                "La sombra del viento;2;9,95",
                "Manual de programación;1;34,00");
    } else {
        Path fichero = Path.of(args[0]);
        origen = "fichero " + fichero;
        try {
            lineas = Files.readAllLines(fichero);
        } catch (NoSuchFileException e) {
            IO.println("No encuentro el fichero: " + fichero.toAbsolutePath());
            IO.println("Directorio de trabajo: " + Path.of("").toAbsolutePath());
            IO.println("Revisa el argumento o el directorio de trabajo de la ejecución.");
            return;
        } catch (IOException e) {
            IO.println("No se ha podido leer " + fichero + ": " + e.getMessage());
            return;
        }
    }

    Locale es = Locale.of("es", "ES");
    int unidadesTotales = 0;
    double importeTotal = 0;

    IO.println("Lote de libros · Biblioteca");
    IO.println("Origen de los datos: " + origen);
    IO.println(String.format("%-28s %5s %9s %10s", "Título", "Uds.", "Precio", "Importe"));

    int numero = 0;
    for (String linea : lineas) {
        numero++;
        if (linea.isBlank() || linea.startsWith("#")) {
            continue;
        }
        String[] partes = linea.split(";");
        if (partes.length != 3) {
            IO.println("Línea " + numero + " ignorada: no tiene tres campos separados por ';'");
            continue;
        }
        try {
            String titulo = partes[0].trim();
            int unidades = Integer.parseInt(partes[1].trim());
            double precio = Double.parseDouble(partes[2].trim().replace(',', '.'));
            double importe = unidades * precio;
            unidadesTotales += unidades;
            importeTotal += importe;
            IO.println(String.format(es, "%-28s %5d %9.2f %10.2f", titulo, unidades, precio, importe));
        } catch (NumberFormatException e) {
            IO.println("Línea " + numero + " ignorada: unidades o precio no son números");
        }
    }

    IO.println(String.format(es, "Total del lote: %d unidades, %.2f EUR", unidadesTotales, importeTotal));
    IO.println("Ejecutado con Java " + System.getProperty("java.version"));
}
