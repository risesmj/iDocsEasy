package risesmj.com.br.mydoceasy.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import risesmj.com.br.mydoceasy.R
import risesmj.com.br.mydoceasy.ui.adapter.SectionsPagerAdapter
import risesmj.com.br.mydoceasy.ui.adapter.TabsAdapter


class MainFragment : Fragment() {
    private lateinit var tabs: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var sectionsPagerAdapter: SectionsPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sectionsPagerAdapter = SectionsPagerAdapter(
            requireActivity().supportFragmentManager,
            lifecycle)

        viewPager = view.findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        tabs = view.findViewById(R.id.tabs)

        TabLayoutMediator(tabs, viewPager, TabsAdapter(requireContext())).attach()
    }

    companion object {

        fun newInstance(): MainFragment{
            return MainFragment()
        }
    }
}