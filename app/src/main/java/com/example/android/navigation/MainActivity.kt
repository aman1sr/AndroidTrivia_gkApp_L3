/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Kotlin is a "null safety" language. One of the ways it offers null safety is through the lateinit modifier
                                                    // (read >> https://kotlinlang.org/docs/reference/properties.html#late-initialized-properties-and-variables )
    private lateinit var drawerwLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        /*
        * A navigation host fragment acts as a host for the fragments in a navigation graph.
        * The navigation host Fragment is usually named NavHostFragment.As the user moves between destinations defined in the navigation graph,
        * the navigation host Fragment swaps fragments in and out as necessary.
        * The Fragment also creates and manages the appropriate Fragment back stack.
        * */

        // in this Activity, we have set the base fragment -> navGraph , where the startDestination="@id/titleFragment"
                            // therefore no Need to set manually

/*
    NavigationUI is a UI library , contains static methods that manage navigation with
   * the top app bar,
   * the navigation drawer,
   * and bottom navigation.
*/
        val navController = this.findNavController(R.id.myNavHostFragment)              // for Action Bar
        NavigationUI.setupActionBarWithNavController(this, navController)


        /*
        * Once created -menu items for the navigation drawer and the navigation drawer layout.
        *
        * need to connect the navigation drawer to the navigation controller
        * so that when users select items in the navigation drawer, the app navigates to the appropriate Fragment.
        * */
        drawerwLayout = binding.drawerLayout        /* accessing the  drawer layout which contain Navigation View ( which has header & menu items) */
        NavigationUI.setupWithNavController(binding.navView, navController)     /* allows the user to display the navigation drawer. */
        NavigationUI.setupActionBarWithNavController(this, navController, drawerwLayout)


    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)

        return NavigationUI.navigateUp(navController,drawerwLayout)
    }

            // the using onSupportNavigationUp for only -> backButton
    /*
    * The Up/Back button appears in the app bar on every screen except the title screen.
    *  tapping the Up button takes you to the title screen.

     override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
    * */

}
