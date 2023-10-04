package com.desafiolatam.surveydonkey.viewmodel

import androidx.lifecycle.ViewModel
import com.desafiolatam.surveydonkey.ui.COLOR
import com.desafiolatam.surveydonkey.ui.COLORS
import com.desafiolatam.surveydonkey.ui.COLORS_BAND
import com.desafiolatam.surveydonkey.ui.COLOR_BAND
import com.desafiolatam.surveydonkey.ui.MATERIAL
import com.desafiolatam.surveydonkey.ui.MATERIALS

class MainViewModel : ViewModel() {

    private var firstAnswer: ArrayList<String> = arrayListOf()
    private var secondAnswer: ArrayList<String> = arrayListOf()
    private var thirdAnswer: ArrayList<String> = arrayListOf()

    private val separator = ", "

    private var userEmail: String? = null
    private var userSuggest: String? = null

    /**
     * Guarda la primera pregunta y retorna un listado de String,
     * ordenado y sin repetir opciones
     */
    fun addFirstAnswer(value: String): List<String> {
        firstAnswer.add(value)
        firstAnswer = ArrayList(firstAnswer.distinct().sorted().toList())
        return firstAnswer.distinct().sorted().toList()
    }

    /**
     * Si el usuario deseleccion una opcion, entonces la eliminamos de la lista "firstAnswer"
     */
    fun removeFirstAnswer(value: String): List<String> {
        if (firstAnswer.contains(value)) {
            firstAnswer.remove(value)
        }
        return firstAnswer.sorted().toList()
    }

    /**
     * Guarda la segunda pregunta y retorna un listado de String,
     * ordenado y sin repetir opciones
     */
    fun addSecondAnswer(value: String): List<String> {
        secondAnswer.add(value)
        secondAnswer = ArrayList(secondAnswer.distinct().sorted().toList())
        return secondAnswer.distinct().sorted().toList()
    }

    /**
     * Si el usuario deseleccion una opcion, entonces la eliminamos de la lista "secondAnswer"
     */
    fun removeSecondAnswer(value: String): List<String> {
        if (secondAnswer.contains(value)) {
            secondAnswer.remove(value)
        }
        return secondAnswer.sorted().toList()
    }

    /**
     * Guarda la 3era pregunta y retorna un listado de String,
     * ordenado y sin repetir opciones
     */
    fun addThirdAnswer(value: String): List<String> {
        thirdAnswer.add(value)
        thirdAnswer = ArrayList(thirdAnswer.distinct().sorted().toList())
        return thirdAnswer.distinct().sorted().toList()
    }

    /**
     * Si el usuario deseleccion una opcion, entonces la eliminamos de la lista "secondAnswer"
     */
    fun removeThirdAnswer(value: String): List<String> {
        if (thirdAnswer.contains(value)) {
            thirdAnswer.remove(value)
        }
        return thirdAnswer.sorted().toList()
    }

    /**
     * Muestra el resultado de la primera pregunta, separado por ","
     */
    fun getFirstResult(): String =
        when (firstAnswer.size) {
            1 -> "$COLOR ${firstAnswer.joinToString(separator)}"
            else -> "$COLORS ${firstAnswer.joinToString(separator)}"
        }

    /**
     * Muestra el resultado de la segunda pregunta, separado por ","
     */
    fun getSecondResult(): String =
        when (secondAnswer.size) {
            1 -> "$MATERIAL: ${secondAnswer.joinToString(separator)}"
            else -> "$MATERIALS ${secondAnswer.joinToString(separator)}"
        }

    fun getThirdResult(): String =
        when (thirdAnswer.size) {
            1 -> "$MATERIAL: ${thirdAnswer.joinToString(separator)}"
            else -> "$MATERIALS ${thirdAnswer.joinToString(separator)}"
        }

    /**
     * Agrega tus funciones aqui:
     * guardar email
     */

    fun saveUserEmail(email: String)  {
        userEmail = email
    }

    /**
     * guardar sugerencias del usuario
     */
    fun saveUserSuggest(suggest: String)  {
        userSuggest = suggest
    }

    /**
     * guardar email y sugerencias del usuario
     */

    fun getUserEmail(): String = "Email: ${userEmail}"
    fun getUserSuggest(): String = "Sugerencias: ${userSuggest}"

}