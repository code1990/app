package helloworld

class Tree(var treeName:String) {
    //在类内部再定义一个类，这个新类称作嵌套类
    class Flower(var flowerName:String){
        //普通的嵌套类不能访问外部类的成员，如treeName
        fun getName():String{
            return flowerName
        }
    }
    //嵌套类加上inner前缀，就成为内部类
    inner class Fruit(var fruitName:String){
        fun getName():String{
            return fruitName
        }
    }
}