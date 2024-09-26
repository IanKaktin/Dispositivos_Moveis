xml:
<!-- activity_main.xml -->
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <!-- Input do nome do aluno -->
    <EditText
        android:id="@+id/etNomeAluno"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Nome do Aluno" />

    <!-- Input da área de escolha -->
    <EditText
        android:id="@+id/etAreaEscolha"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Área de Escolha" />

    <!-- Botão de Inserir -->
    <Button
        android:id="@+id/btnInserir"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Inserir" />

    <!-- RecyclerView para exibir a lista dos alunos -->
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerViewAlunos"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:orientation="vertical" />

    <!-- Texto que exibe a quantidade de alunos -->
    <TextView
        android:id="@+id/tvContagemAlunos"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Contagem de alunos: 0" />

    <!-- Botão de Zerar -->
    <Button
        android:id="@+id/btnZerar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Zerar" />

<!-- item_aluno.xml -->
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical">

    <TextView
        android:id="@+id/tvNomeAluno"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Nome do Aluno" />

    <TextView
        android:id="@+id/tvAreaEscolha"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Área de Escolha" />

    <TextView
        android:id="@+id/tvData"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Data" />
</LinearLayout>

kotlin:
data class Aluno(val nome: String, val area: String, val data: String)

class AlunoAdapter(private val alunos: MutableList<Aluno>) :
    RecyclerView.Adapter<AlunoAdapter.AlunoViewHolder>() {

    class AlunoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeTextView: TextView = itemView.findViewById(R.id.tvNomeAluno)
        val areaTextView: TextView = itemView.findViewById(R.id.tvAreaEscolha)
        val dataTextView: TextView = itemView.findViewById(R.id.tvData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_aluno, parent, false)
        return AlunoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        val aluno = alunos[position]
        holder.nomeTextView.text = aluno.nome
        holder.areaTextView.text = aluno.area
        holder.dataTextView.text = aluno.data
    }

    override fun getItemCount() = alunos.size
}
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private val alunos = mutableListOf<Aluno>()
    private val alunoAdapter = AlunoAdapter(alunos)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewAlunos.layoutManager = LinearLayoutManager(this)
        recyclerViewAlunos.adapter = alunoAdapter

        btnInserir.setOnClickListener {
            val nome = etNomeAluno.text.toString()
            val area = etAreaEscolha.text.toString()
            val data = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

            if (nome.isNotBlank() && area.isNotBlank()) {
                val aluno = Aluno(nome, area, data)
                alunos.add(aluno)
                alunoAdapter.notifyDataSetChanged()
                atualizarContagem()
                limparCampos()
            }
        }

        btnZerar.setOnClickListener {
            alunos.clear()
            alunoAdapter.notifyDataSetChanged()
            atualizarContagem()
        }
    }

    private fun atualizarContagem() {
        tvContagemAlunos.text = "Contagem de alunos: ${alunos.size}"
    }

    private fun limparCampos() {
        etNomeAluno.text.clear()
        etAreaEscolha.text.clear()
    }
}
