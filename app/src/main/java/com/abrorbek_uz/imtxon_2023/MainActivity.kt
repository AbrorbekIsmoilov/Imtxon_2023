package com.abrorbek_uz.imtxon_2023

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.abrorbek_uz.imtxon_2023.adapter.MyRvAdapter
import com.abrorbek_uz.imtxon_2023.databinding.ActivityMainBinding
import com.abrorbek_uz.imtxon_2023.models.APIDataItem
import com.abrorbek_uz.retrofit2.networking.ApiClient
import com.abrorbek_uz.retrofit2.networking.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var myRvAdapter: MyRvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Retrofit2()

    }
    private fun Retrofit2(){

        val apiService = ApiClient.getRetrofit().create(ApiService::class.java)
        apiService.getMarvels()
            .enqueue(object : Callback<List<APIDataItem>> {
                override fun onResponse(
                    call: Call<List<APIDataItem>>,
                    response: Response<List<APIDataItem>>
                ) {
                    if (response.isSuccessful && response.body()!=null){
                        Log.d(TAG, "onResponse: ${response.body()}")
                        binding.apply {
                            val dataList = response.body()
                            val adapter = MyRvAdapter(dataList!!) // dataList o'rniga kerakli ma'lumotlar ro'yhatini o'tkazing
                            rv.adapter = adapter
                        }

                    }
                }

                override fun onFailure(call: Call<List<APIDataItem>>, t: Throwable) {

                    Toast.makeText(this@MainActivity, "Internet ulanmagan", Toast.LENGTH_SHORT).show()

                }

            })
    }
}
