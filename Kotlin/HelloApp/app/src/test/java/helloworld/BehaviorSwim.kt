package helloworld

class BehaviorSwim : Behavior {
    override fun fly(): String {
        return "fly"
    }

    override fun swim(): String {
        return "swim"
    }

    override var skilledSports: String="fly"
}