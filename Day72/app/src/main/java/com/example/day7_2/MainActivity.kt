package com.example.day7_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieData = parseJsonObject(getJsonString())
        Log.d("movielist", movieData.toString())
        findViewById<RecyclerView>(R.id.recycler_main_list).adapter = GenreAdapter(movieData)
    }

    private fun getJsonString() : String{
        // movie.json 파일을 얽어온다.
        return try{
            val inputStream = assets.open("movie.json")
            val fileSize = inputStream.available()
            val buffer = ByteArray(fileSize)

            inputStream.read(buffer)
            inputStream.close()

            String(buffer, Charset.forName("UTF-8"))
        }   catch (e : Exception){
            //파일이 없다면 빈 문자열을 반환한다.
            ""
        }
    }

    private fun parseJsonObject(json : String) : List<Genre> {
        //json을 넘겨받고 장르 단위로 나눠준다.
        return try {
            val genres : JSONArray = JSONObject(json).getJSONArray("Genres")
            val genresList = mutableListOf<Genre>()

            for(i in 0 until genres.length()){
                val movies = genres.getJSONObject(i).getJSONArray("movies")
                val moviesList = mutableListOf<Movie>()

//                Log.d("movies", movies.toString())
                for (j in 0 until movies.length()){
                    val movie = movies.getJSONObject(j)
                    moviesList.add(parseMovieObject(movie))
                }

                genresList.add(Genre(
                    name = genres.getJSONObject(i).getString("name"),
                    movies = moviesList
                ))
            }
            Log.d("result", genresList.toString())

            genresList
        }   catch (e : Exception){
            listOf()
        }
    }

    private fun parseMovieObject(json: JSONObject) : Movie{
        //영화 제이슨이 들어오면 movie로 반환
        return Movie(
            name = json.getString("name"),
            desc = json.getString("desc"),
            poster = resources.getIdentifier(json.getString("poster"), "drawable", packageName)
        )
    }

}