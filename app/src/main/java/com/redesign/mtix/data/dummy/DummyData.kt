package com.redesign.mtix.data.dummy

data class Seat(
    val title: String,
    val state: Int,// 0 = available, 1 = booked , 2 = selected
    val type: Int,// 0 = indicator, 1 = seat
)

object DummyData {
    val seatData: List<Seat> = listOf(
        Seat(title = "A1", state = 0, type = 1),
        Seat(title = "A2", state = 1, type = 1),
        Seat(title = "A3", state = 1, type = 1),
        Seat(title = "A4", state = 1, type = 1),
        Seat(title = "A", state = 0, type = 0),
        Seat(title = "A5", state = 1, type = 1),
        Seat(title = "A6", state = 1, type = 1),
        Seat(title = "A7", state = 0, type = 1),
        Seat(title = "A8", state = 0, type = 1),

        Seat(title = "B1", state = 1, type = 1),
        Seat(title = "B2", state = 1, type = 1),
        Seat(title = "B3", state = 1, type = 1),
        Seat(title = "B4", state = 1, type = 1),
        Seat(title = "B", state = 0, type = 0),
        Seat(title = "B5", state = 1, type = 1),
        Seat(title = "B6", state = 1, type = 1),
        Seat(title = "B7", state = 0, type = 1),
        Seat(title = "B8", state = 0, type = 1),

        Seat(title = "C1", state = 0, type = 1),
        Seat(title = "C2", state = 0, type = 1),
        Seat(title = "C3", state = 0, type = 1),
        Seat(title = "C4", state = 1, type = 1),
        Seat(title = "C", state = 0, type = 0),
        Seat(title = "C5", state = 1, type = 1),
        Seat(title = "C6", state = 1, type = 1),
        Seat(title = "C7", state = 0, type = 1),
        Seat(title = "C8", state = 0, type = 1),

        Seat(title = "D1", state = 0, type = 1),
        Seat(title = "D2", state = 0, type = 1),
        Seat(title = "D3", state = 0, type = 1),
        Seat(title = "D4", state = 0, type = 1),
        Seat(title = "D", state = 0, type = 0),
        Seat(title = "D5", state = 0, type = 1),
        Seat(title = "D6", state = 0, type = 1),
        Seat(title = "D7", state = 0, type = 1),
        Seat(title = "D8", state = 0, type = 1),

        Seat(title = "E1", state = 0, type = 1),
        Seat(title = "E2", state = 0, type = 1),
        Seat(title = "E3", state = 0, type = 1),
        Seat(title = "E4", state = 0, type = 1),
        Seat(title = "E", state = 0, type = 0),
        Seat(title = "E5", state = 0, type = 1),
        Seat(title = "E6", state = 0, type = 1),
        Seat(title = "E7", state = 0, type = 1),
        Seat(title = "E8", state = 0, type = 1),

        Seat(title = "F1", state = 0, type = 1),
        Seat(title = "F2", state = 0, type = 1),
        Seat(title = "F3", state = 0, type = 1),
        Seat(title = "F4", state = 0, type = 1),
        Seat(title = "F", state = 0, type = 0),
        Seat(title = "F5", state = 0, type = 1),
        Seat(title = "F6", state = 0, type = 1),
        Seat(title = "F7", state = 0, type = 1),
        Seat(title = "F8", state = 0, type = 1),
    )
}
