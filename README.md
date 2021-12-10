# chattigo-palindrome

## Ejercicios completados:

- Palindrome
- Tres Digitos

# Explicación:

## Palindrome:

**Metodos internos**
El código consta básicamente de 3 métodos *nextPrimePalindrome, isPalindrome e isPrime* 
- **isPrime:** Simple algoritmo para evaluar si un número que recibe por parametro de entrada es primo o no.
- **isPalindrome:** Simple algoritmo para evaluar si un número que recibe por parametro de entrada es palindromo o no.
- **nextPrimePalindrome:** Método principal encargado de la orquestación de los otros 2 métodos, dado a que el tiempo de ejecución y coste de evaluación de un n° primo es mayor a la de un palindromo éste sólo se evalua si el número es palindromo.


**Benchmark**

|Benchmark                          |   (N) | Mode |   Cnt |   Score  |   Error   |   Units |
| :------------------------------- |:------:|-----:|------:|---------:|----------:|---------|
|PalindromeBenchmark.isPalindrome  |1.000.000 | avgt |       | 15,179   |           | ms/op   |
|PalindromeBenchmark.isPalindrome2 |1.000.000 | avgt |       | 385,161  |           | ms/op   |
|PalindromeBenchmark.isPrime       |1.000.000 | avgt |       | 2657,045 |           | ms/op   |

En estos resultados se ve el desempeño de cada método utilizado en esta solución, esto contando con un set de 1 millón de entradas.

> Se utilizó para analisis un segundo método de palindromo **isPalindrome2** para comparar el desempeño realizando cambio en el tipo de dato para dar una salida sin necesidad de analizar la completitud del número, aún así no llega a un desempeño esperado.


-------------------------------------------------------------------------------------------------------

## Tres Dígitos:

**Metodos internos**
Para el ejercicio de los tres dígitos utilicé 4 métodos *resolveArithmetic, extractTreeNumbers, reverseNumber y format* 
- **format:** Formateador de texto para ingresar "0" en la izquierda de un número hasta completar una longitud de 3
- **reverseNumber:** Método encargado de cambiar la orientación de un número, similar a la estrategía del palíndromo.
- **extractTreeNumbers:** Método que recibirá un entero de longitud desconocida (por eso el uso de BigInteger), quitará el último valor ya que es el extra usado después de la coma por temas de redondeo y extraerá los 3 siguientes números.
- **resolveArithmetic:** Método encargado de aplicar la ecuación constante en común para todos los parámetros de entrada, además de realizar redondeos y corte decimal para posterior análisis y extracción de números.


**Benchmark**

|Benchmark                          |   (N) | Mode |   Cnt |   Score  |   Error   |   Units |
| :------------------------------- |:------:|-----:|------:|---------:|----------:|---------|
|TreeDigitsBenchmark.extractTreeNumbers  |1.000.000 | avgt |       | 0,008   |           | ms/op   |
|TreeDigitsBenchmark.reverseNumber       |1.000.000 | avgt |       | 0,016 |           | ms/op   |
|TreeDigitsBenchmark.resolveArithmetic |1.000 | avgt |       | 0,036  |           | ms/op   |
|TreeDigitsBenchmark.resolveArithmeticStr       |1.000 | avgt |       | 0,559 |           | ms/op   |


En estos resultados se ve el desempeño de cada método utilizado en esta solución, esto contando con un set de 1 millón de entradas para los métodos de *extractTreeNumbers y reverseNumber* y de 1.000 registros para *resolveArithmetic y resolveArithmeticStr* respectivamente.

> Se utilizó para analisis un segundo método de resolveArithmetic **resolveArithmeticStr** para comparar el desempeño realizando cambio en el tipo de dato para dar una salida sin la necesidad de usar el método reverseNumber, sin embargo, el desempeño se ve afectado y se opta por utilizar los númericos.