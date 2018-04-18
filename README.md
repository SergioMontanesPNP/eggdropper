# Egg Dropper
Supongamos que tienes 100 huevos en un rascacielos de 100 pisos y quieres realizar un experimento para encontrar el piso más alto (criticalFloor) desde el que puedes soltar un huevo sin romperlo... pero estás realmente hambriento, de modo que intenta no desperdiciar huevos.

## Niveles de dificultad (en inglés)
### Basic
Write a function, minEggDropper100 , that will determine the minimum number of egg drops ( minDrops100 ) you’d need to find the criticalFloor.
* Function Name : minEggDropper100
* Output : minDrops100 – an integer representing the minimum number of drops needed to find the criticalFloor
* An egg that survives a fall can be used again.
* A broken egg must be discarded.
* The eggs are all incredibly similar – the effect of a fall from a particular floor is the same for all eggs.
* If an egg survives a fall from floor n , then it would also survive a fall from the floors below it: floor n-1 , floor n-2 , etc.
* If an egg does not survive a fall from floor n , then it would also not survive a fall from the floors above it: floor n+1 , floor n+2 , etc.
* You should not presume that an egg would survive a fall from the first floor, nor should you presume that it would not survive a fall from the 100th floor!
* Much of the challenge in this problem is in formulating your strategy for egg dropping – interviewers want to see how you think in breaking down and solving this problem. Perhaps consider first how you would solve this problem with only one egg. Then think how you’d solve this problem with infinite eggs without any code. After that, think how you can use coding to find criticalFloor more efficiently.
    * Remember: the challenge is not to find criticalFloor itself! Your function should return the minimum number of egg drops you need to find criticalFloor.

### Intermediate
You’re at another 100-floor skyscraper and want to perform another experiment but this time you have only two eggs.
Write a function, minEggDropper2 , that will determine the minimum number of egg drops ( minDrops2 ) you’d need to find the highest floor ( criticalFloor2 ) from which you could drop an egg without breaking it.
* Function Name : minEggDropper2
* Output : minDrops2 – an integer representing the minimum number of drops needed to find criticalFloor2
* Don’t forget to explain your work!

### Hard
Write minEggDropperX that will test for x many eggs and y many floors. Please write this as efficiently as possible !
* Don’t forget to explain your work!

## Interpretaciones del enunciado
A continuación explicaré mi forma de interpretar algunos puntos del enunciado para que todo esté claro al 100% y pueda entenderse mejor la implementación realizada.
* En el enunciado se describe el criticalFloor como "el piso más alto desde el que puedes soltar un huevo sin romperlo", por lo tanto:
    * Si un huevo no tiene la suficiente resistencia como para "sobrevivir" al ser lanzado desde el piso 1, no puede devolverse un resultado válido y, por lo tanto, lo que se hará en este caso será lanzar una excepción.
    * Sin embargo, si un huevo puede "sobrevivir" tras ser lanzado desde el piso más alto del edificio, el retorno de la función será el piso más alto (puesto que, como dice el enunciado, será "el piso más alto desde el que puedes soltar un huevo sin romperlo" en ese edificio).
* De la frase del enunciado "pero estás realmente hambriento, de modo que intenta no desperdiciar huevos", entiendo que no debemos romper todos los huevos. Por lo tanto, cuando finalice la ejecución deberá quedar, como mínimo, un huevo "vivo".


## Tecnologías y herramientas
La implementación del problema estará realizada en Java 1.8 mediante el IDE Eclipse.
Para la realización de los tests, se utilizará la librería jUnit 4.



