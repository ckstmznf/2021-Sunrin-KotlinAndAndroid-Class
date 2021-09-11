fun main(){
    val heechan = Driver()

    val car1 = Sedan()
    val car2 = Suv()
    val car3 = Bus()
    val car4 = Van()
    val car5 = Truck()


    heechan.driving(car1)
    heechan.driving(car2)
    heechan.driving(car3)
    heechan.driving(car4)
    heechan.driving(car5)

    repeat(30){
        print("=")
    }
    println()

    car3.nowPerson()
    car3.inPerson(5)
    car3.nowPerson()
    car3.outPerson(4)
    car3.nowPerson()
    car3.outPerson(2)
    car3.nowPerson()


    repeat(30){
        print("=")
    }
    println()
//    car5.nowLuggage()
//    car5.inLuggage(5)
//    car5.nowLuggage()
//    car5.outLuggage(4)
//    car5.nowLuggage()
//    car5.outLuggage(10)
//    car5.nowLuggage()
//
//
//    repeat(30){
//        print("=")
//    }
//    println()
//
//
//    car4.nowPerson()
//    car4.nowLuggage()
//    car4.inPerson(2)
//    car4.inLuggage(4)
//    car4.nowPerson()
//    car4.nowLuggage()
//    car4.outPerson(4)
//    car4.outLuggage(5)
//    car4.nowPerson()
//    car4.nowLuggage()
}