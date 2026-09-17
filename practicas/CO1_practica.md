# CO1 · Práctica: abrir la caja

**Contornos de desenvolvemento · 1º DAM 


En Programación estás escribiendo programas que funcionan. Aquí vas a ver **por
qué** funcionan. Al terminar esta práctica sabrás exactamente qué pasa entre que
guardas el fichero y ves algo en pantalla.

> Toda la salida que aparece aquí está capturada de una ejecución real con JDK 25.
> Lo que veas en tu pantalla debe parecerse mucho. Si no se parece, avisa.

---

## Preparación

Crea una carpeta `co1` y dentro un fichero `Saludo.java` con **exactamente** esto:

```java
void main() {
    IO.println("Hola, mazmorra.");
}
```

Abre una consola **en esa carpeta**: botón derecho sobre un sitio vacío de la
carpeta, en el Explorador, → *Abrir en Terminal*. Todo lo demás se hace ahí.

Comprueba antes de seguir que  `dir`
lista `Saludo.java`. Si no, no estás donde crees. El recorrido completo —instalar
Java 25, ver las extensiones, guardar en texto plano, abrir la consola— está en
`programacion/GUIA_ENTORNO_JAVA.md`, en el material del curso.

---

## Paso 1 · Compilar a mano

Hasta ahora ejecutabas con `java Saludo.java` y pasaba todo de golpe. Ahora vamos a
partirlo en dos.

```
javac Saludo.java
```

No dice nada. En informática, callarse suele ser buena señal.

Mira la carpeta:

```
Saludo.java
Saludo.class
```

**Ha aparecido un fichero nuevo que tú no has escrito.**

**P1.** ¿Cuánto ocupa cada uno de los dos ficheros, en bytes? Lo dice el Explorador
en *Propiedades* (botón derecho sobre el fichero), o `dir` en la consola, que enseña
el tamaño en la columna de la izquierda del nombre. Anótalo.

---

## Paso 2 · El `.class` no es para ti

Ábrelo con el bloc de notas.

Lo que sale es basura. No es un error: es que **ese fichero no está escrito para
que lo leas tú**. Está escrito para que lo lea la máquina virtual de Java.

### Antes de seguir: bit, byte y hexadecimal

- Un **bit** es un 0 o un 1. Un **byte** son ocho bits agrupados, y es la unidad con
  la que se miden los ficheros: tu `.class` ocupa unos cientos de bytes.
- Un byte puede valer de 0 a 255. Escribirlo en decimal es incómodo, así que se
  escribe en **hexadecimal**, que es contar en base 16 usando dieciséis símbolos:
  `0 1 2 3 4 5 6 7 8 9 a b c d e f`, donde `a` vale 10 y `f` vale 15.
- **Cada byte son exactamente dos símbolos hexadecimales.** El de la izquierda vale
  16 veces más que el de la derecha:

  ```
  45  ->  4 × 16  +  5 × 1  =  64 + 5  =  69
  ca  ->  c × 16  +  a × 1  = 12 × 16 + 10  =  202
  ```

### Ver los bytes de verdad

El bloc de notas **no** te enseña los bytes: intenta leerlos como si fueran letras, y
por eso sale basura. Para verlos hay que usar una vista hexadecimal. En PowerShell,
sin instalar nada:

```powershell
Format-Hex -Path .\Saludo.class | Select-Object -First 3
```

Los primeros dieciséis bytes del fichero salen así:

```
00000000   CA FE BA BE 00 00 00 45  00 16 0A 00 02 00 03 07
```

A la izquierda va la **posición**, en hexadecimal, del primer byte de cada fila; a
la derecha, los bytes de uno en uno.

Los cuatro primeros son `CA FE BA BE`. Escritos seguidos se leen como la palabra
*CAFEBABE*, y por eso se llama así; **no es texto guardado dentro del fichero**, son
cuatro bytes cuya escritura en hexadecimal resulta pronunciable. Es una marca que
llevan todos los ficheros `.class` del mundo desde 1995, y sirve para que la máquina
virtual sepa, nada más abrirlo, que eso es cosa suya.

**P1b.** Cuenta los bytes desde el principio y di cuál es **el octavo**. Ojo: el
primero es `CA`, no el `00`.

**P2.** Ese octavo byte vale `45` en hexadecimal, que en decimal es **69**. Ese
número identifica la versión del formato del `.class`. Estas versiones modernas de
Java generan estas:

| Java | Versión del `.class` |
|---|---|
| 17 | 61 |
| 21 | 65 |
| 25 | 69 |

¿Qué relación hay entre el número de versión de Java y este número, **en estas
tres**? Escribe la fórmula.

> No la presentes como una ley universal: es una regularidad que se cumple en las
> versiones citadas, y lo que de verdad manda es lo que diga la especificación de la
> máquina virtual.

---

## Paso 3 · Ejecutar lo compilado

```
java Saludo
```

```
Hola, mazmorra.
```

Fíjate bien: **sin el `.java` al final**. Antes ejecutabas el fichero fuente; ahora
ejecutas la clase ya compilada.

**P3.** Prueba las dos formas, `java Saludo` y `java Saludo.java`. Las dos
funcionan. Explica en dos líneas qué hace cada una por dentro y por qué una tarda
un poco más.

**P4.** Borra `Saludo.java`, dejando solo el `.class`, y ejecuta `java Saludo`.
¿Funciona? ¿Qué te dice eso sobre qué es lo que se reparte cuando se distribuye un
programa? (Después vuelve a crear el fichero, que hace falta.)

---

## Paso 4 · Mirar dentro del `.class`

Existe una herramienta que traduce el `.class` a algo legible.

```
javap Saludo
```

```
Compiled from "Saludo.java"
final class Saludo {
  Saludo();
  void main();
}
```

Léelo despacio, porque aquí hay algo raro.

Tú has escrito **tres líneas** y ninguna decía `class`. Pero en el `.class` hay una
clase, se llama `Saludo` —como el fichero— y dentro está tu `main`.

**P5.** ¿De dónde ha salido esa clase, si tú no la has escrito?

> **Escribe tu respuesta antes de seguir leyendo, y guárdala.** No hace falta que
> aciertes: lo que se corrige es haber hecho una hipótesis y haberla comprobado
> después, no haber dado con ella. En el apartado 2 de los apuntes está la pista, y en
> la unidad **PR5** de Programación se resuelve del todo. Entonces vuelves a esta hoja
> y compruebas si lo habías pillado.

---

## Paso 5 · El bytecode

```
javap -c Saludo
```

```
Compiled from "Saludo.java"
final class Saludo {
  Saludo();
    Code:
         0: aload_0
         1: invokespecial #1     // Method java/lang/Object."<init>":()V
         4: return

  void main();
    Code:
         0: ldc           #7     // String Hola, mazmorra.
         2: invokestatic  #9     // Method java/lang/IO.println:(Ljava/lang/Object;)V
         5: return
}
```

Esto es **bytecode**: las instrucciones que ejecuta de verdad la máquina virtual.
No es el lenguaje del procesador de tu ordenador; es el lenguaje de la JVM.

Tu `main` son tres instrucciones:

| | Instrucción | Qué hace |
|---|---|---|
| 0 | `ldc` | Carga la constante `"Hola, mazmorra."` |
| 2 | `invokestatic` | Llama a `IO.println` pasándole esa constante |
| 5 | `return` | Termina |

**P6.** En la línea del `ldc` aparece tu texto tal cual. ¿Está el texto guardado
dentro del `.class`? ¿Qué pasaría si lo cambias en el `.java` y vuelves a compilar?
Compruébalo.

**P7.** Cambia el programa para que escriba **dos** líneas en vez de una. Compila y
vuelve a hacer `javap -c`. ¿Cuántas instrucciones tiene ahora el `main`? ¿Se
corresponde con lo que has escrito?

---

## Paso 6 · Por qué existe todo esto

Ese `.class` con el `CAFEBABE` funciona igual en Windows, en Linux y en un Mac, sin
recompilar. Lo único que hace falta en cada sitio es una máquina virtual.

Eso es lo que se quiere decir con que Java es un lenguaje **híbrido**: se compila,
pero no a instrucciones del procesador, sino a un idioma intermedio que después
interpreta y traduce la JVM.

**P8.** Completa la tabla con lo que has visto hoy:

| | ¿Qué es? | ¿Se lee? | ¿Se puede ejecutar directamente? |
|---|---|---|---|
| `Saludo.java` | | | |
| `Saludo.class` | | | |

**P9.** Explica con tus palabras la diferencia entre **JDK**, **JRE** y **JVM**.
Una frase cada uno. Pista: uno es para escribir programas, otro para ejecutarlos y
el tercero está dentro de los dos.

---

## Lo que se entrega

Un documento con:

1. Las respuestas de la **P1 a la P9**, incluida la **P1b**.
2. Una **captura de tu propia salida** de `javac`, `javap` y `javap -c`. La tuya,
   no la de esta hoja. Para capturar solo una parte de la pantalla: `Win+Shift+S`,
   se arrastra sobre la zona, y se pega con `Ctrl+V` en el documento.
3. Al final, **cinco líneas seguidas** explicando el camino completo desde que
   guardas el `.java` hasta que ves letras en la pantalla. Sin viñetas: cinco líneas
   de texto corrido, como si se lo contases a alguien.

Ese último punto es el que más puntúa.

---

## Si terminas antes

- `javap -v Saludo` saca muchísimo más. Busca dentro la línea `major version` y
  comprueba que coincide con lo del paso 2.
- Compila el `E13Ficha.java` de Programación y mira su bytecode. Tiene tres
  `IO.readln`: encuéntralos.
- Averigua qué pasa si compilas con `javac --release 21 Saludo.java`. `--release`
  le pide a `javac` que genere un `.class` para esa versión. **Aviso: aquí va a
  fallar**, y ese es el ejercicio: la forma corta que estás usando —un fichero sin
  `class` y con `void main()`— solo existe a partir de Java 25, así que no hay forma
  de traducirla a Java 21 cambiando una opción. Lee el error y explica con tus
  palabras qué te está diciendo.
- **Ojo con una trampa**: si una compilación falla, **el `.class` anterior sigue
  ahí**. No des por bueno un `javap` sin haber mirado antes si el `javac` terminó
  sin errores.
