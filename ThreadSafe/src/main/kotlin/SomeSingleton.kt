

class SomeSingleton(s:String) {

    companion object{

        private var s = ""

        private val instance : SomeSingleton by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SomeSingleton(s)
        }

        fun getInstances(string: String):SomeSingleton{
            this.s = string
            return instance
        }
    }

    fun printS(){
        println("${System.currentTimeMillis()} : ${Thread.currentThread().name} -------   s is:${s}")
        Thread.sleep(5000)
    }

}