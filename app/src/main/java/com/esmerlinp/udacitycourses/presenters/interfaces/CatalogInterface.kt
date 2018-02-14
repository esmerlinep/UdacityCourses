package com.esmerlinp.udacitycourses.presenters.interfaces

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
    }

    interface Interactor{

        fun getUdaCityCourses()
    }

}