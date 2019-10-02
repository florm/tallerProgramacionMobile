package ar.edu.unlam.florenciamartin.tallerprogramacion

class Prueba {

    fun sumar(a: Int, b: Int):Int{
        return a + b
        //println(a+b)
    }

    //esto de arriba es igual a:
    fun sumar2(a:Int, b:Int) = a+b // en la misma linea hago el retorno.

    //si no retorno nada entonces va :Unit o no va nada.
    fun mostrarMensajePorConsola(){
        println("Hola")
    }

    //Variables
    //val es una constante. No puede cambiarse.
    //var es una variable

    //Constantes
    fun ejemploConstantes(){
        val a: Int = 2 // aca se declara, se dice de que tipo es y se inicializa
        //a = 3 // la contante no se puede reasigar.

        //val b: Int //no puedo declararla y no inicializarla para usarla
        //println(b)

        // puedo inicializarla sin decir de que tipo es porque lo infiere por el valor
        //de la inicializacion
        val c = 1
        println(c)


    }

    fun ejemploVariables(){
        var a = 1
        a =2 //sí puedo cambiar el valor porque es una variable, no una constante

        a++ //etc

    }

    fun ejemploDeStrings(){
        val a = 1
        val texto = "la variable A vale: $a" //con pesos es para algo simple.
        val complejo = "la variable A sumada 4 es igual a: ${a+4}"
        //puedo hacer com un if inline
        var pregunta = "la variable A es mayor a 5? ${a>5}" // esto retornaria un false
    }

    //Condificionales
    fun buscarElMayor(a: Int, b: Int): Int{
        if(a>b)
            return a
        else
            return b
    }
    //if como expresion
    fun buscarMayor(a: Int, b: Int) = if(a > b) a else b

    //When. seria una especie de switch pero mas copado. Por lo que veo no puede ponerse un {},
    //tiene que ser un =
    fun describe(obj: Any): String =
        when(obj){
            1 -> "One"
            "Hola" -> "Saludo"
            is Long -> "Long"
            !is String -> "No es un string"
            else -> "Desconocido"
        }

    //for




}