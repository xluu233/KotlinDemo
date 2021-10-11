import java.lang.Thread.currentThread
import java.lang.Thread.sleep
import java.util.*
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import kotlin.Throws
import kotlin.concurrent.thread

fun main(args: Array<String>) {

    //testFunSync()
    //testClassSync()
    //testObjectSync()
    //testSingleton()
    //testLockSync()

}

/**
 * 测试ReentrantLock()
 */
fun testLockSync() {

    val lock = ReentrantLock()
    var count = 0

    val thread1 = Thread{
        lock.lock()

        for (i in 0..1000){
            count += i
        }
        println("${Thread.currentThread().name} : count:${count}")

        lock.unlock()
    }

    val thread2 = Thread{
        lock.lock()

        for (i in 0..1000){
            count += i
        }
        println("${Thread.currentThread().name} : count:${count}")

        lock.unlock()
    }

    thread1.start()
    thread2.start()
}

/**
 * 测试by lazy单例安全类
 */
fun testSingleton() {
    val thread1 = thread(start = false,name = "first thread"){
        SomeSingleton.getInstances("aaa").printS()
    }

    val thread2 = thread(start = false,name = "second thread"){
        SomeSingleton.getInstances("bbb").printS()
    }

    thread1.start()
    thread2.start()
}

/**
 * 测试object单例类
 */
fun testObjectSync() {

    val thread1 = thread(start = false,name = "first thread"){
        Singleton.printS()
    }

    val thread2 = thread(start = false,name = "second thread"){
        Singleton.printS()
    }

    thread1.start()
    thread2.start()
}

/**
 * 测试类加锁
 */
fun testClassSync() {
    val result= Result()
    val result2= Result()

    Thread{
        synchronized(Result::class.java){
            result.s = currentThread().name
            result.printResult()
        }
    }.apply {
        name = "first thread"
        start()
    }

    Thread{
        synchronized(Result::class.java){
            result2.s = currentThread().name
            result2.printResult()
        }
    }.apply {
        name = "second thread"
        start()
    }

}

/**
 * 测试方法加锁
 */
fun testFunSync() {
    Thread{
        postResult("first thread")
        //我们在此线程阻塞10s,看下结果是否一样
        sleep(10000)
    }.start()

    Thread{
        postResult("second thread")
    }.start()
}

@Synchronized
private fun postResult(s: String){
    println("${System.currentTimeMillis()} ：$s" )
    sleep(5000)
}
