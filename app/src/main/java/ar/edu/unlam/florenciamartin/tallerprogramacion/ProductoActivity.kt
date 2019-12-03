package ar.edu.unlam.florenciamartin.tallerprogramacion

import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ar.edu.unlam.florenciamartin.tallerprogramacion.api.API
import ar.edu.unlam.florenciamartin.tallerprogramacion.modelo.Articulo
import ar.edu.unlam.florenciamartin.tallerprogramacion.modelo.Usuario
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_producto.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)
        precioViejo.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        //para eso es ese metodo -> para que sepa que archivo tiene el layout de la pantalla
    //R.layout.activity_main es un entero. Tiene el mismo nombre del archivo que esta en la carpepa
    //res->layout

//        aca iria la llamada a picaso
        Picasso.get()
            .load(R.drawable.creditcard)
            .into(tarjeta)
        Picasso.get()
            .load(R.drawable.undo)
            .into(camion)

        Picasso.get()
            .load(R.drawable.undo)
            .into(devolucion)
        //Picasso.get().setIndicatorsEnable(true) // te dice desde donde esta sancando la imagen. si de la
        //ram, del disco o de internet
        //rojo-> la esta trayebdo de internet
        //azul -> esta en el disco


        //Retrofit hace pedidos a api y el gson que tiene adentro convierte el json en el objeto que
        //yo le digo
        //hay qeu crear interfaces para la api. esas interfacss esta bueno ponerlas en un apquete que tenga
        //todo lo de la api

//        API().getArticle("MLA644287324", object:Callback<Articulo> {
//            override fun onFailure(call: Call<Articulo>, t: Throwable) {
//                //
//            }
//            override fun onResponse(call: Call<Articulo>, response: Response<Articulo>) {
//                if (response.isSuccessful) {
//                    val received = response.body()
//                }
//            }
//        })

        //leo el extra que vino de la otra pantalla
        val idProducto = intent.extras.getString("idProducto");


        API().getArticle(idProducto, object: Callback<Articulo> {
            override fun onFailure(call: Call<Articulo>, t: Throwable) {
                errorProducto.setVisibility(View.VISIBLE)
                progressBar.setVisibility(View.GONE);
            }
            override fun onResponse(call: Call<Articulo>, response: Response<Articulo>) {
                if (response.isSuccessful) {
                    val producto = response.body()
                    Picasso.get()
                        .load(producto?.imagenesProducto?.first()?.url)
                        .into(imagenProducto)
                    cantidadFotos.text = producto?.imagenesProducto?.size.toString() + " fotos"
                    cantidadVendidos.text = producto?.vendidos + " vendidos"

                    if(producto?.precioOriginal.isNullOrEmpty()){
                        precioConDescuento.text = "$" + producto?.precioDescuento

                    }
                    else{
                        precioViejo.text = "$" +producto?.precioOriginal
                        precioConDescuento.text = "$" + producto?.precioDescuento

                    }
                    nombreProducto.text = producto?.titulo

                    API().getVendedor(producto?.vendedorId.toString(), object:Callback<Usuario>{
                        override fun onFailure(call: Call<Usuario>, t: Throwable) {
                            progressBar.setVisibility(View.GONE);
                            errorProducto.setVisibility(View.VISIBLE)
                        }

                        override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                            if(response.isSuccessful){
                                var usuario = response.body();
                                nombreVendedor.text = usuario?.nickname
                            }
                            progressBar.setVisibility(View.GONE);
                            layoutContenido.setVisibility(View.VISIBLE)
                        }
                    })



                }
            }
        })


    }









}
