package com.example.mykotproj

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ApiCallActivity : AppCompatActivity() {
    private var disposable: Disposable? = null

    private val boredApiService by lazy {
        BoredApiService.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)
        val btnSearch = findViewById<Button>(R.id.btn_search)
        val editSearch = findViewById<EditText>(R.id.edit_search)
        val txtResult = findViewById<TextView>(R.id.txt_search_result)

        btnSearch.setOnClickListener{
            if(editSearch.text.toString().isNotEmpty()) {
                searchIt(editSearch.text.toString(), txtResult)
            }
        }
    }


    private fun searchIt(searchString: String, resultView : TextView ) {
        disposable = boredApiService.getBoredActivity()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> resultView.text = "${result}" },
                { error -> Log.e("RETROFIT ERROR", error.toString())}
            )
    }


    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}