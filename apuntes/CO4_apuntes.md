# CO4 · Control de versiones

**Contornos de desenvolvemento · 1º DAM · Apuntes**

---

## Esta unidad va en dos tramos

| | Cuándo | Apartados | Qué |
|---|---|---|---|
| **Tramo A** | Ahora | 1 a 4 | Traer tu repositorio, confirmar cambios, subirlos y leer lo que contesta el corrector |
| **Tramo B** | En noviembre | 5 a 9 | Leer el historial, ignorar lo que no se sube, recuperar versiones, ramas y conflictos |

Está partida a propósito. El tramo A es oficio: necesitas Git desde octubre para
entregar. El tramo B llega cuando ya tienes semanas de historial propio, y entonces
las ideas se explican sobre algo tuyo.


---

## Cómo están escritos estos apuntes

Del apartado 2 al 9, cada uno tiene las mismas cuatro partes:

| Parte | Qué es |
|---|---|
| **La explicación** | Lo mínimo que hay que saber antes de escribir una orden |
| **En directo** | Un ejemplo que se hace en clase a la vez, en pantalla y en tu equipo. Pasos numerados y **lo que tienes que ver** después de cada uno |
| **Errores típicos** | Lo que suele salir mal, cómo se reconoce y cómo se sale |
| **Ahora tú** | Lo mismo con otros datos, sin ayuda. Trae el **resultado esperado**: si lo que ves coincide, está bien |

### Dos sitios de trabajo que no se mezclan

| Carpeta | Para qué | Se entrega |
|---|---|---|
| `git\lab-co4` · **el laboratorio** | Los ejemplos «En directo» y los «Ahora tú». Aquí se puede romper todo | No |
| `git\hito1-TUUSUARIO` · **tu repositorio del juego** | Lo de Programación y la práctica de esta unidad | Sí |

El laboratorio se crea con `git init` y **no tiene remoto**. Tu repositorio del juego
**no se crea**: ya existe en GitHub y se **clona**. Si alguna vez dudas de en cuál
estás, `git remote -v`: el laboratorio no contesta nada; el del juego contesta su URL.

### Antes de empezar

- Los mensajes de Git salen en inglés. Si tu Git los da en español, cambia el idioma,
  no el significado.
- Las órdenes se escriben en el terminal de IntelliJ (*View → Tool Windows → Terminal*)
  o en PowerShell. Las de Git son iguales en los dos.
- Los ficheros pequeños de los ejemplos se crean con el editor (en IntelliJ, *File →
  New → File*) con el contenido **exacto** que se da, línea a línea.
- Cuando `git log` o `git diff` llenan la pantalla y se quedan esperando, se sale con
  **`q`**.
- Los nombres de menú de IntelliJ son los de las versiones actuales. Si en tu versión
  no encuentras uno, **Ctrl+Mayús+A** y escribe el nombre de la acción.

---

# TRAMO A

## 1. Qué problema resuelve

Sin control de versiones, esto te va a pasar:

```
juego.java
juego_v2.java
juego_v2_bueno.java
juego_v2_final.java
juego_v2_final_BUENO.java
juego_definitivo_ESTE_SI.java
```

Y cuando algo se rompa, no sabrás cuál funcionaba ni qué cambiaste.

Git guarda **el historial completo** de tu proyecto: qué cambió, cuándo, quién lo
hizo y con qué intención, y te deja volver a cualquier punto anterior.

### Los cuatro sitios

```
  carpeta de trabajo ──git add──> preparado ──git commit──> historial ──git push──> GitHub
     (editas aquí)            (lo que va a entrar)     (en tu equipo)          (el remoto)
                                                                <──git pull──
```

- **Carpeta de trabajo**: los ficheros tal como los ves en el editor.
- **Preparado** (*staging area* o índice): lo que entrará en el próximo commit.
  `add` no guarda: **prepara**.
- **Historial**: la lista de commits de tu equipo. `commit` es el que guarda.
- **Remoto**: la copia en GitHub. `push` sube tus commits; `pull` trae los que no
  tienes.

Un **commit** es una foto del proyecto con un mensaje, un autor, una fecha y un
identificador (el *hash*, algo como `1dc6947`).

---

## 2. Preparar el puesto y traer tu repositorio

### La explicación

Antes del primer commit hacen falta cinco cosas, **en este orden**:

| | Qué | Por qué |
|---|---|---|
| 1 | Git instalado -Descárgalo del siguiente [enlace](https://github.com/git-for-windows/git/releases/download/v2.56.0.windows.1/Git-2.56.0-64-bit.exe) | `git --version` responde |
| 2 | **Identidad**: nombre y correo | Va escrita dentro de cada commit que hagas. No se cambia después |
| 3 | **Acceso**: aceptar la invitación a tu repositorio | El repositorio es privado: sin aceptar, no existe para ti |
| 4 | **Autenticación**: demostrar a GitHub que eres tú | GitHub no acepta tu contraseña desde el terminal. La primera vez se abre el navegador para iniciar sesión |
| 5 | **Clonar**: traer el repositorio a una carpeta tuya | Crea la carpeta, trae el historial y deja apuntado de dónde viene |

Al clonar quedan fijadas tres cosas que conviene saber mirar:

| | Qué es | Cómo se mira |
|---|---|---|
| **Carpeta** | Dónde está tu copia. Git solo funciona **dentro** de ella | `Get-Location` (PowerShell) o la ruta del terminal |
| **Rama** | La línea de trabajo en la que estás. En este curso, `main` | `git branch --show-current` |
| **Remoto** | La dirección de GitHub a la que subes. Se llama `origin` | `git remote -v` |

Tu repositorio **no se crea con `git init`**: ya existe en GitHub, creado desde una
plantilla, con tu nombre de usuario en la dirección. `git init` solo se usa para crear
un repositorio **nuevo y vacío**, como el laboratorio del apartado 3.

### En directo

1. Comprueba Git.

   ```
   git --version
   ```

   **Ves:** `git version 2.…` (el número exacto da igual).

2. Pon tu identidad. El correo, el de tu cuenta de GitHub.

   ```
   git config --global user.name "Nombre Apellido"
   git config --global user.email "tu.correo@ejemplo.com"
   git config --global init.defaultBranch main
   git config --global core.autocrlf true
   git config --global pull.rebase false
   ```

   **Ves:** nada. Git no contesta cuando todo va bien. Compruébalo:

   ```
   git config --global --list
   ```

   **Ves:** tus dos líneas `user.name=…` y `user.email=…`, y las otras tres.

3. Acepta la invitación. Llega al correo de tu cuenta de GitHub; si no la ves, mira en
   spam o entra en `https://github.com/ORGANIZACION/hito1-TUUSUARIO/invitations`.
   `ORGANIZACION` y `TUUSUARIO` te los dan en clase.

   **Ves:** la página de tu repositorio con `Juego.java`, `README.md`,
   `BITACORA_PROMPTS.md` y `.gitignore`.

4. Colócate en tu carpeta de trabajo. Una carpeta `git` dentro de tu carpeta personal:

   ```
   mkdir ~\git
   cd ~\git
   ```

5. Clona. La dirección la copias del botón verde **Code** de tu repositorio, pestaña
   **HTTPS**.

   ```
   git clone https://github.com/ORGANIZACION/hito1-TUUSUARIO.git
   ```

   **Ves:** la primera vez, una ventana para iniciar sesión en GitHub desde el
   navegador. Después:

   ```
   Cloning into 'hito1-TUUSUARIO'...
   done.
   ```

6. Entra en la carpeta que acaba de crearse y pregunta dónde estás.

   ```
   cd hito1-TUUSUARIO
   git status
   ```

   **Ves:**

   ```
   On branch main
   Your branch is up to date with 'origin/main'.

   nothing to commit, working tree clean
   ```

7. Mira la rama, el remoto y el historial.

   ```
   git branch --show-current
   git remote -v
   git log --oneline
   ```

   **Ves:** `main`; dos líneas `origin  https://github.com/ORGANIZACION/hito1-TUUSUARIO.git`
   con `(fetch)` y `(push)`; y un único commit, `Initial commit`, que es el de la
   plantilla.

8. Ábrelo en IntelliJ: *File → Open* y eliges la carpeta `hito1-TUUSUARIO`. Abajo o
   arriba a la izquierda (según la versión) verás el nombre de la rama, `main`.

### Errores típicos

| Lo que ves | Qué pasa | Qué haces |
|---|---|---|
| `fatal: not a git repository` | Estás en una carpeta que no es un repositorio | `cd` a la carpeta del repositorio y repite |
| `Author identity unknown` al hacer commit | Te saltaste el paso 2 | Haz el paso 2 y repite el commit |
| `Repository not found` al clonar | No aceptaste la invitación, o la dirección tiene una errata | Paso 3, y copia la dirección del botón **Code** |
| Te pide contraseña y no vale ninguna | GitHub no acepta contraseñas desde el terminal | Cierra, repite el `clone` y usa la ventana del navegador |
| Clonas **dentro** de otro repositorio | Hiciste el `clone` estando en `hito1-…` | Clona siempre desde `~\git` |

### Ahora tú · AT2

Con tu repositorio ya clonado, desde **su** carpeta, ejecuta:

```
git config user.name
git config user.email
git branch --show-current
git remote get-url origin
```

**Resultado esperado:**

1. Tu nombre y tu correo, no una línea vacía.
2. `main`.
3. `https://github.com/ORGANIZACION/hito1-TUUSUARIO.git`, con **tu** usuario.

Si la tercera línea no es tu repositorio, has clonado otro: bórralo y vuelve al
paso 5.

---

## 3. El commit: los tres estados de un fichero

### La explicación

Un fichero de tu carpeta puede estar en uno de estos estados:

| `git status --short` | Estado | Qué significa |
|---|---|---|
| `??` | Sin seguimiento | Git lo ve, pero nunca se ha preparado ni confirmado |
| `A ` o `M ` (letra a la izquierda) | Preparado | Entrará en el próximo commit |
| ` M` (letra a la derecha) | Modificado sin preparar | Ha cambiado respecto de lo preparado y **no** entrará |
| *(no aparece)* | Confirmado y sin cambios | Igual que en el último commit |

Y dos formas de ver diferencias, que se confunden siempre:

| Orden | Compara | Sirve para |
|---|---|---|
| `git diff` | Carpeta de trabajo **contra** lo preparado | Ver lo que has cambiado y **todavía no** has preparado |
| `git diff --staged` | Lo preparado **contra** el último commit | Ver **exactamente** lo que va a entrar en el commit |

Un fichero nuevo, sin seguimiento, **no aparece** en `git diff`: Git todavía no lo
compara con nada.

**La regla del curso:** un commit por cada cosa que funciona. El mensaje dice **qué
hace** el cambio, en infinitivo:

| Bien | Mal |
|---|---|
| `Añadir el menú de acciones` | `cambios` |
| `Corregir el bucle infinito del combate` | `.` |
| `E2.4: enmarcar la ficha con String.format` | `asdf` |

### En directo · primer commit

En el laboratorio, que **no es** tu repositorio del juego.

1. Crea el laboratorio junto a tu repositorio, no dentro.

   ```
   cd ~\DAM\git
   git init lab-co4
   cd lab-co4
   git status
   ```

   **Ves:** `Initialized empty Git repository in …/lab-co4/.git/` y después
   `On branch main` y `No commits yet`.

2. Crea `leeme.md` con esta única línea:

   ```
   Laboratorio de Git de CO4
   ```

   ```
   git status --short
   ```

   **Ves:** `?? leeme.md`.

3. Prepáralo y confírmalo.

   ```
   git add leeme.md
   git status --short
   git commit -m "Crear el leeme del laboratorio"
   git log --oneline
   ```

   **Ves:** `A  leeme.md`; después `[main (root-commit) …] Crear el leeme del
   laboratorio` y `1 file changed`; y en el historial, una línea con ese mensaje.

### Ahora tú · AT3a

En el laboratorio, crea `equipo.md` con la línea `Equipo: ` y el número de tu equipo, y
confírmalo con el mensaje `Anotar el equipo del laboratorio`.

**Resultado esperado:** `git log --oneline` muestra **dos** commits, el tuyo arriba, y
`git status` dice `nothing to commit, working tree clean`.

### En directo · confirmar dos ficheros de tres

1. Crea tres ficheros en el laboratorio.

   `aviso.md`:

   ```
   Aviso: la sala abre el lunes
   ```

   `horario.md`:

   ```
   Lunes a viernes
   Apertura: 8
   Cierre: 17
   ```

   `borrador.md`:

   ```
   Idea sin terminar
   ```

2. Mira el estado y la diferencia.

   ```
   git status
   git diff
   ```

   **Ves:** los tres en `Untracked files`. `git diff` no enseña nada: son nuevos.

3. Prepara solo los dos que están terminados.

   ```
   git add aviso.md horario.md
   git status
   ```

   **Ves:** `aviso.md` y `horario.md` en `Changes to be committed` como `new file`, y
   `borrador.md` sigue en `Untracked files`.

4. Antes de confirmar, mira **lo que va a entrar**.

   ```
   git diff --staged
   ```

   **Ves:** los dos ficheros, cada línea con un `+` delante. `borrador.md` no está.

5. Confirma y comprueba qué ha entrado.

   ```
   git commit -m "Publicar el aviso y el horario"
   git show --stat --oneline HEAD
   git status --short
   ```

   **Ves:** `2 files changed`; en el `show`, `aviso.md | 1 +` y `horario.md | 3 +++`;
   y `?? borrador.md`, que sigue fuera.

6. Ahora un cambio en un fichero que ya está en el historial. En `horario.md`, cambia
   `Cierre: 17` por `Cierre: 18` y guarda.

   ```
   git diff
   ```

   **Ves:**

   ```
   -Cierre: 17
   +Cierre: 18
   ```

7. Prepáralo y vuelve a mirar las dos diferencias.

   ```
   git add horario.md
   git diff
   git diff --staged
   ```

   **Ves:** `git diff` ya **no** enseña nada; `git diff --staged` enseña las dos
   líneas del paso anterior. El cambio ha pasado de un sitio a otro.

8. Confirma y mira el historial.

   ```
   git commit -m "Retrasar el cierre a las 18"
   git log --oneline
   ```

   **Ves:** cuatro commits; arriba, `Retrasar el cierre a las 18`.

### Lo mismo desde IntelliJ

1. *File → Open* y abre la carpeta `lab-co4`.
2. Crea `nota.md` con una línea cualquiera y cambia `aviso.md` a
   `Aviso: la sala abre el lunes a las 8`.
3. Abre la ventana **Commit** (*View → Tool Windows → Commit*, o **Alt+0**).
   **Ves:** `aviso.md` en **Changes** y el fichero nuevo en **Unversioned Files**.
4. Selecciona `aviso.md` y pulsa **Show Diff** (**Ctrl+D**). **Ves:** dos columnas, la
   versión confirmada a la izquierda y la tuya a la derecha.
5. Marca **solo** la casilla de `aviso.md`, escribe el mensaje y pulsa **Commit**.
6. Abre la ventana **Git** (**Alt+9**), pestaña **Log**. **Ves:** tu commit arriba, con
   el mismo mensaje que verías con `git log --oneline`.

La casilla de IntelliJ hace lo mismo que elegir qué ficheros van en el `git add`.

### Errores típicos

| Lo que ves | Qué pasa | Qué haces |
|---|---|---|
| `git status --short` dice `MM horario.md` | Editaste **después** del `add`. La primera `M` es lo preparado; la segunda, lo que cambiaste luego y **no** entrará | `git diff` para ver lo nuevo y `git add` otra vez si también debe entrar |
| El commit se lleva un fichero que no querías | Usaste `git add .` | `git diff --staged` **antes** de cada commit. Nunca confirmes sin mirarlo |
| `nothing added to commit but untracked files present` | Hiciste `commit` sin `add` | `git add` de los ficheros que quieres |
| `git diff` vacío y sabes que hay cambios | El cambio ya está preparado | `git diff --staged` |
| Se abre un editor raro al hacer commit | Olvidaste `-m "…"` | Si es Vim: `Esc`, escribe `:q!` e Intro, y repite con `-m` |

### Ahora tú · AT3

En el laboratorio, crea `normas.md`, `contacto.md` y `pendiente.md`, con una línea
cualquiera cada uno. Confirma **solo** `normas.md` y `contacto.md`, mirando antes lo que
va a entrar. Hazlo por terminal y repite la parte de mirar el cambio desde la ventana
**Commit** de IntelliJ.

**Resultado esperado:**

```
git show --stat --oneline HEAD
```

enseña **exactamente** dos ficheros, `contacto.md` y `normas.md`, y

```
git status --short
```

enseña `?? pendiente.md` (y `?? borrador.md` o `?? nota.md` si los tienes).

Al terminar, **borra `borrador.md`, `pendiente.md` y `nota.md`** desde el explorador de
archivos.
Nunca se confirmaron, así que Git no puede recuperarlos: lo que no está en un commit no
está protegido. `git status` tiene que decir `working tree clean`.

---

## 4. Sincronizar con GitHub y leer el corrector

### La explicación

| Orden | Qué hace | Cuándo |
|---|---|---|
| `git push` | Sube a GitHub los commits que tienes y GitHub no | Después de confirmar |
| `git pull` | Trae los commits que GitHub tiene y tú no, y los aplica | Antes de empezar a trabajar, y si GitHub tiene algo nuevo |
| `git fetch` | Solo pregunta a GitHub qué hay, sin tocar tus ficheros | Para que `git status` sepa si vas por detrás |

**`git status` no pregunta a GitHub.** Compara con lo último que supo. Si alguien ha
cambiado algo en la web, `status` no se entera hasta un `fetch` o un `pull`.

**Haz `pull` con la carpeta limpia** (`working tree clean`). Si tienes cambios sin
confirmar en un fichero que también viene cambiado de GitHub, Git se niega a mezclar.

El ciclo de todo el curso:

```
  git pull ──> escribes ──> ¿funciona? ──no──> lo arreglas
                               │ sí
                               v
              git add ──> git diff --staged ──> git commit -m "…" ──> git push
```

### En directo · subir y bajar

Se hace en un repositorio de demostración, en pantalla. Tú lo repites en el tuyo en el
AT4.

1. Añade una línea al final de `README.md`, confirma y mira el estado.

   ```
   git add README.md
   git commit -m "Añadir una línea de prueba al README"
   git status
   ```

   **Ves:** `Your branch is ahead of 'origin/main' by 1 commit.` Tienes un commit que
   GitHub no tiene.

2. Súbelo.

   ```
   git push
   git status
   ```

   **Ves:** una línea `… main -> main` y después `Your branch is up to date with
   'origin/main'`. En la web, el README ya tiene la línea.

3. En la web, edita esa misma línea con el lápiz del README y pulsa **Commit
   changes**. Vuelve al terminal:

   ```
   git status
   ```

   **Ves:** `up to date`. **Mentira**: `status` no ha preguntado a GitHub.

4. Pregunta y trae.

   ```
   git fetch
   git status
   git pull
   git log --oneline -3
   ```

   **Ves:** tras el `fetch`, `Your branch is behind 'origin/main' by 1 commit, and can
   be fast-forwarded`. Tras el `pull`, `Fast-forward` y `README.md | 2 +-`. Arriba del
   historial, `Update README.md`, que es el commit que hiciste en la web.

### Lo mismo desde IntelliJ

**Push** está en *Git → Push…* (**Ctrl+Mayús+K**): enseña los commits que van a subir
antes de subirlos. **Pull** está en *Git → Pull…*. La ventana **Commit** tiene además
**Commit and Push…**, que hace las dos cosas seguidas.

### Errores típicos

| Lo que ves | Qué pasa | Qué haces |
|---|---|---|
| `! [rejected] main -> main (fetch first)` | GitHub tiene commits que tú no | `git pull` y después `git push` |
| `error: Your local changes to the following files would be overwritten by merge` | Haces `pull` con cambios sin confirmar en un fichero que también viene cambiado | Confirma tu cambio (o descártalo con `git restore fichero`, apartado 7) y repite el `pull` |
| `Everything up-to-date` y en la web no está tu cambio | No hiciste `commit`, o lo hiciste en otra carpeta | `git status` y `git log --oneline -1` en la carpeta correcta |
| Hiciste `push` desde el laboratorio | El laboratorio no tiene remoto: `fatal: No configured push destination` | Es correcto que falle, y Git te sugiere `git remote add`: **no lo hagas**. Se sube desde `hito1-…` |

### Ahora tú · AT4

En **tu repositorio del juego**:

1. Añade al final de `README.md` la línea `Prueba de sincronización: completada`,
   confírmala y súbela.
2. En la web, cambia en esa línea `completada` por `verificada` y confirma allí.
3. Con la carpeta limpia, trae el cambio.

**Resultado esperado:**

- el `README.md` de tu equipo termina en `Prueba de sincronización: verificada`;
- después de `git fetch`, `git status` dice `Your branch is up to date with
  'origin/main'` y `working tree clean`;
- `git log -1 --format=%h` y `git log -1 --format=%h origin/main` escriben **el mismo**
  identificador.

### En directo · qué hace GitHub con cada subida

Cada `push` a `main` de tu repositorio del juego lanza el corrector automático. Lo que
contesta hay que saber relacionarlo **con el commit que lo lanzó**.

1. Pestaña **Actions** de tu repositorio. Cada fila es una **ejecución**; su título es
   el mensaje del commit que la lanzó. Pincha la de arriba.
2. **Ves:** el identificador corto del commit. Compáralo con el tuyo:

   ```
   git log -1 --format=%h
   ```

   Si no coincide, estás mirando la ejecución de otro commit.

3. Pincha el trabajo `corregir`. **Ves:** los pasos en orden: *Descargar el
   repositorio*, *Preparar Java 25*, *Preparar Python*, *Traer el corrector*,
   *Corregir*, *Publicar el resultado* y *Avisar si no llega al mínimo*. Cada uno se
   despliega y enseña lo que escribió.
4. Vuelve a la ejecución y baja hasta el **resumen** (*Summary*). Ahí está el resultado,
   prueba por prueba, con `OK` o `FALLA`.

**Lo que significan los colores:**

| Qué ves | Qué significa |
|---|---|
| Círculo amarillo girando | Se está ejecutando |
| ✅ verde | El corrector **ha podido ejecutarse**. No dice nada de tu nota: puede ser un 0 |
| Aviso amarillo `Por debajo de 5` | Lo que sacaste está por debajo de 5. Lo dice el resumen |
| ❌ rojo | El corrector **no ha podido** ni empezar. Casi siempre: no hay un `Juego.java` en la raíz |

**El diagnóstico está en el resumen, no en el color.** Un programa que no compila da un
✅ verde con `NO COMPILA` dentro.

**La plantilla sin tocar no saca 10.** Hoy tu `Juego.java` no es un juego: algunas líneas
del resumen saldrán con `FALLA`, y es lo normal. Lo que se mira hoy es la línea
`OK  compila`.

### Errores típicos

| Lo que ves | Qué pasa | Qué haces |
|---|---|---|
| No aparece ninguna ejecución nueva | El `push` no llegó, o subiste a otra rama | `git status` y `git branch --show-current` |
| Lees el resumen de una ejecución vieja | Miraste la primera fila sin comparar el identificador | Paso 2 |
| «Está en verde, así que está bien» | El verde solo dice que el corrector corrió | Lee el resumen entero |

### Ahora tú · AT4b

En tu repositorio del juego:

1. En `Juego.java`, borra el punto y coma final de la línea
   `IO.println("Aqui va tu juego.");`. Confirma con el mensaje `Provocar un error de
   compilación` y súbelo.
2. Busca la ejecución **de ese commit** (compara el identificador) y localiza el
   diagnóstico en el resumen.
3. Vuelve a poner el punto y coma, confirma con `Corregir el error de compilación` y
   súbelo.
4. Busca la ejecución del nuevo commit.

**Resultado esperado:**

- en el paso 2, el resumen tiene una línea
  `NO COMPILA: Juego.java:19: error: ';' expected` (el `19` es la línea en la plantilla
  sin tocar; si has cambiado el fichero, será otra) y `0/10`;
- en el paso 4, esa línea ya no está y aparece `OK  compila`;
- no se pide ninguna puntuación concreta ni ningún color.

---