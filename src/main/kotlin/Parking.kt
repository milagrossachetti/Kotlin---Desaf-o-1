data class Parking(val vehicles: MutableSet<Vehicle>) {
    fun addVehicle(vehicle: Vehicle): Boolean{
        //1. comprobar si puede añadir un nuevo vehículo de acuerdo a la cantidad
        val amount: Int = vehicles.size
        val result: Boolean
        if (amount < 20) {
            vehicles.add(vehicle)
            result = true
        } else {
            result = false
        }
        return result
    }
    fun checkIn(allowedToPark: Boolean){
        if(allowedToPark){
            println("Welcome to the AlkeParking!")
        } else {
            println("Sorry, the ckeck-in failed")
        }
    }

    fun information(parkable: Parkable){
        var vehiclesRemove: Int = parkable.vehiclesRemove
        var earnings: Int = parkable.totalEarnings
        val data: Pair<Int, Int> = Pair(vehiclesRemove, earnings)
        val first = data.first
        val second = data.second
        println("$first vehicles have checked out and have earnings of $ $second \n")
    }

    fun listVehicles(){
        println("List of vehicles plates: ")
        for(Vehicle in vehicles){
            println("\t ${Vehicle.plate}")
        }
    }

}


