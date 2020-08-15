
/**
 * 枚举类和密封类的结合使用
 */

fun main(){
    val const = Const(123)
    println(eval(const))    //123

    val sum = Sum(12,23)
    println(eval(sum))  //35
}

sealed class Expr

data class Const(val num:Int) : Expr()

data class Sum(val a1:Int,val a2:Int) : Expr()

object NotANumber:Expr()

fun eval(expr: Expr):Int = when(expr){
    is Const -> expr.num
    is Sum -> expr.a1+expr.a2
    //else -> 0
    NotANumber -> 0
}