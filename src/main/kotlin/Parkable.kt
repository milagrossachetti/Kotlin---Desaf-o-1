import java.util.*
import kotlin.math.min
import kotlin.math.nextUp
import kotlin.math.ulp

data class Parkable(var vehicle: Vehicle){
    var totalEarnings: Int = 0
    var vehiclesRemove: Int = 0
    fun checkOutVehicle(plate: String, onSuccess: Int? = null, onError: Boolean? = null): Boolean{
        if(vehicle.plate == plate){
            val total: Int = calculateFree(vehicleType.MOTO, vehicle.getParkedTime(), vehicle.discountCard.toBoolean()
            )
            onSuccess(total)
            totalEarnings += total
            vehiclesRemove += 1
            return true
        } else {
            return onError(plate)

        }
    }

    fun onSuccess(int: Int) {
        println("The total to pay is $int")
    }

    fun onError(plate: String): Boolean {
        return false
    }

    fun calculateFree(vehicle: vehicleType, parkedTime: Int ,hasDiscountCard: Boolean): Int {
        /*primeras 2 horas
            auto: 20, moto: 15, minibus: 25, bus: 30
          despues de las 2 horas 5pe por cada 15'
        */
        var numberHours: Float = 0.0F
        var minutes: Float = 0F
        var discount: Int
        var TOTAL: Int = 0
        var minutesBlock: Int = 0

        if(parkedTime >= 60){
            numberHours = (parkedTime/60).toFloat()
            minutes = (numberHours - 2)*60
        }
        minutes = parkedTime.toFloat()
        if(minutes >= 15){
            minutesBlock = (minutes/15).nextUp().toInt()
        }

        if(vehicle == vehicleType.MOTO){
            if(numberHours >= 2){
                TOTAL = 15 + minutesBlock*5
            } else if(minutesBlock >= 1){
                TOTAL = minutesBlock*5
            } else if(minutes < 15){
                TOTAL = 5
            }
        } else if (vehicle == vehicleType.AUTO) {
            if(numberHours >= 2){
                TOTAL = 20 + minutesBlock*5
            } else if(minutesBlock >= 1){
                TOTAL = minutesBlock*5
            } else if(minutes < 15){
                TOTAL = 5
            }
        } else if (vehicle == vehicleType.BUS){
            if(numberHours >= 2){
                TOTAL = 30 + minutesBlock*5
            } else if(minutesBlock >= 1){
                TOTAL = minutesBlock*5
            } else if(minutes < 15){
                TOTAL = 5
            }
        }else if (vehicle == vehicleType.MINIBUS){
            if(numberHours >= 2){
                TOTAL = 25 + minutesBlock*5
            } else if(minutesBlock >= 1){
                TOTAL = minutesBlock*5
            } else if(minutes < 15){
                TOTAL = 5
            }
        }
        if(hasDiscountCard == true){
            discount = (TOTAL * 0.15).toInt()
            TOTAL -= discount
        }
        return TOTAL
    }
}












