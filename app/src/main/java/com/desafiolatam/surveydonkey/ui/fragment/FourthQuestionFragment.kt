package com.desafiolatam.surveydonkey.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.desafiolatam.surveydonkey.databinding.FragmentFourthQuestionBinding
import com.desafiolatam.surveydonkey.viewmodel.MainViewModel

class FourthQuestionFragment : Fragment() {
    private var _binding : FragmentFourthQuestionBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFourthQuestionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("FourthQuestion", "FourthQuestion onViewCreated")
        binding.run {
            answer41.doOnTextChanged { text, _, _, _ ->
                viewModel.saveUserEmail(text.toString())
            }
            answer42.doOnTextChanged { text, _, _, _ ->
                viewModel.saveUserSuggest(text.toString())
                answer42.maxLines=6
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("FourthQuestion", "FourthQuestion onDestroy")
    }


}