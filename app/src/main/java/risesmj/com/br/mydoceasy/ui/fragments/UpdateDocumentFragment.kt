package risesmj.com.br.mydoceasy.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import risesmj.com.br.mydoceasy.R
import risesmj.com.br.mydoceasy.data.model.DocumentPersonal
import java.lang.Exception

class UpdateDocumentFragment : Fragment() {
    private lateinit var tvTitle: TextView
    private lateinit var ivIcon: ImageView
    private lateinit var tvDataEnvio: TextView
    private lateinit var etObservacao: TextInputEditText
    private lateinit var btExcluir: Button
    private lateinit var btEnviar: Button

    private var documentPersonal: DocumentPersonal? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_update_document, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //bind views
        tvTitle = view.findViewById(R.id.tvTitle)
        ivIcon = view.findViewById(R.id.ivIcon)
        tvDataEnvio = view.findViewById(R.id.tvDataEnvio)
        etObservacao = view.findViewById(R.id.etObservacao)
        btExcluir = view.findViewById(R.id.btExcluir)
        btEnviar = view.findViewById(R.id.btEnviar)

        //Resgata o documento pessoal
        documentPersonal = arguments?.getParcelable("documentPersonal")

        //Seta as informações
        try{
            tvTitle.text = documentPersonal?.title
            ivIcon.setImageDrawable(resources.getDrawable(documentPersonal?.icon!!,null))
            tvDataEnvio.text = ""
            etObservacao.setText(documentPersonal?.observation)
        }catch (e: Exception){
            Log.e("view",e.message.toString())
        }
    }
}
