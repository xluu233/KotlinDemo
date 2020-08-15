class test {

}

fun main(){
    var people = People("xlu",21,"男","test",23)

    //因为val name 所以没有setter属性
    //people.name = "xxxlll"
    //var reName就可以修改了哦
    people.reName = "xxxlu"
    System.out.println(people)

    val people2 = People("xlu",21,"男","test",23)
    val people3 = People("xlu",21,"男","test",23)
    System.out.println(people2 == people3)    // true   == 比较的是值，和equals一样的
    System.out.println(people2 === people3)   // false  ===比较的是内存地址

    val people4 = people3.copy()
    System.out.println(people4 == people3)  // true  按理说copy是浅拷贝，就是只people3和people4指向内存地址一样的，为什么返回true呢？

    //enum类使用方式一
    val monday = WeekDay.Monday
    System.out.println(monday)              //Monday
    System.out.println(monday.str)          //Mon
    System.out.println(monday.name)         //Monday
    System.out.println(monday.isWorkDay())  //true

    //方式二，必须输入完整的：Monday，否则报错
    val monday2 = WeekDay.valueOf("Monday")

    //sunday重写了toString方法
    val sunday = WeekDay.Sunday
    System.out.println(sunday)     //啥玩意啊

    //实现了A接口的Enum类
    val test = EnumInterface.TEST
    System.out.println(test)            //TEST
    System.out.println(test.getSth())   //继承接口的enum类

}
