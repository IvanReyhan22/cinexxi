package com.redesign.mtix.ui.navigation

sealed class Screen(val route: String) {

    object OnBoarding : Screen("onboarding_screen")
    object Login : Screen("login_screen")
    object Register : Screen("register_screen")

    object Home : Screen("home_screen")
    object Theater : Screen("theater_screen")
    object MyFood : Screen("myfood_screen")
    object Account : Screen("account_screen")

    object MovieDetail : Screen("movie_detail_screen")
    object SelectSeat : Screen("select_seat_screen")
    object TicketPayment : Screen("ticket_payment_screen")
    object MovieTicket : Screen("movie_ticket_screen")
}