package risesmj.com.br.mydoceasy

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import risesmj.com.br.mydoceasy.data.model.DocumentPersonal

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Configura a view da activity
        setContentView(R.layout.activity_main)

        bindViews()
        setupActionBar()
        setupNavigationUI()
        setupBottomNavigation()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> navController.navigateUp()
        }

        return super.onOptionsItemSelected(item)
    }

    //Resgata os id de views
    fun bindViews(){
        navController = Navigation.findNavController(this,R.id.nav_host_fragment)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
    }

    //Configura o action bar
    fun setupActionBar(){
        setSupportActionBar(findViewById(R.id.toolbar))
        //Prepara o actionbar
        appBarConfiguration = AppBarConfiguration
            .Builder(R.id.destination_pin,R.id.destination_main,R.id.destination_setting).build()
        setupActionBarWithNavController(navController,appBarConfiguration)
    }

    //Configura o bottom navigation
    fun setupBottomNavigation(){
        //Listener do bottom navigation
        bottomNavigationView.setOnItemSelectedListener {  m ->
            when(m.itemId){
                R.id.documents -> navigateTo(R.id.destination_main)
                R.id.settings ->navigateTo(R.id.destination_setting)
            }
            true
        }
    }

    //Configura o navigation ui
    fun setupNavigationUI(){
        //Listenen de navegação no aplicativo
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.destination_update -> {
                    bottomNavigationView.visibility = View.GONE
                }
                R.id.destination_main -> {
                    bottomNavigationView.visibility = View.VISIBLE
                }
                R.id.destination_pin -> {
                    bottomNavigationView.visibility = View.GONE
                }
            }
        }
    }

    //Função auxiliar para navegar a um destino, onde a mesma verifica se é o destino atual
    private fun navigateTo(destiny: Int){
        if(navController.currentDestination?.id != destiny) {
            navController.navigate(destiny)
        }
    }

    //Abrir visualização
    fun openUpdate(m: DocumentPersonal){
        //Prepara a dialog de ação do usuário, para atualizar ou visualizar
        val builder = MaterialAlertDialogBuilder(this,R.style.MyThemeOverlay_MaterialComponents_MaterialAlertDialog)
        builder.setTitle(m.title)
        builder.setMessage("O que você deseja fazer?")
        builder.setCancelable(true)
        builder.setIcon(resources.getDrawable(m.icon,null))
        builder.setPositiveButton("Visualizar") { _, _ ->
        }
        builder.setNegativeButton("Atualizar") { _,_ ->
            val b = Bundle()
            b.putParcelable("documentPersonal",m)
            navController.navigate(R.id.action_main_to_viewDocumentFragment,b)
        }
        builder.create()
        builder.show()
    }

    override fun onBackPressed() {
        if(navController.currentDestination?.id == R.id.destination_main)
            finish() else navController.navigateUp()
    }
}