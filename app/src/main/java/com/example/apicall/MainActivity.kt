package com.example.apicall

import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

const val BASE_URL= "https://jsonplaceholder.typicode.com/";
class MainActivity : AppCompatActivity() {
lateinit var myAdapter: DemoAdapter
lateinit var linearManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleId.setHasFixedSize(true)
        linearManager= LinearLayoutManager(this)
        recycleId.layoutManager=linearManager
        getMyData()
    }

    private fun getMyData() {
       var retroFitBuilder=Retrofit.Builder()
           .addConverterFactory(GsonConverterFactory.create())
           .baseUrl(BASE_URL)
           .build()
           .create(ApiInterface::class.java)
        val retrofitData=retroFitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<DemoDataModelItem>?> {
            override fun onResponse(
                call: Call<List<DemoDataModelItem>?>,
                response: Response<List<DemoDataModelItem>?>
            ) {
//                val demoStringBuilder=StringBuilder()
          val responseBody=response.body()!!
                myAdapter= DemoAdapter(baseContext,responseBody)
                myAdapter.notifyDataSetChanged()
                recycleId.adapter=myAdapter

//                for (demoData in responseBody){
//                    demoStringBuilder.append(demoData.title)
//                    demoStringBuilder.append("\n")
//                }
//                demoTxt.text=demoStringBuilder
            }

            override fun onFailure(call: Call<List<DemoDataModelItem>?>, t: Throwable) {
               d("MainActivity","onFailure"+t.message)

            }
        })
    }
}