package ar.edu.unlam.florenciamartin.tallerprogramacion

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ar.edu.unlam.florenciamartin.tallerprogramacion.api.API
import ar.edu.unlam.florenciamartin.tallerprogramacion.modelo.SearchResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaProductosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_productos)

        var textoBusqueda = intent.extras.getString("busqueda")

        API().search(textoBusqueda, object: Callback<SearchResult>{
            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                if(response.isSuccessful){
                    val search = response.body()
                    search?.articulos?.forEach {
                        var a = it.titulo
                    }

                }
            }
        })


    }
}
