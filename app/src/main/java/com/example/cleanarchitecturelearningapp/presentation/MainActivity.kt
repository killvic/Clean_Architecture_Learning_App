package com.example.cleanarchitecturelearningapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.cleanarchitecturelearningapp.R
import com.example.cleanarchitecturelearningapp.domain.models.Data
import com.example.cleanarchitecturelearningapp.domain.models.SaveDataParam
import com.example.cleanarchitecturelearningapp.domain.usecase.GetDataUsecase
import com.example.cleanarchitecturelearningapp.domain.usecase.SaveDataUseCase

class MainActivity : AppCompatActivity() {
    private lateinit var etEnterData: EditText
    private lateinit var tvData: TextView
    private lateinit var btSaveData: Button
    private lateinit var btGetData: Button

    private val getDataUseCase = GetDataUsecase()
    private val saveDataUseCase = SaveDataUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etEnterData = findViewById(R.id.etDataEnter)
        tvData = findViewById(R.id.tvGetData)
        btSaveData = findViewById(R.id.btSaveData)
        btGetData = findViewById(R.id.btGetData)

        btSaveData.setOnClickListener {
            // Click on Save Button
            val text = etEnterData.text.toString()
            val params = SaveDataParam(text = text)
            val result: Boolean = saveDataUseCase.execute(param = params)
            tvData.text = "Save Results = $result"

        }

        btGetData.setOnClickListener {
            // Click on Get Data Button
            val data: Data = getDataUseCase.execute()
            tvData.text = "${data.text}, ${data.number}"
        }

    }
}