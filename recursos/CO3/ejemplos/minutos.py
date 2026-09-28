"""CO3 · Ejemplo resuelto de los apuntes: convierte minutos en horas y minutos.

Es el mismo cálculo que ``Minutos.java``, escrito en Python, para comparar
qué parte del trabajo hace el lenguaje y qué parte hace el entorno.
"""

minutos = 135
horas = minutos // 60
resto = minutos % 60

print("Conversión de duraciones · versión Python")
print(f"{minutos} minutos son {horas} h y {resto} min")
print("Texto de prueba: año, canción, pequeño, acción")
