"""CO3 · Práctica: recargos por retraso en los préstamos de una biblioteca.

No hace falta modificar este script: sirve para comprobar que el entorno sabe
ejecutar un segundo lenguaje. Los datos van escritos dentro para que la salida
sea siempre la misma. Las dos últimas líneas dicen qué intérprete lo ha
ejecutado, que es justo lo que hay que comprobar al configurar el entorno.
"""

import sys

DIAS_SIN_RECARGO = 15
CENTIMOS_POR_DIA = 20

PRESTAMOS = [
    ("Cien años de soledad", 12),
    ("La sombra del viento", 19),
    ("Manual de programación", 23),
]


def recargo_en_centimos(dias):
    """Devuelve el recargo, en céntimos, de un préstamo que ha durado ``dias`` días."""
    retraso = max(0, dias - DIAS_SIN_RECARGO)
    return retraso * CENTIMOS_POR_DIA


def euros(centimos):
    """Formatea una cantidad en céntimos como euros con coma decimal: 160 -> '1,60'."""
    return f"{centimos // 100},{centimos % 100:02d}"


def main():
    """Imprime la tabla de préstamos, el total y el intérprete utilizado."""
    print("Préstamos con retraso · Biblioteca")
    print(f"{'Título':<28} {'Días':>5} {'Recargo':>8}")
    total = 0
    for titulo, dias in PRESTAMOS:
        importe = recargo_en_centimos(dias)
        total += importe
        print(f"{titulo:<28} {dias:>5} {euros(importe):>8}")
    print(f"Total de recargos: {euros(total)} EUR")
    version = sys.version_info
    print(f"Ejecutado con Python {version.major}.{version.minor}.{version.micro}")
    print(f"Intérprete: {sys.executable}")


if __name__ == "__main__":
    main()
