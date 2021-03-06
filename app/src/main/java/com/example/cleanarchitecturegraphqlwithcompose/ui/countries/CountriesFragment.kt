package com.example.cleanarchitecturegraphqlwithcompose.ui.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cleanarchitecturegraphqlwithcompose.databinding.FragmentCountriesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountriesFragment : Fragment() {

    private lateinit var binding: FragmentCountriesBinding

    companion object {

        fun newInstance() = CountriesFragment()
    }

    private val viewModel: CountriesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCountriesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeData()
    }

    private fun observeData() {

        with(viewModel) {

            binding.countriesComposeView.setContent {

                val countryList by countries.observeAsState()
                val loadingState by loading.observeAsState(true)

                CountriesCompose(countryList, loadingState)
            }

            error.observe(viewLifecycleOwner, { errorMessage ->

                // Burada gerekli aksiyonu alabilirsiniz.

            })
        }
    }
}