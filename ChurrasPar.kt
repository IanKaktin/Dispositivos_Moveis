Xml:
<!-- activity_main.xml -->
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <!-- Campo de entrada: Número de Homens -->
    <EditText
        android:id="@+id/etHomens"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Número de Homens"
        android:inputType="number" />

    <!-- Campo de entrada: Número de Mulheres -->
    <EditText
        android:id="@+id/etMulheres"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Número de Mulheres"
        android:inputType="number" />

    <!-- Campo de entrada: Número de Crianças -->
    <EditText
        android:id="@+id/etCriancas"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Número de Crianças"
        android:inputType="number" />

    <!-- Botão: Calcular -->
    <Button
        android:id="@+id/btnCalcular"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Calcular" />

    <!-- TextView: Resultados Calculados -->
    <TextView
        android:id="@+id/tvResultado"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Resultados: "
        android:textSize="16sp"
        android:paddingTop="16dp" />

    <!-- Botão: Limpar -->
    <Button
        android:id="@+id/btnLimpar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Limpar" />
</LinearLayout>

Kotlin:
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener {
            calcularChurrasco()
        }

        btnLimpar.setOnClickListener {
            limparCampos()
        }
    }

    private fun calcularChurrasco() {
        val numHomens = etHomens.text.toString().toIntOrNull() ?: 0
        val numMulheres = etMulheres.text.toString().toIntOrNull() ?: 0
        val numCriancas = etCriancas.text.toString().toIntOrNull() ?: 0

        val carneHomens = numHomens * 400
        val carneMulheres = numMulheres * 300
        val carneCriancas = numCriancas * 200
        val totalCarne = (carneHomens + carneMulheres + carneCriancas) * 1.1

        val aperitivosHomens = numHomens * 150
        val aperitivosMulheres = numMulheres * 100
        val aperitivosCriancas = numCriancas * 50
        val totalAperitivos = (aperitivosHomens + aperitivosMulheres + aperitivosCriancas) * 1.1

        val bebidaHomens = numHomens * 4.0
        val bebidaMulheres = numMulheres * 2.0
        val totalBebidaAlcoolica = (bebidaHomens + bebidaMulheres) * 1.1

        val agua = (numMulheres + numCriancas) * 2.0 * 1.1
        val refrigerante = (numMulheres + numCriancas) * 1.5 * 1.1

        val resultado = """
            Carne Total: %.2f kg
            Aperitivos Totais: %.2f g
            Bebida Alcoólica: %.2f L
            Água: %.2f L
            Refrigerante: %.2f L
        """.trimIndent().format(totalCarne / 1000, totalAperitivos, totalBebidaAlcoolica, agua, refrigerante)

        tvResultado.text = resultado
    }

    private fun limparCampos() {
        etHomens.text.clear()
        etMulheres.text.clear()
        etCriancas.text.clear()
        tvResultado.text = "Resultados: "
        Toast.makeText(this, "Campos limpos", Toast.LENGTH_SHORT).show()
    }
}
