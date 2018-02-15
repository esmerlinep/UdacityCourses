package com.esmerlinp.udacitycourses.views.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import android.widget.Toast
import com.esmerlinp.udacitycourses.R
import com.esmerlinp.udacitycourses.interactors.Entities.CatalogEntity
import com.esmerlinp.udacitycourses.presenters.CatalogPresenters
import com.esmerlinp.udacitycourses.presenters.interfaces.CatalogInterface
import com.esmerlinp.udacitycourses.views.adapters.CoursesAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CatalogInterface.View {
companion object {

}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val presenter:CatalogInterface.Presenter = CatalogPresenters(this)
        presenter.getUdaCityCourses()


    }

    override fun onRequestSuccess(response: CatalogEntity?) {

        if(response != null){
            reciclador.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
            reciclador.adapter = CoursesAdapter(response.courses, this)
        }

    }

    override fun onRequestFail(errorMesage: String) {
        Toast.makeText(this,errorMesage,Toast.LENGTH_LONG).show()
    }
}
