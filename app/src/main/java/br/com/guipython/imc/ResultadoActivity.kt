package br.com.guipython.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        var caso = intent.getStringExtra("caso")
        var pesoIdeal = intent.getStringExtra("pesoIdeal").toFloat()
        var imc = intent.getStringExtra("imc").toFloat()
        txvImcStatus.text = caso
        txvPesoId.text = "Seu peso ideal : %.2f".format(pesoIdeal)
        txvImc.text = "Seu imc : %.2f".format(imc)
    }
}
