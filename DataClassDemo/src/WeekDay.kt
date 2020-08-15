enum class WeekDay(val str: String) {
    Monday("Mon"),
    Tuesday("Tue"),
    Wednesday("Wed"),
    Thursday("Thurs"),
    Friday("Fri"),
    Saturday("Sat"),
    Sunday("Sun"){
        override fun toString(): String {
            return "啥玩意啊"
        }
    };


    fun isWorkDay():Boolean{
        return !(this == Saturday || this == Sunday)
    }

}

interface A{
    abstract fun getSth():String

    fun test():String = "接口中默认实现的方法不能用abstract修饰哦"
}

enum class EnumInterface:A{
    TEST{
        override fun getSth(): String {
            return "继承接口的enum类"
        }
    },
    TEST2 {
        override fun getSth(): String {
            return "必须实现接口方法哦"
        }
    };

}