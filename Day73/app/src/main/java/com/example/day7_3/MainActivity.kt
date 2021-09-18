package com.example.day7_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieData = parseJsonObject(getJsonString())
        findViewById<RecyclerView>(R.id.g_list).adapter = GenreAdapter(movieData)
    }

    private fun getJsonString() : String {
        return try {
            val inputStream = assets.open("movie.json")
            val fileSize: Int = inputStream.available()
            val buffer = ByteArray(fileSize)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charset.forName("UTF-8"))
        } catch (e: Exception) {
            ""
        }
    }

    private fun parseJsonObject(json: String) : List<Genre>{
        return try {
            val genres = mutableListOf<Genre>()
            val jsonObject = JSONObject(json)
            val genreArray: JSONArray = jsonObject.getJSONArray("Genres")
            for (i in 0 until genreArray.length()) {
                val genreObject = genreArray.getJSONObject(i)
                val moviesArray = genreObject.getJSONArray("movies")
                val movies = mutableListOf<Movie>()
                for(j in 0 until moviesArray.length())
                {
                    val movieObject = moviesArray.getJSONObject(j)
                    movies.add(parseJsonMovieObject(movieObject))
                }
                genres.add(Genre(name = genreObject.getString("name"), movies = movies))
            }
            return genres
        } catch (e: JSONException) {
            e.printStackTrace()
            listOf()
        }
    }

    private fun parseJsonMovieObject(json:JSONObject) : Movie {
        return Movie(
            name = json.getString("name"),
            desc = json.getString("desc"),
            poster = resources.getIdentifier(json.getString("poster"),"drawable",packageName)
        )
    }
}