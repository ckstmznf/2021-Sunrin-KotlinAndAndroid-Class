import javax.print.DocFlavor

abstract class Car {
    // 모든 자동차가 상속받는 car 클래스, 차의 종류와 주행, 브래이크의 함수를 정의돼있다.
    abstract val kind : String

    fun go(){
        println("$kind 주행합니다.")
    }

    fun brake(){
        println("$kind 정지합니다.")
    }
}

abstract class KindForPerson : Car() {
    // 사람을 태우는 자동차, 현재 탑승해있는 사람의 수와 사람을 태우고 내리는 함수가 정의돼있다.
    var countPerson = 0

    fun inPerson(count : Int){
        countPerson += count
    }

    fun outPerson(count : Int){
       if(countPerson - count < 0){
           println("내리는 사람 수가 잘못됐습니다.")
       }    else{
           countPerson -= count
       }
    }

    fun nowPerson(){
        println("현재 ${kind}의 탑승자는 ${countPerson}명 입니다.")
    }
}
abstract class KindForLuggage : Car(){
    // 짐을 싣고 내리는 자동차, 현재 싣고 있는 짐의 수와 짐을 싣고 내리는 함수가 정의돼있다.
    var countLuggage = 0

    fun inLuggage(count : Int){
        countLuggage += count
    }

    fun outLuggage(count : Int){
        if(countLuggage - count < 0){
            println("내리는 짐의 수가 잘못됐습니다.")
        }   else{
            countLuggage -= count
        }
    }


    fun nowLuggage(){
        println("현재 ${kind}가 싣고있는 짐의 수는 ${countLuggage}개 입니다.")
    }
}


// 사람과 짐을 모두 태우고 싣는 자동차 클래스를 만들어 주기 위해서 만들어 주었다.
// 코틀린은 2중 상속이 안되기 때문에 kindForPerson 클래스를 상속받는 클래스를 만들어주고
// 이 클래스에서 짐을 싣고 내리는 기능을 만들어주었다.
abstract class kindForAll : KindForPerson(){
    var countLuggage = 0

    fun inLuggage(count : Int){
        countLuggage += count
    }

    fun outLuggage(count : Int){
        if(countLuggage - count < 0){
            println("내리는 짐의 수가 잘못됐습니다.")
        }   else{
            countLuggage -= count
        }
    }

    fun nowLuggage(){
        println("현재 ${kind}가 싣고있는 짐의 수는 ${countLuggage}개 입니다.")
    }
}


class Sedan() : Car(){
    override val kind = "세단"
}

class Suv() : Car(){
    override val kind = "SUV"
}

class Bus() : KindForPerson(){
    override val kind = "버스"
}

class Van() : kindForAll(){
    override val kind = "승합차"
}

class Truck() : KindForLuggage(){
    override val kind = "트럭"
}
