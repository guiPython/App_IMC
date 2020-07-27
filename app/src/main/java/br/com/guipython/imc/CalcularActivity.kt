package br.com.guipython.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_calcular.*

class CalcularActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcular)



        btnCalculo.setOnClickListener {
            var peso = edtPeso.text.toString().trim()
            var altura = edtAltura.text.toString().trim()

            if (peso.isEmpty() || altura.isEmpty()) {
                AlertDialog.Builder(this@CalcularActivity).setTitle("Alerta").setMessage("Preencha todos os campos.")
                    .setPositiveButton("OK") { _, _ -> }.setCancelable(false).create().show()
            }
            else {
                if (peso.toDouble() == 0.00 || altura.toDouble() == 0.00) {
                    AlertDialog.Builder(this@CalcularActivity).setTitle("Erro de Cálculo")
                        .setMessage("Insira valores não nulos.").setPositiveButton("OK") { _, _ -> }
                        .setCancelable(false).create().show()
                } else {
                    var imc = (peso.toDouble()) / (Math.pow(altura.toDouble(), 2.0))
                    var caso = when {
                        imc < 17 -> "Muito abaixo do peso"
                        imc > 17 && imc < 18.49 -> "Abaixo do peso ideal"
                        imc > 18.49 && imc < 24.99 -> "Peso ideal"
                        imc > 25 && imc < 29.99 -> "Acima do peso ideal"
                        imc > 30 && imc < 34.99 -> " Obesidade Grau 1"
                        imc > 35 && imc < 39.99 -> "Obesidade Grau 2"
                        else -> "Obesidade Grau 3"
                    }
                    var pesoIdeal = ((24.99 + 18.49) / 2.0) * Math.pow(altura.toDouble(), 2.0)
                    startActivity(
                        Intent(
                            this@CalcularActivity,
                            ResultadoActivity::class.java
                        ).apply {
                            putExtra("caso", caso)
                            putExtra("imc", imc.toString())
                            putExtra("pesoIdeal", pesoIdeal.toString())
                        })
                }
                edtAltura.text.clear()
                edtPeso.text.clear()
            }

        }
    }
}
