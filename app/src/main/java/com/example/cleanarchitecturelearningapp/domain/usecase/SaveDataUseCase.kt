package com.example.cleanarchitecturelearningapp.domain.usecase

import com.example.cleanarchitecturelearningapp.domain.models.SaveDataParam

class SaveDataUseCase {

    fun execute (param: SaveDataParam) : Boolean {
        if (param.text.isEmpty()) {
            return false
        } else {
            return true
        }
    }
}