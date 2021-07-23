package risesmj.com.br.mydoceasy.database

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration
import risesmj.com.br.mydoceasy.R

class RealmApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        val configuration = RealmConfiguration
            .Builder()
            .name("idocper.realm")
            .schemaVersion(this.resources.getInteger(R.integer.schema_version_realm).toLong())
            .build()

        Realm.setDefaultConfiguration(configuration)
        Realm.getInstance(configuration)
    }
}