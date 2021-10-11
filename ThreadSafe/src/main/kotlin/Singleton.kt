import kotlinx.coroutines.delay
import java.lang.Thread.currentThread
import java.lang.Thread.sleep


object Singleton {


    @Synchronized
    fun printS(){
        println("${System.currentTimeMillis()} : ${Thread.currentThread().name}")
        sleep(1000)
        println("${System.currentTimeMillis()} : ${Thread.currentThread().name}")
    }


}