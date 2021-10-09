interface EDCAN{
    fun coding(language : String)
    fun design()
    fun android()
    fun web()
    fun IoT()
    fun game()

    fun noSleep(time : Int)
    fun otaku()
}

class EDCANPeople : EDCAN{
    override fun coding(language: String) {
        println("$language 언어 코딩중")
    }

    override fun design() {
        println("에드캔 디자인은 세계 제일")
    }

    override fun android() {
        println("EDCAN은 안드로이드를 하지")
    }

    override fun web() {
        println("EDCAN은 웹도 하지")
    }

    override fun IoT() {
        println("EDCAN은 IoT도 했지")
    }

    override fun game() {
        println("EDCAN은 게임도 했지")
    }

    override fun noSleep(time: Int) {
        println("EDCAN이 잠을 잔다?")
    }

    override fun otaku() {
        println("사실 에드캔은 씹덕 동아리 였습니다")
    }
}

interface AppplePi{
    fun coding(language : String)
    fun design()
    fun android()

    fun firebase()
    fun baking()
}

class AppplePiPeople : AppplePi{
    override fun coding(language: String) {
        println("$language 언어 코딩중")
    }

    override fun design() {
        println("애플파이 디자인은 세계 제일")
    }

    override fun android() {
        println("애플파이는 안드로이드 개발 동아리 입니다.")
    }

    override fun firebase() {
        println("애플파이에서는 파이어베이스도 배워요")
    }

    override fun baking() {
        println("맛있는 애플파이를 굽고있어요!")
    }
}

class EdcanplePi(val appPlePiPeople : AppplePiPeople) : EDCAN{

    override fun coding(language: String) {
        println("$language 언어 코딩중")
    }

    override fun design() {
        throw Exception()
    }

    override fun android() {
        throw Exception()
    }

    override fun web() {
        println("EDCAN:ple Pi는 웹을 하지")
    }

    override fun IoT() {
        println("EDCAN:ple Pi는 IoT도 했지")
    }

    override fun game() {
        println("EDCAN:ple Pi는 게임도 했지")
    }

    override fun noSleep(time: Int) {
        println("EDCAN:ple Pi는 잠을 잔다?")
    }

    override fun otaku() {
        println("사실 여기도 씹덕 동아리 였습니다")
    }
}

fun Adapter() {
    val student1 = EDCANPeople()
    val student2 = AppplePiPeople()
    val student3 = EdcanplePi(AppplePiPeople())

    student1.coding("Kotlin")
    student1.design()
    student1.android()
    student1.web()
    student1.IoT()
    student1.game()
    student1.otaku()

    student2.coding("JAVA")
    student2.design()
    student2.android()
    student2.firebase()
    student2.baking()


    student3.coding("C")
    try{
        student3.design()
    }   catch (e : Exception){
        println("디자인은 애플파이에서 담당합니다.")
    }

    try{
        student3.android()
    }   catch (e : Exception){
        println("안드로이드는 애플파이에서 담당합니다.")
    }

    
    student3.web()
    student3.IoT()
    student3.game()
    student3.otaku()
    student3.appPlePiPeople.coding("C")
    student3.appPlePiPeople.design()
    student3.appPlePiPeople.android()
    student3.appPlePiPeople.baking()
}