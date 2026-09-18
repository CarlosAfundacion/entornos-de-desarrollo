# CO1 · Qué pasa cuando ejecutas un programa

**Contornos de desenvolvemento · 1º DAM · Apuntes**

---

## Al terminar esta unidad vas a saber

- Qué ocurre de verdad entre que pulsas Enter y aparece algo en pantalla.
- Compilar y ejecutar a mano, sin IDE.
- La diferencia entre código fuente, código objeto y ejecutable.
- Qué es la JVM, qué es el JDK y qué es el JRE, que se confunden siempre.
- Por qué Java funciona igual en Windows y en Linux.
- Entender por qué a veces se muestran mal los acentos y otros caracteres.

---

## 1. El programa y la máquina

Cuando ejecutas un programa, tres piezas del ordenador se reparten el trabajo:

| Pieza | Qué hace |
|---|---|
| **Procesador** | Ejecuta las instrucciones, una detrás de otra |
| **Memoria** | Guarda el programa y sus datos mientras corre |
| **Periféricos** | Todo lo que entra y sale: teclado, pantalla, disco, red |

**El sistema operativo** es el programa que manda en la máquina: reparte la memoria
y el procesador entre los programas, y es el único que habla con los periféricos.
Windows y Debian son sistemas operativos.

Tu programa no habla directamente con el teclado ni con la pantalla. Le pide al
sistema operativo que lo haga por él, y el sistema operativo habla con el
dispositivo.

```
   tu programa  →  sistema operativo  →  pantalla
```

### Memoria y disco, que no son lo mismo

| | Memoria (RAM) | Disco |
|---|---|---|
| Para qué | Donde el programa **trabaja** mientras corre | Donde las cosas **se quedan** |
| Velocidad | Muy rápida | Mucho más lenta |
| Al apagar | **Se borra entera** | Se conserva |
| Cuánta hay | Poca (8, 16 GB) | Mucha (cientos de GB) |

Cuando abres el editor y escribes, lo que escribes está **en memoria**. Hasta que no
pulsas `Ctrl+S`, en el disco no hay nada nuevo: por eso, si se va la luz, se pierde
lo que no habías guardado. Y por eso `java Hola.java` ejecuta **lo último que
guardaste**, no lo que se ve en la pantalla del editor.

El mismo reparto explica el resto del curso: el `.java` y el `.class` viven en el
disco; las variables de tu programa viven en memoria y desaparecen al terminar.

Esa cadena de intermediarios explica un posible error de visualización.

### Por qué pueden salir mal los acentos

En los ordenadores del aula esto normalmente no sucede. El JDK 25 usa **UTF-8
como codificación predeterminada** de Java (`file.encoding`), pero la entrada y la
salida de la consola son independientes de esa codificación. En nuestra consola de
Windows, Java usa la página de códigos CP850 para `stdin` y `stdout` porque es la
que está usando el terminal.

Eso significa que pueden convivir sin problema dos codificaciones distintas:

```text
fichero .java: UTF-8  →  Java trabaja con caracteres  →  consola: CP850
```

Java hace la conversión entre ambas. Por eso **ver `file.encoding=UTF-8` y a la
vez `stdin.encoding=cp850` o `stdout.encoding=cp850` no significa que haya un
error**. De hecho, en los equipos del aula esa combinación es la correcta.

El problema aparece cuando **dos extremos que se están comunicando no esperan la
misma codificación**. Entonces la ñ, las tildes u otros caracteres pueden aparecer
convertidos en símbolos raros.

No es necesariamente un error de programación: es que **dos piezas de la cadena
no se han puesto de acuerdo sobre cómo se codifica el texto**.

Conviene distinguir estas cosas:

| | Qué es |
|---|---|
| La codificación **del fichero** | Cómo guardó tu editor el `.java`. En este curso, siempre UTF-8 |
| `file.encoding` | La codificación predeterminada que usan muchas APIs de Java. En JDK 25, normalmente UTF-8 |
| La codificación **de salida** | Cómo codifica Java lo que envía por la salida estándar (`stdout.encoding`) |
| La codificación **de entrada** | Cómo interpreta Java lo que recibe por la entrada estándar (`stdin.encoding`) |

Y hay otra parte que no pertenece a Java: **la codificación que está usando la
consola**. Lo importante no es que todo sea UTF-8, sino que los dos extremos de
cada comunicación estén de acuerdo.

Para ver qué está usando tu Java:

```text
java -XshowSettings:properties -version
```

- `-version` dice la versión y termina. Es la orden más corta que existe para
  arrancar Java sin ejecutar ningún programa tuyo.
- `-XshowSettings:properties` hace que además imprima **todas sus propiedades**: una
  lista larga de parejas nombre-valor con las que Java arranca.

Busca especialmente estas líneas:

```text
file.encoding
stdin.encoding
stdout.encoding
```

En los equipos del aula es normal encontrar algo parecido a:

```text
file.encoding = UTF-8
stdin.encoding = cp850
stdout.encoding = cp850
```

No hay contradicción: el código fuente puede estar en UTF-8 mientras Java se
comunica con una consola CP850.

Para comprobar qué página de códigos usa `cmd`, puedes ejecutar:

```text
chcp
```

### Provocar el fallo a propósito

Podemos forzar Java a usar UTF-8 en la entrada y la salida **solo para ver qué
ocurre cuando los dos extremos dejan de coincidir**:

```text
java -Dstdout.encoding=UTF-8 -Dstdin.encoding=UTF-8 MiPrograma.java
```

Cada `-D` da un valor a una propiedad **solo durante esa ejecución**. No cambia
nada de forma permanente.

En una consola que sigue trabajando en CP850, hemos hecho esto:

```text
Java envía UTF-8  →  la consola interpreta CP850  →  caracteres incorrectos
```

Por eso las tildes o la `ñ` pueden verse mal. **Este comando no es una solución:
es un experimento para provocar el desajuste y reconocer sus síntomas.** Si la
consola también estuviese usando UTF-8, ese desajuste no existiría.

### Comprobarlo de ida y de vuelta

Un programa que escribe y lee permite ver los dos sentidos a la vez:

```java
void main() {
    IO.println("Lucía, ñ, ¿qué tal?");
    String x = IO.readln("Escribe tu nombre con tilde o ñ: ");
    IO.println("He leído: " + x);
}
```

Primero ejecútalo normalmente. En los equipos del aula deberían verse bien tanto
la salida como lo que escribes.

Después repite la ejecución forzando UTF-8 con los dos `-D`. Si la consola sigue
en CP850, podrás observar el desajuste. Si falla la salida, el problema se ve al
escribir en pantalla; si falla la entrada, se ve al recuperar lo que has tecleado.

> Lo importante no es «poner UTF-8 en todas partes». Lo importante es entender
> **qué codificación usa cada extremo de una comunicación** y que ambos coincidan.
> El comando con `-D` nos sirve precisamente para romper ese acuerdo a propósito y
> ver qué ocurre.

---

## 2. Fuente, objeto y ejecutable

Tú escribes texto. El procesador ejecuta números. En medio hay una traducción.

| | Qué es | Extensión |
|---|---|---|
| **Código fuente** | Lo que escribes tú. Texto que puede leer una persona | `.java` |
| **Código objeto** | El resultado de traducirlo. En Java, *bytecode* | `.class` |
| **Ejecutable** | Lo que el sistema puede lanzar directamente | `.exe`, o nada en Java |

### Hazlo a mano

Escribe `Hola.java`:

```java
void main() {
    IO.println("Hola");
}
```

**Paso 1 — compilar.** Traduce el fuente a bytecode:

```
javac Hola.java
```

Si no hay errores, no dice nada. Y aparece un fichero nuevo: `Hola.class`.

**Paso 2 — ejecutar.** Lanza el bytecode:

```
java Hola
```

> Desde Java 11 se puede hacer todo de una vez con `java Hola.java`, y es lo que
> usamos en Programación. Pero por debajo ocurren los dos pasos igual, y conviene
> haberlos visto separados una vez.

### Mira el `.class` por dentro

```
javap -c Hola
```

Sale esto (salida real de JDK 25):

```
Compiled from "Hola.java"
final class Hola {
  Hola();
    Code:
         0: aload_0
         1: invokespecial #1     // Method java/lang/Object."<init>":()V
         4: return

  void main();
    Code:
         0: ldc           #7     // String Hola
         2: invokestatic  #9     // Method java/lang/IO.println:(Ljava/lang/Object;)V
         5: return
}
```

Eso es **bytecode**: las instrucciones a las que se ha traducido tu programa.

**No hay que saber leer bytecode, y no se evalúa.** Lo que sí se pide es saber
señalar tres cosas en esa salida. Para eso, el mínimo de vocabulario:

| Lo que ves | Qué es |
|---|---|
| `class Hola` | La **clase**: la caja donde Java agrupa el código. Qué es por dentro, en PR5 y PR7 |
| `Hola();` | Un **constructor**: lo que se ejecuta al crear un objeto de esa clase. Hoy solo hay que saber que está |
| `void main();` | Tu programa. El `void` dice que no devuelve ningún resultado |
| `0:`, `2:`, `5:` | La **posición** de cada instrucción dentro del método, no el número de línea de tu fichero |
| `#7`, `#9` | Una referencia a una tabla interna del `.class` donde viven los textos y los nombres. `javap` es legible y pone al lado, tras `//`, a qué apunta |
| `Object` | La clase de la que descienden todas las demás en Java. Eso es PR8 |

Y las tres cosas que sí hay que ver a simple vista:

- Ahí está tu texto: `ldc #7  // String Hola` carga la constante `"Hola"`.
- Ahí está la llamada: `invokestatic ... IO.println`.
- **Y hay cosas que tú no escribiste.** Aparece una `class Hola` que no pusiste, y un
  constructor `Hola()` que tampoco. El compilador los ha puesto por ti: el punto de
  entrada tiene que vivir dentro de una clase, y cuando el fichero es tan corto Java
  la crea con el nombre del fichero.

Lo que queda para PR5 no es **que** exista esa clase, sino **qué es una clase por
dentro** y por qué el `main` de la forma larga se escribe como se escribe. 

Lo que hay que entender es que el bytecode **existe**, que es lo que de verdad se
ejecuta, y que tu `.java` es solo el punto de partida.

### `javap` tiene tres niveles

| Orden | Qué enseña |
|---|---|
| `javap Saludo` | Solo la **estructura**: qué clase hay y qué métodos tiene |
| `javap -c Saludo` | Además, las **instrucciones** de cada método: el bytecode |
| `javap -v Saludo` | Todo, incluida la tabla de constantes y la línea `major version` |

En los tres casos opera **sobre el `.class`**, no sobre el `.java`, y se le pasa el
nombre de la clase **sin la extensión**.

---

## 3. Código intermedio y máquinas virtuales

Un compilador de C traduce el fuente a instrucciones del procesador concreto. El
resultado corre en las máquinas **compatibles**: mismo tipo de procesador, mismo
sistema operativo y las mismas librerías. Un programa compilado para Windows de 64
bits no corre en un Linux ni en un móvil, aunque el ordenador de al lado sí lo
ejecute.

Java hace algo distinto: traduce a **bytecode**, que no son instrucciones de ningún
procesador real, sino de una máquina inventada: la **máquina virtual de Java**.

```
   Hola.java  ──javac──>  Hola.class  ──JVM──>  se ejecuta
   (fuente)               (bytecode)
```

La JVM es un programa normal, instalado en tu ordenador, que lee bytecode y lo va
traduciendo a instrucciones reales de tu procesador.

### Qué se gana

**El mismo `.class` funciona en cualquier sitio donde haya una JVM que lo entienda.**
Windows, Linux, Mac. No hay que recompilar: el fichero es idéntico.

Con dos condiciones, que son las que hacen que la frase sea verdad y no un eslogan:

- **La versión.** Un `.class` lleva grabado para qué versión se generó. Una JVM de
  Java 21 **no** ejecuta bytecode de Java 25: contesta
  `UnsupportedClassVersionError`. Al revés sí funciona. Está en la especificación:
  <https://docs.oracle.com/javase/specs/jvms/se25/html/jvms-1.html>
- **Las dependencias.** Si tu programa usa librerías, tienen que estar también
  donde se ejecute.

Lo que cambia es la JVM, que es distinta en cada sistema. La frase que resume Java
desde los noventa: *escribe una vez, ejecuta en cualquier parte*.

### Qué se pierde

Una capa de traducción cuesta tiempo. Java es algo más lento que C en arranque,
aunque muy poco en programas largos, porque la JVM va optimizando lo que más se
repite mientras corre.

### JDK, JRE y JVM

Se confunden siempre. De dentro afuera:

| | Qué es | Lo necesitas si… |
|---|---|---|
| **JVM** | La máquina virtual.  | *Ejecuta bytecode (va dentro del JRE)* |
| **JRE** | La JVM + las librerías básicas | Solo quieres **ejecutar** programas Java |
| **JDK** | El JRE + el compilador (`javac`) y herramientas | Quieres **escribir** programas Java |

```
┌─ JDK ──────────────────────────────┐
│  javac, javap, jar...              │
│  ┌─ JRE ────────────────────────┐  │
│  │  librerías (String, Math...) │  │
│  │  ┌─ JVM ─────────────────┐   │  │
│  │  │  ejecuta el bytecode  │   │  │
│  │  └───────────────────────┘   │  │
│  └──────────────────────────────┘  │
└────────────────────────────────────┘
```

Nosotros instalamos el **JDK**, porque escribimos programas.

---

## 4. Clasificar los lenguajes

### Por cómo se ejecutan

| Tipo | Modelo simplificado | Ejemplos |
|---|---|---|
| **Compilados** | Se traducen enteros a instrucciones de la máquina **antes** de ejecutar | C, C++, Rust |
| **Interpretados** | Se traducen **mientras** se ejecutan, sin generar un ejecutable previo | Python, JavaScript |
| **Híbridos** | Se compilan a un código intermedio que ejecuta una máquina virtual | **Java**, C# |

Java es híbrido, y eso explica todo lo anterior: por eso hay un `.class`, por eso
hay una JVM, y por eso el mismo fichero corre en varios sistemas.

> **Los tres cajones son un modelo, no una ley.** Una cosa es el **lenguaje** y otra
> la **implementación** concreta que lo ejecuta. Python compila a bytecode antes de
> interpretarlo —los ficheros `.pyc` de la carpeta `__pycache__` son eso— y los
> navegadores compilan JavaScript a instrucciones reales mientras corre, para que
> vaya rápido. Así que «interpretado» aquí significa «no produces un ejecutable y lo
> distribuyes», no «se traduce estrictamente línea a línea».
>
> Fuentes: <https://docs.python.org/3/glossary.html#term-bytecode> ·
> <https://v8.dev/blog/launching-ignition-and-turbofan>
>
> No hay que memorizar categorías que se contradicen. Lo que hay que saber es **qué
> pasa entre tu fichero y la pantalla**, que es lo que has visto hoy.

### Por nivel

| Nivel | Cómo de cerca está de la máquina | Ejemplos |
|---|---|---|
| **Bajo** | Instrucciones del procesador | Ensamblador |
| **Medio** | Cerca de la máquina, pero legible | C |
| **Alto** | Cerca de cómo pensamos las personas | Java, Python |

### Por paradigma

Cómo se organiza el código: **estructurado** (instrucciones y funciones),
**orientado a objetos** (datos y comportamiento juntos), **funcional** (funciones
que se combinan).

Java es de alto nivel, híbrido y principalmente orientado a objetos. Este año vas a
programarlo primero de forma estructurada, y **a partir de la unidad PR5** vas a
empezar a usar objetos que ya existen; escribir tus propias clases llega en PR7.

---

## Resumen en una página

```
   Hola.java  ──javac──>  Hola.class  ──java──>  salida por pantalla
    fuente                 bytecode              (la JVM lo ejecuta)
```

| Concepto | En una línea |
|---|---|
| Código fuente | Lo que escribes. `.java` |
| Bytecode | Lo que se genera. `.class` |
| JVM | El programa que ejecuta el bytecode |
| JRE | JVM + librerías. Para ejecutar |
| JDK | JRE + `javac`. Para programar |
| `javac` | Compila fuente a bytecode |
| `java` | Ejecuta bytecode |
| `javap -c` | Enseña el bytecode de un `.class` |

**Las cinco ideas de la unidad**

1. Tu programa habla con los periféricos **a través del sistema operativo**. De ahí
   venía lo de los acentos.
2. Lo que escribes y lo que se ejecuta **no son lo mismo**. Hay una traducción.
3. El bytecode no es de ningún procesador real: es de la **máquina virtual**.
4. Por eso el mismo `.class` corre en Windows y en Linux sin recompilar.
5. JDK para escribir, JRE para ejecutar, JVM dentro de los dos.

---

## Una pregunta que se abre en PR5

En la práctica de esta unidad hay una pregunta, la **P5**, cuya respuesta no se da
todavía.

**Guarda lo que contestes**, aunque después leas aquí la respuesta: lo que cuenta es
haber escrito tu hipótesis antes y haberla comprobado después.

En la unidad **PR5** de Programación,  se abre otra vez y
se ve lo que hoy no se podía ver: qué es una clase por dentro y qué significa cada
palabra de la forma larga del `main`.
