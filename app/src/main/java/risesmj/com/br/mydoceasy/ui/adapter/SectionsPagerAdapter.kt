package risesmj.com.br.mydoceasy.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import risesmj.com.br.mydoceasy.R
import risesmj.com.br.mydoceasy.ui.fragments.DocumentsFragment

private val TAB_TITLES = listOf(
    R.string.meus,
    R.string.mae,
    R.string.pai
)

class SectionsPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = TAB_TITLES.size
    override fun createFragment(position: Int) = DocumentsFragment()

}