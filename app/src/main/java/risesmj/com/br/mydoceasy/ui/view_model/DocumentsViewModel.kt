package risesmj.com.br.mydoceasy.ui.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DocumentsViewModel : ViewModel() {

    private val mindex = MutableLiveData<Int>()

    fun setIndex(index: Int) {
        mindex.value = index
    }
}