abstract class car {
    abstract val kind : String

    fun go(){
        println("$kind 주행합니다.")
    }

    fun brake(){
        println("$kind 정지합니다.")
    }
}