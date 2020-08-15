/**
 * 对象表达式-2
 */
class ObjectExpression2 {

    //私有方法
    private fun A() = object : Parent(){
        val x:String = "x"
    }

    //公有方法
    public fun B() = object : Parent(){
        val x:String = "x"
    }

    fun test(){
        val objectPrivate = A()
        val objectPublic = B()

        //私有方法返回的是匿名类的真实类型，可以访问x和y对象
        System.out.println(objectPrivate.x + objectPrivate.y)

        //公有方法返回的是父类型对象，Parent()或者Any()，只能访问父类型的对象
        System.out.println(objectPublic.y)
        //访问x报错
        //System.out.println(objectPublic.x)
    }
}

open class Parent{
    val y:String = "y"
}
