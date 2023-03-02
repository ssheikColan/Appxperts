package com.example.appxperts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appxperts.adapter.ChildTitleAdapter
import com.example.appxperts.adapter.CourseRVAdapter
import com.example.appxperts.adapter.TitleAdapter
import com.example.appxperts.databinding.ActivityCatalogueBinding
import com.example.appxperts.databinding.ActivityHomeBinding
import com.example.appxperts.model.CourseRVModal
import com.example.appxperts.model.TitleModel

class CatalogueActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCatalogueBinding

    //Gride
    lateinit var courseRVAdapter: CourseRVAdapter
    lateinit var courseList: ArrayList<CourseRVModal>

    //ParentList
    lateinit var titleAdapter: TitleAdapter
    lateinit var tileList: ArrayList<TitleModel>


    //ChildList
    lateinit var childTitleAdapter: ChildTitleAdapter
    lateinit var childTitleList: ArrayList<TitleModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatalogueBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)
        }

        binding.navView.setNavigationItemSelectedListener { menuItem ->

            menuItem.isChecked = true

            binding.myDrawerLayout.closeDrawers()


            when (menuItem.itemId) {

                R.id.nav_dashboard -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                R.id.nav_stack -> {

                    binding.myDrawerLayout.closeDrawers()
                }
                R.id.nav_logout -> {

                }
            }


            true
        }





        //Gride
        courseList = ArrayList()

        val layoutManager = GridLayoutManager(this, 2)

        binding.idRVCourses.layoutManager = layoutManager


        courseRVAdapter = CourseRVAdapter(courseList, this)


        binding.idRVCourses.adapter = courseRVAdapter


        courseList.add(CourseRVModal("Android Development", R.drawable.ic_logo_trans))
        courseList.add(CourseRVModal("C++ Development", R.drawable.ic_logo_trans))
        courseList.add(CourseRVModal("Java Development", R.drawable.ic_logo_trans))
        courseList.add(CourseRVModal("Python Development", R.drawable.ic_logo_trans))
        courseList.add(CourseRVModal("JavaScript Development", R.drawable.ic_logo_trans))
        courseList.add(CourseRVModal("Android Development", R.drawable.ic_logo_trans))
        courseList.add(CourseRVModal("C++ Development", R.drawable.ic_logo_trans))
        courseList.add(CourseRVModal("Java Development", R.drawable.ic_logo_trans))
        courseList.add(CourseRVModal("Python Development", R.drawable.ic_logo_trans))
        courseList.add(CourseRVModal("JavaScript Development", R.drawable.ic_logo_trans))


        courseRVAdapter.notifyDataSetChanged()





        //ParentList
        tileList = ArrayList()

        titleAdapter = TitleAdapter(tileList, this)

        binding.idParentRecycle.adapter = titleAdapter


        tileList.add(TitleModel("AGRICULTURAL PRODUCT"))
        tileList.add(TitleModel("HEALTH & BEAUTY"))
        tileList.add(TitleModel("HOUSEHOLDS"))
        tileList.add(TitleModel("Android Development"))
        tileList.add(TitleModel("Android Development"))
        tileList.add(TitleModel("Android Development"))
        tileList.add(TitleModel("Android Development"))

        titleAdapter.notifyDataSetChanged()




        //ChildList
        childTitleList = ArrayList()


        childTitleAdapter = ChildTitleAdapter(tileList, this)


        binding.idChildRecycle.adapter = childTitleAdapter


        childTitleList.add(TitleModel("Baby Care"))
        childTitleList.add(TitleModel("Feminine Care"))
        childTitleList.add(TitleModel("Men's Toiletries"))
        childTitleList.add(TitleModel("Oral Care"))
        childTitleList.add(TitleModel("Ios Development"))
        childTitleList.add(TitleModel("Ios Development"))
        childTitleList.add(TitleModel("Ios Development"))

        childTitleAdapter.notifyDataSetChanged()




    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                binding.myDrawerLayout.openDrawer(GravityCompat.START)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
    }
