package com.esmerlinp.udacitycourses.presenters

import com.esmerlinp.udacitycourses.interactors.CatalogModel
import com.esmerlinp.udacitycourses.interactors.Entities.CatalogEntity
import com.esmerlinp.udacitycourses.presenters.interfaces.CatalogInterface

class CatalogPresenters(private val view:CatalogInterface.View): CatalogInterface.Presenter {
    private val presenter:CatalogInterface.Interactor
    init{
        presenter = CatalogModel(this)
    }
    override fun onRequestSuccess(response: CatalogEntity?) {
       view.onRequestSuccess(response)
    }

    override fun onRequestFail(errorMessage: String) {
        view.onRequestFail(errorMessage)
    }

    override fun getUdaCityCourses() {
        presenter.getUdaCityCourses()
    }
}