# Informe CO3 · Puesto de desarrollo para la biblioteca

> Trabaja sobre la versión editable, `plantilla_informe_CO3.docx`, guardada como
> `CO3_apellido_nombre.docx`. Rellénala mientras haces la práctica y entrégala **en
> un único PDF**, `CO3_apellido_nombre.pdf`, con el anexo de uso de IA incluido.
> Cómo se captura, se pega y se exporta está en el apartado 0 de los apuntes. No
> borres los encabezados: cada uno corresponde a una actividad del enunciado y es
> donde se busca su evidencia.

| | |
|---|---|
| Nombre y apellidos | |
| Equipo del aula (número o nombre) | |


## Cómo presentar cada evidencia

- **Una captura por evidencia** (`Win+Mayús+S`), recortada a lo que importa y
  legible sin ampliar.
- Debajo de cada captura, **una frase que diga qué demuestra**: «La consola de
  Eclipse muestra *Ejecutado con Java 25.0.x* y el total 91,40 EUR».
- No hacen falta capturas de cada clic: solo las que se piden.
- Si algo no ha funcionado, **no lo tapes**: explica qué pasó en el apartado de
  incidencias. Un bloqueo real bien documentado es información útil.

## Mapa de actividades y evidencias

Marca cada fila cuando la tengas. Es la lista que se revisa al corregir.

| Actividad | Evidencia que se busca | Hecho |
|---|---|---|
| C1 | Tabla de inventario completa, con la salida de `java --version` | ☐ |
| C2 | Versión, origen y tamaño de cada IDE, medidos al instalar | ☐ |
| C3 | En cada IDE: JDK del proyecto, nivel de lenguaje y salida de `ComprobarVentana` con la ventana visible | ☐ |
| C4 | En cada IDE: dónde está el `.class` generado, y la misma salida de `LoteLibros` desde el IDE y desde la consola | ☐ |
| C5 | Rutas del original y de la copia, el error provocado en la copia, dónde lo has leído, qué lo causa, y la copia restaurada y el original dando 91,40 EUR | ☐ |
| C6 | Ciclo del complemento en Eclipse (4 momentos) y desactivación temporal en IntelliJ (antes, durante, después) | ☐ |
| C7 | Codificación efectiva, formato al guardar y atajo (conflicto, prueba, restauración), cada uno con su alcance, y la salida de `LoteLibros` con tildes y eñe correctas | ☐ |
| C8 | La configuración de ejecución guardada (argumento, directorio de trabajo, construir antes), la salida con 92,80 EUR, la orden de consola y la tabla de tiempos: tres filas con seis tiempos | ☐ |
| C9 | Versiones del IDE y del complemento, dónde se revisan, el ajuste antes y después comprobado al reabrir, la política elegida y la comprobación posterior | ☐ |
| C10 | `LoteLibros` y `prestamos.py` ejecutados desde el mismo Eclipse, con la línea del intérprete visible, y la tabla de componentes | ☐ |
| C11 | Protocolo, tres arranques y su mediana por IDE, primera apertura y tamaño (o «no registrada»), y las cuatro observaciones | ☐ |
| C12 | Tres apartados: comunes, diferencias en IntelliJ, diferencias en Eclipse | ☐ |
| C13 | Recomendación para la biblioteca y respuesta al escenario alternativo | ☐ |
| Anexo | Declaración de uso de IA, en este mismo PDF | ☐ |

---

## C1 · Inventario del puesto

| Dato | Valor | Cómo lo has sabido |
|---|---|---|
| Sistema operativo y versión | | |
| Memoria RAM | | |
| Espacio libre en el disco donde vas a instalar | | |
| Carpeta de trabajo de CO3 | | |
| Salida de `java --version` | | |
| Salida de `where.exe java` | | |

## C2 · Instalación de los dos entornos

| | IntelliJ IDEA | Eclipse IDE for Java Developers |
|---|---|---|
| Versión exacta instalada | | |
| Origen de la descarga | | |
| Carpeta de instalación | | |
| Tamaño de la carpeta instalada (*Tamaño en disco*, medido al terminar) | | |
| Tiempo aproximado de instalación | | |
| Incidencias | | |

## C3 · Java 25 en cada entorno

| | IntelliJ IDEA | Eclipse |
|---|---|---|
| JDK del proyecto (nombre y carpeta) | | |
| Nivel de lenguaje / conformidad del compilador | | |
| Java que arranca el propio IDE (si lo has encontrado) | | |
| Salida de `ComprobarVentana` (las dos líneas) | | |

Capturas: ventana de Swing visible en cada IDE, junto a su consola.

## C4 · El mismo fuente en los dos

| | IntelliJ IDEA | Eclipse |
|---|---|---|
| Carpeta del proyecto | | |
| Carpeta donde ha quedado `LoteLibros.class` | | |
| Orden usada para ejecutarlo desde la consola | | |
| ¿Coinciden total y unidades con el lote de referencia? | | |

Capturas: la salida en la consola del IDE y en la consola del sistema, de cada
entorno.

## C5 · Incidencia provocada y resuelta

| Pregunta | Respuesta |
|---|---|
| Entorno | |
| Ruta del proyecto original | |
| Ruta de la copia de trabajo | |
| Total del original antes de empezar | |
| ¿Qué has cambiado exactamente en la copia? | |
| ¿Qué mensaje aparece y dónde? | |
| ¿Por qué ocurre? | |
| ¿Cómo lo has restaurado? | |
| Total de la copia después de restaurar | |
| Total del original al terminar | |

Captura: la copia restaurada ejecutando con su total, y el original ejecutando con
el suyo.

## C6 · Complementos

**Ciclo completo en Eclipse**

| Momento | Qué has hecho | Qué has comprobado |
|---|---|---|
| 1. Instalar | | |
| 2. Comprobar que funciona | | |
| 3. Desinstalar y comprobar que ya no está | | |
| 4. Reinstalar y comprobar que vuelve a funcionar | | |

Nombre, versión, función y dependencias del complemento (incluido el Java que
arranca Eclipse, con dónde lo has visto):

**Desactivación temporal en IntelliJ**

| | Qué se ve |
|---|---|
| Antes de desactivar | |
| Desactivado | |
| Reactivado | |

## C7 · Personalización

| Ajuste | Entorno | Dónde se cambia | Alcance (todo el IDE, espacio de trabajo, proyecto, ejecución) |
|---|---|---|---|
| Codificación efectiva del fichero | | | |
| Codificación del proyecto | | | |
| Codificación de la consola de ejecución | | | |
| Formato al guardar | | | |
| Atajo de teclado | | | |

Atajo: acción, combinación, ¿había conflicto?, cómo lo has probado y si lo has
restaurado:

Captura: salida de `LoteLibros` con las tildes y la eñe correctas.

## C8 · Automatización

| Dato de la configuración | Valor |
|---|---|
| Entorno | |
| Nombre de la configuración | |
| Programa que lanza | |
| Argumento | |
| Directorio de trabajo | |
| ¿Construye antes de ejecutar? | |
| ¿Dónde queda guardada? | |
| Orden usada a mano, desde `datos` | |

Captura: salida de la configuración con las líneas `Origen de los datos: fichero
pedido_marzo.txt` y `Total del lote: 7 unidades, 92,80 EUR`.

Tabla de tiempos: tres filas con seis tiempos. Inicio y final, los mismos en las
dos formas (apartado 8 de los apuntes).

| Repetición | Pasos a mano | Tiempo a mano | Pasos con la configuración | Tiempo con la configuración |
|---|---|---|---|---|
| 1 | | | | |
| 2 | | | | |
| 3 | | | | |

Estimación del ahorro (di cuántas veces al día supones que se repite la tarea):

## C9 · Actualizaciones

| | IntelliJ IDEA | Eclipse |
|---|---|---|
| Versión instalada | | |
| Dónde se revisan las actualizaciones del IDE | | |
| Dónde se revisan las de los complementos | | |
| Cómo estaba configurado antes | | |
| Cómo lo has dejado configurado | | |
| ¿Sigue igual al reabrir la pantalla? | | |

Política que propones para el puesto de la biblioteca y por qué:

Comprobación que harías después de actualizar:

## C10 · Java y Python en el mismo Eclipse

| | Java | Python |
|---|---|---|
| Qué ha hecho falta añadir al IDE | | |
| Qué ha hecho falta instalar fuera del IDE | | |
| Fichero que escribes | | |
| Qué se genera al ejecutar, y dónde | | |
| Quién ejecuta de verdad el programa | | |

Capturas: las dos ejecuciones en el mismo Eclipse, con la línea `Intérprete:`
visible en la de Python.

## C11 · Medidas y observaciones

Protocolo aplicado (equipo, proyecto abierto, qué has cerrado antes):

Arranques posteriores, tres por entorno:

| | Arranque 1 | Arranque 2 | Arranque 3 | Mediana |
|---|---|---|---|---|
| IntelliJ IDEA | | | | |
| Eclipse | | | | |

| | IntelliJ IDEA | Eclipse | VS Code (caso de referencia) |
|---|---|---|---|
| Primera apertura tras instalar (o «no registrada») | | | no observado |
| Arranque posterior (mediana de 3) | | | no observado |
| Espacio en disco | | | |
| Memoria con el proyecto abierto | | | no observado |
| Completar una instrucción | | | |
| Mostrar un error de compilación | | | |
| Encontrar el JDK del proyecto | | | |
| Ejecutar el mismo fuente | | | |

## C12 · Características comunes y específicas

**Comunes a IntelliJ y Eclipse** (mínimo cuatro):

1.
2.
3.
4.

**Diferencias observadas en IntelliJ** (mínimo dos):

1.
2.

**Diferencias observadas en Eclipse** (mínimo dos):

1.
2.

## C13 · Recomendación

Entorno que recomiendas para el puesto de la biblioteca, y las evidencias de
este informe en que te apoyas:

Escenario alternativo: ¿cambiaría tu recomendación? ¿Por qué?

---

## Incidencias

Rellena una fila por cada cosa que no haya salido a la primera y te haya costado
más de cinco minutos.

| Actividad | Qué pasó (síntoma) | Qué comprobaste | Cómo se resolvió, o en qué punto quedó |
|---|---|---|---|
| | | | |

## Lista final antes de entregar

- [ ] Las trece actividades tienen su apartado relleno.
- [ ] Cada captura se lee sin ampliar y lleva debajo su frase.
- [ ] En la columna de VS Code no hay medidas copiadas de otro equipo.
- [ ] Las incidencias que quedaron sin resolver están explicadas.
- [ ] La copia de C5 ha quedado restaurada y el original da el mismo total.
- [ ] El anexo de uso de IA está al final de este PDF.
- [ ] Has reabierto el PDF: ninguna tabla ni captura sale cortada.
- [ ] El fichero es un único PDF llamado `CO3_apellido_nombre.pdf`.

---

## Anexo · Declaración de uso de IA

Sigue `evaluacion/PROTOCOLO_IA_1DAM.md` y el ejemplo del apartado 0 de los apuntes.

Si no has usado IA, escribe solo: *No he usado IA en esta entrega.*

Si la has usado, copia este bloque una vez por consulta relevante:

| | |
|---|---|
| Actividad (C1…C13) | |
| Objetivo y resultado esperado (escrito antes de preguntar) | |
| Contexto compartido, y qué dejaste fuera | |
| Petición y resumen de la respuesta | |
| Decisión: qué aceptaste, cambiaste o rechazaste, y por qué | |
| Ajuste o fichero revisado, con su valor antes y después | |
| Prueba real: qué ejecutaste y qué salió | |
