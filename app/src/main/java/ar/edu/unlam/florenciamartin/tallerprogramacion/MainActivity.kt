package ar.edu.unlam.florenciamartin.tallerprogramacion

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonBuscar.setOnClickListener{
            //este codigo se ejecuta cuando se hace click en el boton
            //"it" es el objeto donde se hizo click

            //leer lo que dice el edit text
            val textoIngresado = campoDeBusqueda.text.toString()
            Log.e("Hola", textoIngresado) //esto es un logueo

            //tengo que crear un intent que es un mensaje de una a
            //otra actividad. El intent recibe como parmetros desde donde
            //a donde va. Mensaje entre componentes de la aplicacion (una view
            // es tambien un componente)

            val intent = Intent(this, ListaProductosActivity::class.java)
            //los intent pueden tener extras, que son clave=valor

            intent.putExtra("busqueda", textoIngresado)
            //aca inicio la actividad y le paso el intent por parametro
            startActivity(intent)


            //MLA779405199

        }
    }
}
