package com.tiyas.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.tiyas.navigationcomponent.databinding.FragmentDetailCategoryBinding

class DetailCategoryFragment : Fragment() {

//     dalam detail ini kita menerima data dari fragment category

    private var _binding : FragmentDetailCategoryBinding? = null
    private  val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailCategoryBinding.inflate(inflater, container, false)
        val view = binding.root
        return  view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

/**
 * codelab untuk mengirim data menggunakan bundle
 *
     val dataName = arguments?.getString(CategoryFragment.EXTRA_NAME)
     val dataDescription = arguments?.getLong(CategoryFragment.EXTRA_STOCK)
**/
//         mengirim data dengan safeArgs

        val dataName = DetailCategoryFragmentArgs.fromBundle(arguments as Bundle).name
        val dataDescription = DetailCategoryFragmentArgs.fromBundle(arguments as Bundle).stock

        binding.categoryName.text = dataName
        binding.categoryDescription.text = "Stock : $dataDescription "

        binding.btnProfileDetail.setOnClickListener {
                view -> view.findNavController().navigate(R.id.action_detailCategoryFragment_to_homeFragment)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}