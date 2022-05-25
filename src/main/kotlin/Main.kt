import java.util.Calendar

fun main() {
    val car = Vehicle("AA111AA", Calendar.getInstance().timeInMillis, vehicleType.AUTO, "DISCOUNT_CARD_001")
    val moto = Vehicle("BB222BB", Calendar.getInstance().timeInMillis, vehicleType.MOTO)
    val minibus = Vehicle("CC333CC", Calendar.getInstance().timeInMillis, vehicleType.MINIBUS)
    val bus = Vehicle("DD444DD", Calendar.getInstance().timeInMillis, vehicleType.BUS, "DISCOUNT_CARD_002")
    val car2 = Vehicle("EE555EE", Calendar.getInstance().timeInMillis, vehicleType.AUTO)

    val moto2 = Vehicle("FF666FF", Calendar.getInstance().timeInMillis, vehicleType.MOTO, "DISCOUNT_CARD_003")
    val moto3 = Vehicle("HH888HH", Calendar.getInstance().timeInMillis, vehicleType.MOTO)
    val minibus2 = Vehicle("II999II", Calendar.getInstance().timeInMillis, vehicleType.MINIBUS)
    val bus2 = Vehicle("JJ000JJ", Calendar.getInstance().timeInMillis, vehicleType.BUS, "DISCOUNT_CARD_004")
    val car3 = Vehicle("KK555KK", Calendar.getInstance().timeInMillis, vehicleType.AUTO)

    val car4 = Vehicle("GG111GG", Calendar.getInstance().timeInMillis, vehicleType.AUTO, "DISCOUNT_CARD_005")
    val moto4 = Vehicle("LL012LL", Calendar.getInstance().timeInMillis, vehicleType.MOTO)
    val car5 = Vehicle("MM210MM", Calendar.getInstance().timeInMillis, vehicleType.AUTO, "DISCOUNT_CARD_006")
    val car6 = Vehicle("NN815NN", Calendar.getInstance().timeInMillis, vehicleType.AUTO,)
    val moto5 = Vehicle("OO489OO", Calendar.getInstance().timeInMillis, vehicleType.MOTO, "DISCOUNT_CARD_007")

    val car7 = Vehicle("PP498PP", Calendar.getInstance().timeInMillis, vehicleType.AUTO, "DISCOUNT_CARD_008")
    val moto6 = Vehicle("QQ465QQ", Calendar.getInstance().timeInMillis, vehicleType.MOTO)
    val minibus3 = Vehicle("RR167RR", Calendar.getInstance().timeInMillis, vehicleType.MINIBUS)
    val bus3 = Vehicle("SS852SS", Calendar.getInstance().timeInMillis, vehicleType.BUS, "DISCOUNT_CARD_009")
    val car8 = Vehicle("TT921TT", Calendar.getInstance().timeInMillis, vehicleType.AUTO)
    val car9 = Vehicle("UU948UU", Calendar.getInstance().timeInMillis, vehicleType.AUTO, "DISCOUNT_CARD_010")



    val vehicles: Array<Vehicle> = arrayOf(
        car, moto, minibus, bus, car2, moto2, moto3, moto4, moto5, car3,
        car4, car5, car6, bus2, minibus2, car7, moto6, minibus3, bus3, car8, car9
    )

    val parking = Parking(mutableSetOf())

    for (Vehicle in vehicles) {
        val isParked = parking.addVehicle(Vehicle)
        parking.checkIn(isParked)
    }
    var vehiclesSize: Int = vehicles.size
    println("\n")
    val parkable = Parkable(moto)
    val plate = parkable.vehicle.plate
    val result = parkable.checkOutVehicle(plate)
    if (result) {
        parking.vehicles.remove(moto)
    } else {
        println("The vehicle is not parked!")
    }
    println("\n")
    parking.information(parkable)
    parking.listVehicles()
}



























