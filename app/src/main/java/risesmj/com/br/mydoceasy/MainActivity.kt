package risesmj.com.br.mydoceasy

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import risesmj.com.br.mydoceasy.data.model.DocumentPersonal

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        navController = Navigation.findNavController(this,R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration
            .Builder(R.id.destination_pin,R.id.destination_main).build()
        setupActionBarWithNavController(navController,appBarConfiguration)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id){
                R.id.destination_update -> {

                }
                R.id.destination_main -> {
                }
            }
        }
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

    //Abrir visualização
    fun openView(m: DocumentPersonal){
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