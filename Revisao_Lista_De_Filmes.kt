XML:
<!-- res/layout/activity_main.xml -->
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"/>

</LinearLayout>
<!-- res/layout/item_movie.xml -->
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:id="@+id/tvTitle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Title"
        android:textSize="18sp"
        android:textStyle="bold"/>

    <TextView
        android:id="@+id/tvGenre"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Genre"
        android:textSize="16sp"/>

    <TextView
        android:id="@+id/tvYear"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Year"
        android:textSize="14sp"
        android:textColor="@android:color/darker_gray"/>
</LinearLayout>

Kotlin:
data class Movie(val title: String, val genre: String, val year: Int)

class MovieAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvGenre: TextView = itemView.findViewById(R.id.tvGenre)
        val tvYear: TextView = itemView.findViewById(R.id.tvYear)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = movieList[position]
        holder.tvTitle.text = currentMovie.title
        holder.tvGenre.text = currentMovie.genre
        holder.tvYear.text = currentMovie.year.toString()
    }

    override fun getItemCount() = movieList.size
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val movies = listOf(
            Movie("The Shawshank Redemption", "Drama", 1994),
            Movie("The Godfather", "Crime", 1972),
            Movie("The Dark Knight", "Ação", 2008),
        )

        val adapter = MovieAdapter(movies)
        recyclerView.adapter = adapter
    }
}
