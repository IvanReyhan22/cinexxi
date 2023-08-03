package com.redesign.mtix.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.redesign.mtix.R
import com.redesign.mtix.ui.navigation.NavItem
import com.redesign.mtix.ui.navigation.Screen
import com.redesign.mtix.ui.screen.home.HomeScreen
import com.redesign.mtix.ui.screen.login.LoginScreen
import com.redesign.mtix.ui.screen.register.RegisterScreen
import com.redesign.mtix.ui.theme.Dimens

@Composable
fun MtixApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomNavScreen = listOf(
        Screen.Home.route,
        Screen.Theater.route,
        Screen.MyFood.route,
        Screen.Account.route
    )

    Scaffold(
        modifier = modifier,
        bottomBar = { if (bottomNavScreen.contains(currentRoute)) BottomBar(navController = navController) },
        content = {
            MyNavigation(navController = navController)
        }
    )
}

@Composable
private fun MyNavigation(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.OnBoarding.route) {
            OnBoarding(navController = navController)
        }
        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.Register.route) {
            RegisterScreen(navController = navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
) {
    val selectedItem = rememberSaveable { mutableStateOf(Screen.Login.route) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val navigationItems = listOf(
        NavItem(
            title = stringResource(R.string.home),
            icon = if (currentRoute == Screen.Home.route) R.drawable.ic_solid_home_alpine else R.drawable.ic_outline_home,
            screen = Screen.Login,
            contentDescription = stringResource(R.string.home),
        ),
        NavItem(
            title = stringResource(R.string.theater),
            icon = if (currentRoute == Screen.Theater.route) R.drawable.ic_solid_building_alpine else R.drawable.ic_outline_building,
            screen = Screen.Register,
            contentDescription = stringResource(R.string.theater),
        ),
        NavItem(
            title = stringResource(R.string.myfood),
            icon = if (currentRoute == Screen.MyFood.route) R.drawable.ic_solid_drink_alpine else R.drawable.ic_outline_drink,
            screen = Screen.Login,
            contentDescription = stringResource(R.string.myfood),
        ),
        NavItem(
            title = stringResource(R.string.account),
            icon = if (currentRoute == Screen.Account.route) R.drawable.ic_solid_user_alpine else R.drawable.ic_outline_user,
            screen = Screen.Login,
            contentDescription = stringResource(R.string.account),
        ),
    )

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        tonalElevation = Dimens.spacing_1,
        containerColor = MaterialTheme.colorScheme.background
    ) {
        navigationItems.forEachIndexed { _, item ->
            NavigationBarItem(
                onClick = {
                    selectedItem.value = item.screen.route
                    navController.navigate(route = item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                label = {
                    Text(
                        text = item.title,
                        style = typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                        modifier = Modifier.padding(top = Dimens.spacing_8)
                    )
                },
                selected = item.screen.route == selectedItem.value,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    indicatorColor = MaterialTheme.colorScheme.background,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground,
                    unselectedTextColor = MaterialTheme.colorScheme.onBackground,
                ),
                icon = {
                    Image(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.contentDescription,
                        modifier = Modifier.size(Dimens.spacing_28)
                    )
                },
            )
        }
    }
}