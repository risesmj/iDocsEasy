package risesmj.com.br.mydoceasy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import risesmj.com.br.mydoceasy.ui.adapter.DocumentListAdapter
import risesmj.com.br.mydoceasy.R
import risesmj.com.br.mydoceasy.data.model.DocumentPersonal
import risesmj.com.br.mydoceasy.ui.view_model.DocumentsViewModel

class DocumentsFragment : Fragment() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: DocumentListAdapter
    private val mDocumentsViewModel: DocumentsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_documents, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mListMenu = listOf(
            DocumentPersonal("RG/CPF", R.drawable.ic_rg_cpf),
            DocumentPersonal("CNH", R.drawable.ic_car),
            DocumentPersonal("HISTÓRICO ESCOLAR", R.drawable.ic_history),
            DocumentPersonal("COMPROVANTE RESIDÊNCIA", R.drawable.ic_home),
            DocumentPersonal("CERTIDÃO NASCIMENTO", R.drawable.ic_nascimento),
            DocumentPersonal("CTPS", R.drawable.ic_work),
            DocumentPersonal("COMPROVANTE RENDA", R.drawable.ic_money),
            DocumentPersonal("DECLARAÇÃO IR ANUAL", R.drawable.ic_lion),
            DocumentPersonal("CERTIDÃO CASAMENTO", R.drawable.ic_casamento),
            DocumentPersonal("CERTIDÃO DIVÓRCIO", R.drawable.ic_divorcio),
            DocumentPersonal("CONCLUSÃO ENSINO MÉDIO", R.drawable.ic_graduation),
            DocumentPersonal("COMPROVANTE TIPO MORADIA", R.drawable.ic_moradia)
        )

        mAdapter = DocumentListAdapter(mListMenu)

        mRecyclerView = view.findViewById(R.id.recycleView)
        mRecyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        mRecyclerView.adapter = mAdapter
    }
}