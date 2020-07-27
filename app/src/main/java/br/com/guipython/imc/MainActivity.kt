package br.com.guipython.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            // Funcao Lambda
            startActivity(Intent(this@MainActivity,CalcularActivity::class.java))
            // Fecha a Pagina de splash
            finish()
        },3000)

    }
}
