import java.util.*
import java.util.concurrent.TimeUnit

class Vehicle(val plate: String, val checkInTime: Long, vehicleType: vehicleType, val discountCard: String? = null) {
    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return this.plate.hashCode()
    }

    fun getParkedTime(): Int{
        val totalTime: Long = (Calendar.getInstance().timeInMillis - checkInTime)
        val parkedTime: Long = TimeUnit.MILLISECONDS.toMinutes(totalTime)
        return parkedTime.toInt()
    }



}