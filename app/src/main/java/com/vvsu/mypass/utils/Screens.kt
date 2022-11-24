package com.vvsu.mypass.utils

import androidx.compose.ui.graphics.vector.ImageVector
import com.vvsu.mypass.utils.Constants.ROUTE_HOME
import com.vvsu.mypass.utils.Constants.ROUTE_CUSTOMIZATION
import com.vvsu.mypass.utils.Constants.ROUTE_SETTING
import compose.icons.FeatherIcons
import compose.icons.feathericons.CreditCard
import compose.icons.feathericons.Edit
import compose.icons.feathericons.Settings

sealed class Screens(val route: String, var label: String, val icon: ImageVector) {

    object Home : Screens(ROUTE_HOME, "Пропуск", FeatherIcons.CreditCard)
    object Customization : Screens(ROUTE_CUSTOMIZATION, "Изменить", FeatherIcons.Edit)
    object Setting : Screens(ROUTE_SETTING, "Настройки", FeatherIcons.Settings)

    object Items {
        val items = listOf(
            Home, Customization, Setting
        )
    }
}