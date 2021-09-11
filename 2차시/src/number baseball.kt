import java.util.Random

fun main(){
    val random = Random()
    var count = 0
    var oldInput = mutableListOf<List<Int>>()

    val randomList = mutableListOf<Int>()

    while(randomList.size != 3){
        val rand = random.nextInt(10)

        if(!(rand in randomList)){
            randomList.add(rand)
        }
        //        println(rand)
    }

//    println(randomList)


//    println(randomList)


    while (true){
        var strake = 0
        var ball = 0

        print("숫자 세개를 입력하세요 : ")
        val input = readLine()

        if(input == "R"){
            println("지금까지 시도한 횟수 : $count")
            for(i in oldInput){
                for(j in i){
                    print("$j, ")
                }

                println()
            }
            continue
        }

        val inputData = input!!.split(" ").map {
            it.toInt()
        }

        oldInput.add(inputData)


        for((n, i) in inputData.withIndex()){
            if(i == randomList[n]){
//                println("$i 스트라이크")
                strake++
            }   else if(i in randomList){
//                println("$i 볼")
                ball++
            }

        }`

        if(strake == 3) {
            println("축하합니다.")
            println("정답은 ${randomList}입니다.")
            break
        }

        println("${ball}볼 ${strake}스트라이크")
        count++
    }
}