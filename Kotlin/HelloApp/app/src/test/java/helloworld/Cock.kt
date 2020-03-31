package helloworld

class Cock(name: String = "chicken", sex: Int = Bird.MALE, voice: String = "wowo") : Chicken(name, sex, voice) {
    override fun callOut(times: Int): String {
        var count = when {
            //when语句判断大于和小于时，要把完整的判断条件写到每个分支中
            times <= 0 -> 0
            times >= 10 -> 9
            else -> times
        }
        return "$sexName$name${voice}叫了${numberArray[count]}声"
    }
}