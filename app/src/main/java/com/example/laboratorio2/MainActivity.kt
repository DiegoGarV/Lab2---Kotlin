package com.example.laboratorio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listNum = intArrayOf(1,3,4,6,5,4,8,9,3,7)

        println(" ")
        println("Punto 1")
        println("El promedio de es: ${calcularPromedio(listNum)}") //El promedio debería ser 5

        println(" ")
        println("Punto 2")
        val pares: List<Int> = listNum.filter { it % 2 == 0 }
        println("Lista de pares: $pares") //El resultado debería ser [4,6,4,8]

        println(" ")
        println("Punto 3")
        val palabra1 = "reconocer"
        val palabra2 = "hablar"
        println("¿$palabra1 es un palindromo?  ${isPalindrome(palabra1)}") //La respuesta debería ser true
        println("¿$palabra2 es un palindromo?  ${isPalindrome(palabra2)}") //La respuesta debería ser false

        println(" ")
        println("Punto 4")
        val nombres = arrayListOf<String>("Diego","Gabby","Miguel","Christina","Andres","Dania")
        val saludos = nombres.map{"¡Hola, $it!"}
        println(saludos)

        println(" ")
        println("Punto 5")
        val suma: (Int, Int) -> Int = {a,b -> a+b}
        val resta: (Int, Int) -> Int = {a,b -> a-b}
        println("Sumando 3 y 2: ${performOperation(3,2,suma)}") //resultado debería ser 5
        println("Restando 3 y 2: ${performOperation(3,2,resta)}") //resultado debería ser 1

        println(" ")
        println("Punto 6")
        val listaPer = listOf(Person("Diego",20,"Masculino"),Person("Gabby",22,"Femenino"),Person("Pedro",19,"Masculino"),Person("Sara",21,"Femenino"))
        val listaEst = listaPer.map{mapeo(it)}
        for (i in listaEst) {
            println("El estudiante ${i.name} tiene ${i.age} años.")
        }

        println(" ")
    }

    //función del primer punto
    private fun calcularPromedio(numbers: IntArray): Int {
        val suma = numbers.reduce { acc, num -> acc + num }
        val prom = suma/numbers.size
        return prom
    }

    //función del tercer punto
    private fun isPalindrome(palabra: String): Boolean = palabra == palabra.reversed()

    //función para el punto 5
    private fun performOperation(num1:Int,num2:Int,op:(Int,Int) -> Int):Int{
        return op(num1,num2)
    }

    //función para el punto 6
    private fun mapeo(persona: Person): Student {
        return Student(persona.name,persona.age,persona.gender,"id")
    }

}

//Clases para el punto 6
data class Person(val name: String, val age: Int, val gender: String)
data class Student(val name: String, val age: Int, val gender: String, val studentId: String)