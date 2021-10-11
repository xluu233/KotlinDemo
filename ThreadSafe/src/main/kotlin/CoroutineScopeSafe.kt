import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.lang.Thread.sleep
import java.util.*
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

fun main() = runBlocking{
    //testAsync()
    //testMutex()

    testCoroutineWithSync()
}


/**
 * 测试协程中使用Synchronzied
 */
fun testCoroutineWithSync() = runBlocking{
    repeat(3){
        launch(Dispatchers.IO){
            doSomething2()
        }
    }
}

@Synchronized
suspend fun doSomething(){

    println("currentThread:${Thread.currentThread().name}, time:${System.currentTimeMillis()}, start")
    delay(1000)
    println("currentThread:${Thread.currentThread().name}, time:${System.currentTimeMillis()}, end")

}

suspend fun doSomething2(){
    synchronized(Any()){
        println("currentThread:${Thread.currentThread().name}, time:${System.currentTimeMillis()}, start")

        //模拟某些阻塞操作
        val time = measureTimeMillis {
            var count = 0
            repeat(1000000){
                count *= count
            }
        }

        println("currentThread:${Thread.currentThread().name}, time:${System.currentTimeMillis()}, end")
    }
}

suspend fun testMutex() {
    var count = 0

    //注意：对于多个协程来说用的是同一个Mutex
    val mutex = Mutex()

    val job1 = CoroutineScope(Dispatchers.IO).launch{

        mutex.withLock(count) {
            repeat(100) {
                count++
                delay(1)
            }
        }

        println("count1:${count}")
    }


    val job2 = CoroutineScope(Dispatchers.IO).launch{
        mutex.withLock(count) {
            repeat(100) {
                count++
                delay(1)
            }
        }
        println("count2:${count}")
    }

    job1.join()
    delay(10)
    job2.join()
}

fun testAsync() = runBlocking {
    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() }
        val two = async { doSomethingUsefulTwo() }
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L) // 假设我们在这里做了些有用的事
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L) // 假设我们在这里也做了些有用的事
    return 29
}