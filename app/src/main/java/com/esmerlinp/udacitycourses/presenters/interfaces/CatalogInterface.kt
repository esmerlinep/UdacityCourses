package com.esmerlinp.udacitycourses.presenters.interfaces

import android.widget.ImageView
import com.esmerlinp.udacitycourses.interactors.Entities.CatalogEntity



interface CatalogInterface {
    interface View{
        fun onRequestSuccess(response:CatalogEntity?)
        fun onRequestFail(errorMesage:String)

    }

    interface  Presenter{
        fun onRequestSuccess(response:CatalogEntity?)
        fun onRequestFail(errorMessage:String)

        fun getUdaCityCourses()
        fun downloadImage(url:String, imageView: ImageView)
    }

    interface Interactor{

        fun getUdaCityCourses()
        fun downloadImage(url:String, imageView: ImageView)
    }

}