package ar.edu.unlam.florenciamartin.tallerprogramacion

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import ar.edu.unlam.florenciamartin.tallerprogramacion.api.API
import ar.edu.unlam.florenciamartin.tallerprogramacion.modelo.Articulo
import ar.edu.unlam.florenciamartin.tallerprogramacion.modelo.SearchResult
import ar.edu.unlam.florenciamartin.tallerprogramacion.modelo.Usuario
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_lista_productos.*
import kotlinx.android.synthetic.main.activity_producto.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaProductosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_productos)

        var gridLayoutManager =  GridLayoutManager(this, 2)
        recycler.layoutManager = gridLayoutManager

        val adapter = AdaptadorDeArticulos()
        recycler.adapter = adapter

        var textoBusqueda = intent.extras.getString("busqueda")

        API().search(textoBusqueda, object: Callback<SearchResult>{
            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                if(response.isSuccessful){
                    val search = response.body()?.articulos

                    adapter.articulos = search as ArrayList<Articulo>
                    adapter.notifyDataSetChanged()


                }
            }
        })


//        producto1.setOnClickListener(){
//            var intent = Intent(this, ProductoActivity::class.java)
//            intent.putExtra("idProducto", idProducto1.text.toString())
//
//            startActivity(intent)
//        }




    }
}
