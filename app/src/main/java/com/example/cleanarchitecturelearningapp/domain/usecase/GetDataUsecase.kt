package com.example.cleanarchitecturelearningapp.domain.usecase

import com.example.cleanarchitecturelearningapp.domain.models.Data

class GetDataUsecase{

    fun execute(): Data {
        return Data(text = "TEST", number = 0)
    }

}