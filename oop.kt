// Abstract base class for all vehicles
abstract class Vehicle(val brand: String) {
    // Abstract method to be implemented by child classes
    abstract fun move()

    // Concrete method in the base class
    fun displayBrand() {
        println("Vehicle brand: $brand")
    }
}

// First concrete class inheriting from Vehicle
class Car(brand: String, val model: String) : Vehicle(brand) {
    override fun move() {
        println("Car is driving on the road")
    }

    fun honk() {
        println("Beep beep!")
    }
}

// Second concrete class inheriting from Vehicle
class Boat(brand: String, val type: String) : Vehicle(brand) {
    override fun move() {
        println("Boat is sailing on water")
    }

    fun anchor() {
        println("Dropping anchor")
    }
}

// Demonstration function
fun main() {
    val myCar = Car("Toyota", "Camry")
    val myBoat = Boat("Yamaha", "Speedboat")

    // Demonstrating inherited and class-specific methods
    myCar.displayBrand()
    myCar.move()
    myCar.honk()

    println("\n")

    myBoat.displayBrand()
    myBoat.move()
    myBoat.anchor()
}