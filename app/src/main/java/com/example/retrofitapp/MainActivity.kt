package com.example.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)

        val retrofitService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java) // -> pass service class

        val responseLiveData: LiveData<Response<Albums>> =
            liveData {
                //val response = retrofitService.getAlbums()

                val response2 = retrofitService.getSpecificAlbums(6)
                emit(response2) // -> emit the response
            }

        responseLiveData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()

            if(albumsList != null) {
                while(albumsList.hasNext()) {
                    val albumItem = albumsList.next()
                    // Log.i("TAGY", albumItem.title)

                    // Store all elements of the album
                    val result = " Album Title: ${albumItem.title} \n"

                    textView.append(result)

                }
            }
        })

    }
}