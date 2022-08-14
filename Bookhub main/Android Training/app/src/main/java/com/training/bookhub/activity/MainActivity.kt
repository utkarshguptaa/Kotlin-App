package com.training.bookhub.activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.training.bookhub.fragments.DashboardFragment
import com.training.bookhub.fragments.FavouriteFragment
import com.training.bookhub.fragments.ProfileFragment
import com.training.bookhub.R
import com.training.bookhub.fragments.AboutFragment

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var frameLayout: FrameLayout
    lateinit var toolbarLayout: androidx.appcompat.widget.Toolbar
    lateinit var navigationLayout: NavigationView
        var PreviousMenuItem:MenuItem?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        drawerLayout = findViewById(R.id.drawer)
        coordinatorLayout = findViewById(R.id.coordinator)
        frameLayout = findViewById(R.id.frame)
        toolbarLayout = findViewById(R.id.toolbar)
        navigationLayout = findViewById(R.id.navigation)

        SetToolBar()
        setDashboard()

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()



        navigationLayout.setNavigationItemSelectedListener {

            if(PreviousMenuItem!=null){
                PreviousMenuItem?.isChecked=false
            }
            it.isCheckable = true
            it.isChecked = true
            PreviousMenuItem = it
            when(it.itemId) {
                R.id.dashboard -> {
                    setDashboard()
                    drawerLayout.closeDrawers()
                    Toast.makeText(this@MainActivity, "opening Dashboard", Toast.LENGTH_SHORT).show()
                }
                R.id.favourite ->{
                    val favourite = FavouriteFragment()
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.frame,favourite).commit()
                    supportActionBar?.title="Favourite"
                    drawerLayout.closeDrawers()

                    Toast.makeText(this@MainActivity, "opening Favourite", Toast.LENGTH_SHORT).show()

                }
                R.id.profile ->{
                        val profile = ProfileFragment()
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.frame, profile).commit()
                    supportActionBar?.title="Profile"
                    drawerLayout.closeDrawers()

                    Toast.makeText(this@MainActivity, "opening Profile", Toast.LENGTH_SHORT).show()

                }
                R.id.about_app ->{
                    val about = AboutFragment()
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.frame,about).commit()
                    supportActionBar?.title="About App"
                    drawerLayout.closeDrawers()

                    Toast.makeText(this@MainActivity, "opening About App", Toast.LENGTH_SHORT).show()
                }
                R.id.log_out ->{
                    Toast.makeText(this@MainActivity, "Log out", Toast.LENGTH_SHORT).show()
                }
            }

            return@setNavigationItemSelectedListener true
        }




    }
    override fun onOptionsItemSelected(item:MenuItem):Boolean{

        val id = item.itemId
        if(id==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return super.onOptionsItemSelected(item)
    }


fun setDashboard(){
    val fragment = DashboardFragment()
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.frame, fragment)
    transaction.commit()
    supportActionBar?.title = "Dashboard"
    navigationLayout.setCheckedItem(R.id.dashboard)
}

    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.frame)
        when(frag){
            !is DashboardFragment ->setDashboard()
            else-> super.onBackPressed()

        }
    }



    fun SetToolBar(){
        setSupportActionBar(toolbarLayout)
        supportActionBar?.title = "Book Hub"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}


