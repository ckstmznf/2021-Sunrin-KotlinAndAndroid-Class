open class Car(){
    protected var kind = ""
    protected var color = ""
    protected var name = ""
    protected var owner = ""
    protected var carId = 0
}

abstract class CarBuilder : Car(){
    abstract fun setKinds()
    fun setColors(color : String) {
        this.color = color
    }
    fun setNames(name: String) {
        this.name = name
    }

    fun setOwners(owner: String) {
        this.owner = owner
    }

    fun setCarIDs(carId: Int) {
        this.carId = carId
    }


    fun getKinds() = kind
    fun getColors() = color
    fun getNames() = name
    fun getOwners() = owner
    fun getCarIDs() = carId
}

class Suv() : CarBuilder(){
    override fun setKinds() {
        kind = "SUB"
    }
}

class Bus() : CarBuilder(){
    override fun setKinds() {
        kind = "버스"
    }
}


fun Builder(){
    val car1 = Suv()
    car1.setKinds()
    car1.setColors("검정색")
    car1.setNames("부릉이")
    car1.setOwners("박희찬")
    car1.setCarIDs(1189)
    
    val car2 = Bus()
    car2.setKinds()
    car2.setColors("초록색")
    car2.setNames("타요")
    car2.setOwners("바키찬")
    car2.setCarIDs(9999)
}