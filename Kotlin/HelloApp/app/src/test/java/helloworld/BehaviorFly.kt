package helloworld

class BehaviorFly : Behavior {
    override fun fly(): String {
        return "fly"
    }

    override fun swim(): String {
        return "swim"
    }

    override var skilledSports: String="fly"
}