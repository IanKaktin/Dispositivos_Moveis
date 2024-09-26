XML:
<!-- res/layout/activity_main.xml -->
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="16dp">

    <TextView
        android:id="@+id/tvTeam1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Equipe 1"
        android:textSize="24sp"
        android:layout_marginBottom="16dp"/>

    <TextView
        android:id="@+id/tvScoreTeam1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="0"
        android:textSize="48sp"
        android:layout_marginBottom="16dp"/>

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button
            android:id="@+id/btnAddTeam1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="+1"/>

        <Button
            android:id="@+id/btnSubtractTeam1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="-1"
            android:layout_marginStart="16dp"/>
    </LinearLayout>

    <TextView
        android:id="@+id/tvTeam2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Equipe 2"
        android:textSize="24sp"
        android:layout_marginTop="32dp"
        android:layout_marginBottom="16dp"/>

    <TextView
        android:id="@+id/tvScoreTeam2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="0"
        android:textSize="48sp"
        android:layout_marginBottom="16dp"/>

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button
            android:id="@+id/btnAddTeam2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="+1"/>

        <Button
            android:id="@+id/btnSubtractTeam2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="-1"
            android:layout_marginStart="16dp"/>
    </LinearLayout>

    <Button
        android:id="@+id/btnReset"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Resetar"
        android:layout_marginTop="32dp"/>

</LinearLayout>

Kotlin:
class MainActivity : AppCompatActivity() {

    private var scoreTeam1 = 0
    private var scoreTeam2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvScoreTeam1 = findViewById<TextView>(R.id.tvScoreTeam1)
        val tvScoreTeam2 = findViewById<TextView>(R.id.tvScoreTeam2)

        val btnAddTeam1 = findViewById<Button>(R.id.btnAddTeam1)
        val btnSubtractTeam1 = findViewById<Button>(R.id.btnSubtractTeam1)
        val btnAddTeam2 = findViewById<Button>(R.id.btnAddTeam2)
        val btnSubtractTeam2 = findViewById<Button>(R.id.btnSubtractTeam2)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnAddTeam1.setOnClickListener {
            if (scoreTeam1 < 12) {
                scoreTeam1++
                tvScoreTeam1.text = scoreTeam1.toString()
            }
        }

        btnSubtractTeam1.setOnClickListener {
            if (scoreTeam1 > 0) {
                scoreTeam1--
                tvScoreTeam1.text = scoreTeam1.toString()
            }
        }

        btnAddTeam2.setOnClickListener {
            if (scoreTeam2 < 12) {
                scoreTeam2++
                tvScoreTeam2.text = scoreTeam2.toString()
            }
        }

        btnSubtractTeam2.setOnClickListener {
            if (scoreTeam2 > 0) {
                scoreTeam2--
                tvScoreTeam2.text = scoreTeam2.toString()
            }
        }

        btnReset.setOnClickListener {
            scoreTeam1 = 0
            scoreTeam2 = 0
            tvScoreTeam1.text = scoreTeam1.toString()
            tvScoreTeam2.text = scoreTeam2.toString()
        }
    }
}
