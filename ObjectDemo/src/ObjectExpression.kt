/**
 * 对象表达式-1
 */
class ObjectExpression {

    /**
     * 匿名类的对象，简称“对象表达式”
     */
    var people = object :Action(){
        override fun eat(): String {
            return "油条"
        }

        override fun run() {
            TODO("Not yet implemented")
        }
    }

    fun main(){
        people.eat()
        people.run()
    }

}

abstract class Action{
    abstract fun eat():String

    abstract fun run()

    fun sleep(){
        //do something
    }

}

