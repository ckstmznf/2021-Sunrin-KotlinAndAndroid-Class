open class Observable{
    val observers = mutableListOf<Observer>()
}

abstract class Observer{
    abstract fun upData()

    fun addObserver(observable: Observable){
        observable.observers.add(this)
    }

    fun rmObserver(observable: Observable){
        observable.observers.remove(this)
    }
}

class Elevator() : Observable() {
    var now = 1


    init {
        this.now = 1
    }

    fun up(){
        now += 1

        println("${now}층")
        for(i in observers){
            println(i)
            i.upData()
        }
    }

    fun down(){
        if(now < 1) now -1

        println("${now}층")
        for(i in observers){
            println(i)
            i.upData()
        }
    }
}


data class Passenger(val destination : Int, val parent : Observable) : Observer(){
    init {
        addObserver(parent)
    }

    override fun upData() {
        if((parent as Elevator).now == destination){
            println("내립니다.")

            rmObserver(parent)
        }
    }
}


fun main(){
    val elebvator = Elevator()
    val p1 = Passenger(10, elebvator)
    val p2 = Passenger(3, elebvator)
    val p3 = Passenger(5, elebvator)
    val p4 = Passenger(4, elebvator)


    elebvator.up()
    elebvator.up()
    elebvator.up()
    elebvator.up()
    elebvator.up()
    elebvator.up()
    elebvator.up()
    elebvator.up()
    elebvator.up()
    elebvator.up()
}