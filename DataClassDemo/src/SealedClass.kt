/**
 * 密封类：和抽象类相似，但不完全相等。
 * 1.密封类只能在类的内部继承，外部类无法继承
 * 2.外部类可以继承密封类的嵌套类
 */

sealed class SealedClass {

    class Apple:SealedClass(){

    }

    open class Banna:SealedClass(){
        open fun A():String{
            return "A"
        }
    }


}

/**
 * 外部类不能继承密封类哦，以下报错
 */
/*class test:SealedClass(){

}*/

/**
 * 外部类可以继承密封类的嵌套类
 */
class test2:SealedClass.Banna(){

    override fun A(): String {
        return "B"
    }

}