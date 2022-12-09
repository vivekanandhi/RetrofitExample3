package com.vivi.retrofitexample3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.vivi.retrofitexample3.network.ApiClient
import com.vivi.retrofitexample3.network.CharacterResponse
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = ApiClient.apiService.fetchCharacters("1")

        client.enqueue(object : retrofit2.Callback<CharacterResponse>{
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                if (response.isSuccessful) {
                    Log.d("characters", " " + response.body())
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Log.e("failed"," "+t.message)

            }
        })
    }
}