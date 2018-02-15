package com.esmerlinp.udacitycourses.interactors

import android.widget.ImageView
import com.esmerlinp.udacitycourses.interactors.Entities.CatalogEntity
import com.esmerlinp.udacitycourses.interactors.api.UdaCityServices
import com.esmerlinp.udacitycourses.presenters.interfaces.CatalogInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CatalogModel(private val presenter:CatalogInterface.Presenter): CatalogInterface.Interactor{

    override fun getUdaCityCourses() {
        val retrofit:Retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(UdaCityServices.BASE_URL).build()
        val service = retrofit.create(UdaCityServices::class.java)
        val request = service.getCourses()

        request.enqueue(object :Callback<CatalogEntity>{
            override fun onFailure(call: Call<CatalogEntity>?, t: Throwable?) {
                    presenter.onRequestFail(t?.message ?: "No Message defined")
            }

            override fun onResponse(call: Call<CatalogEntity>?, response: Response<CatalogEntity>?) {

                    val data:CatalogEntity? = response?.body()
                    if(data != null){
                        presenter.onRequestSuccess(data)
                    }

            }
        })
    }

    override fun downloadImage(url: String, imageView: ImageView) {
        //val loader: ImageLoader = ImageLoader.getInstance()
        //loader.displayImage(url,imageView)

      /*  Thread(Runnable{

        }).start()*/

    }
}