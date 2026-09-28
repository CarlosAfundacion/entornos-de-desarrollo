# CO2 · Fases del desarrollo y herramientas

**Contornos de desenvolvemento · 1º DAM · Apuntes**


---

## Al terminar esta unidad vas a saber

- Que programar es **una** fase de un proceso más largo, no el proceso entero.
- Cuáles son las siete fases y qué se hace en cada una.
- Qué herramienta resuelve cada fase, y qué pasa cuando falta.

Es la unidad más corta del curso, tres sesiones. Pero lo que se construye aquí
—el cuadro de herramientas— es el índice de todo lo que viene después.

---

## 1. Programar no es el trabajo

Cuando alguien encarga una aplicación, escribir código es una parte del trabajo, y
casi nunca la más larga.

| Fase | Qué se hace | Pregunta que responde |
|---|---|---|
| **1. Análisis** | Averiguar qué hace falta de verdad | ¿Qué problema hay? |
| **2. Diseño** | Decidir cómo se va a construir | ¿Cómo lo resolvemos? |
| **3. Codificación** | Escribir el programa | — |
| **4. Pruebas** | Comprobar que hace lo que debe | ¿Funciona? |
| **5. Documentación** | Dejar escrito cómo funciona y cómo se usa | ¿Cómo se entiende? |
| **6. Explotación** | Ponerlo a funcionar de verdad | ¿Ya lo usa alguien? |
| **7. Mantenimiento** | Arreglarlo y mejorarlo mientras se usa | ¿Y ahora qué? |

### El orden no es tan limpio

En la práctica se va y se vuelve: pruebas que obligan a rediseñar, mantenimiento
que descubre que el análisis estaba mal. La lista de arriba es un mapa, no un
calendario.

### Dónde estás tú

En **la fase 3**, y a ratos en la 4. Durante el curso vas a ir tocando las demás:

| Fase | Cuándo la tocas |
|---|---|
| Análisis | CO9, con los casos de uso |
| Diseño | CO6, con los diagramas de clases; CO9, con secuencia/estados/actividades |
| Codificación | Todo el año |
| Pruebas | CO5, con el depurador; CO7, con JUnit |
| Documentación | Los comentarios `///`, desde PR1 |
| Explotación | CO3, con Maven |
| Mantenimiento | CO8, refactorizando tu propio código |

---

## 2. Las herramientas

Cada fase tiene herramientas — no todas el mismo número. Estas son las de este
curso, ordenadas por las siete fases de arriba, no por cuándo las vayamos a ver:

| Fase | Herramienta | Qué aporta | Qué pasa si falta |
|---|---|---|---|
| Análisis | **Diagramas de casos de uso** (CO9) | Modelan *qué* tiene que hacer el programa, sin decidir todavía *cómo* | No queda claro qué se le prometió a quien encargó la aplicación; cada uno construye «lo que le parece» y el desajuste se descubre al final |
| Diseño | **Generador de diagramas** (clases en CO6; secuencia, estados y actividades en CO9) | Ver la estructura antes de escribirla | Se descubre el error de diseño cuando ya está escrito |
| Codificación | **Consola, `javac` y `java`** | Entender qué pasa de verdad entre escribir código y verlo funcionar | Dependes del IDE a ciegas; el día que algo falla fuera de él (examen sin red, un servidor) no sabes por dónde mirar |
| Codificación | **IDE** (IntelliJ) | Editar, autocompletar, señalar errores al escribir | Se pierde el tiempo en errores que el editor habría cazado |
| Codificación | **Control de versiones** (Git) | Historial, deshacer, trabajar en paralelo | `juego_v2_final_BUENO.java` |
| Pruebas | **JUnit** | Comprobar el programa automáticamente | Probar a mano cada vez, y no hacerlo |
| Pruebas | **Depurador** | Ver el programa por dentro mientras corre | Cambiar cosas al azar hasta que «funcione» |
| Documentación | **Javadoc** | Generar la documentación desde el código | Documentación que envejece y miente, o no existe |
| Explotación | **Maven** | Compilar y montar el proyecto siempre igual, en cualquier máquina | «En mi máquina funciona» — y en la de quien lo tiene que usar, no |
| Mantenimiento | **Analizador de código** | Detectar código sospechoso | La deuda se acumula sin que nadie la vea, hasta que tocar una cosa rompe otras diez |



### La columna que importa

**La última.** Una herramienta no se entiende por lo que hace, sino **por el
problema que resuelve**. Si no sabes qué pasa cuando falta, no sabes para qué
sirve.

Por eso el cuadro que hay que entregar en esta unidad tiene esa columna, y por eso
es la que más puntúa.

---


---

## Resumen en una página

**Las siete fases:** análisis · diseño · codificación · pruebas · documentación ·
explotación · mantenimiento.

**Las herramientas de este curso:**

| Herramienta | Fase | El problema que resuelve |
|---|---|---|
| Diagramas de casos de uso | Análisis | No saber qué se prometió construir |
| Consola, `javac`, `java` | Codificación | Depender del IDE sin saber qué hace por debajo |
| IntelliJ | Codificación | Escribir a ciegas |
| Git | Codificación | Perder trabajo y no poder volver atrás |
| JUnit | Pruebas | Probar a mano y no hacerlo |
| Depurador | Pruebas | Adivinar en vez de mirar |
| Diagramas de clases, secuencia, estados, actividades | Diseño | Descubrir el error demasiado tarde |
| Javadoc | Documentación | Documentación que envejece y miente |
| Maven | Explotación | Que compile distinto en cada máquina |
| Analizador de código | Mantenimiento | Que la deuda técnica se acumule sin verse |

**La idea de la unidad:** una herramienta se entiende por el problema que resuelve,
no por su lista de funciones.

---


