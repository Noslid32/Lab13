# Lab13

# BMI Calculator (Calculadora de IMC)

Este es un proyecto de una calculadora de índice de masa corporal (IMC) construida con Jetpack Compose en Kotlin para una aplicación Android. Permite al usuario ingresar su peso y altura, y calcula su IMC, proporcionando una clasificación de su estado físico (bajo peso, peso normal, sobrepeso u obesidad).

## Características

- Interfaz de usuario intuitiva y moderna usando **Jetpack Compose**.
- Entrada de peso (en libras) y altura (en centímetros) con campos de texto **OutlinedTextField**.
- Cálculo automático del IMC basado en la fórmula estándar.
- Clasificación del IMC en categorías: **Bajo peso**, **Peso normal**, **Sobrepeso**, **Obesidad**.
- Gradiente de fondo con un diseño visual atractivo.
- Uso de **Material3** para la interfaz de usuario.

## Instalación

1. Clona el repositorio en tu máquina local:
   ```bash
   git clone https://github.com/Noslid32/Lab13
   ```

2. Abre el proyecto en **Android Studio**.



3. Sincroniza el proyecto para descargar las dependencias.

4. Ejecuta la aplicación en un dispositivo o emulador Android.

## Uso

- Al abrir la aplicación, se presentará un fondo con un gradiente vertical y un campo para ingresar el peso (en libras) y la altura (en centímetros).
- Después de ingresar los valores, presiona el botón **"Calculate BMI"** para obtener tu **IMC** y la clasificación correspondiente.

## Cómo funciona

1. **Cálculo del IMC**: El IMC se calcula usando la fórmula:
   dividir el peso, expresado en kilos, entre la estatura, en metros, elevada al cuadrado. 

   Donde el peso está en kilogramos y la altura en metros. Para convertir el peso de libras a kilogramos, multiplicamos el valor ingresado por 0.453592.

2. **Clasificación**:
   - IMC < 18.5: Bajo peso
   - 18.5 <= IMC < 25: Peso normal
   - 25 <= IMC < 30: Sobrepeso
   - IMC >= 30: Obesidad

3. El resultado se muestra en una tarjeta con el IMC calculado y la categoría correspondiente.

ejemplo en video:https://drive.google.com/file/d/1pL5UfoV0Mjp_mQUmgDKPRbci3kRWx79H/view?usp=drive_link
usar correo galileo



