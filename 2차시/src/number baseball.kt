import java.util.Random

fun main(){
    val random = Random()
    var count = 0
    var oldInput = mutableListOf<List<Int>>()


    val randomList = mutableListOf<Int>()

    repeat(3){
        randomList.add(random.nextInt(10))
    }



    println(randomList)
    while (true){
        var strake = 0
        var ball = 0

        print("숫자 세개를 입력하세요 : ")
        val input = readLine()!!.split(" ")

        for((n, i) in input.withIndex()){
            if(i == randomList[n].toString()){
//                println("$i 스타라이크")
                strake++
            }   else if(i.toInt() in randomList){
//                println("$i 볼")
                ball++
            }

        }

        if(strake == 3){
            println("축하합니다.")
            break
        }

    }
}