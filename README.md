# ⏰ README – Práctica Reloj Digital (Java)

## 🧩 Práctica – Reloj Digital en consola
**Ignacio Breñas Muñoz – 1º DAW (STUCOM)**

En esta práctica implemento un reloj digital en formato `HH:MM` mediante la clase `RelojDigital` (Java).  
El reloj se gestiona con un array de 4 dígitos `int[4]` y un menú interactivo por consola para adelantar/retrasar horas y minutos respetando los límites de un reloj de 24 horas.

**Archivo principal:** `RelojDigital.java`

---

## 🧠 Estructura y funcionamiento

### Representación del reloj
Se usa `int[] reloj = new int[4]` para mantener los dígitos:

- `reloj[0]` → decenas de hora (0–2)  
- `reloj[1]` → unidades de hora (0–9, limitado a 0–3 cuando `reloj[0] == 2`)  
- `reloj[2]` → decenas de minuto (0–5)  
- `reloj[3]` → unidades de minuto (0–9)  

### Salida por pantalla
Muestra el tiempo como `HH:MM`, por ejemplo `09:07` o `23:59`.

### Inicialización
El reloj inicia en `00:00`.

---

## 🗂️ Funciones implementadas

- **`mostrarReloj(int[] reloj)`**  
  Imprime la hora en formato `HH:MM`, concatenando los 4 dígitos.

- **`iniciarReloj(int[] reloj)`**  
  Pone el reloj en `00:00`.

- **`adelantarHora(int[] reloj)`**  
  Incrementa la hora con control de límites:  
  - Si `H1 < 9`, incrementa `H1`.  
  - Si se pasa de 23, reinicia a `00`.

- **`retrasarHora(int[] reloj)`**  
  Decrementa la hora con control de límites:  
  - Si `H1 > 0`, decrementa `H1`.  
  - Si va por debajo de 00, salta a 23.

- **`adelantarMinuto(int[] reloj)`**  
  Incrementa minutos con arrastre:  
  - Si `M1 == 9`, pone `M1 = 0` y sube `M0`.  
  - Si `M0` pasa de 5, reinicia minutos a `00` y adelanta la hora.

- **`retrasarMinuto(int[] reloj)`**  
  Decrementa minutos con arrastre:  
  - Si `M1 == 0`, pone `M1 = 9` y baja `M0`.  
  - Si `M0` baja de 0, pone `M0 = 5, M1 = 9` y retrasa la hora.

- **`menu()`**  
  Muestra el menú y devuelve la opción elegida:
  1. Adelantar hora  
  2. Retrasar hora  
  3. Adelantar minuto  
  4. Retrasar minuto  
  0. Salir  

---

## 🧭 Flujo del programa

1. Inicializa el reloj (`00:00`).  
2. Muestra la hora actual.  
3. Presenta el menú.  
4. Ejecuta la acción seleccionada.  
5. Repite hasta que el usuario pulse `0` (Salir).  

---

## 🧪 Casos límite manejados

- Subida de `23:59 → 00:00` (por adelantar minuto u hora).  
- Bajada de `00:00 → 23:59` (por retrasar minuto u hora).  
- Restricción de dígitos de hora cuando `H0 == 2`: `H1` no puede superar 3.  
- Arrastre correcto entre minutos ↔ horas en adelanto y retraso.

---

## 🔢 Ejemplos de uso (escenarios)

- Desde `23:59`, opción 3 (Adelantar minuto) → `00:00`.  
- Desde `00:00`, opción 4 (Retrasar minuto) → `23:59`.  
- Desde `19:59`, opción 3 (Adelantar minuto) → `20:00`.  
- Desde `20:00`, opción 2 (Retrasar hora) → `19:00`.  

---

## 🧱 Decisiones de diseño

- Array de 4 posiciones para trabajar a nivel de dígito (control fino de límites sin formateos complejos).  
- Funciones pequeñas y específicas (SRP) para cada operación: legibilidad y reutilización.  
- Sin dependencias externas: entrada por `Scanner`, salida por `System.out`.  

---
