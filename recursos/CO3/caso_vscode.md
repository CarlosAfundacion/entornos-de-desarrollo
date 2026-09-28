# CO3 · Caso comparativo de referencia: Visual Studio Code

**Contornos de desenvolvemento · 1º DAM · Recurso de la práctica CO3**

En CO3 instalas y usas **dos** entornos: IntelliJ IDEA y Eclipse. Visual Studio
Code es el tercer entorno de la comparación, pero **no lo instalas**: se estudia
como caso de referencia, a partir de este documento y de la documentación oficial
que se cita al final.

Por eso, en tu tabla comparativa la columna de VS Code se distingue de las otras
dos:

| En las columnas de IntelliJ y Eclipse | En la columna de VS Code |
|---|---|
| Lo que **has medido u observado tú** en tu equipo | Lo que **dice la documentación**, citando de dónde sale |
| Una medida sin hacer es una casilla pendiente | Una medida que no has podido hacer se escribe **«no observado»**, y es una respuesta correcta |

No copies en la columna de VS Code tiempos ni memoria de otro ordenador: no se
pueden comparar con los tuyos. Si en clase se ve VS Code funcionando en otro
equipo, lo que veas sirve como observación cualitativa («el diagnóstico aparece
subrayado y en el panel *Problems*»), no como medida.

---

## 1. Qué es y quién lo distribuye

| Pregunta | Respuesta documentada |
|---|---|
| ¿Qué es? | Un **editor de código** ampliable con extensiones. Con las extensiones adecuadas se comporta como un entorno de desarrollo completo |
| ¿Cuesta dinero? | No. Microsoft lo declara gratuito para uso privado y comercial |
| ¿Es software libre? | **Depende de qué distribución.** El código fuente está en el repositorio **Code - OSS**, con licencia MIT, que es libre. El producto **Visual Studio Code** que se descarga de Microsoft se distribuye con una **licencia propia de Microsoft** e incluye personalizaciones suyas. Microsoft lo resume diciendo que VS Code está *construido sobre* código abierto, no que *sea* código abierto |

Es un buen ejemplo de por qué **gratis y libre son cosas distintas**: la
distribución oficial es gratuita, pero su licencia no es libre; el código del
que sale, sí.

---

## 2. Cómo trabaja con Java

VS Code, sin extensiones, trae una contribución básica para Java: reconoce los
ficheros `.java` y colorea su sintaxis. **No** analiza el código, no completa
instrucciones con sentido, no compila ni ejecuta. Para eso hace falta instalar
extensiones.

La que se usa normalmente es el paquete **Extension Pack for Java**, que no es
una extensión sino un **paquete de seis**:

| Extensión | Para qué sirve |
|---|---|
| Language Support for Java by Red Hat | Análisis del código, navegación, autocompletado, refactorización |
| Debugger for Java | Depurador |
| Test Runner for Java | Ejecutar pruebas JUnit y TestNG |
| Maven for Java | Proyectos Maven |
| Gradle for Java | Proyectos Gradle |
| Project Manager for Java | Vista de proyectos, bibliotecas y clases |

Consecuencias que conviene saber leer:

- **Instalar un paquete instala varias cosas a la vez**, incluidas algunas que
  quizá no uses. Se pueden quitar después por separado.
- Las extensiones **no traen Java**: necesitan un JDK instalado en el equipo.
- El paquete añade funciones; que eso se note o no en el arranque o en la
  memoria es algo que **se mide**, no que se da por hecho.

### Proyecto, construcción y ejecución

| Operación | Cómo lo documenta VS Code |
|---|---|
| Crear un proyecto sin herramienta de construcción | Paleta de órdenes (`Ctrl+Shift+P`) → **Java: Create Java Project** → *No build tools*. La plantilla crea una carpeta de proyecto con `src` para el código y `lib` para bibliotecas |
| Dónde deja los `.class` | En la carpeta de salida del proyecto, que en esa plantilla es `bin`. Se cambia con el ajuste `java.project.outputPath` |
| Ejecutar | Botón *Run* sobre el `main`, o una **configuración de lanzamiento** en `.vscode/launch.json` |
| Argumentos y directorio de trabajo | Propiedades `args` y `cwd` de esa configuración de lanzamiento |

### Personalización y actualizaciones

| Ajuste | Dónde está |
|---|---|
| Codificación de los ficheros | Ajuste `files.encoding` (UTF-8 por defecto) |
| Formatear al guardar | Ajuste `editor.formatOnSave` |
| Atajos | *File → Preferences → Keyboard Shortcuts* |
| Actualización del propio editor | Ajuste `update.mode`: `default` (comprueba en segundo plano), `start` (solo al arrancar), `manual` (solo cuando lo pides) o `none` (desactivada) |
| Actualización de las extensiones | Ajuste `extensions.autoUpdate` |

Los ajustes se pueden guardar para el usuario o solo para una carpeta de
proyecto (`.vscode/settings.json`). Es la misma idea de **alcance** que en IntelliJ
y en Eclipse: no es lo mismo cambiar algo para todos los proyectos que para uno.

---

## 3. Y con Python

Para Python se instala la extensión **Python** de Microsoft, y además hace falta
un **intérprete de Python** instalado: la extensión no lo trae. Se elige con la
orden **Python: Select Interpreter**. Es el mismo reparto que verás con PyDev en
Eclipse: complemento por un lado, intérprete por otro.

---

## 4. Cómo usar este caso en tu comparación

1. En la tabla, rellena la columna de VS Code **solo** con lo que está en este
   documento o en las fuentes de abajo, y cita cuál.
2. Donde la fila pide una medida tuya (arranque, disco, memoria), escribe
   **«no observado»**.
3. Una característica es **común** si la has visto en IntelliJ y en Eclipse; que
   VS Code también la tenga, según la documentación, es un dato más, no un
   requisito.
4. En la recomendación puedes hablar de VS Code, pero apoyándote en lo que está
   documentado, no en impresiones de otros.

---

## Fuentes

- [VS Code FAQ: licencia y distribuciones](https://code.visualstudio.com/docs/supporting/faq#_licensing)
- [Java en VS Code](https://code.visualstudio.com/docs/languages/java)
- [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
- [Contribución Java incorporada en VS Code](https://github.com/microsoft/vscode/tree/main/extensions/java)
- [Python en VS Code](https://code.visualstudio.com/docs/languages/python)
- [Ajustes de usuario y de espacio de trabajo](https://code.visualstudio.com/docs/configure/settings)
- [Gestión de actualizaciones de VS Code](https://code.visualstudio.com/docs/enterprise/updates)
- [Proyectos Java en VS Code](https://code.visualstudio.com/docs/java/java-project)
