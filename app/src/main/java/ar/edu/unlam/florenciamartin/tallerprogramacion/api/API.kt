package ar.edu.unlam.florenciamartin.tallerprogramacion.api

import ar.edu.unlam.florenciamartin.tallerprogramacion.modelo.Articulo
import ar.edu.unlam.florenciamartin.tallerprogramacion.modelo.SearchResult
import ar.edu.unlam.florenciamartin.tallerprogramacion.modelo.Usuario
import com.google.gson.Gson
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API {

    private fun getAPI(): MercadoLibreAPI {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .baseUrl("https://api.mercadolibre.com/")
            .build();

        return retrofit.create(MercadoLibreAPI::class.java)
    }

    fun getArticle(id: String, callback: Callback<Articulo>) {
        getAPI().getArticle(id).enqueue(callback)
    }

    fun getVendedor(id: String, callback: Callback<Usuario>){
        getAPI().getVendedor(id).enqueue(callback)
    }

    fun search(textoBusqueda: String, callback: Callback<SearchResult>){
        getAPI().search(textoBusqueda).enqueue(callback)
    }


}