package ar.edu.unlam.florenciamartin.tallerprogramacion

import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        precioViejo.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        //para eso es ese metodo -> para que sepa que archivo tiene el layout de la pantalla
    //R.layout.activity_main es un entero. Tiene el mismo nombre del archivo que esta en la carpepa
    //res->layout


    }









}
