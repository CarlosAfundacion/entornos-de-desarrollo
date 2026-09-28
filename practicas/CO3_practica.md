# CO3 · Práctica: un puesto de desarrollo para la biblioteca

**Contornos · 1º DAM**

La biblioteca municipal quiere un puesto de trabajo para mantener dos programas
pequeños que ya tiene: uno en **Java** que calcula el importe de los lotes de
libros que compra, y un script en **Python** que calcula los recargos por
retraso de los préstamos. Te encargan **preparar ese puesto, dejarlo comprobado
y recomendar con qué entorno trabajar**.

Vas a instalar dos entornos, **IntelliJ IDEA** y **Eclipse**, hacer lo mismo en
los dos, registrar lo que observas y decidir con esas evidencias. Un tercero,
**Visual Studio Code**, entra en la comparación como caso de referencia, sin
instalarlo.

Los programas ya funcionan: **no tienes que programar nada**. Lo que se trabaja es
el entorno.

---

## Lo que necesitas

| Recurso | Dónde está | Para qué |
|---|---|---|
| Apuntes de CO3 | `entornos/apuntes/CO3_apuntes.md` | Todos los procedimientos, paso a paso |
| `LoteLibros.java` | `entornos/recursos/CO3/practica/` | El programa Java de la biblioteca |
| `pedido_marzo.txt` | `entornos/recursos/CO3/practica/` | Un lote guardado en fichero |
| `prestamos.py` | `entornos/recursos/CO3/practica/` | El script Python de la biblioteca |
| `ComprobarVentana.java` | `entornos/recursos/CO3/practica/` | Comprobar Java y la parte gráfica |
| `caso_vscode.md` | `entornos/recursos/CO3/` | El caso de referencia de VS Code |
| `plantilla_informe_CO3.docx` | `https://docs.google.com/document/d/1ghJLda1w7-9ugQxUxfprFCiXJxGBgF8QvyjQJXP9Xos/edit?usp=sharing` | La plantilla editable del informe que entregas. |

Los apuntes usan otros programas de ejemplo (`Minutos`, `Duraciones`). En la
práctica los procedimientos son los mismos, pero los programas, los datos y los
resultados son los de la biblioteca.

**Cómo se trabaja.** La práctica se hace **en el equipo del aula**, en clase, y el
informe se va rellenando **mientras** trabajas: cada actividad deja su evidencia
en su apartado de la plantilla. Cómo se hace una captura, se pega con su frase y
se saca el PDF está en el apartado 0 de los apuntes. Si además quieres instalarlo
en un portátil propio, puedes, pero no hace falta.

**Antes de instalar nada**, lee en los apuntes «Antes de instalar: prepara las
medidas» (apartado 2): la **primera apertura** y el **tamaño instalado** de cada
entorno se anotan en C11 en el momento de instalar, porque después ya no se
pueden medir.

---

## Parte 1 · Preparar el puesto

**C1 · Inventario.** Antes de instalar nada, rellena la tabla de inventario de la
plantilla: sistema, memoria, espacio libre, si tu usuario puede instalar, carpeta
de trabajo y la salida de `java --version` y `where.exe java`.

**C2 · Instalar los dos entornos.** Instala IntelliJ IDEA y Eclipse IDE for Java
Developers. De cada uno anota la versión exacta, de dónde lo has sacado, cuánto
ocupa la carpeta instalada y cuánto ha tardado más o menos. Mide el tamaño en
cuanto termine la instalación, y la **primera apertura** de cada uno con el
cronómetro preparado antes de abrirlo; esa medida va a la tabla de C11. Si ya lo
abriste sin medir, escribe «no registrada»: no reinstales.

> **Si la instalación se bloquea** (permisos, disco lleno, antivirus), no busques
> atajos: anota el mensaje exacto y qué has probado en la tabla de incidencias,
> avisa en clase y sigue con el otro entorno. Cuando se resuelva, retomas ese
> punto y lo anotas también.

**C3 · Java 25 en cada entorno.** En cada entorno, crea un proyecto de prueba con
el JDK 25 y el nivel de lenguaje 25, añade `ComprobarVentana.java` y ejecútalo.

- Anota en la tabla qué JDK y qué nivel tiene el proyecto, y dónde se configura
  cada cosa.
- La salida tiene que decir **qué Java** y **desde qué carpeta**, y tiene que
  abrirse una ventana. Captura la ventana junto a la consola.
- La ventana dice que la parte gráfica funciona; **las dos líneas de consola** son
  las que dicen qué Java se ha usado.

**C4 · El mismo fuente en los dos.** Crea en cada entorno un proyecto para la
biblioteca (por ejemplo `biblio-intellij` y `biblio-eclipse`) y **copia** en cada
uno `LoteLibros.java`.

1. Construye de forma explícita en cada entorno.
2. Localiza dónde ha quedado `LoteLibros.class` en cada uno.
3. Ejecútalo **sin argumentos** desde el entorno.
4. Ejecuta ese mismo `.class` **desde la consola del sistema**, con `java -cp`.

La salida tiene que coincidir en las cuatro ejecuciones: el lote de referencia
son **6 unidades** y **91,40 EUR**. No compares los `.class` entre sí: se
comprueba que **se comportan igual**, no que sean el mismo fichero.

**C5 · Una incidencia a propósito.** En uno de los dos entornos, haz una **copia de
trabajo** del proyecto de la biblioteca con el procedimiento del apartado 5 de los
apuntes: un proyecto nuevo con otro nombre (por ejemplo `biblio-copia`) al que
solo copias `LoteLibros.java`. No toques el original.

1. Ejecuta el original y anota su total: la referencia.
2. Comprueba que el original y la copia están en carpetas distintas.
3. Construye y ejecuta la copia: el mismo total.
4. En la copia, baja el nivel de lenguaje a **21** y construye. ¿Qué mensaje
   aparece, dónde y por qué?
5. Restaura el nivel 25 en la copia, construye y ejecuta: tiene que volver a dar
   **91,40 EUR**.
6. Ejecuta otra vez el **original**: sigue dando **91,40 EUR**.

Es un fallo distinto del que viene resuelto en los apuntes: allí faltaba el JDK;
aquí el JDK está, pero el proyecto le pide otra versión del lenguaje.

---

## Parte 2 · Adaptar el entorno

**C6 · Complementos.**

- Antes de empezar, comprueba lo que PyDev necesita (apartado 6 de los apuntes):
  el Java que arranca Eclipse, y anótalo.
- **En Eclipse**, haz el ciclo completo con **PyDev**: instalar → comprobar que
  funciona → desinstalar → comprobar que ya no está → reinstalar → comprobar que
  vuelve. Anota nombre, versión, para qué sirve y qué necesita para funcionar.
  Deja PyDev **instalado** al terminar: lo necesitas en C10.
- **En IntelliJ**, **desactiva** temporalmente el complemento incluido
  **Markdown** y vuelve a activarlo. Describe qué se ve antes, durante y después.

No instales complementos que no se pidan ni desactives los de soporte de Java.

**C7 · Personalizar.** En el entorno que elijas:

- Deja en UTF-8 la codificación de fichero, de proyecto y de la consola de
  ejecución, y **comprueba** con la salida de `LoteLibros` que las tildes y la
  eñe salen bien («Cien años de soledad», «Manual de programación»).
- Activa el formato al guardar y comprueba que funciona.
- Asigna un atajo de teclado a una acción que vayas a usar: comprueba si hay
  conflicto, aplícalo, pruébalo y, si era solo de prueba, restáuralo.

De cada ajuste, anota **dónde** se cambia y **a qué alcance** afecta: todo el
entorno, el espacio de trabajo, el proyecto o una ejecución.

**C8 · Automatizar una ejecución.** El programa de la biblioteca también sabe leer
un lote de un fichero. En el proyecto de la biblioteca de uno de los dos
entornos:

1. Crea una carpeta `datos` en el proyecto (al lado de `src`) y copia dentro
   `pedido_marzo.txt`.
2. Crea una **configuración de ejecución** con nombre `Lote de marzo` que lance
   `LoteLibros` con el argumento `pedido_marzo.txt`, con `datos` como directorio
   de trabajo, y que construya antes de ejecutar (en Eclipse, comprueba el ajuste
   *Build (if required) before launching*).
3. La salida correcta incluye la línea `Origen de los datos: fichero
   pedido_marzo.txt` y la línea `Total del lote: 7 unidades, 92,80 EUR`. Después
   del total aparece la versión de Java.
4. Haz la misma ejecución **a mano desde la consola**, con la consola en `datos`
   y la orden del apartado 8 de los apuntes adaptada a `LoteLibros` y
   `pedido_marzo.txt`. Tiene que dar lo mismo.
5. Compara: **tres veces a mano** y **tres veces con la configuración**, con el
   mismo punto de inicio y de final que en los apuntes. Anota pasos y tiempo de
   cada una: tres filas con seis tiempos.

Si quieres estimar cuánto ahorra al día, di cuántas veces al día supones que se
repite la tarea.

**C9 · Actualizaciones.** En los dos entornos: anota la versión instalada del
entorno y de PyDev, dónde se revisan las actualizaciones del entorno y de los
complementos, cómo estaba configurado y cómo lo has dejado (avisar, no instalar
solo), y comprueba al **reabrir** la pantalla que se ha guardado. No hace falta
que haya ninguna actualización pendiente, y **no instales** ninguna. Después propón **una política de
actualización para el puesto de la biblioteca** y explica qué comprobarías
después de actualizar.

---

## Parte 3 · Dos lenguajes en el mismo entorno

**C10 · Java y Python en Eclipse.**

1. Instala Python 3 si no lo está, y comprueba `python --version` y
   `where.exe python`.
2. Configura en PyDev el intérprete de Python.
3. Crea un proyecto PyDev, copia `prestamos.py` y ejecútalo. La salida termina con
   el total de recargos (**2,40 EUR**), la versión de Python y la línea
   `Intérprete:`, que dice qué `python.exe` lo ha ejecutado.
4. En **el mismo Eclipse**, vuelve a ejecutar `LoteLibros` en su proyecto Java.
5. Rellena la tabla de componentes de la plantilla: qué ha hecho falta añadir al
   entorno, qué ha hecho falta instalar fuera, qué se genera en cada caso y quién
   ejecuta de verdad cada programa.

---

## Parte 4 · Comparar y decidir

**C11 · Medir y observar.** Rellena la tabla de medidas y observaciones de la
plantilla con el protocolo de los apuntes: mismo equipo, mismo proyecto, **tres
arranques por entorno** con sus tres tiempos y su mediana. La primera apertura y
el tamaño ya los tomaste al instalar; si alguno no se tomó, «no registrada». Las
cuatro observaciones se hacen con `LoteLibros.java` en los dos entornos.

En la columna de **VS Code**, solo lo que diga `caso_vscode.md` o sus fuentes,
citando cuál. Donde haría falta una medida tuya, escribe **«no observado»**.

**C12 · Común y específico.** Escribe tres apartados:

1. **Comunes** a IntelliJ y Eclipse, que hayas visto en los dos: al menos cuatro.
2. **Diferencias observadas en IntelliJ**: al menos dos.
3. **Diferencias observadas en Eclipse**: al menos dos.

Cada característica en una frase y, si puedes, con la actividad donde la viste
(«en C4, …»).

**C13 · Recomendación.** Recomienda un entorno para el puesto de la biblioteca,
apoyándote en evidencias de este informe: para quién es, qué evidencias la apoyan
y qué se pierde con esa elección.

Después responde al **escenario alternativo** que te toque según el **último
dígito del número de tu equipo del aula**:

| Último dígito | Escenario |
|---|---|
| 0, 1, 2 o 3 | El puesto se sustituye por un portátil con **8 GB de memoria** |
| 4, 5 o 6 | La biblioteca decide que el trabajo principal será **mantener scripts de Python**, y el programa Java se tocará poco |
| 7, 8 o 9 | La persona que usará el puesto necesita **ver ficheros Markdown con vista previa** y no quiere instalar nada más |

¿Cambiaría tu recomendación? Explica por qué con lo que has observado, no con
prestaciones que no hayas comprobado.

---

## Lo que se entrega

| | |
|---|---|
| **Qué** | El informe, hecho con la plantilla, con el **anexo de uso de IA** al final del mismo PDF |
| **Formato** | Un único PDF, sacado de la plantilla y comprobado al reabrirlo (apartado 0 de los apuntes) |
| **Nombre** | `CO3_apellido_nombre.pdf` |
| **Dónde y cuándo** | En la tarea de CO3 de Classroom, con la fecha que figure en ella |

Antes de entregar, repasa la **lista final** del final de la plantilla. La copia
de C5 tiene que haber quedado restaurada y el original intacto, y en la columna de
VS Code no puede haber medidas copiadas de otro equipo.

**Anexo de uso de IA.** Si no la has usado: «No he usado IA en esta entrega». Si la
has usado, los seis datos del apartado 0 de los apuntes, siguiendo
`evaluacion/PROTOCOLO_IA_1DAM.md`. Donde no hay repositorio, anota el ajuste o el
fichero con su valor antes y después; no hace falta ningún commit.

Cómo se califica cada parte está en `evaluacion/como-se-califica/practicas_contornos.md`.
