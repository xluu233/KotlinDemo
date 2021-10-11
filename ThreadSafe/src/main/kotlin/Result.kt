
class Result {

    var s : String = ""

    public fun printResult(){
        println("${System.currentTimeMillis()} ：$s" )
        Thread.sleep(5000)
    }

}