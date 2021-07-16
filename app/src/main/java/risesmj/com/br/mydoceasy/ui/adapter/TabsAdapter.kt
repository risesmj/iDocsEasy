package risesmj.com.br.mydoceasy.ui.adapter

import android.content.Context
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import risesmj.com.br.mydoceasy.R

class TabsAdapter(
    private val context: Context): TabLayoutMediator.TabConfigurationStrategy {
    private val TAB_TITLES = listOf(
        R.string.meus,
        R.string.mae,
        R.string.pai
    )

    private val TAB_ICON = listOf(
        R.drawable.you,
        R.drawable.mother,
        R.drawable.dad
    )

    override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
        tab.text = context.getString(TAB_TITLES[position])
        tab.icon = context.getDrawable(TAB_ICON[position])
    }
}