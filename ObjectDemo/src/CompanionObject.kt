
import `interface`.People

/**
 * 伴生对象
 */
class CompanionObject {
    //外部类私有属性
    private var name:String = "xlu"

    fun getMyName():String{
        //外部类可以访问伴生对象的私有属性
        return myName
    }

    companion object test{
        //伴生对象的私有属性
        private var myName:String = "companion xlu"
        //JvmStatic注解生成static成员
        @JvmStatic var test = "static"

        fun getCompaionName():String{
            val objects = create()
            //伴生对象可以访问外部类的私有属性
            return CompanionObject().name
        }

        fun create():CompanionObject{
            return CompanionObject()
        }
    }

    /**
     * 一个类最多一个伴生对象，以下会报错
     */
/*    companion object second:People{
        //伴生对象可以有超类型
        override fun setKind(): String {
            return super.setKind()
        }
    }*/

}

fun main(){
    System.out.println(CompanionObject.test)
    System.out.println(CompanionObject.getCompaionName())
}