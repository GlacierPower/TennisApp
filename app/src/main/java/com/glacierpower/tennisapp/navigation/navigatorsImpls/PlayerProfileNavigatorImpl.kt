
package com.glacierpower.tennisapp.navigation.navigatorsImpls

import androidx.navigation.NavController
import com.glacierpower.tennisapp.features.player_profile.navigation.PlayerProfileNavigator
import javax.inject.Inject

class PlayerProfileNavigatorImpl @Inject constructor(
    private val navController: NavController
) : PlayerProfileNavigator {
    override fun navigateBack() {
        navController.popBackStack()
    }
}
