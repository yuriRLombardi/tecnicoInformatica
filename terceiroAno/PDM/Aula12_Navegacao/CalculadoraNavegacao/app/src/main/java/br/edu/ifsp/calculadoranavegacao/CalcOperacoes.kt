package br.edu.ifsp.calculadoranavegacao

data class CalcOperacoes(var num1: Float, var num2: Float) {
    fun naoNulo():Boolean{
        if (num1 == null || num2 == null){
            return false
        }
        else{
            return true
        }
    }

    fun soma(): Float {
        if (naoNulo()){
            return num1 + num2
        }
        else{
            return 0.0f
        }
    }
    fun subtracao(): Float {
        if (naoNulo()){
            return num1 - num2
        }
        else{
            return 0.0f
        }
    }
    fun multiplicacao(): Float {
        if (naoNulo()){
            return num1 * num2
        }
        else{
            return 0.0f
        }
    }
    fun divisao(): Float {
        if (naoNulo()){
            return num1 / num2
        }
        else{
            return 0.0f
        }
    }
}

