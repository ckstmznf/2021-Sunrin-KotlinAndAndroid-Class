open class Observable{
    val observers = mutableListOf<Observer>()
}

abstract class Observer(val parent : Observable){
    abstract fun upData()
    var rm = false

    fun addObserver(){
        parent.observers.add(this)
    }

    fun rmObserver(){
        parent.observers.remove(this)
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
            if(!i.rm){
                i.upData()
            }
        }
    }

    fun down(){
        if(now < 1) now -1

        println("${now}층")

        for(i in observers){
            if(!i.rm){
                i.upData()
            }
        }
    }
}


data class Passenger(val destination : Int, val p : Observable) : Observer(p){
    init {
        addObserver()
    }

    override fun upData() {
        if((parent as Elevator).now == destination){
            println("내립니다.")
            rm = true
        }   else{
            println("저는 ${destination}층에서 내립니다.")
        }
    }
}


fun Observer(){
    val elebvator = Elevator()
    val p1 = Passenger(10, elebvator)
    val p2 = Passenger(3, elebvator)
    val p3 = Passenger(5, elebvator)
    val p4 = Passenger(4, elebvator)


//    println(elebvator.observers.toString())

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