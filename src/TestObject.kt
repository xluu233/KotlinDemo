import `interface`.People

class TestObject {

    /**
     * 单例对象
     */
    object SingleObject{
        //object声明的对象可以拥有方法和自己的属性
        var num = 0

        fun totalNum():Int{
            num += 1
            return num
        }
    }

    /**
     * 单例对象可以有超类（实现接口或者继承其他类）
     */
    object people:People{
        override fun setKind(): String {
            return "American"
        }

        override val name: String
            get() = "tony"
    }

}



fun main(){
    //调用单例对象
    System.out.println(TestObject.SingleObject.num)
    System.out.println(TestObject.SingleObject.totalNum() == 1)
    System.out.println(TestObject.SingleObject.totalNum() == 1)
    System.out.println(TestObject.SingleObject.totalNum())

    System.out.println(TestObject.people.setKind())
    System.out.println(TestObject.people.name)
}