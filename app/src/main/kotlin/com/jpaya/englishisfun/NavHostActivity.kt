/*
 * Copyright 2020 Jose Maria Payá Castillo
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

package com.jpaya.englishisfun

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * Base activity class that use the support library action bar features.
 * Link: https://developer.android.com/guide/navigation/navigation-ui
 */
@AndroidEntryPoint
class NavHostActivity : AppCompatActivity(R.layout.activity_main) {

    @Inject
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firebaseAuth.signInAnonymously().addOnCompleteListener(this) {
//            if (it.isSuccessful) {
//                viewState = HomeViewState.NavigationScreen
//            }
        }

        setupNavigationController()
    }

    private fun setupNavigationController() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        nav_view.setupWithNavController(navController)
        toolbar.setupWithNavController(
            navController,
            AppBarConfiguration(
                setOf(
                    R.id.abbreviations_list_fragment,
                    R.id.conditionals_list_fragment,
                    R.id.idioms_list_fragment,
                    R.id.irregulars_list_fragment,
                    R.id.settings_fragment
                ),
                drawer_layout
            )
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        item.onNavDestinationSelected(findNavController(R.id.nav_host_fragment)) || super.onOptionsItemSelected(item)
}
